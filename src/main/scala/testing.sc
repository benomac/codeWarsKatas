import scala.annotation.tailrec
import scala.collection.mutable

def factorial(number: Int): BigInt = {
  def helper(x: Int, acc: BigInt = 1): BigInt = {
    if (x <= 1) acc
    else helper(x - 1, x * acc)
  }
  helper(number)
}

def factorial2(number: Int): BigInt = {
  def helper(x: Int, acc: BigInt = 1, lookUp: mutable.Map[Int, BigInt]): BigInt = {
    if (x <= 1) acc
    else helper(x - 1, x * acc, lookUp + (x -> x * acc))
  }
  helper(number, lookUp =  mutable.Map.empty[Int, BigInt])
}



factorial(10000)