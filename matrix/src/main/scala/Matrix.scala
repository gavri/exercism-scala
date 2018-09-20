case class Matrix(input: String) {
  val parsed  = input.lines.map(_.split(" "))

  val row = parsed.map(_.map(_.toInt).toVector).toVector
  val column = row.transpose
}
