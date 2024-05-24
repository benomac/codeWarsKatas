def luckCheck(s: String): Boolean = {
  def addNums(i: Int, acc: Int = 0): Int = {
    if (i == 0)
      acc
    else
      addNums(i / 10, acc + i % 10)
  }
  if (s.forall(_.isDigit))
    addNums(s.take(s.length / 2).toInt) == addNums(s.takeRight(s.length / 2).toInt)
  else
    throw new NumberFormatException
}
luckCheck("111111112")
val f = "12345678919"
f.take(f.length / 2)
f.takeRight(f.length / 2)
f.sum

123 / 10
123 % 10
12 /10
12 % 10
1/ 10

def addNums(i: Int, acc: Int = 0): Int = {
  if(i == 0)
    acc
  else
    addNums(i / 10, acc + i % 10)
}
addNums(1234567)