package learnOOP

import scala.language.postfixOps

object methodNotations extends App {

  //Method notations AKA synthetic sugars which

  class Person(val name:String, val age:Int, val favMovie:String){

    def greet :String = s"Hi, I am ${name}, And I am ${age} years old "
    def likes(movie:String):Boolean = movie == favMovie

    def +(otherName:String):String = s"${this.name} hanging out with $otherName"

    def unary_- :String = s"$name what the hell"

    def isAlive:Boolean = true

    def apply():String = s"Hi, I am ${name}, and My Favourite move is $favMovie "

    def apply(name:String):String = s"Hi, I am ${name}, and My Favourite move is $favMovie "
  }

  val karthik = new Person("karthik",28,"Shutter Island")

  println(karthik.likes("Inception"))
  println(karthik likes "Shutter Island")
  // This is called method notation, both the methods works, but the method should have exactly one parameter.
  //Otherwise, this won't work.

  //INFIX notation
  //In scala, we can use operators as the method name

  println(karthik + "Samantha")
  println(karthik.+("Samantha"))
  //Both the things are same.
  // ALL THE OPERATORS ARE METHODS IN SCALA

  //PREFIX notation -prefix notations are nothing but the unary operator
  // only + - ~ ! are allowed

  val x = -1 // here - is the unary operator
  val y = 1.unary_-  // both are equivalent

  println(-karthik)
  println(karthik.unary_-)

  //POSTFIX notations -  it doesn't take any arguments, and it is same as infinx

  println(karthik isAlive)
  println(karthik.isAlive)

  //it is not in practice since the difference is just a dot . and space " "

  //APPLY
  // paranthesis is important

  println(karthik.apply())
  println(karthik()) // we can simply use object name with paranthesis

  println(karthik("balaji"))






}
