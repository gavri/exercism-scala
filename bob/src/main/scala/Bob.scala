object Bob {
  def response(statement: String): String = {
    val trimmedStatement = statement.trim

    if (isSilence(trimmedStatement)) { "Fine. Be that way!" }
    else if (isYelledOutQuestion(trimmedStatement)) { "Calm down, I know what I'm doing!" }
    else if (isYelledOut(trimmedStatement)) { "Whoa, chill out!" }
    else if (isQuestion(trimmedStatement)) { "Sure." }
    else { "Whatever." }
  }

  private[this] def isSilence(statement: String) = "^\\s*$".r.pattern.matcher(statement).matches
  private[this] def isYelledOutQuestion(statement: String) = isQuestion(statement) && isYelledOut(statement)
  private[this] def isYelledOut(statement: String) = !statement.exists(_.isLower) && statement.exists(_.isUpper)
  private[this] def isQuestion(statement: String) = statement.last == '?'
}
