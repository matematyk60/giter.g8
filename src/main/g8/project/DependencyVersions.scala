import com.trueaccord.scalapb.compiler.Version

object DependencyVersions {
  val akkaVersion              = "2.5.17"
  val logbackVersion           = "1.2.3"
  val slf4jVersion             = "1.7.25"
  val scalaLoggingVersion      = "3.9.0"
  val catsVersion              = "1.4.0"
  val catsEffectVersion        = "1.0.0"
  val scalaTestVersion         = "3.0.5"
  val scalaCheckVersion        = "1.14.0"
  val scalaMockVersion         = "4.1.0"
  val hasherVersion            = "1.2.0"
  val chimneyVersion           = "0.2.1"
  val inMemJournalVersion      = "2.5.1.1"
  val akkaCassandraVersion     = "0.80"
  val mongoVersion             = "0.16.0"
  val codeheroesCommonsVersion = "0.3"
  val embeddedMongoVersion     = "0.2.4"
  val flapdoodleMongoVersion   = "2.0.3"

  val grpcNettyVersion: String   = Version.grpcJavaVersion
  val grpcRuntimeVersion: String = Version.scalapbVersion
}
