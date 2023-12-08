package exercise

import exercise.{Counter, Novel, Writer}

object oopBasicExercise extends App{

  ////////////////////// Exercise 1 Writer and Novel ///////////////////////
  val writer1 = new Writer("Karthik","Vairam",1995)

  val Novel1  = new Novel("NeverMind",2021,writer1)

  println(Novel1.name)

  println(Novel1.isWrittenBy("Venky"))

  println(Novel1.authorAge)

  println(Novel1.YOR)
  Novel1.copy(2023)
  println(Novel1.YOR)


  ////////////////////// Exercise 2 Counter ////////////////////////////////

  val counter = new Counter(0)
  println(counter.inc.print)

  println(counter.dec.print)

  println(counter.inc(5).print)


}

class Writer(val firstname:String, val Surname:String, val year:Int){

  def fullName:String = s"$firstname $Surname"

}

class Novel(val novelName:String, var YOR:Int, val author:Writer){

  def name:String = s"Novel name: $novelName"

  def authorAge: Int = this.author.year

  def isWrittenBy(authorName:String): Boolean = this.author.fullName == authorName
  def copy(New_YOR:Int):Unit ={
      this.YOR = New_YOR
  }

}

class Counter(val count:Int = 0) //Always initialize with 0 default constructor parameter
{

  def inc:Counter = {
    println("Increamenting")
    new Counter(count+1)
  }
  def dec:Counter ={
    println("Decrementing")
    new Counter(count-1)
  }

  //Operator Overloading
  def inc(n:Int): Counter = {
    if(n<=0) this
    else inc.inc(n-1) // it calls inc method without arguments and it returns New counter,
    // with that it counts recursively increment till 0, and returns last counter object(this)

  }

  def dec(n: Int): Counter = {
    if (n <=0) this
    else dec.dec(n - 1) // Same logic as Increment
  }

  def print:Int = count

}