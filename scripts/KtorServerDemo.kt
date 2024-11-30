///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS io.ktor:ktor-bom:3.0.1@pom
//DEPS io.ktor:ktor-server-netty-jvm
//DEPS io.ktor:ktor-serialization-jackson-jvm
//DEPS io.ktor:ktor-server-content-negotiation-jvm

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

data class Todo(val title: String, val isCompleted: Boolean)

fun main(args: Array<String>) {
    val todos = listOf(Todo("Sleep", false), Todo("Eat", true))
    print(todos)
    embeddedServer(Netty, 8080) {
        install(ContentNegotiation) {
            jackson {
                enable(SerializationFeature.INDENT_OUTPUT)
            }
        }
        routing { get("/") { call.respond(todos) } }
    }.start(wait = true)
}
