
object SettingParser {

  def parse(args: Array[String]): Setting = parse(args.toList, Setting.Empty)

  def parse(args: List[String], setting: Setting): Setting = {
    args match {
      case ("-h" | "--help") :: tail => parse(tail, setting.copy(isHelp = true))
      case ("-i" | "--min")  :: min :: tail => parse(tail, setting.copy(min = Some(min.toInt)))
      case ("-a" | "--max")  :: max :: tail => parse(tail, setting.copy(max = Some(max.toInt)))
      case Nil => setting
      case head :: tail => throw new IllegalArgumentException(head)
    }

  }
}
