def spinWords(sentence: String): String = {
  sentence.split(" ").map(w => if (w.length > 5) w.reverse else w).mkString(" ")
}
spinWords("hello my names is benjamin")