package learnPatternMatching

object AllThePatterns extends App {

  // 1) constants

  val x :Any = "Scala"

  val constants = x match {
    case 1 => "Its a number"
    case "Scala" => "its a string"
    case true => "Its a boolean"
    case AllThePatterns => "its a Objcet"

  }

  // 2) Match anything
  // 2.1) wild card
  val matchAnything = x  match {
    case _ => "some value"
  }

//  val something = 2
  // 2.2) variable
  val matchAVariable = x match {
    case something => "some value"
  }

  // 3) tuples
  val atuple = (1,2)
  val matchAtuple = atuple match {
    case (1,1) => true
    case (something,2) => s"it is $something"
  }

  println(matchAtuple)

  val nestedtuple = (1,(2,3)) //matches pattern inside the tuple also, it so powerfull
  val matchNestedTuple = nestedtuple match {
    case (_,(2,v)) => true
  }

  println(matchNestedTuple)

  // 4)  case class - constructor pattern
  //we have seen in patternmatching file itself,
  // nested pattern matching works well with CCs

  // 5) List PMs

  val alist = List(1,2,3,4)
  val listPm = alist match {
    case List(1,_,_,_,_) => // Extractor - advanced
    case List(1,_*) => // list of arbitary length - advanced
    case 1 :: List(_) => // Infix pattern
    case List(1,2,3) :+ 4 => //Infix pattern
  }

  // 6- type specifiers

  val typeSpec = alist match {
    case list : List[Int] => // explicit type specifier
  }

  // 7 - name binding
  val nameBinding = alist match {
    case aNonEmptyList @ List(1,2,3) => //name binding => use this name later(here)
    //can also do nested name binding case List(1, rest @ (1,2,4))
  }
  // 8)  Multi-pattern
  val multiPattern = alist match {
    case List(1,2,3) | List(1,3,4) => // multi-pattern  List(1,2,3) or List(1,3,4)
  }

  // 9 - if guards
  val ifGaurd = alist match {
    case List(1,specialelement,3,4) if specialelement %2 == 0 =>
  }


  /*
   One trick question

WHAT IS THE OUTPUT OF THE BELOW CODE:

  val atrick = alist match {
    case listofStrings : List[Strings] => "list of strings"
    case listofIntegers : List[Integers] => "list of integers"
    case _ => "Some other lists"
  }

  if we print this , we expect the output as "list of integers", but the output will be "list of strings"

  THIS IS NOT THE FAULT OF SCALA, IT IS WITH JVM, since jvm is designed for java, java generic types introduced on java 5.
  but jvm support from java 1, so  it take List[Strings] as List only, List[Int] as List only.
  it compared List = List. first case matched and it returns "list of strings"
   */
  val alist1 = List(1,2,3,4)
  val atrick = alist1 match {
    case listOfStrings: List[String] => "list of strings"
    case listOfIntegers: List[Int] => "list of integers"
    case _ => "Some other lists"
  }

  println(atrick) // output : list of strings
}
