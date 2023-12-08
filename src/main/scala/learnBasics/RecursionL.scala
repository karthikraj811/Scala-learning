package learnBasics

import scala.annotation.tailrec

object RecursionL extends App {

  // factorial using recursion
  def aNormalRecursion(n: Int): Int = {

    if (n < 1) 1
    else {
      println("Now processing recursion" + n + " and needed recursive function" + (n - 1))
      val result = n * aNormalRecursion(n - 1)
      println("Completed " + n)
      result
    }

  }

  //  println(aNormalRecursion(5))


  /*
  But the problem with this recursion is , it will give  you stackoverflow error for larger numbers like 1000,5000,20000.
  For this kinda scenario we have to use tail recursion which stores intermediate result as variable instead of storing all the way
   */
  //TAIL RECURSIVE FUNCTION

  def aTailRecFact(n: BigInt): BigInt = {
    def accumulateRes(n: BigInt, accumulator: BigInt): BigInt = {
      if (n <= 1) 1
      else {
        val result: BigInt = n * accumulateRes(n - 1, n * accumulator);
        result
      }
    }

    accumulateRes(n, accumulator = 1)
  }

  //  println(aTailRecFact(1000))


  //Concatenating String using tail recursion

  def aStringConcat(S: String, Num: Int): String = {

    def accumulateRes(S: String, Num: Int, accumulator: String): String = {
      if (Num < 1) ""
      else S + accumulateRes(S, Num - 1, S + accumulator)
    }

    accumulateRes(S, Num, "")

  }

//  println(aStringConcat("hello", 5))

  //IsPrime In Tail Recursion
  def isPrimeTail(n: Int):Boolean = {
    @tailrec
    def isPrimeAcc(t:Int, acc:Boolean):Boolean ={
      if (!acc) false
      else if (t<=1) true
      else isPrimeAcc(t-1 , n%t!=0 && acc)
    }
    isPrimeAcc(n/2,acc = true)
  }
//  println(isPrimeTail(12))


  def fibonacciTail(n:Int):Int = {

    @tailrec
    def fibAcc(t:Int, f_2:Int, f_1:Int):Int = {
      if (t>=n) f_2
      else fibAcc(t+1,f_1+f_2,f_2)
    }
    if (n<=1) 1
    else fibAcc(2,1,1)
  }
  // 1 1 2 3 5 8 13 21
  // println(fibonacciTail(7))

}