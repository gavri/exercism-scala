object CollatzConjecture {
  def stepsRecur(n: Int, count: Int): Int = n match {
    case 1 => count
    case n if isEven(n) => stepsRecur(n / 2, count + 1)
    case n => stepsRecur(3 * n + 1, count + 1)
  }

  def steps(n: Int): Option[Int] = {
    if (n < 1) None
    else Some(stepsRecur(n, 0))
  }

  private[this] def isEven(n: Int) = n % 2 == 0
}
