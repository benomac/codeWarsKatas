import cats.parse.Parser.{char, ignoreCase}
import cats.parse.Rfc5234.{alpha, digit, sp}

import scala.annotation.tailrec
//
//val jnz = ignoreCase("jnz")
//val mov = ignoreCase("mov")
//val inc = ignoreCase("inc")
//val dec = ignoreCase("dec")
//val multiDigit = digit.rep.string.map(_.toInt)
//
//val jnzParser = (jnz ~ alpha.surroundedBy(sp) ~ (multiDigit | (char('-') ~ multiDigit) | alpha)).string
//val movParser = (mov ~ alpha.surroundedBy(sp) ~ (multiDigit | (char('-') ~ multiDigit) | alpha)).string
//val incParser = (inc ~ sp ~ alpha).string
//val decParser = (dec ~ sp ~ alpha).string

//types = mov key int
//        mov key acc(key0
//        inc 1
//        dec 1
//        jnx key int
//        jnx key acc(key)
case class theMap(m: Map[String, Int]) {
  def inc(key: String): theMap = theMap(m + (key -> (m(key) + 1)))
  def dec(key: String): theMap = theMap(m + (key -> (m(key) - 1)))
  def movKey(key: String, value: Int): theMap =
    theMap(m + (key -> value))
  def movKey(key: String, value: String): theMap =
    theMap(m + (key ->  m(value)))
  def getMapElem(v: String): Boolean = {
    if(m.contains(v)) !m.get(v).contains(0)
    else v.toInt != 0
  }
}
def interpret(program: List[String], a: Map[String, Int] = Map.empty): Map[String, Int] = {
  @tailrec
  def innerterpret(index: Int = 0, acc: theMap): Map[String, Int] = {
    if(index < program.length) {
      program(index).split(" ").toList match {
        case List("mov", k, v) =>
          if (!v.head.isLetter) innerterpret(index + 1, acc.movKey(k, v.toInt))
          else innerterpret(index + 1, acc.movKey(k, v))
        case List("inc", k) => innerterpret(index + 1, acc.inc(k))
        case List("dec", k) => innerterpret(index + 1, acc.dec(k))
        case List("jnz", k, v) =>
          if(!v.head.isLetter && acc.getMapElem(k)) innerterpret(index + v.toInt, acc)
          else if (v.head.isLetter && acc.getMapElem(k)) innerterpret(index + acc.m(v), acc)
          else innerterpret(index + 1, acc)
      }
    } else acc.m
  }
  innerterpret(acc = theMap(a))
}

val foo = List("mov a 5","inc a","dec a","dec a","jnz a -1","inc a")
val bar = List("mov a -10","mov b a","inc a","dec b","jnz a -2")
interpret(foo)
interpret(bar)
