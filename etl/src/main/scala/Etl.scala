object Etl {
  def transform(input: Map[Int, Seq[String]]): Map[String, Int] = transformList(input.toList).toMap

  private[this] def transformList(input: List[(Int, Seq[String])]): List[(String, Int)] = {
    input.flatMap { case(score, letters) =>
      letters.map {(letter: String) => (letter.toLowerCase, score)}
    }
  }
}
