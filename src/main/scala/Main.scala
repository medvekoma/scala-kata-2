import scala.util.{Failure, Random, Success, Try}

sealed trait Result
case class RandomResult(value: Int) extends Result
object HelpResult extends Result

object Main extends App {

  val random = new Random
  val richRandom = new RichRandom

  def main(): Result = {
    val setting = SettingParser.parse(args)
    setting match {
      case Setting(_, _, true) => HelpResult
      case Setting(Some(min), Some(max), _) => RandomResult(richRandom.nextInt(min, max))
      case Setting(_, Some(max), _) => RandomResult(random.nextInt(max))
      case Setting(Some(min), None, _) => RandomResult(richRandom.nextInt(min, Int.MaxValue))
      case _ => RandomResult(random.nextInt)
    }
  }

  Try(main()) match {
    case Failure(exception) => println(s"ERROR: $exception")
    case Success(HelpResult) => println("Help string")
    case Success(RandomResult(value)) => println(value)
  }
}
