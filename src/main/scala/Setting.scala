case class Setting(min: Option[Int], max: Option[Int], isHelp: Boolean)

object Setting {
  val Empty = new Setting(None, None, false)
}