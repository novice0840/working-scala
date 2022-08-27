ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

val zioVersion = "2.0.0"
val sttpVersion = "3.7.4"
val sttpClientVersion = "3.7.4"


lazy val sharedSettings = Seq(
  libraryDependencies ++= Seq(
    "dev.zio" %% "zio" % zioVersion,
    "dev.zio" %% "zio-test" % zioVersion % Test,
    "dev.zio" %% "zio-test-sbt" % zioVersion % Test,
  ),
)

lazy val root = (project in file("."))
  .settings(
    name := "working-scala"
  )

lazy val `zio-json` = project
  .settings(sharedSettings)
  .settings(
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio-json" % "0.3.0-RC10",
    )
  )

lazy val `tapir-with-zio-http` = project
  .settings(sharedSettings)
  .settings(
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio-json" % "0.3.0-RC10",
      "io.d11" %% "zhttp" % "2.0.0-RC10",
      "com.softwaremill.sttp.tapir" %% "tapir-zio" % "1.0.4",
      "com.softwaremill.sttp.tapir" %% "tapir-zio-http-server" % "1.0.4"
    )
  )