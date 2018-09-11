package de.smartsquare.dotlang.webviz

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WebvizApplication {
}

fun main(args: Array<String>) {
    SpringApplication.run(WebvizApplication::class.java, *args)
}
