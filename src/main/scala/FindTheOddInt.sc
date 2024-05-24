def findOdd(xs: Seq[Int]): Int = {
  xs.filter(x => xs.count(y => y == x) % 2 != 0).head
}

val g = List(1, 2, 2, 4, 4)
g.filter(x => g.count(y => y == x) % 2 != 0).head