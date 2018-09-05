package de.smartsquare.dotlang.webview

import com.google.common.collect.Maps
import com.intellivat.core.mapping.Jdk8EnabledObjectMapper
import com.intellivat.domain.masterdata.LocationLevel
import com.intellivat.domain.taxtree.*
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.io.InputStream
import java.util.*


@Component
class TaxTreeRenderer(val freemarker: FreemarkerHtmlRenderer) {

    companion object {
        val objectMapper: Jdk8EnabledObjectMapper = Jdk8EnabledObjectMapper()
        val log = LoggerFactory.getLogger(this::class.java)
        val LINE_LENGTH = 25
    }

    fun renderDot(treeStream: InputStream): String {
        val tree = objectMapper.readValue(treeStream, TaxDecisionTree::class.java)
        val leaves = mutableSetOf<TreeNode>()
        val rootNode = tree.rootNode
        return renderDot(rootNode, leaves)
    }

    fun renderDot(treeStream: InputStream, subtreeId: String): String {
        val tree = objectMapper.readValue(treeStream, TaxDecisionTree::class.java)
        val leaves = mutableSetOf<TreeNode>()
        val rootNode = tree.getSubtreeByUUID(UUID.fromString(subtreeId)).get().rootNode
        return renderDot(rootNode, leaves)
    }

    fun renderDot(rootNode: RootNode, leaves: MutableSet<TreeNode>): String {
        val sb = StringBuilder("digraph {\n")
        sb.append("  node [shape=box,style=filled]\n")
        val visited = mutableSetOf<TreeNode>()

        sb.append("  ${rootNode.label()} [${nodeLayout(rootNode)}]\n")

        recurseTree(rootNode, rootNode.yesNode, sb, visited, leaves)
        recurseTree(rootNode, rootNode.noNode, sb, visited, leaves)
        sb.append("  {rank=same;")
        leaves.forEach { it -> sb.append(" " + it.label()) }
        sb.append("}\n")

        sb.append("}\n")

        log.info("\n" + sb.toString())

        return sb.toString()
    }

    private fun recurseTree(parentNode: DecisionNode?, childNode: TreeNode?, sb: StringBuilder, visited: MutableSet<TreeNode>, leaves: MutableSet<TreeNode>) {
        if (parentNode == null || childNode == null) {
            // nothing to do here
            return
        }

        if (!visited.contains(childNode)) {
            sb.append("  ${childNode.label()} [${nodeLayout(childNode)}]\n")
            visited.add(childNode)
        }

        val edgeColor = if (childNode == parentNode.yesNode) "green" else "red"
        sb.append("  ${parentNode.label()} -> ${childNode.label()} [color=\"$edgeColor\"]\n")

        if (childNode is SimpleDecisionNode) {
            recurseTree(childNode, childNode.yesNode, sb, visited, leaves)
            recurseTree(childNode, childNode.noNode, sb, visited, leaves)
        } else {
            leaves.add(childNode)
        }
    }

    fun nodeLayout(childNode: TreeNode): String {
        return when (childNode) {
            is SimpleDecisionNode -> buildDecisionNodeLabel(childNode, "#91B449")
            is ResultNode -> buildResultNodeLabel(childNode, "#A6A6A6")
            is SubtreeBookmark -> buildLabel(childNode.subtreeName, "#4681BD") + buildLink(childNode)
            is ExceptionNode -> buildLabel(childNode.type, "#C0504D")
            else -> buildLabel(childNode.id.toString(), "grey")
        }
    }

    private fun buildLink(bookmark: SubtreeBookmark): String {
        return ", URL=\"${ServletUriComponentsBuilder.fromCurrentContextPath().pathSegment("tree/${bookmark.subtreeId.toString()}").build()}\""
    }

    fun TreeNode.label(): String {
        return Math.abs(this.hashCode()).toString()
    }

    private fun buildLabel(label: String, color: String): String {
        val cleanedLabel = label.replace("\"", "\\\"")
        return "label=\"${splitString(cleanedLabel)}\", fillcolor=\"$color\""
    }

    private fun buildDecisionNodeLabel(decisionNode: SimpleDecisionNode, color: String): String {
        val decisionRule = decisionNode.decisionRule
        var question = decisionRule.question
        decisionNode.parameterValues.forEachIndexed { i, pval ->
            val param = decisionRule.parameters[i]
            val value = if (pval != null) pval.displayName else "not set"
            question = question.replace("<${param.getName()}>", value)

        }

        return "label=\"${splitString(question)}\", fillcolor=\"$color\""
    }

    fun splitString(question: String?): StringBuilder {
        val output = StringBuilder(question)
        var index = 0
        while (index + LINE_LENGTH < output.length) {
            index = output.lastIndexOf(" ", index + LINE_LENGTH)
            if (index != -1) {
                output.replace(index, index + 1, "\n")
            }
        }
        return output
    }

    private fun buildResultNodeLabel(resultNode: ResultNode, color: String): String {
        val parameters = Maps.newHashMap<String, Any>()

        val countryResult = resultNode.getResult(LocationLevel.COUNTRY)
        val stateResult = resultNode.getResult(LocationLevel.STATE)

        if (countryResult != null) {
            parameters["taxIndicator"] = countryResult.taxIndicatorReference
            parameters["sellerGeoArea"] = countryResult.sellerJurisdictionReferenceLocation
            parameters["buyerGeoArea"] = countryResult.buyerJurisdictionReferenceLocation
            parameters["sellerTaxReg"] = countryResult.sellerTaxRegJurisdiction.orElse(null)
            parameters["buyerTaxReg"] = countryResult.buyerTaxRegJurisdiction.orElse(null)
        }

        if (stateResult != null) {
            parameters["additionalTaxIndicator"] = stateResult.taxIndicatorReference
            parameters["additionalSellerGeoArea"] = stateResult.sellerJurisdictionReferenceLocation
            parameters["additionalBuyerGeoArea"] = stateResult.buyerJurisdictionReferenceLocation
            parameters["additionalSellerTaxReg"] = stateResult.sellerTaxRegJurisdiction.orElse(null)
            parameters["additionalBuyerTaxReg"] = stateResult.buyerTaxRegJurisdiction.orElse(null)
        }

        val label = freemarker.buildResultNodeLabel(parameters)
        return "label=<$label>, fillcolor=\"$color\""
    }
}