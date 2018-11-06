
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class TiamatCloud extends Simulation {

	val httpProtocol = http
		.baseUrl("https://code.jquery.com")
		.inferHtmlResources()

	val headers_6 = Map("User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36")

	val headers_9 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
		"cache-control" -> "max-age=0",
		"if-modified-since" -> "Mon, 22 Oct 2018 17:17:41 GMT",
		"if-none-match" -> "a1a3dede25c411096c04ea81f231c875:1540228727.334962",
		"upgrade-insecure-requests" -> "1",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36")

	val headers_12 = Map(
		"accept" -> "image/webp,image/apng,image/*,*/*;q=0.8",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-GB,en-US;q=0.9,en;q=0.8",
		"cache-control" -> "no-cache",
		"pragma" -> "no-cache",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36")

    val uri1 = "https://www.tiamat.cloud"
    val uri2 = "https://code.jquery.com/jquery-3.2.1.slim.min.js"
    val uri3 = "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
    val uri4 = "https://fonts.gstatic.com/s/fondamento/v8/4UaHrEJGsxNmFTPDnkaJ96rp5w.woff2"
    val uri5 = "https://fonts.googleapis.com"

	val scn = scenario("TiamatCloud")
		.exec(http("request_0")
			.get("/jquery-3.2.1.slim.min.js")
			.resources(http("TiamatCloudHomePage")
			.get(uri3 + ""),
            http("request_2")
			.get(uri1 + "/inline.a189011e10bdbeb6ed46.bundle.js"),
            http("request_3")
			.get(uri1 + "/polyfills.114b1052125ed9b9779c.bundle.js"),
            http("request_4")
			.get(uri1 + "/scripts.bde3a4cda34d1556c80e.bundle.js"),
            http("request_5")
			.get(uri1 + "/main.ce9d09b7a31d2b075d6b.bundle.js"),
            http("request_6")
			.get(uri5 + "/css?family=Fondamento")
			.headers(headers_6),
            http("request_7")
			.get(uri5 + "/icon?family=Material+Icons")
			.headers(headers_6),
            http("request_8")
			.get(uri1 + "/styles.aa074a48c36a0f0f2c89.bundle.css")
			.headers(headers_6),
            http("request_9")
			.get(uri1 + "/")
			.headers(headers_9)
			.check(status.is(304)),
            http("request_10")
			.get(uri4 + ""),
            http("request_11")
			.get(uri1 + "/assets/img/landing-bg.png"),
            http("request_12")
			.get(uri1 + "/favicon.ico")
			.headers(headers_12)))

	setUp(scn.inject(atOnceUsers(500))).protocols(httpProtocol)
}