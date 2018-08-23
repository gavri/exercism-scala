import scala.collection.immutable.SortedMap

class School {
  type DB = Map[Int, Seq[String]]

  var db: DB = SortedMap[Int, Seq[String]]().withDefaultValue(Seq())

  def add(name: String, g: Int) = {
    db = db.updated(g, db(g) :+ name)
  }

  def grade(g: Int): Seq[String] = db(g)

  def sorted: DB = db.mapValues(_.sorted)
}
