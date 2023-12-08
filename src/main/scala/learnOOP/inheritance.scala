package learnOOP



object inheritanceAndTraits_1 extends App {

  /*
  1)Inheritance
  2)Access modifier - protected,private
  3)Inheritance with constructors
  4)Polymorphism
  5)0verrides and overLoading
  6)super
  7)protecting overrides - final,sealed
   */

  //single class inheritance ---------------------------------------------------------------------
  class Animal {
    val n_legs: Int = 4

    def creatureType = "domestic"

  }

  class dog extends Animal { //normal single class inheritance
  }

  val dog1 = new dog
  println(dog1.n_legs) // we will get n_legs = 4


  class cat extends Animal {
    override val n_legs = 5 // overriding val

    override def creatureType: String = "Wild" //overriding method
  }

  val cat1 = new cat
  println(cat1.n_legs) // here we will n_legs = 5 since we override the value
  println(cat1.creatureType)
  //access modifier --------------------------------------------------------------------------------

  class Animal1 {
    protected val n_legs = 2 // we have modified the access for val n_legs, it can be access only inside the child class and we can
    // access it from public method from outside of the clas
  }

  class cat2 extends Animal1 {
    def printleg = println(n_legs)
  }

  val cat22 = new cat2
  cat22.printleg // this  will work, because we already accessed using printleg method,
  // cat22.n_legs        // but outside of the class, we can't access it


  // Constructors ------------------------------------------------------------------------------------------

  class Person1(name: String, age: Int)

  // class Adult(name:String,age:Int,Idcard:String) extends Person - this won't work because Person has constructors

  class Adult(name: String, age: Int, Idcard: String) extends Person1(name, age)

  //have to PROVIDE constructor of the parent class, because parent class starts first.

  //Polymorphism (type substitution)

  val unknownAnimal: Animal = new cat
  println(unknownAnimal.n_legs)

  //Super

  // if you want to use Parent method inside the overridden method, we can use super

  class cat3 extends Animal{
    override def creatureType:String = {
      println(super.creatureType)
      "wild"
    }
  }
  val anotherCat = new cat3
  println(anotherCat.creatureType)  // we can use both values of parent method and overidden method


  //preventing overrides
  /*
  1- final on member
  2- final on the entire class
  3 -sealed (which can be overridded only on the same file)
   */
}