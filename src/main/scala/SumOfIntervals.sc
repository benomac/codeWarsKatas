val intervals = List((1, 5), (6, 10))

def sumOfIntervals(intervals: List[(Int, Int)]): Int = {
  val sorted = intervals.sortBy(_._1)
  val merged = sorted.foldLeft(List[(Int, Int)]()) { (acc, interval) =>
    acc match {
      case Nil => List(interval)
      case head :: tail =>
        if (head._2 >= interval._1) (head._1, interval._2 max head._2) :: tail
        else interval :: acc
    }
  }
  merged.map { case (a, b) => b - a + 1 }.sum
}