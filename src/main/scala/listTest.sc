val list = List(1, 2, 3)

case class Number(value: Int)

val listOfNumbers = list.map(Number)

println(listOfNumbers)

listOfNumbers.flatMap(n => List(n.value))
listOfNumbers.map(n => n.value)