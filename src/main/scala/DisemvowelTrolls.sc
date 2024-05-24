def disemvowel(str: String): String = {
  val vowels = List("a", "e", "i", "o", "u", "A", "E", "I", "O", "U")
  str
    .toList
    .map(_.toString)
    .map(l => if(vowels.contains(l)) "" else l)
    .mkString
}

//More concise (from codewars, not mine)
def disemvowel2(str: String): String =
  str.filterNot("aeiouAEIOU".contains(_))

disemvowel("beN!")
"ben".toList.map(_.toString)
  