package learnOOP

object GenericsL {

  //List we have created is only take int as the type, what if we want a list with string elements
  //For that we have to use generics

  //We have to use a common variable as a class generic

  class MyList[A]{
    // Thi use Type A
  }

  // we can use two or more generics
  class Map[key,Value]{

  }

  val listofIntegers = new MyList[Int] //So we can use integers and Strings for our list
  val listofStrings = new MyList[String]

  //generic methods, suppose we are creating a companion for class Mylist
  object MyList{
    def aMethod[A]:MyList[A] = ???
  }

  val amethodfromcomp: MyList[Int] = MyList.aMethod[Int] //we are using Generics directly to the method

  //Variance problems in generic

  // Three scenarios we can face, Covariance, Invariance, Contravariance

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // List[cat] can extends to List[Animal]
  class covariantList[+A] // This + sign will extends our List of class extends to use list of Animals
  val animal:Animal = new Cat // This fine its a polymorph thing
  val animalList:covariantList[Animal] = new covariantList[Cat]

  //But if we create a covariant list of cat to animal, it will create a problem if we add a dog in the list
  //Suppose we add a dog to newclass which is declared as covariantlist of animal, it will polute the list,
  //Because it actually a cat list.
  //Eg animalList.add(New Dog) to solve we use bounded types (<:,>:) will see later

  //Invariance class
  //We cannot substitute one another
  class Invariant[A]
 // val InvariantAnimalList:Invariant[Animal] = Invariant[Cat] //This will throw error, have to use Animal
  val InvariantAnimalList:Invariant[Animal] = new Invariant[Animal]

 //CONTRAVARIANCE
 /*
 class Contravariant[-A]
 val contraVariantList:Contravariant[Cat]  = new Contravariant[Animal]
*/
 //but This above implementation doesn't make sense, because we cannot declare all the animals as cat.
 //so, this will be useful to us if we use trainer

  class Trainer[-A]
  val contraVariantList: Trainer[Cat] = new Trainer[Animal]

  // this make sense , we can assign a trainer of animal to the trainer of cat.
  // because animal trainer can train all the animals

  //Bounded types
  class Cage[A <: Animal](animal:A)
  val cage = new Cage(new Dog)

  // <:  = use subtypes of class, here animal as example
  // >: = use Supertype of class

  class Car
//  val newcage = new Cage(new Car)

  //In covariance we faced the issue, what if we add dog list into the cat list declared as Animal

  //In that case, the class will be changed into Animal Type

  class MyList1[+A]{
    def add[B >:A](element : B):MyList1[B]  = ???
  }
  // This above code is the example, if we are giving adding Dog into Cat type,
  // this will change whole class to Animal


}
