import jdk.dynalink.linker.support.Lookup

import scala.annotation.tailrec
import scala.collection.mutable


val lookUp = mutable.Map.empty[Int, BigDecimal]
val lookUp2 = mutable.Map.empty[Int, BigDecimal]

def factorial(num: Int): BigDecimal = {
  def f(a: BigDecimal, i: Int) = {
    val fact = a * i
    lookUp(i) = fact
    fact
  }

  def helper(n: Int, acc: BigDecimal): BigDecimal = {
    if (n <= 1) acc
    else if (lookUp.contains(n)) lookUp(n) * acc
    else {
      helper(n - 1, acc * n)
    }
  }

  val fact = helper(num, 1)
  lookUp(num) = fact
  fact
}
def going(n: Int): Double = {
  def f(a: BigDecimal, i: Int) = {
    val fact = a + factorial(i)
    lookUp2(i) = fact
    fact

  }
  def helper(i: Int, acc: BigDecimal = 0): BigDecimal = {
    if (i == 0) acc
    else if (lookUp2.contains(i)) lookUp2(i) + acc
    else
      helper(i - 1, acc + factorial(i))
  }

  val gone = helper(n, 0)
  lookUp2(n) = gone

  val result = gone * 1 / factorial(n)
  result.toString.slice(0, 8).toDouble
}
going(5)
going(6)
