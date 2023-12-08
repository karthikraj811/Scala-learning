package learnOOP

object caseClassesL extends App {

  /* it is like combining class of object and class
  Light weight class with lots of benifts
   */

  case class Person(name:String,Age:Int)

  // 1) class parameteres are promoted as fields

  val jim = new Person("Jim",24)
  println(jim.name)

  // 2) Sensible toString repr
  val kar = new Person("kar",28)
  println(kar.toString)
  println(kar) //Both gives same output it is a syntactic sugar by Java , like apply() Notation
  /*
  output : Person(kar,28)
  if it is not case class we will something like this : learnOOP.caseClassesL$Person@6442b0a6
   */

  //3) Equals and hashCode implemented out of the box

  val jim2 = new Person("Jim",24)

  println(jim2 == jim) // It gives true , normally a class of two instances are not equal

  //4) case classes have handy copy method

  val jim3 = jim2.copy(Age=34)
  println(jim3)

  //5) CCs have companion objects

  val harry = Person("Harry",23)

  println(harry)

  // 6) case classes are serializable , we can use it for distibuted systems

  //7) powerfull feature of caseclass in scala is PATTERN MATCHING

  //8) case class have case object also, but we won't get the companion
  case object Mobile {
    def Mobname():String = "Iphone"
  }
  val mob = Mobile
  println(mob.Mobname())





 }
