package learnFuncProgramming

object mapFilterFlatmap extends App {


  val lists = List(1,2,3,4)

  println(lists)
  println(lists.head)
  println(lists.tail)

  val mapFunc = lists.map(_ * 2)
  println(mapFunc)

  val filterfunc = lists.filter( _ % 2 == 0)
  println(filterfunc)

  val toPair:(Int => List[Int]) = x => List(x,x + 1)

  val flatmpFunc = lists.flatMap(toPair)
  println(flatmpFunc)

  val numbers = List(1,2,3)
  val chars = List("a","b","c")


  val combination = chars.flatMap(n=>numbers.map(n+_))

  println(combination)





}
