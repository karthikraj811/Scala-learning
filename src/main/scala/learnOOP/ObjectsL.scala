package learnOOP

object ObjectsL extends App {

  // In scala there is no class-level functionality like java
/*
In java we can directly use the class attributes
suppose we have class person,
we can directly System.out.println(person.n_eyes) this works
but we can't do that , To attain this class-level functionality we have to use object Person1{}

And object is the SINGLETON INSTANCE, that means we cannot create more instance like per = new Person1
And class is the instance-level functionality, we can create new instance out of class but we can't use it as a class level functionality
like printing  Person1.n_eyes directly without instantiate it.

To attain both we can name same object name in object and class like below
 */
  object Person1 {
    val n_eyes = 2
  }

  /*
  class
   */
  class Person1 {
      val n_eyes =2
  }
  val per1 = Person1
  val per2 = Person1
  println(per1 == per2) // it is from singleton instance , it returns true .if you comment out Object part, it throws the error

  val per3 = new Person1
  val per4 = new Person1
  println(per3 == per4) //it is instance-level functionality , it returns false. if you comment out class part, it won't work
}

