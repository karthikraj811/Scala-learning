package learnFuncProgramming

object AnonymousClass extends App{

  /*
  Normally we use like this below lines to create a function
  val somfunc:(Int =>Int) = new Function1 {
      def apply(n: Int) = n * 2

 Instead we can simplify this in scala

   */

  val someFunction:Int=>Int = (x=>x*3)

  println(someFunction(3)) // we get 9

  /*
  val somfunc:(Int =>Int) = new Function1 {      equals to   val someFunction:(Int=>Int) = (x=>x*3)
      def apply(n: Int) = n * 2

  but Type of the input and output should be mentioned Int =>Int

  if there are more paramaters then we should use brackets in types like (Int,Int,String) => String

  this is called as Anonymous Function as well as LAMBDA
   */

  val noParamFunc : () => Int =  () => 3

  println(noParamFunc)
  println(noParamFunc())

  //MOAR syntactic sugar
  /*
  where _ act as the parameter,
   */
  val Incrementer:Int =>Int = _ +1

  println(Incrementer(5))

  val adder: (Int,Int) => Int = _ + _

  println(adder(5,4))
}
