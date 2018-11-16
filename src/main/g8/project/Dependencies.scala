import DependencyVersions._
import sbt._

object Dependencies {

  private val akkaDependencies = Seq(
    "com.typesafe.akka" %% "akka-actor"       % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j"       % akkaVersion,
    "com.typesafe.akka" %% "akka-persistence" % akkaVersion
  )

  private val akkaPersistenceDependencies = Seq(
    "com.github.dnvriend" %% "akka-persistence-inmemory"  % inMemJournalVersion,
    "com.typesafe.akka"   %% "akka-persistence-cassandra" % akkaCassandraVersion
  )

  private val loggingDependencies = Seq(
    "ch.qos.logback"             % "logback-classic"  % logbackVersion,
    "ch.qos.logback"             % "logback-core"     % logbackVersion,
    "org.slf4j"                  % "jcl-over-slf4j"   % slf4jVersion,
    "org.slf4j"                  % "log4j-over-slf4j" % slf4jVersion,
    "org.slf4j"                  % "jul-to-slf4j"     % slf4jVersion,
    "com.typesafe.scala-logging" %% "scala-logging"   % scalaLoggingVersion
  )

  private val hasherDependencies = Seq(
    "com.roundeights" %% "hasher" % hasherVersion
  )

  private val catsDependencies = Seq(
    "org.typelevel" %% "cats-core"   % catsVersion,
    "org.typelevel" %% "cats-effect" % catsEffectVersion
  )

  private val mongoDependencies = Seq(
    "org.reactivemongo" %% "reactivemongo" % mongoVersion
  )

  private val grpcDependencies = Seq(
    "io.grpc"                % "grpc-netty"            % grpcNettyVersion,
    "com.trueaccord.scalapb" %% "scalapb-runtime-grpc" % grpcRuntimeVersion
  )

  private val commonDependencies = Seq(
    "io.codeheroes" %% "codeheroes-commons" % codeheroesCommonsVersion
  )

  private val testDependencies = Seq(
    "org.scalatest"     %% "scalatest"    % scalaTestVersion % Test,
    "org.scalamock"     %% "scalamock"    % scalaMockVersion % Test,
    "org.scalacheck"         %% "scalacheck"               % scalaCheckVersion      % Test,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion      % Test,
    "com.typesafe.akka"      %% "akka-testkit"             % akkaVersion            % Test,
    "com.github.simplyscala" %% "scalatest-embedmongo"     % embeddedMongoVersion   % Test,
    "de.flapdoodle.embed"    % "de.flapdoodle.embed.mongo" % flapdoodleMongoVersion % Test
  )

  val all: Seq[ModuleID] =
    akkaPersistenceDependencies ++
      loggingDependencies ++
      akkaDependencies ++
      catsDependencies ++
      mongoDependencies ++
      hasherDependencies ++
      grpcDependencies ++
      commonDependencies ++
      testDependencies

  val additionalResolvers = Seq(
    Resolver.jcenterRepo,
    Resolver.mavenCentral,
    Resolver.bintrayRepo("codeheroes", "maven"),
    "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
  )
}
