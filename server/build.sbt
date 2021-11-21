name := "server"

version := "1.0"

description := "GraphQL server with akka-http and sangria"

scalaVersion := "2.12.14"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies ++= Seq(
  "org.sangria-graphql" %% "sangria" % "2.1.6",
  "org.sangria-graphql" %% "sangria-spray-json" % "1.0.2",

  "com.typesafe.akka" %% "akka-actor" % "2.6.17",
  "com.typesafe.akka" %% "akka-stream" % "2.6.17",
  "com.typesafe.akka" %% "akka-http" % "10.2.7",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.2.7",

  "ch.megard" %% "akka-http-cors" % "1.1.2",

  "com.typesafe.slick" %% "slick" % "3.3.3",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3",

  "org.slf4j" % "slf4j-nop" % "1.6.6",

  "com.h2database" % "h2" % "1.4.196",


  "org.scalatest" %% "scalatest" % "3.2.9" % Test
)

Revolver.settings
