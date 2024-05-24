case class Address(house: Int, street: String)

case class Person(name: String, address: Address)

val nameAddress = Map("name" -> "ben", "house" -> "18", "street" -> "Pond Close")
nameAddress("house")

def readString(fieldName: String, data: Map[String, String]): Either[String, String] = {
  data.get(fieldName) match {
    case Some(value) => Right(value)
    case None => Left("error")
  }
}

def readInt(fieldName: String, data: Map[String, String]): Either[String, Int] = {
  data.get(fieldName) match {
    case Some(value) => value.toIntOption.toRight("Not an Int")

  }
}

def getAddress(data: Map[String, String]): Either[String, Address] = {
  for {
    house <- readInt("house", data)
    street <- readString("street", data)
  } yield Address(house, street)
}

def getPerson(data: Map[String, String]): Either[String, Person] = {
  for {
    name <- readString("name", data)
    address <- getAddress(data)
  } yield Person(name, address)
}

readString("name", nameAddress)
readString("house", nameAddress)
readInt("house", nameAddress)

val person: Object = getPerson(nameAddress) match {
  case Left(value) => value
  case Right(value) => value
}
person