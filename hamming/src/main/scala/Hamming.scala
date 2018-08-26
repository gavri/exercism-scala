import scala.annotation.tailrec

object Hamming {
  def distance(xs: String, ys: String) = {
    if (xs.length != ys.length) {
      None
    }
    else {
      Some(xs.zip(ys).count { case (x, y) => x != y })
    }
  }
}
