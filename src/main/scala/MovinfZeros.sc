import java.time.Instant.now
import java.util.Calendar
//def moveZeroes(lst: List[Int]): List[Int] = {
//  def rec(list: List[Int], acc: List[Int]): List[Int] = {
//    list match {
//      case ::(head, next) => if(head == 0) rec(next, next ::: List(head)) else rec
//      case Nil => ???
//    }
//  }
//}
val f1: BigInt = Calendar.getInstance().getTimeInMillis
List(9, 0, 0, 9, 1, 2, 0, 1, 0, 1, 0, 3, 0, 1, 9, 0, 0, 0, 0, 9).filterNot(_ == 0) ::: List(9, 0, 0, 9, 1, 2, 0, 1, 0, 1, 0, 3, 0, 1, 9, 0, 0, 0, 0, 9).filter(_ == 0)
val f2: BigInt = Calendar.getInstance().getTimeInMillis

f2 - f1


val s1: BigInt = Calendar.getInstance().getTimeInMillis
List(9, 9, 1, 2, 1, 1, 3, 1, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0).sortBy(_ == 0)
val s2: BigInt = Calendar.getInstance().getTimeInMillis

s2 - s1