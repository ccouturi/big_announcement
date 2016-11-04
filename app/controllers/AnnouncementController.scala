package controllers

import javax.inject._

import play.api.libs.json._
import play.api.mvc._
import models.Announcement

import scala.collection.mutable.MutableList

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class AnnouncementController @Inject() extends Controller {

  val announcementsList: MutableList[Announcement] = MutableList(Announcement("toto"), Announcement("tata"))


  def announcements = Action { implicit request =>
    render {
      case Accepts.Html() => Ok(views.html.announcements(announcementsList))
      case Accepts.Json() => Ok(Json.toJson(announcementsList))
    }
  }

  def addAnnouncement() = Action { implicit request =>
    request.body.asJson match {
      case Some(newAnnouncement) => {
        announcementsList += newAnnouncement.as[Announcement]
        Created(Json.toJson("{}"))
      }
      case None => BadRequest("fail")
    }

  }

}
