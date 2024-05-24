//import cats._
//import cats.implicits._

val f = List("c", "a", "b", "c", "c")

f.map(x => x -> f.count(_ == x)).toMap


f.groupBy(identity).map {
  case (k, v) => (k, v.length)
}

