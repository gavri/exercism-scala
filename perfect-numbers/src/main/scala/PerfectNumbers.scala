class NumberType

object NumberType extends Enumeration {
  case object Perfect extends NumberType
  case object Abundant extends NumberType
  case object Deficient extends NumberType
}

object PerfectNumbers {
  def classify(n: Int): Either[String, NumberType] = {
    if (n <= 0) Left("Classification is only possible for natural numbers.")
    else Right(classifyNaturalNumber(n))
  }

  private[this] def classifyNaturalNumber(n: Int): NumberType = {
    if (sumOfFactors(n) < n) NumberType.Deficient
    else if (sumOfFactors(n) == n) NumberType.Perfect
    else NumberType.Abundant
  }

  private[this] def sumOfFactors(n: Int): Int = {
    1.to(n/2).filter(n % _ == 0).sum
  }
}
