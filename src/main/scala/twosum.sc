import scala.annotation.tailrec

def twoSum(numbers: List[Int], target: Int): (Int, Int) = {
  def helper(index: Int): (Int, Int) = {
    val remainder: Int = target - numbers(index)
    if (numbers.contains(remainder))
      (numbers.indexOf(numbers(index)), numbers.lastIndexOf(remainder))
    else
      helper(index + 1)
  }

  helper(0)
}
twoSum(List(1, 2, 3), 4)

List(1, 2, 2, 3).filterNot(_ == 2)


def twoSum2(numbers: List[Int], target: Int): (Int, Int) = {
  def helper(index: Int): (Int, Int) = {
    (numbers.contains(target - numbers(index)), target - numbers(index)) match {
      case (true, r) => (numbers.indexOf(numbers(index)), numbers.lastIndexOf(r))
      case _ => helper(index + 1)
    }
  }
  helper(0)
}


twoSum2(List(1, 2, 3), 4)
twoSum2(List(1, 2, 3), 4)
twoSum2(List(1234, 5678, 9012), 14690)
twoSum2(List(2, 2, 3), 4)