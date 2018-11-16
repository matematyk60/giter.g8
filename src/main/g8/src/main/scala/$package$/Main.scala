package $package$

import java.time.Clock

import com.typesafe.config.ConfigFactory

object Main extends App {

  val config = args.headOption match {
    case None           => ConfigFactory.load("base.conf")
    case other          => throw new UnsupportedOperationException(s"Cannot start application for config: $other.")
  }

  val configuration = ConfigValueProvider.provide(config)

  val app = new Application(configuration)(Clock.systemUTC())

  app.startServer()
}
