package learnBasics

object stringOps extends App{

  val aString :String = "Hello, I am K"

  println(aString.charAt(2)) // prints l which is the 2nd index of hello
  println(aString.split(" ").toList)
  println(aString.length)
  println(aString.replace(" ","_"))
  println(aString.reverse)
  println(aString.substring(7,13))

  val astrInt = "42"
  val aInt = astrInt.toInt
  println(aInt)

  //SCALA SPECIFIC
  //S-Interpolator
  val name = "K"
  val age = "28"
  val Greet = s"Hai I am $name , and I am $age years old"
  println(Greet)

  //F-interpolator
  //  it formats the type whatever we want

  val distance = 60.23f
  println(f"$name can run at the speed of $distance%1.3f Km/Hr")

  //raw-interpolator

  val rawLine = raw"I \n Don't work here"  //raw interpolators actually gives literal values
  println(rawLine)
  val notRawLine = "I \n Do work here"
  println(notRawLine)


}
