package controllers

import javax.inject._

import play.api.libs.json._
import play.api.mvc._

import models.Announcement

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class AnnouncementController @Inject() extends Controller {

  val announcementsList: List[Announcement] = List(Announcement("toto"), Announcement("tata"))


  def announcements = Action { implicit request =>
    render {
      case Accepts.Html() => Ok(views.html.announcements("Announcements"))
      case Accepts.Json() => Ok(Json.toJson(announcementsList))
    }
  }

}
