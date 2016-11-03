import org.scalatestplus.play._
import play.api.test._
import play.api.test.Helpers._

class AnnoucementInteg   extends PlaySpec with OneServerPerTest with OneBrowserPerTest with HtmlUnitFactory {

  "Announcements" should {

    "work from within a browser" in {

      go to (s"http://localhost:$port/announcements")

      pageTitle mustBe  ("Announcements")

      find(cssSelector("h1")) map(_.underlying.getText) mustBe Some("Announcements")
    }


  }

}
