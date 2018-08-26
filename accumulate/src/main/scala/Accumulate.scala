import scala.annotation.tailrec

class Accumulate {
  def accumulate[A, B](f: (A) => B, list : List[A]): List[B] = accumulateRecur(f, list, List[B]()).reverse

  @tailrec private[this] def accumulateRecur[A, B](f: (A) => B, list: List[A], resultSoFar: List[B]): List[B] = list match {
    case Nil => resultSoFar
    case x :: xs => accumulateRecur(f, xs, f(x) :: resultSoFar)
  }
}
