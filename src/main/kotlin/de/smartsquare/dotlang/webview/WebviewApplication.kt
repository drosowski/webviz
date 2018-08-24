package de.smartsquare.dotlang.webview

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WebviewApplication {
}

fun main(args: Array<String>) {
    SpringApplication.run(WebviewApplication::class.java, *args)
}
