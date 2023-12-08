package learnBasics

object callByVal_callByName extends App {


  /*
  the output of the first function callByValue is :
        the time is4756036061993000
        the time is4756036061993000

   Both the print statements gives same output, because the function System.nanoTime()
                                                              is executed only once while calling the function

  the output of the Second function callByName is :
        the time is4756036108389600
        the time is4756036108452600

   Here, it does the lazy evaluation it runs everytime when it is invoked inside the functions

   basically, call by value executes System.nanoTime() and sends only the values into the function
              call by name sends the System.nanoTime() itself into the function, and executes each time.

   */


  def callByValue(x:Long) ={
    println("the time is" + x)
    println("the time is" + x)
  }

  def callByName(x: => Long) = {
    println("the time is" + x)
    println("the time is" + x)
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

}
