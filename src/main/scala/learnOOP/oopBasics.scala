package learnOOP

object oopBasics extends App {

  val person = new Person("Karthik",28)

  /*
  We have to mention val name and val age in the class constructors  to use this as fields (person.age or person.name)
  Otherwise will get an error like below
  """
  value name is not a member of learnOOP.Person
    println(s"I am ${person.name} and I am ${person.age} years old)")

  """
   */
  println(s"I am ${person.name} and I am ${person.age} years old)")

  // But we can use x from the class since those are not constructors , it will be executed once we instantiate the class

  println(person.x)

  person.greet("Balaji")
}

class Person(val name:String, val age:Int){ // name and age are constructors // we can use default values in constructors like age:Int = 0//

  val x:Int =10

  def greet(name:String):Unit= println(s"${this.name} says: Hi, $name")

}