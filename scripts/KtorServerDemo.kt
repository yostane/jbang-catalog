///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS io.ktor:ktor-bom:3.0.1@pom
//DEPS io.ktor:ktor-server-netty-jvm
//DEPS io.ktor:ktor-serialization-kotlinx-json-jvm
//DEPS io.ktor:ktor-server-content-negotiation-jvm

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.engine.*

@Serializable
data class Project(val name: String, val language: String)

fun main(args: Array<String>) {
    embeddedServer(Netty, 8080) {
        install(ContentNegotiation) {
            json()
        }
        routing {
            get("/") {
                call.respond(mapOf("hello" to "world"))
            }
        }
    }.start(wait = true)
}