package $package$

import com.typesafe.config.Config

object ConfigValueProvider {

  def provide(config: Config): Configuration =
    Configuration(
      config,
      ApiConfig(
        config.getInt("api.bind-port")
      )
    )

  final case class Configuration(
      rawConfig: Config,
      apiConfig: ApiConfig
  )

  final case class ApiConfig(
      port: Int
  )
}
