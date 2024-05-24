import scala.annotation.tailrec
import scala.util.Random

object Deck {
  trait Suit
  case object Spades extends Suit
  case object Clubs extends Suit
  case object Hearts extends Suit
  case object Diamonds extends Suit

  trait CardValue
  case object Ace extends CardValue
  case object Two extends CardValue
  case object Three extends CardValue
  case object Four extends CardValue
  case object Five extends CardValue
  case object Six extends CardValue
  case object Seven extends CardValue
  case object Eight extends CardValue
  case object Nine extends CardValue
  case object Ten extends CardValue
  case object Jack extends CardValue
  case object Queen extends CardValue
  case object King extends CardValue

  val suits: List[Suit] = List(Spades, Clubs, Hearts, Diamonds)
  val cardValues: List[CardValue] = List(Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King)

  case class Card(cardValue: CardValue, suit: Suit)
  val deck: List[Card] = for {
    card <- cardValues
    suit <- suits
  } yield Card(card, suit)

  def shuffleDeck: List[Card] = {
    Random.shuffle(deck)
  }
}
import Deck._
val shuffledDeck: List[Deck.Card] = shuffleDeck

case class WorkingHands(remainderOfDeck: List[Deck.Card], elevenUniqueCards: List[Deck.Card])

case class PairToLookFor(card1: Deck.CardValue, card2: Deck.CardValue)

@tailrec
def dealTheHands(deck: List[Deck.Card], elevenUniqueCards: List[Deck.Card]): WorkingHands = {
    (deck, elevenUniqueCards.size == 11) match {
      case (::(head, next), false) =>
      if (elevenUniqueCards.forall(a => head.cardValue != a.cardValue)) {
        dealTheHands(next, elevenUniqueCards :+ head)
      }
      else {
        dealTheHands(next, elevenUniqueCards)
      }
      case (_, _) => WorkingHands(deck, elevenUniqueCards)
    }
  }



def checkTheLeftOverPair(workingHands: WorkingHands, cardValues: List[CardValue], pair: List[CardValue]): PairToLookFor = {
  val eleven: List[CardValue] = workingHands.elevenUniqueCards.flatMap(c => List(c.cardValue))
  val pairToReturn = cardValues.flatMap(cv => if(eleven.contains(cv)) Nil else pair :+ cv)
  PairToLookFor(pairToReturn.head, pairToReturn.last)
}


@tailrec
def isThePairTogetherInTheRemainder(checkedCards: List[String], pair: PairToLookFor, deck: List[CardValue], acc: Int): (Int, List[String]) = {
  deck match {
    case _ if deck.size < 2 => (acc, checkedCards :+ deck.last.toString)
    case ::(head, next) if List(head, next.head) == List(pair.card1, pair.card2)
    => isThePairTogetherInTheRemainder(checkedCards ++ List(pair.card1.toString.toUpperCase, pair.card2.toString.toUpperCase), pair, next.drop(1), acc + 1)
    case ::(head, next) if List(head, next.head) == List(pair.card2, pair.card1)
      => isThePairTogetherInTheRemainder(checkedCards ++ List(pair.card2.toString.toUpperCase, pair.card1.toString.toUpperCase), pair, next.drop(1), acc + 1)
    case ::(head, next) => isThePairTogetherInTheRemainder(checkedCards :+ head.toString, pair, next, acc)
    case _ => (acc, checkedCards :+ deck.last.toString)
  }
}

val workingHands: WorkingHands = dealTheHands(shuffledDeck, Nil)
val remainderOfDeckValues: List[CardValue] = workingHands.remainderOfDeck.flatMap(c => List(c.cardValue))
val pairToFind: PairToLookFor = checkTheLeftOverPair(workingHands, cardValues, Nil)
isThePairTogetherInTheRemainder(Nil, pairToFind, remainderOfDeckValues, 0)
