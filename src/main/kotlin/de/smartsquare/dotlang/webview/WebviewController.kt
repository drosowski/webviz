package de.smartsquare.dotlang.webview

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class WebviewController(
        private val gmlRenderer: GmlRenderer
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
}
