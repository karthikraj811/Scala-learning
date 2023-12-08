package learnOOP

object inheritanceAbsClassaAndTraits extends App {

    /*
    Abstact class are the classes without implementing fields or method values
     */

    abstract class Mobile {
      val ram: String
      val Model : String
    }
    /*
    We cannot instantiate abstract class
     */

   // val mob1 = new Mobile : error msg "Class 'Mobile' is abstract; cannot be instantiated"

   class Apple extends Mobile{

      val ram = "16GB"
      val Model = "15 Pro"
    }
   /*
   No need to override the values for abstract classes
    */

    trait highPerformance {
      def performanceLevel(mobile:Mobile):String
    }

    trait security

    class Apple2 extends Mobile with highPerformance  with security{

      val ram = "16GB"
      val Model = "15 Pro"
      def performanceLevel(mobile:Mobile):String = s"${mobile.Model} performance is High"
    }

    val mob2 = new Apple2
    println(mob2.performanceLevel(mob2))

    /*
    Both can have with values and without values, then we override with the inherited class.But difference is
    1) we can use only one inheritance of class(scala supports single-class inheritance,
    but we can inherit more traits like above " class Apple2 extends Mobile with highPerformance  with security "

    2) we are using Class as Thing, Like animal,mobile,person. trait as a behaviour

    3) Before scala 3, trait can't have constructor parameter, but scala 3 has. So that was a difference , not now
     */


}
