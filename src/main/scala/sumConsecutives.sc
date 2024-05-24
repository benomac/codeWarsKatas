val list = List(1, 2, 2, 4, 4, 4)
list.map(x => x * x)

def sumConsecutives(xs: List[Int]): List[Int] =
  if (xs.isEmpty) Nil else xs.span(_ == xs.head) match {
    case (a, b) => a.sum :: sumConsecutives(b)
  }

List(1, 2, 2, 3).span(_ == 1)
def sqrList(l: List[Int]): List[Int] = {
  l match {
    case Nil => Nil
    case ::(head, next) => head * head :: sqrList(next)

  }
}
sqrList(list)

def sqrList(l: List[Int], acc: List[Int]): List[Int] = {
  l match {
    case Nil => acc
    case ::(head, next) => sqrList(next, acc ::: List(head * head))

  }
}