def fizzBuzz(number: Int): String = {
  (number % 15 == 0, number % 3 == 0, number % 5 == 0) match {
    case (true, true, true) => "fizzBuzz"
    case (false, true, false) => "fizz"
    case (false, false, true) => "buzz"
    case _ => number.toString
  }
//  number match {
//    case n if n % 15 == 0 => "fizzBuzz"
//    case n if n % 3 == 0 => "fizz"
//    case n if n % 5 == 0 => "buzz"
//    case _ => number.toString
//  }
//  if (number % 15 == 0) "fizzBuzz"
//  else if (number % 3 == 0) "fizz"
//  else if (number % 5 == 0) "buzz"
//  else number.toString
}


val numbers = (1 to 100).toList.foreach(x => println(fizzBuzz(x)))