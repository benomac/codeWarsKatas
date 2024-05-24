val list = List(1, 2, 3, 4)

def duplicateElements[A](list: List[A], acc: List[A]): List[A] =
  list match {
    case ::(head, next) => duplicateElements(next, acc ::: List(head, head))
    case Nil => acc
  }

duplicateElements(list, Nil)

def duplicateElementsNTimes[A](n: Int, list: List[A]): List[A] = {
  def helper(n: Int, remaining: Int, list: List[A], acc: List[A]): List[A] =
    (remaining, list) match {
      case (_, Nil) => acc
      case (0, _ :: tail) => helper(n, n, tail, acc)
      case (_, head :: tail) => helper(n, remaining - 1, head :: tail, acc :+ head)
    }
  helper(n, n, list, Nil)
}

def duplicateElementsNTimes2[A](n: Int, list: List[A]): List[A] = {
  def helper(remaining: Int, list: List[A], newList: List[A]): List[A] =
    (remaining, list) match {
      case (_, Nil) => newList
      case (0, _ :: tail) => {
        println(tail)
        helper(n, tail, newList)
      }
      case (_, head :: _) => helper(remaining - 1, list, newList :+ head)
    }
  helper(n, list, Nil)
}

duplicateElementsNTimes(3, list)
duplicateElementsNTimes2(3, list)