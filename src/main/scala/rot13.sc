import scala.Predef.char2Character


def rot13(message: String): String = {
  def calculate(c: Char, a: Int, z: Int): Char = {
    (c.isLetter, c.toInt + 13 > z) match {
      case (true, true) => (a + (c.toInt + 13 - z)).toChar
      case (true, false) => (c.toInt + 13).toChar
      case _ => c
    }
  }
    message.map(c => {
      if(c.isLower) calculate(c, 96, 122)
      else calculate(c, 64, 90)
    }
  )
}
'A'.toInt
'Z'.toInt
rot13("aA bB zZ 1234 *!?%")
's'.toInt
122 - 115
97 + 7
'z'.toInt
122 - 'z'.toInt
97 + (122 - 'z'.toInt)
(97 + (122 - 116)).toChar
(65 to 90 ).foreach(x => println(x.toChar))
(97 to 122 ).foreach(x => println(s"($x, ${x.toChar})"))

def rotateList(list: List[Char], rotations: Int): List[Char] = (list, rotations) match {
  case (::(_, _), 0) => list
  case (::(h, t), _) => rotateList(t :+ h, rotations - 1)
}

val a = List(
  'n',
  'o',
  'p',
  'q',
  'r',
  's',
  't',
  'u',
  'v',
  'w',
  'x',
  'y',
  'z',
  'a',
  'b',
  'c',
  'd',
  'e',
  'f',
  'g',
  'h',
  'i',
  'j',
  'k',
  'l',
  'm'
)


