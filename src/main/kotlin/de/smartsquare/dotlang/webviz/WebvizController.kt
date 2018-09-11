package de.smartsquare.dotlang.webviz

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class WebvizController(
        private val gmlRenderer: GmlRenderer,
        private val taxTreeRenderer: TaxTreeRenderer
) {


    @RequestMapping("/java")
    fun java(model: Map<String, Any>): String {
        return "java"
    }

    @RequestMapping(value = ["/", "/sketch"])
    fun sketch(model: Map<String, Any>): String {
        return "sketch"
    }

    @RequestMapping("/network")
    fun ebaum(model: MutableMap<String, Any>): String {
        val graph = gmlRenderer.renderDot(javaClass.classLoader.getResourceAsStream("data/lesmiserables.gml"))
        model["graph"] = graph
        return "network"
    }

    @RequestMapping("/tree")
    fun tree(model: MutableMap<String, Any>): String {
        val graph = taxTreeRenderer.renderDot(javaClass.classLoader.getResourceAsStream("data/Complex_Tree.tdt"))
        model["graph"] = graph
        return "tree"
    }

    @RequestMapping("/tree/{subtreeId}")
    fun tree(model: MutableMap<String, Any>, @PathVariable("subtreeId") subtreeId: String): String {
        val graph = taxTreeRenderer.renderDot(javaClass.classLoader.getResourceAsStream("data/Complex_Tree.tdt"), subtreeId)
        model["graph"] = graph
        return "tree"
    }
}
