package learnBasics

object defaultArgs extends App {



  def aFactorial(n:Int,acc:Int ):Int={
    if(n<=1) acc
    else aFactorial(n-1,n*acc)
  }

  println(aFactorial(3,1))

  //Here We always pass accumulator initial values as 1, so we don't need to specify it everytime.
  // we can give the default like python
  def aFactorial2(n: Int, acc: Int =1): Int = {
    if (n <= 1) acc
    else aFactorial(n - 1, n * acc)
  }

  println(aFactorial2(3))


  //No Need to give value for acc if we reuse the function manytimes

  //NAMED arguments

}
