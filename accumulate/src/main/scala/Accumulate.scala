import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

class Accumulate {
  def accumulate[A, B](f: (A) => B, list : List[A]): List[B] = accumulateRecur(f, list, new ListBuffer[B]()).toList

  @tailrec private[this] def accumulateRecur[A, B](f: (A) => B, list: List[A], resultSoFar: ListBuffer[B]): ListBuffer[B] = list match {
    case Nil => resultSoFar
    case x :: xs => accumulateRecur(f, xs, resultSoFar += f(x))
  }
}
