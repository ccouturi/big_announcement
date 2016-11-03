import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._

/**
  * Created by jcoudon on 11/3/16.
  */
class AnnoucementSpec extends PlaySpec with OneAppPerTest {

  "AnnoucementController" should {

    "render the index page" in {
      val announcements = route(app, FakeRequest(GET, "/announcements")).get

      status(announcements) mustBe OK
      contentType(announcements) mustBe Some("text/html")
      contentAsString(announcements) must include ("Announcements")
    }

  }


}
