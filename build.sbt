name := "akka-fault-tolerance"

version := "1.0"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "2.4.14" % "test",
    "com.typesafe.akka" %% "akka-actor" % "2.4-SNAPSHOT")

resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

