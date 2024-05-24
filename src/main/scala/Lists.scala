object ListsOf {

  val stringList = ('a' to 'z').toList.map(_.toString)
  val charList = ('a' to 'z').toList
  val intList = (1 to 100).toList

  val allLists: (List[String], List[Char], List[Int]) = (stringList, charList, intList)

}
