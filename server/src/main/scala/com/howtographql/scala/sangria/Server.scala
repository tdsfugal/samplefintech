package com.howtographql.scala.sangria

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import akka.http.scaladsl.server.Directives._
import spray.json._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
// import ch.megard.akka.http.cors.scaladsl.CorsDirectives.cors

import scala.concurrent.Await
import scala.language.postfixOps

object Server extends App {

  val PORT = 8080

  implicit val actorSystem = ActorSystem("graphql-server")

  import actorSystem.dispatcher
  import scala.concurrent.duration._

  scala.sys.addShutdownHook(() -> shutdown())

  // val route: Route = cors() {
  val route: Route =
    (post & path("graphql")) {
      entity(as[JsValue]) {requestJson =>
        GraphQLServer.endpoint(requestJson)
      }
    } ~ {
      getFromResource("graphiql.html")
    }

  Http().newServerAt("0.0.0.0", PORT).bind(route)
  println(s"GraphQL endpoint is at URL: http://localhost:$PORT")

  def shutdown(): Unit = {
    actorSystem.terminate()
    Await.result(actorSystem.whenTerminated, 30 seconds)
  }
}
