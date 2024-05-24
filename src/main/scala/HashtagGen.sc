def generateHashtag(s: String): String = {
  val g = s.toLowerCase().split(" ").map(_.capitalize).mkString
  val f = s"#${g.filterNot(_ == ' ')}"
  f match {
    case "#" => ""
    case f if f.length > 140 => ""
    case _ => f
  }
}

generateHashtag("should remove spaces")