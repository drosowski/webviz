package de.smartsquare.dotlang.webview

import com.tinkerpop.blueprints.Direction
import com.tinkerpop.blueprints.impls.tg.TinkerGraph
import com.tinkerpop.blueprints.util.io.gml.GMLReader
import org.springframework.stereotype.Component
import java.io.InputStream

@Component
class GmlRenderer {

    fun renderDot(gmlStream: InputStream): String {
        val graph = TinkerGraph()
        val gmlReader = GMLReader.inputGraph(graph, gmlStream)

        val sb = StringBuilder("digraph {\n")

        for (vertex in graph.vertices) {
            val label = vertex.getProperty<String>("label")
            sb.append("${vertex.id} [label=\"$label\"]\n")
        }
        for (edge in graph.edges) {
            val outV = edge.getVertex(Direction.OUT)
            val inV = edge.getVertex(Direction.IN)
            val weight = edge.getProperty<Int>("value")
            val penwidth = if (weight <= 5) weight else 5;
            sb.append("${outV.id} -> ${inV.id} [label=\"$weight\",weight=\"$weight\",penwidth=\"$penwidth\"]\n")
        }

        sb.append("}")
        return sb.toString()
    }
}