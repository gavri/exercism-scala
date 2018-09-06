object Bearing extends Enumeration {
  val North, East, South, West = Value

  def right(bearing: Value) = apply((bearing.id + 1) % maxId)
  def left(bearing: Value) = apply((bearing.id + maxId - 1) % maxId)
}

case class Robot(var bearing: Bearing.Value, var coordinates: (Int, Int)) {
  def turnRight = { bearing = Bearing.right(bearing); this }

  def turnLeft = { bearing = Bearing.left(bearing); this }

  def advance = {
    coordinates = bearing match {
      case Bearing.North => mapY(_ + 1)
      case Bearing.South => mapY(_ - 1)
      case Bearing.East => mapX(_ + 1)
      case Bearing.West => mapX(_ - 1)
    }
    this
  }

  def simulate(input: String) = {
    val commands = input.map(commandsMap(_))
    commands.reduce(_ andThen _)(this)
  }

  private val commandsMap: Map[Char, Robot => Robot] = Map('L' -> (_.turnLeft), 'R' -> (_.turnRight), 'A' -> (_.advance))

  private[this] def mapX(f: Int => Int) = (f(coordinates._1), coordinates._2)
  private[this] def mapY(f: Int => Int) = (coordinates._1, f(coordinates._2))
}
