object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = multiplesToLimit(factors, limit).sum

  def multiplesToLimit(factors: Set[Int], limit: Int) = {
    (1 until limit).filter { n =>
      factors.exists { m =>
        isMultipleOf(n, m)
      }
    }
  }

  def isMultipleOf(m: Int, n: Int) = m % n == 0
}

