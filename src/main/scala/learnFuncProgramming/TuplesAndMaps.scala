package learnFuncProgramming

object TuplesAndMaps extends App {

  //Tuples are finite ordered list., it is same like functions Function1,Function2 , tuples are like
  //Tuple1,Tuple2
  val tuple1:Tuple2[Int,String] = Tuple2(1,"Scala 3.0.0")

  println(tuple1)
  val tuple2 = (2,"Scala 3.0.1") // we can simply write elements inside bracket as python to create Tuple

  // to access tuple elements
  println(tuple2._1)
  println(tuple2._2)
  println(tuple2.swap)
  println(tuple2.copy(_2="Java 20"))

    //Maps are collection with key,value pair

    val phonebook = Map(("Jim",9087),("Mary",8768))
    println(phonebook) // output : Map(Jim -> 9087, Mary -> 8768)

    //we can declare Map like
    val phonebook1 = Map("Jim"->9087,"Mary"->8768)
    println(phonebook1)

    // we can declare tuple like Type->Type instead of (Type,Type)
    // we can also use list inplace of tuples inside map

    //Map ops

    println(phonebook.contains("Jim"))
   println(phonebook("Jim"))  // to get the value of Jim

   val newTuple = "daniel" -> 7659

   val newPhonebook = phonebook + newTuple
   println(newPhonebook)

   //functions with Maps

   //map,filter,flatmap

  //map
   val pbMap = phonebook.map(pair=>pair._1.toLowerCase()->pair._2)
   println(pbMap)

   //filterwithkeys
   val pbMap1 = phonebook.filter(x => x._1.contains("J"))
  println(pbMap1)

  //mapvalues
  val pbMap2 = phonebook.map(value => value._1 -> ("044-" + value._2))
  println(pbMap2)

  //conversion to others and vise versa
  val phonebookList = phonebook.toList
  println(phonebookList)

  val list1 = List(("James",20)).toMap
  println(list1)

  // groupBy
  val list2 = List("james","bob","julie","alice","daniel","danish","willie")

  println(list2.groupBy(x => x.charAt(0)))





}
