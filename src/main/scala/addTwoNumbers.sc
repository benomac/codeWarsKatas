import scala.collection.immutable
// 1 rotate list
// 2 get prefix (eg: ab, if the rotate is only by 1 place) should be connected to first letter
// 3 split message


object CaesarCipher {

  def splitEncodedMessage(s: String): List[String] = {
    val divider = s.length / 5 + 1
    def rec(str: String, acc: List[String]): List[String] = {
      str match {
        case "" => acc.reverse
        case s if s.length < divider => rec("", s"$s" :: acc)
        case _ => rec(str.drop(divider), str.take(divider) :: acc)
      }
    }
    rec(s, Nil)
  }

  def encode(s: String, shift: Int): List[String] = {
    val codedMessage = s.map(l => if (l.isLetter) (l.toInt + shift).toChar else l)
    val codedMessageWithKey = s"${s.head.toLower}${(s.head.toLower.toInt + shift).toChar}$codedMessage"
    splitEncodedMessage(codedMessageWithKey)
  }

  def decode(s: List[String]): String = {
    val unSplitMessage = s.fold("")((k, v) => s"$k" + v)
    val shift = Math.abs(unSplitMessage.head - unSplitMessage(1))
    unSplitMessage.drop(2).map(l => if (l.isLetter) (l.toInt - shift).toChar else l)
  }

}

import CaesarCipher._
encode("ben", 1)
decode(encode(1, "Ben Mcallister!"))
decode(List("opP DBQUBJ", "O! nz Dbqu", "bjo! pvs g", "fbsgvm usj", "q jt epof;"))


