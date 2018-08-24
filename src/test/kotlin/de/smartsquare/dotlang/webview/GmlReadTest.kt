package de.smartsquare.dotlang.webview

import com.tinkerpop.blueprints.Direction
import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.GraphFactory
import com.tinkerpop.blueprints.impls.tg.TinkerGraph
import com.tinkerpop.blueprints.util.io.gml.GMLReader
import org.apache.commons.configuration.Configuration
import org.junit.Test

class GmlReadTest {

    @Test
    fun read_a_gml() {
        val gmlStream = javaClass.classLoader.getResourceAsStream("data/lesmiserables.gml")

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
        print(sb.toString())
    }
}