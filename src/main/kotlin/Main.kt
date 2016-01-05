import io.vertx.core.AbstractVerticle
import io.vertx.core.logging.LoggerFactory
import io.vertx.kotlin.lang.*

class MainVerticle : AbstractVerticle() {
    override fun start() {
        val logger = LoggerFactory.getLogger("main")

        val route = Route {

            GET("/api/v1/conf") { request ->
                bodyJson {
                    "field1" to "this is a test"
                }
            }

            GET(glob("/static/**/*")) { request -> sendFile(request.path().substring(1)) }
            GET("/") { request -> sendFile("static/templates/index.html") }
            GET("/index.html") { request -> sendFile("static/templates/index.html") }
            otherwise { request -> sendFile("static/templates/index.html") }
        }
        httpServer(8084, "0.0.0.0", block = route)
    }
}
