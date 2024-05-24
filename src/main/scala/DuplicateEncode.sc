def duplicateEncode(word: String): String = {
  word.map(x => if(word.count(l => l.toLower == x.toLower) > 1) ')' else '(')
}
"ben".count(x => x =='b')
duplicateEncode("ben")