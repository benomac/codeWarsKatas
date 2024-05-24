import cats.parse.Numbers._
import cats.parse.Parser._
import cats.parse.Rfc5234.{alpha, digit, hexdig, sp}
import cats.parse.{Numbers, Parser, Parser0}

import scala.annotation.tailrec


case class PhoneNumber(first: String, second: String, third: String, fourth: String) {
  def createPhoneNumber: String = s"$first-$second-$third-$fourth"
}

case class Name(name: String)


val dr = "/+11-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010\n" +
  "+1-541-984-3012 <P Reed> /PO Box 530; Pollocksville, NC-28573\n :+1-321-512-2222 <Paul Dive> Sequoia Alley PQ-67209\n" +
  "+1-741-984-3090 <Peter Reedgrave> _Chicago\n :+1-921-333-2222 <Anna Stevens> Haramburu_Street AA-67209\n" +
  "+1-111-544-8973 <Peter Pan> LA\n +1-921-512-2222 <Wilfrid Stevens> Wild Street AA-67209\n" +
  "<Peter Gone> LA ?+1-121-544-8974 \n <R Steell> Quora Street AB-47209 +1-481-512-2222\n" +
  "<Arthur Clarke> San Antonio $+1-121-504-8974 TT-45120\n <Ray Chandler> Teliman Pk. !+1-681-512-2222! AB-47209,\n" +
  "<Sophia Loren> +1-421-674-8974 Bern TP-46017\n <Peter O'Brien> High Street +1-908-512-2222; CC-47209\n" +
  "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n <P Salinger> Main Street, +1-098-512-2222, Denver\n" +
  "<C Powel> *+19-421-674-8974 Chateau des Fosses Strasbourg F-68000\n <Bernard Deltheil> +1-498-512-2222; Mount Av.  Eldorado\n" +
  "+1-099-500-8000 <Peter Crush> Labrador Bd.\n +1-931-512-4855 <William Saurin> Bison Street CQ-23071\n" +
  "<P Salinge> Main Street, +1-098-512-2222, Denve\n" + "<P Salinge> Main Street, +1-098-512-2222, Denve\n" +
  "/+5-541-754-3010 156 Alphandria_Street. <Jr Part>\n 1333, Green, Road <F Fulgur> NW-46423 ;+6-541-914-3010!\n" +
  "+5-541-984-3012 <Peter Reeves> /PO Box 5300; Albertville, SC-28573\n :+5-321-512-2222 <Paulo Divino> Boulder Alley ZQ-87209\n" +
  "+3-741-984-3090 <F Flanaghan> _Chicago Av.\n :+3-921-333-2222 <Roland Scorsini> Bellevue_Street DA-67209\n" +
  "+8-111-544-8973 <Laurence Pantow> SA\n +8-921-512-2222 <Raymond Stevenson> Joly Street EE-67209\n" +
  "<John Freeland> Mantow ?+2-121-544-8974 \n <Robert Mitch> Eleonore Street QB-87209 +2-481-512-2222?\n" +
  "<Arthur Paternos> San Antonio $+7-121-504-8974 TT-45121\n <Ray Charles> Stevenson Pk. !+7-681-512-2222! CB-47209,\n" +
  "<JP Gorce> +9-421-674-8974 New-Bern TP-16017\n <P McDon> Revolution Street +2-908-512-2222; PP-47209\n" +
  "<Elizabeth Corber> +8-421-674-8974 Via Papa Roma\n <C Saborn> Main Street, +15-098-512-2222, Boulder\n" +
  "<Colin Marshall> *+9-421-674-8974 Edinburgh UK\n <Bernard Povit> +3-498-512-2222; Hill Av.  Cameron\n" +
  "+12-099-500-8000 <Pete Highman> Ontario Bd.\n +8-931-512-4855 <W Mount> Oxford Street CQ-23071\n" +
  "<Donald Drinkaw> Moon Street, +3-098-512-2222, Peterville\n"

// get the phone number from the string
val firstNumGroup = (digit ~ digit | digit)
val tripDig = digit ~ digit ~ digit
val quadDigit = digit ~ digit ~ digit ~ digit

def phoneNumParser: Parser0[String] =
  for {
    _ <- until(char('+')) | !sp
    _ <- char('+')
    firstNumGroup <- bigInt.string
    _ <- char('-')
    secondNumGroup <- tripDig.string
    _ <- char('-')
    thirdNumGroup <- tripDig.string
    _ <- char('-')
    fourthNumGroup <- quadDigit.string
  } yield PhoneNumber(firstNumGroup, secondNumGroup, thirdNumGroup, fourthNumGroup).createPhoneNumber

def nameParser: Parser0[String] =
  for {
    _ <- until(char('<')) | !sp
    _ <- void(char('<'))
    name <- until(char('>'))
  } yield Name(name).name

def personDetailsParser = {
  val name = nameParser
  val phone = phoneNumParser
  List(name, phone)
}

def personList(person: String) =
  personDetailsParser
    .map(parser => parser
      .parse(person)
      .map(x => x._2))
    .collect {
      case Right(v) => v
    }
def inputToList(input: String): List[List[String]] =
  input.split("\n").toList.map(p => personList(p))

@tailrec
def listToMap(input: List[List[String]], acc: Map[String, String] = Map.empty): Map[String, String] =
  input match {
    case ::(head, next) => {
      if
      (head.length < 2) listToMap(next, acc)
      else
        listToMap(next, acc + (head.head -> head.last))
    }
    case Nil => acc
  }


val input = dr.split("\n").toList.map(p => personList(p))
val bar = listToMap(input)



val aPerson = "/+11-541-754-3010 156 Alphand_St. <J Steeve>"
val oneMap = Map("J Steeve" -> "11-541-754-3010")
val noName = aPerson.replace(oneMap.keys.head, "").replace(s"+${oneMap.values.head}", "")
val address = " / Alphand_St. <>"

val p = alpha.rep.between(sp, sp)
val h = p.parse(address)




