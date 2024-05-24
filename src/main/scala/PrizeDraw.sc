val abc = Range.inclusive('a', 'z').map(_.toChar)
val nums = Range.inclusive(1, 26)
val abcToNumsMap = abc.zip(nums).toMap

def nthRank(st: String, we: Array[Int], n: Int) = {
  val stSplit = st.split(",").toList
  if(st.isEmpty) "No participants"
  else
    if(stSplit.length < we.length) "Not enough participants"
  else
      (stSplit
        .map(name => name.map(l => abcToNumsMap(l.toLower)).sum + name.length)
        .zip(we).map(n => n._2 * n._1)
          .zip(st.split(","))
          .sortBy {
            case (w, name) => (-w, name.toLowerCase)
          }).map(_._2)(n - 1)
}
//nthRank("COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH", Array(1, 4, 4, 5, 2, 1), 4)
nthRank("Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin", Array(4, 2, 1, 4, 3, 1, 2), 4)
nthRank("Elijah,Chloe,Elizabeth,Matthew,Natalie,Jayden", Array(1, 3, 5, 5, 3, 6), 2)
nthRank("Aubrey,Olivai,Abigail,Chloe,Andrew,Elizabeth", Array(3, 1, 4, 4, 3, 2), 4)
//nthRank("Lily,Aiden,Sofia,Naoh", Array(4, 4, 4, 3), 1)

List("Aubrey", "Abigail").sorted

List(1, 3, 2, 5).sortBy{
  case n => -n
}