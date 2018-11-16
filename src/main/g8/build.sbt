name := "pel-service"
scalaVersion := "2.12.7"
version := "0.01"

enablePlugins(SbtNativePackager)
enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

val baseSettings = Seq(
  scalaVersion := "2.12.7",
  resolvers ++= Dependencies.additionalResolvers,
  libraryDependencies ++= Dependencies.all,
  sources in (Compile, doc) := Seq.empty,
  publishArtifact in (Compile, packageDoc) := false,
  publishArtifact in packageDoc := false,
  parallelExecution in Test := true,
  scalacOptions += "-Ypartial-unification"
)

val dockerSettings = Seq(
  dockerBaseImage := "java:openjdk-8",
  daemonUser in Docker := "root",
  dockerRepository := Some("docker.codeheroes.io"),
  dockerExposedPorts := Seq(8080)
)

val protoSettings = Seq(
  PB.targets in Compile := Seq(
    scalapb.gen(flatPackage = true) -> (sourceManaged in Compile).value
  )
)

lazy val `$name$` =
  project
    .in(file("."))
    .settings(baseSettings: _*)
    .settings(dockerSettings: _*)
    .settings(protoSettings: _*)

PB.protoSources in Compile := Seq(
  //here goes directories with protobufs
  //baseDirectory.value / "pel-proto-files" / "training"
)