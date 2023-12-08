package learnPatternMatching

import learnOOP.GenericsL.Animal

import scala.util.Random

object patternMatching1 extends App {

  // 1) Switch like use

  val random = new Random()

  val x = random.nextInt(10)

  val describe = x match {
    case 1 => "First is best"
    case 2 => "Second before First"
    case 3 => "Thrid is not weird"
    case _ => "Nothing in top 3"
  }

  println(describe)

  // 2 decompose values [case class]

  case class Person(name:String, age:Int)

  val person = new Person("Karthik",10)
  val nameOfPerson = person match {
    case Person(n,a) => println(s"$n")
  }
  /*
   notes:
  1)cases are matched in order
  2) if no matches, throws MatchError
  3) type of PM, unified type of all the types in all the class.
  4) PM is well with case class
   */
//sealed class shows warning as """ match may not be exhaustive.  It would fail on pattern case: _: Animal """  with pattern matching

  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val dog:Animal = Dog("Great Dan")

  val desc = dog match {
    case Dog(breed) => s"Dogs bread is $breed "
  }
  println(desc)

  /*
  Exercise
  function which return expr to human readable
  eg:
  sum(number(2),number(3)) -> 2 + 3
  prod(number(2),number(3)) -> 2 * 3
  prod(number(4,sum(number(2),number(3))) -> 4 * (2 + 3)
   */

  trait expr
  case class Number(n:Int) extends expr
  case class Sum(e1:expr,e2:expr) extends expr
  case class Prod(e1:expr,e2:expr) extends expr

  def show(e:expr):String = e match {
    case Number(e) => s"$e"
    case Sum(e1,e2) => show(e1) + " + " + show(e2)
    case Prod(e1,e2) => {
      def paranthesis(exp:expr) = exp match {
        case Prod(_,_) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }
      paranthesis(e1) + " * " + paranthesis(e2)
    }
  }

  println(show(Sum(Number(2),Number(3))))
  println(show(Prod(Number(4),Sum(Number(2),Number(3)))))
  println(show(Sum(Number(2),Prod(Number(4),Sum(Number(2),Number(3))))))
}
