import scala.math

def factorial(i: BigInt, acc: BigInt = 1): BigInt = {
  if
  (i == 0)  acc
  else
    factorial(i - 1, acc * i)
}

def getZeros(n: BigInt, acc: Int = 0): Int =
  if(n.toString.last == '0') getZeros(BigInt(n.toString.dropRight(1)), acc + 1)
  else
    acc
getZeros(12909900)

"12909900".reverse.span(x => x == '0')

def zeros(n: BigInt) = {
  if (n == 0) 0
  else {
    val b: BigInt = 1
    getZeros(b.to(n).product)

  }
}
def zeros2(n: Int): Int =
  n / 5 match {
    case 0 => 0
    case x => {
      println(x)
      x + zeros2(x)
    }
  }

zeros2(200)
zeros(200)

//def zeros(n: BigInt) = {
//  if (n == 0) 0
//  else {
//    val b: BigInt = 1
//    b.to(n).product
//      .toString
//      .reverse
//      .span(_ == '0')
//      ._1
//      .mkString.length
//  }
//}


zeros(30)
val g: BigInt = 7
//g.until(9).product.toString.foldRight('0')((x, y) => if(x == '0') x else y)

//List(0, 0, 1, 0).foldRight(Nil)((x, y) => if(x == 0) x + y else y)

List("a", "b", "c").foldLeft("") { (m: String, n: String) => println("m: " + m + " n: " + n)
  m + n }

List("a", "b", "c").foldRight("") { (m: String, n: String) => println("m: " + m + " n: " + n)
  m + n}

List("0", "0", "1", "2", "0").foldRight(""){
  (m: String, n: String) =>
    println("m: " + m + " n: " + n)

      m + n

}
