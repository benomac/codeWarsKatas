def findOutlier(integers: List[Int]) = {
  if(integers.count(_ % 2 == 0) == 1)
    integers.filter(_ % 2 == 0)
  else
    integers.filterNot(_ % 2 == 0)
}

def findOutlier2(integers: List[Int]): Int =
  integers.partition(_%2 == 0) match {
    case (List(outlier), _) => outlier
    case (_, List(outlier)) => outlier
  }

val list = List(4, 3,6, 5, 7)


list.filter(_ % 2 == 0)
list.partition(_ % 2 != 0)
findOutlier(list)
3.min(4)