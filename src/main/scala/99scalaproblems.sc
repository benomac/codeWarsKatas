val list = List(0, 1, 2, 3, 4, 5, 6, 7, 8)
val list2: List[Any] = List(List(1, 1), 2, List(3, List(5, 8)))

def getLastElement[T](l: List[T]): Either[String, T] = {
  l match {
    case ::(h, Nil) => Right(h)
    case ::(_, next) => getLastElement(next)
    case _ => Left("error empty list.")
  }
}

getLastElement(list)


def getSecondToLastElement[T](l: List[T]): Either[String, T] = {
  l match {
    case h :: _ :: Nil => Right(h)
    case _ :: tail => getSecondToLastElement(tail)
    case _ => Left("error empty list.")
  }
}
getSecondToLastElement(list)


def getSecondToLastElement2[T](l: List[T]): Either[String, T] = {
  l match {
    case h :: _ :: Nil => Right(h)
    case _ :: tail => getSecondToLastElement2(tail)
    case _ => Left("error")
  }
}

getSecondToLastElement2(list)

def getTheKthElement[T](l: List[T], k: Int): Either[String, T] = {
  (k, l) match {
    case (0, ::(h, _)) => Right(h)
    case (_, Nil) => Left("error empty list")
    case _ => getTheKthElement(l.tail, k - 1)
  }
}

getTheKthElement(list, 7)

def getLength[T](list: List[T], acc: Int = 0): Int =
  list match {
    case Nil => acc
    case ::(_, next) => getLength(next, acc + 1)
  }


getLength(Nil)

def reverseList[T](l: List[T], acc: List[T] = Nil): List[T] =
  l match {
    case ::(h, t) => reverseList(t, h :: acc)
    case Nil => acc
  }

reverseList(list)

def palindromeChecker[T](l: List[T]): Boolean = {
  if (l.length <= 1) true
  else
    if (l.head == l.last) palindromeChecker(l.drop(1).dropRight(1))
    else
    false
}

palindromeChecker(list)
palindromeChecker(List(1, 1))


def flatten(ls: List[Any]): List[Any] = ls flatMap {
  case ms: List[_] => flatten(ms)
  case e => List(e)
}
flatten(list2)

val list3 = List(1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 1, 1)





def compressTailRecursive[A](ls: List[A]): List[A] = {
  def compressR(result: List[A], curList: List[A]): List[A] = curList match {
    case h :: tail => compressR(h :: result, tail.dropWhile(_ == h))
    case Nil       => result.reverse
  }
  compressR(Nil, ls)
}

def pack[A](ls: List[A]): List[List[A]] = {
  if (ls.isEmpty) List(List())
  else {
    val (packed, next) = ls span { _ == ls.head }
    if (next == Nil) List(packed)
    else packed :: pack(next)
  }
}

compressTailRecursive(list3)

def runLengthEncodingMethod(l: List[Char]): Either[String, List[(Int, Char)]] = {
  if (l.isEmpty) Left("error, empty List") else Right(pack(l).map(e => (e.length, e.head)))
}
runLengthEncodingMethod(List('d'))

def encodeModified(l: List[Char]): Either[String, List[Any]] =
  runLengthEncodingMethod(l) match {
    case Left(value) => Left(value)
    case Right(value) => Right(value.map(e => if(e._1 == 1) e._2 else e))
  }
encodeModified(List())