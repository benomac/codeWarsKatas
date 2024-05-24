//def arrayDiff(a: Seq[Int], b: Seq[Int]): Seq[Int] = {
//  if(a.isEmpty || b.isEmpty) a else {
//    val a2 = a.toList
//    val b2 = b.toList
//
//    def rec(a2: List[Int], b2: List[Int]): List[Int] = {
//
//      (a2, b2) match {
//        case (_, Nil) => a2
//        case (a, ::(h, t)) => rec(a.filterNot(x => x == h), t)
//      }
//    }
//
//    rec(a2, b2)
//  }
//}

def arrayDiff(a: Seq[Int], b: Seq[Int]): Seq[Int] = {
  if(a.isEmpty || b.isEmpty) a else {
    (a.toList, b.toList) match {
      case (_, Nil) => a
      case (a, ::(h, t)) => arrayDiff(a.filterNot(x => x == h), t)
    }
  }
}
val a = Vector(-1, 2, 3, 1)
val b = Vector(-1, 2, 3).toList
a.isEmpty

arrayDiff(a, b)
//a.filterNot(x => x == b.head)

