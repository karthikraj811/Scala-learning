package learnFuncProgramming

object WhatsAfunc extends App {
  //Function are the first level elements,
  // we can use it as value like "passing function as parameters or returning function as value"
  //All the functions are instance(or would say object) in SCALA
  // There are 22 predefined functions Function1[Int,Int] first Int is incoming value type, next one is output type
  //Like that we can use Function2[Int,Int,Int] , 2 input types as Int and one output Type as Int,
  //we can use Function with 22 parameters

  val someFunction: Function1[Int, Int] = new Function1 {
    def apply(n: Int) = n * 2
  }


  println(someFunction.apply(2))

  println(someFunction(2)) //Syntactic sugar

  // we can use just (Type,Type)=>Type instead of Function1[Type,Type], it is also syntactic sugar
  def concatenateString:((String, String) => String) = new Function2 {
    def apply(a: String, b: String) = a + b
  }

  println(concatenateString("Scala ", "3.0.0"))


  //basically Function1,2,3 those are nothing but the classes
   trait Myfucn{
    def apply(a:Int,b:Int):Int
  }

  val adder = new Myfucn {
    override def apply(a: Int, b: Int): Int = a + b
  }
 println(adder(10,20))

 // SCALA is not originally created for functional programming, So all the functions like
 //Function1, Function2..Function22 are predefined classes with apply methods.

 

}