import org.scalatestplus.play._
import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

class AnnoucementInteg   extends PlaySpec with OneServerPerTest with OneBrowserPerTest with HtmlUnitFactory {

  "Announcements" should {

    "work from within a browser" in {

      go to (s"http://localhost:$port/")

      pageTitle mustBe  ("Announcements")

      find(cssSelector("h1")) map(_.underlying.getText) mustBe Some("Announcements")
      findAll(cssSelector(".announcement")).toList.size mustBe 2
    }

    "add a new announcement" in {
      go to (s"http://localhost:$port/")
      val nbBeforeAdd = findAll(cssSelector(".announcement")).toList.size

      val request = FakeRequest(POST, "/announcements")
        .withHeaders("Content-Type" -> "application/json")
        .withJsonBody(Json.parse("""{"message": "titi"}"""))
      //Comment serialiser automatiquement Announcement
      val addAnnouncement = route(app, request).get

      go to (s"http://localhost:$port/")
      val nbAfterAdd = findAll(cssSelector(".announcement")).toList.size

      nbAfterAdd mustBe nbBeforeAdd + 1
    }


  }

}
