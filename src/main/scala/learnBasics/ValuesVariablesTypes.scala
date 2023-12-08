package learnBasics

object ValuesVariablesTypes {

  def main(args: Array[String]): Unit = {

    // val is a value which cannot be altered, it is immutable

    val x: Int = 42

    val aString :String = "This a String"
    val aChar :Char = 'a'
    val aBoolean :Boolean = true
    val aFloat :Float = 2.7f //if f is not mentioned then it is considered as Double type
    val aDouble:Double = 0.999
    val aShort :Short = 12
    val aLong :Long = 12345678899987L //if L is not mentioned then we will get the error like int is exceeding limit
    println(x)

    // var is variable which can be changed, it is mutable

    var a :Int = 10
    a += 10
    println(a)

    // ; is mandatory only if we write it in a same line
    val w :Int = 10; val y :Int = 20;

  }

}
