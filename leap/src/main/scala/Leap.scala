object Leap {
  def leapYear(year: Int): Boolean = {
    isDivisibleBy(year, 400) ||
    isDivisibleBy(year, 4) && !isDivisibleBy(year, 100)
  }

  private[this] def isDivisibleBy(m: Int, n: Int) = m % n == 0
}
