def score(dice: List[Int]): Int = {
  val f = dice.groupBy(identity).map {
    case (k, v) => (k, v.length)
  }

  def tally(m: Map[Int, Int], s: Int): Int = {
    def cal(n: Int): Int = {
      m.head._1 match {
        case 1 => if (n >= 3) tally(m.tail, s + 1000 + ((n - 3) * 100)) else tally(m.tail, s + (n * 100))
        case 5 => if (n >= 3) tally(m.tail, s + 500 + ((n - 3) * 50)) else tally(m.tail, s + (n * 50))
        case _ => if (n >= 3) tally(m.tail, s + (m.head._1 * 100)) else tally(m.tail, s)
      }
    }
    if (m.isEmpty)
      s
    else
      m.head match {
        case (1, n) => cal(n)
        case (2, n) => cal(n)
        case (3, n) => cal(n)
        case (4, n) => cal(n)
        case (5, n) => cal(n)
        case (6, n) => cal(n)
        case _ => tally(m.tail, s)
      }
  }
  tally(f, 0)
}

score(List(2, 2, 2, 3, 3))

