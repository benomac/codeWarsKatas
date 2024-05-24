
case class Node(
                 left: Option[Node],
                 right: Option[Node],
                 value: Int
               )



val node2 = Node(
  Some(Node(
    Some(Node(
      None,
      None,
      1)),
    Some(Node(
      None,
      None,
      3)),
    8)),
  Some(Node(
    Some(Node(
      None,
      None,
      4)),
    Some(Node(
      None,
      None,
      5)),
    9)),
  2)

val node = Node(Some(Node(None, None, 2)),
            Some(Node(None, None, 3)),
              1)

def treeByLevels(node: Node): Seq[Int] = {
  def rec(nodeList: Seq[Node], acc: Seq[Int] = Seq.empty): Seq[Int] = {
    if(nodeList.isEmpty) acc
    else
    nodeList.head match {

    }
  }
  rec(Seq(node))
}


treeByLevels(node2)

//    case (None, Some(v), i) => Seq(i) ++ treeByLevels(v)
//    case (Some(v), None, i) => Seq(i) ++ treeByLevels(v)

//val expectedResult = List(2, 8, 9, 1, 3, 4, 5)
