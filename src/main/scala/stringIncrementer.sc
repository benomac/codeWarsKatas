"ben01".reverse.takeWhile(_.isDigit)
"01".dropRight(1)
"01".dropWhile(_ == '0')
"".forall(_.isLetter)

def incrementString(s: String): String = {
  if(s.forall(_.isLetter) || (s.head.isLetter && s.last.isLetter )) s + "1"
  else
    if(s.last == '0') s"${s.dropRight(1)}1"
    else {
      val a = s.reverse
      val digits = a.takeWhile(_.isDigit)
      val letters = a.dropWhile(_.isDigit)
      val zeroCount = digits.reverse.takeWhile(_ == '0').length
      val numberToIncrement = digits.reverse.dropWhile(_ == '0')
      val incrementedNumber = if(numberToIncrement == "9" || numberToIncrement.last == '9')
        s"${letters.reverse}${"0" * (zeroCount - 1)}${numberToIncrement.toInt + 1}"
      else
        s"${letters.reverse}${("0" * zeroCount)}${numberToIncrement.toInt + 1}"
      incrementedNumber
    }
}
//incrementString("f00bar")
incrementString("209")
incrementString("foo0")
incrementString("009")
incrementString("foobar00999")

"009".format().toInt
val b = "ben"
if(b.forall(_.isLetter))
  b + "1"
else
  if(b.last.isDigit) {
    val c = b.reverse

  }

