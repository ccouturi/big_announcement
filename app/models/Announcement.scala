package models

import play.api.libs.json._

case class Announcement(val message: String)

object Announcement {
  implicit val announcementReads = Json.reads[Announcement]
  implicit val announcementWrites = Json.writes[Announcement]
}
