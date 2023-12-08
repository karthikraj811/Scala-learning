package learnBasics

object expressionsL {

  def main(args: Array[String]): Unit = {

    //EVERYTHING IN SCALA is expression. That means it gives something rather than just executing it.

    var i = (1 * 2 + 7) //All the operators are expressions

    println(i)

    val aWhile: Unit = while (i < 10) {
      println(i)
      i+=1
    } //this is expression it gives a value of type Unit

    //INSTRUCTION (Do) vs EXPRESSION (VALUE), Have to think everything as expression in scala
    //In Java there is no expression, it has instruction. it execute the code.
    //example
    val aCondition: Boolean = true
    val aValues = if(aCondition) 5 else 6
    println(aValues) // We will get 5 because this if expression returns a Value, just not execute it.


    //CODE BLOCKS -everything inside the { } is code block and returns last line of the block

    val aBlock = { if(aCondition)
                      456 else 2000
                      34
                      "Hello this is the last line"
    }  // aBlock type will be string and it returns last line of the code block which is hello this is the last line
    print(aBlock)
    //Code Blocks are also an Expression.

  }


}
