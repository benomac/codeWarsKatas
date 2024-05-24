def multiplicationTable(size: Int): List[List[Int]] = {
  val list = Range.inclusive(1, size).toList
  def makeArray(l: List[Int], n: Int, m: Int, acc: List[List[Int]]): List[List[Int]] = {
    n match {
      case 0 => acc
      case _ => makeArray(l, n - 1, m + 1, acc ::: List(l.map(_ * m)))
    }
  }
  makeArray(list, size, 1, Nil)
}
//"  [[1,2,3],[2,4,6],[3,6,9]]"
//val d = Range.inclusive(1, size).toList
//def makeArray(l: List[Int], n: Int, m: Int, acc: List[List[Int]]): List[List[Int]] = {
//  n match {
//    case 0 => acc
//    case _ => makeArray(l, n - 1,  m + 1, acc ::: List(l.map(_ * m)))
//  }
//}
multiplicationTable(5)