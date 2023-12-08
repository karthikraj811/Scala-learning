package learnOOP

object exceptionsL extends App {

  //There are two types of throwable
  //Exception and errors
  //Exceptions are something wrong with the program , eg: runtimeException,nullPointerException
  //Errors are something off with the system eg:outOfMemoryError(oom) stackOverFlowError



  //throw and catch exception


//  throw new RuntimeException("Throwing runtime exception")

  //throwing an exception is also an expression in scala // mostly we throw exception only, throwing errors are  rare

//  val aNothingval  = throw new NullPointerException()

  /*
  the type of any exception is Nothing, so we can assign any type to the value
  val aNothingval :String  = throw new NullPointerException()
  val aNothingval :Int  = throw new NullPointerException()
   */
//Catching exception

//  def someinteger(cond:Boolean):Int = if (cond) throw new NullPointerException() else 42
//
//  try{
//    someinteger(true)
//  }
//  catch{
//    case e : NullPointerException => println("Null not allowed")
//  }
//  finally{
//    println("Finally runs whatever")
//  }

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathErrorException extends RuntimeException

  object simpleCalc {
    def add(a:Int,b:Int): Int = {
      val result = a + b
//      result
      if (a>0 && b>0 && result>0) result else throw new OverflowException
    }

    def sub(a:Int, b:Int) :Int = {
      val result = a - b
      if (a < 0 && b < 0 && result > 0) result else throw new OverflowException
    }

    def mul(a:Int,b:Int):Int = {
        val result = a * b
        result
    }

    def divide(a:Int,b:Int) = {
      if (b==0) throw new MathErrorException else a/b

    }
  }

  val calc = simpleCalc
//  print(simpleCalc.add(4,Int.MaxValue))
//  print(simpleCalc.divide(4,0))

}
