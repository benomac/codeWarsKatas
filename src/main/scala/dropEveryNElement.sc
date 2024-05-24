val list = (1 to 10).toList
val listChar = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')

def dropEveryNthElement[A](list: List[A], n: Int, acc: List[A], counter:Int): List[A] = {
  (list, counter == n) match {
    case (_ :: tail, true) => dropEveryNthElement(tail, n, acc, 0)
    case (head :: tail, false) => dropEveryNthElement(tail, n, acc :+ head, counter + 1)
    case (Nil, _) => acc
  }
}


dropEveryNthElement(listChar, 2, Nil, 0)


