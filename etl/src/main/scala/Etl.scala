object Etl {
  def transform(input: Map[Int, Seq[String]]): Map[String, Int] = transformList(input.toList).toMap

  private[this] def transformList(input: List[(Int, Seq[String])]): List[(String, Int)] = {
    for {
      (score, letters) <- input
      letter <- letters
    } yield (letter.toLowerCase, score)
  }
}
