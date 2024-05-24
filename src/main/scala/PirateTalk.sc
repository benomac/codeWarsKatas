def grabscrab(word: String, possibleWords:Seq[String]): Seq[String] = {
  def rec(acc: List[String], pw: Seq[String]): Array[String] = {
    pw match {
      case Nil => acc.toArray
      case ::(h, t) => if(h.sorted == word.sorted) rec(acc ::: List(h), t) else rec(acc, t)
    }
  }
  rec(Nil, possibleWords)
}
val word = "oob"
val listOfWords = Seq("bob", "baobab")

grabscrab(word, listOfWords)