package learnFuncProgramming

object HOFsCurries extends App {

  //Higher order functions is like sending a functions as parameter and receiving a result as function

  //for example
  val superFunction:(Int,(String,(Int,Boolean) => Int)) => (Int,Int) = null

  //In the above example, we are passing functions as parameters and returning as function
  // This is just a example for HOFs which is not actual logic or code implemented

  //real example
  //if we want pass a function which runs n times over x
  //Like nTimes(F,n,x)

  def nTimes(f : Int => Int , N:Int,x:Int):Int =
    if(N<=0) x
    else nTimes(f,N-1,f(x))

  val plusOne = (x:Int) => x+1

//  val plus10 = nTimes(plusOne,10,1)

//  println(plus10)

  //nTimes(f,n,x) = f(f(f(x)))...ntime of f(x)
  //functional programming is related to mathematics
  // if someone says functional programming is easy, either they are really master of it or lying


  def nTimesBetter(f: Int => Int, N: Int): (Int =>Int) =
    if (N <= 0) (x:Int) => x
    else (x:Int) => nTimesBetter(f, N - 1)(f(x))


  val plus10 = nTimesBetter(plusOne,10)

  println(plus10(1))


  //curried function - function with multiple parameters
  def superAdder(x:Int)(y:Int):Int =  x + y

  val add3 = superAdder(3)
  val add3plus = add3(10)
  println(add3plus)

    // we can write like this below
  def superAdder2:Int => (Int => Int) = (x:Int) => (y:Int) => x+y

  val add4 = superAdder2(4)
  val add4plus = add4(3)

  println(add4plus)

  

}
