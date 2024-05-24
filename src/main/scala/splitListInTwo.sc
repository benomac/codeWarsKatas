object ListsOf {

  val stringList = ('a' to 'z').toList.map(_.toString)
  val charList = ('a' to 'k').toList
  val intList = (1 to 10).toList

  val allLists: (List[String], List[Char], List[Int]) = (stringList, charList, intList)

}

import ListsOf._
"a"
println(stringList)
println(intList)
println(charList)

def splitListInTwo[A](n: Int, count: Int = 1, list: List[A], acc: List[A] = Nil): (List[A], List[A]) = {
  (list, count == n) match {
    case (head :: tail, true) => (acc :+ head, tail)
    case (head :: tail, false) => splitListInTwo(n, count + 1, tail, acc :+ head)
    case (Nil, false) => (acc, List())
  }
}

def filter[A](f: A => Boolean, list: List[A], acc: List[A] = Nil): List[A] = {
  list match {
    case head :: tail if f(head) => filter(f, tail, acc :+ head)
    case _ :: tail => filter(f, tail, acc)
    case Nil => acc
  }
}

def extractSlice[A](i: Int, k: Int, list: List[A], acc: List[A]): List[A] = {
  val check: Int => Boolean = _ > 0
  (i, k, list) match {
    case (ib, _, _ :: tail) if check(ib)  => extractSlice(i - 1, k - 1, tail, acc)
    case (_, kb, head :: tail) if check(kb) => extractSlice(0, k - 1, tail, acc :+ head)
//    case (0, _, Nil) => List()
    case _ => acc

  }
}

extractSlice(3, 2, charList, Nil)
filter((x:Int) => x % 2 == 0, intList)