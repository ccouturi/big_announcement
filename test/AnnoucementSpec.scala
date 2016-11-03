import org.scalatestplus.play._
import play.api.mvc.Headers
import play.api.test._
import play.api.test.Helpers._

/**
  * Created by jcoudon on 11/3/16.
  */
class AnnoucementSpec extends PlaySpec with OneAppPerTest {

  "AnnoucementController" should {

    "render html list page" in {
      val announcements = route(app, FakeRequest(GET, "/announcements")).get

      status(announcements) mustBe OK
      contentType(announcements) mustBe Some("text/html")
      contentAsString(announcements) must include ("Announcements")

    }

    "render json list page" in {
      val request = FakeRequest(GET, "/announcements")
        .withHeaders("Accept" -> "application/json")
      val announcements = route(app, request).get

      status(announcements) mustBe OK
      contentType(announcements) mustBe Some("application/json")
      contentAsString(announcements) must include ("[]")

    }

  }


}
