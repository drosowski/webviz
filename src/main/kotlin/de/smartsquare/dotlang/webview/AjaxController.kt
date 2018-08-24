package de.smartsquare.dotlang.webview

import bsh.EvalError
import bsh.Interpreter
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AjaxController {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/api/gendot")
    fun genDot(@RequestBody bshCode: String): ResponseEntity<*> {
        val i = Interpreter()
        try {
            i.eval(bshCode)
            val model = i.get("model")
            val dot = LJV.drawGraph(model)
            log.info("\n" + dot)
            return ResponseEntity.ok(dot)
        } catch (evalError: EvalError) {
            log.error("Error evaluating bsh", evalError)
            return ResponseEntity.badRequest().body("Error evaluating bsh: " + evalError.message)
        }

    }
}
