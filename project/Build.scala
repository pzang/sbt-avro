import sbt._
import Keys._

object build extends Build {
    val scalaV = "2.10.5"
    val sbtAvro = Project(
        id = "sbt-avro",
        base = file("."),
        settings = Defaults.defaultSettings ++ Seq[Project.Setting[_]](
            organization := "com.cavorite",
            version := "0.3.3",
            sbtPlugin := true,
            libraryDependencies ++= Seq(
                    "org.apache.avro" % "avro" % "1.7.5",
                    "org.apache.avro" % "avro-compiler" % "1.7.5"
            ),
            scalaVersion := scalaV,
            scalacOptions in Compile ++= Seq("-deprecation"),
            crossScalaVersions := Seq(scalaV),
            description := "Sbt plugin for compiling Avro sources",

            publishTo := Some(Resolver.url("sbt-plugin-releases", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)),

            publishMavenStyle := false
        )
    )
}
