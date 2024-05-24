case class SplitTime(seconds: Int) {
  private def secs = seconds % 60
  def printSecs = if(secs == 0) "" else if (secs == 1) s"$secs second" else s"$secs seconds"

  private def mins = ((seconds - secs) / 60) % 60
  def printMins = if(mins == 0) "" else if (mins == 1) s"$mins minute" else s"$mins minutes"

  private def hours = (((seconds - secs) / 60) / 60) % 24
  def printHours = if(hours == 0) "" else if (hours == 1) s"$hours hour" else s"$hours hours"

  private def days = ((((seconds - secs) / 60) / 60) / 24) % 365
  def printDays = if(days == 0) "" else if (days == 1) s"$days day" else s"$days days"

  private def years = ((((seconds - secs) / 60) / 60) / 24) / 365
  def printYears = if(years == 0) "" else if (years == 1) s"$years year" else s"$years years"

  def printTime = {
    val timeList = List(printYears, printDays, printHours, printMins, printSecs).filterNot(_ == "")
    timeList match {
      case Nil => "now"
      case ::(head, Nil) => head
      case l => s"${l.dropRight(1)mkString(", ")} and ${l.last}"
    }
  }
}

def formatDuration(seconds: Int): String = {
  val time = SplitTime(seconds)
  time.printTime
}
formatDuration(132030240)