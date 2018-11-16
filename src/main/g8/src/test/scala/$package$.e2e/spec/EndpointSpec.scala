package $package$.e2e.spec

import java.time.Clock

import $package$.{Application, ConfigValueProvider}
import com.typesafe.config.{ConfigFactory, ConfigValueFactory}
import io.grpc.ManagedChannelBuilder
import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, Matchers, WordSpec}

import scala.util.Random

abstract class EndpointSpec extends WordSpec with BeforeAndAfter with BeforeAndAfterAll with Matchers {

  private val bindPort = 8000 + Random.nextInt(999)
  private val channel  = ManagedChannelBuilder.forAddress("localhost", bindPort).usePlaintext(true).build

//protected var grpcService: GrpcService = _

  private val config = ConfigFactory
    .load("test.conf")
    .withValue("api.bind-port", ConfigValueFactory.fromAnyRef(bindPort))

  protected implicit var app: Application = _

  override protected def beforeAll(): Unit = {
    val appConfig = ConfigValueProvider.provide(config)

    app = new Application(appConfig)(Clock.systemUTC())

//    grpcService = GrpcServiceGrpc.blockingStub(channel)
    app.startServer()
  }

  override protected def afterAll(): Unit =
    app.stop()
}
