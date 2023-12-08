package learnBasics


object FunctionsL extends App {

  //Just a Normal Function which takes String and int and concat
  def aConcatFun(a: String, b: Int): String = {
    a + " " + b
  }

  println(aConcatFun("Hai", 5))

  // When we want loop, we have to do recursive function in Scala , note: compiler can't infer type of a recursive function
  def aSumSeries(n: Int): Int = {
    if (n == 1) 1
    else
      n + aSumSeries(n - 1)
  }

  println(aSumSeries(5))


  // Note : Functions also an Expression in Scala

  //Lets see parameterless-function, this only works with scala 2, scala 3 won't allow.

  def aParameterLessFunc(): Int = 45

  println(aParameterLessFunc())
  //println(aParameterLessFunc)

  //Recursive fibonacci

  def recFib(n:Int):Int = {
    if(n<=2)1
    else
      recFib(n-1)+recFib(n-2)
  }
  println(recFib(8))



  //recursive prime
  def recIsPrime(n:Int):Boolean = {
    def recIsPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && recIsPrimeUntil(t - 1)
    }

    recIsPrimeUntil(n/2)

  }
  println(recIsPrime(37))







}


