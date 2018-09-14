import scala.collection.immutable.ListMap

object SecretHandshake {

  val bitPositionToCommand = ListMap(0 -> "wink", 1 -> "double blink", 2 -> "close your eyes", 3 -> "jump")

  def commands(n: Int): List[String] = {
    val isBitSet = (bit: Int) => (n & (1 << bit)) != 0
    val handshake = bitPositionToCommand.filterKeys(isBitSet).values.toList
    if (isBitSet(4)) handshake.reverse else handshake
  }
}
