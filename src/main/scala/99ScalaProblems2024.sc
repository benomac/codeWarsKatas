val list = List(0, 1, 2, 3, 3, 4, 4, 5, 6, 4, 7, 8)
val charList = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
val listPalindrome = List(1, 2, 1)
Nil.length

def lastElement(list: List[Int]): Int =
  if (list.length == 1) list.head
  else lastElement(list.tail)
lastElement(list)

def lastButOneElement[A](list: List[A]): A =
  list match {
    case e :: _ :: Nil => e
    case _ :: next => lastButOneElement(next)
    case Nil => throw new Exception("no element found")
  }

lastButOneElement(list)

def findTheKthElementOfAList[A](list: List[A], k: Int): A =
  (k, list) match {
    case (0, h :: _) => h
    case (k, _ :: next) => findTheKthElementOfAList(next, k - 1)
    case _ => throw new Exception("no element found")
  }

findTheKthElementOfAList(list, 1)

def findListLength[A](list: A, acc: Int): Int =
  list match {
    case _ :: next => findListLength(next, acc + 1)
    case Nil => acc
  }
findListLength(Nil, 0)

list.foldLeft(0)((acc, _) => acc + 1)


def reverseList[A](list: List[A], acc: List[A]): List[A] =
  list match {
    case h :: t => reverseList(t, h +: acc)
    case Nil => acc
  }

reverseList(list, Nil)


def isItAPalindrome[A](list: List[A]): Boolean = {
  if (findListLength(list, 0) == 0)
    true
  else if (list.head == list.last) isItAPalindrome(list.tail.dropRight(1))
  else
    false
}

isItAPalindrome(listPalindrome)

def flattenAList[A](list: List[List[A]], acc: List[A]): List[A] = {
  list match {
    case ::(head, next) => flattenAList(next, acc ::: head)
    case Nil => acc
  }
}

flattenAList(List(List(1), List(2)), Nil)



//def compressFunctional[A](ls: List[A]): List[A] =
//  ls.foldRight(List[A]()) { (h, r) =>
//    if (r.isEmpty || r.head != h) h :: r
//    else r
//  }
//
//compressFunctional(list)
//
list.foldLeft(List.empty[Int])((acc, h) => if (acc.contains(h)) acc else acc :+ h)

def eleminateDuplicates[A](list: List[A]): List[A] =
  list.foldLeft(List.empty[A])((acc, h) => if (acc.contains(h)) acc else acc :+ h)

eleminateDuplicates(list)

def pack[A](ls: List[A]): List[List[A]] = {
  if (ls.isEmpty) List(List())
  else {
    val (packed, next) = ls span {
      _ == ls.head
    }
    if (next == Nil) List(packed)
    else packed :: pack(next)
  }
}

pack(list)
println("r" * 8)

//     Example:
//     scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
//     res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

def runlengthEncoder[A](ls: List[A]): List[(A, Int)] = {

  val result = pack(ls)
  result.map(e => (e.head, e.length))
}
val encoded = runlengthEncoder(charList)

def decode[A](list: List[(A, Int)]): List[List[A]] = {
  list.map {
    e =>
      Range(0, e._2)
        .toList
        .map(_ => e._1)
  }
}

decode(encoded)

