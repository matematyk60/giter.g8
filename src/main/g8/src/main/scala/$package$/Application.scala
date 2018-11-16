package $package$

import java.time.Clock

import $package$.ConfigValueProvider.Configuration
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.typesafe.scalalogging.StrictLogging
import io.grpc.Server
import io.grpc.netty.NettyServerBuilder

import scala.concurrent.ExecutionContext

class Application(configuration: Configuration)(implicit clock: Clock) extends StrictLogging {

  private implicit val system: ActorSystem =
    ActorSystem("TrainingService", configuration.rawConfig)
  private implicit val dispatcher: ExecutionContext    = system.dispatcher
  private implicit val materializer: ActorMaterializer = ActorMaterializer()

  private val apiConfig = configuration.apiConfig

  private var server: Server = _

  def startServer(): Unit =
    try {
      server = NettyServerBuilder
        .forPort(apiConfig.port)
//        .addService(Grpc.bindService())
        .build()
        .start()

      logger.info(s"Service started on port: \${apiConfig.port}")
    } catch {
      case ex: Throwable =>
        logger.error(s"Error encountered while binding to port \${apiConfig.port}", ex)
    }

  def stop(): Unit = {
    system.terminate()
    if (server != null) server = server.shutdown()
  }
}
