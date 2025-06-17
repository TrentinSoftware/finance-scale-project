ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "finance-scala-project",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.10.0",
      "org.scalatest" %% "scalatest" % "3.2.17" % Test,
      "org.typelevel" %% "cats-effect" % "3.5.2" // Adição recomendada para efeitos funcionais
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-unchecked",
      "-language:implicitConversions",
      "-language:higherKinds"
    )
  )