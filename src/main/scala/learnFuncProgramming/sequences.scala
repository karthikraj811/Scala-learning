package learnFuncProgramming

import scala.util.Random

object sequences extends App {

  //Sequence

  val sequence: Seq[Int] = Seq(1, 2, 3)

  println(sequence)
  println(sequence.updated(2, 0))

  //List

  val list = List(1, 2, 3)
  val list1 = 0 +: list //or 0 :: list //prepend
  val list2 = 0 +: list :+ 4 //append
  println(list)
  println(list1)
  println(list2)

  //Array - which are nothing but the java array, which are mutable

  val array = Array(1, 2, 3, 4)
  array(2) = 0
  println(array.toList)

  //vectors -  vectors are similar like list which is good for bigger sequences

  val numberOfList = List(1, 2, 3)
  val numbersOfVector = Vector(1, 2, 3)

  println(numbersOfVector)

  val maxTime = 1000
  val maxCapacity = 10000

  def writeTime(collection: Seq[Int]): Double = {
    val r = new Random

    val times = for {
      it <- 1 to maxTime
    } yield {
      val current = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - current

    }
    times.sum  / maxTime * 1.0
  }
  //List
  //Keeps referencing tail : advantage
  //updating the element in the middle takes long :disadvantage
  val lists = (1 to maxCapacity).toList

  //Vectors
  //depth of the tree is small :advantage
  //Need to update the entire 32-element chunk : disadvantage
  val vectors = (1 to maxCapacity).toVector

  println(writeTime(lists)) // 57787 nanosecs
  println(writeTime(vectors)) // 977 nanosecs


}
