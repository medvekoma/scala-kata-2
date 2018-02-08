import scala.util.Random

class RichRandom {

  val random = new Random()

  def nextInt(min: Int, max: Int): Int = {
    val diff = max - min
    if (diff <= 0)
      throw new IllegalArgumentException("Max should be bigger than min.")
    min + random.nextInt(diff)
  }

}
