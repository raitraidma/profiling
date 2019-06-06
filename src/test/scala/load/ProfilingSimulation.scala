package load

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class ProfilingSimulation extends Simulation {
  val applicationPort = Integer.getInteger("applicationPort", 9000).toInt;

  val httpProtocol = http.baseUrl("http://localhost:" + applicationPort)

  val latestPosts = scenario("Get latest posts")
    .repeat(300) {
      exec(http("GET /posts/latest").get("/posts/latest"))
    }

  val latestComments = scenario("Get latest comments")
    .repeat(300) {
      exec(http("GET /comments/latest").get("/comments/latest"))
    }

  val avatarScenario = scenario("Get author's avatar")
    .repeat(150) {
      exec(http("GET /authors/1/avatar").get("/authors/1/avatar"))
    }

  val commentContainsTextCountScenario = scenario("Get count of comments that contain 'daenerys'")
    .repeat(20) {
      exec(http("GET /comments/contains/daenerys/count").get("/comments/contains/daenerys/count"))
    }

  setUp(
    avatarScenario.inject(atOnceUsers(50)),
    commentContainsTextCountScenario.inject(atOnceUsers(50)),
    latestPosts.inject(atOnceUsers(50)),
    latestComments.inject(atOnceUsers(50))
  ).protocols(httpProtocol)
    .assertions(
      global.responseTime.max.lt(3000),
      global.successfulRequests.percent.gt(95)
    )
}
