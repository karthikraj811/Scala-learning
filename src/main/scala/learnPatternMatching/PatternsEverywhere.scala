package learnPatternMatching

object PatternsEverywhere extends App {

  // BIG IDEA 1
  // catches are actually PATTERN MATCHING
  try {
    //code
  } catch {
    case e: RuntimeException => "RTE"
    case npe : NullPointerException => "npe"
    case _ => "other exp"
  }

  /*
  try {
    //code
  } catch (e) { e match {
    case e: RuntimeException => "RTE"
    case npe : NullPointerException => "npe"
    case _ => "other exp"
  }
  }
   */

  //BIG IDEA 2

  // generators are also based on PATTERN MATCHING

  val alist = List(1,2,3,4)
  val gen = for {
    x <- alist if  x % 2 == 0
  } yield x * 10

  gen.foreach(println) // output 20
                       //        40

  // BIG IDEA 3
  //Multiple value definition is also based on PATTERN MATCHING
  val tuple = (1,2,3)
  val (a,b,c) = tuple
  println(b)  // output 2

  //BIG IDEA 4
  // partial function (advanced topic) is also based on PATTERN MATCHING

  val newList = alist.map{
    case x if x %2==0 => x + " is even"
    case x => x + " is odd"
  }

  // partial function also based on PM
  val newList1 = alist.map { x => x match {
      case x if x % 2 == 0 => x + " is even"
      case x => x + " is odd"
    }
  }

  print(newList)





}
