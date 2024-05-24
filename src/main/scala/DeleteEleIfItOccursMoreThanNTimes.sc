val list = List(1, 1, 3, 3, 3, 7, 2, 2, 2, 2)



//def sumConsecutives(xs: List[Int], acc: List[Int]): List[Int] =
//  if (xs.isEmpty) Nil else xs.span(_ == xs.head) match {
//    case (a, b) => a.sum :: sumConsecutives(b)
//  }


def deleteNth(elements: List[Int], max: Int): List[Int] =
  elements
    .fold(List[Int]()) {
      case (xs, x) if xs.count(_ == x) < max => x :: xs
      case (xs, _)                           => xs
    }.reverse

deleteNth(list, 1)