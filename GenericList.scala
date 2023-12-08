package exercise


abstract class GList[+A] {
  def head: A
  def tail: GList[A]
  def isEmpty: Boolean
  def add[B >:A](element: B): GList[B]
  def printelement: String
  override def toString: String = "[" + printelement + "]"

  def map[B](transformer:MyTransformer[A,B]) : GList[B]
  def filter(predicate:MyPredicate[A]):GList[A]
  def flatMap[B](transformer:MyTransformer[A,GList[B]]) : GList[B]

  //Concatenation
  def ++[B >: A](list:GList[B]):GList[B]

}

object EmptylsG extends GList[Nothing] {

  def head: Nothing = throw new NoSuchElementException()
  def tail: Nothing = throw new NoSuchElementException()
  def isEmpty: Boolean = true
  def add[B >:Nothing](element: B): GList[B] = new consG(element, EmptylsG)
  def printelement:String = ""


  def map[B](transform: MyTransformer[Nothing, B]): GList[B] = EmptylsG
  def filter(predicate: MyPredicate[Nothing]): GList[Nothing] = EmptylsG
  def flatMap[B](transformer: MyTransformer[Nothing, GList[B]]): GList[B] = EmptylsG

  def ++[B >:Nothing](list:GList[B]):GList[B] = list

}

class consG[+A](h: A, t: GList[A]) extends GList[A] {
  def head: A = h
  def tail: GList[A] = t
  def isEmpty: Boolean = false
  def add[B >:A](element: B): GList[B] = new consG(element, this)
  def printelement: String =  ""+h + " " + t.printelement

  def map[B](transformer: MyTransformer[A, B]): GList[B] = {
    new consG(transformer.transform(h),t.map(transformer))
  }

  def filter(predicate: MyPredicate[A]): GList[A] =
    if (predicate.test(h)) new consG(h, t.filter(predicate))
    else t.filter(predicate)

  def ++[B >: A](list:GList[B]):GList[B] = new consG(h, t ++ list)

  def flatMap[B](transformer: MyTransformer[A, GList[B]]): GList[B] = {
    transformer.transform(h)++  t.flatMap(transformer)
  }

}
trait MyPredicate[-t]{
  def test(elem: t) : Boolean
}

trait MyTransformer[-A,B]{
  def transform(elem : A) :B
}


object GenericList extends App{



  val list1ofIntegers = EmptylsG
  val list2 = list1ofIntegers.add(3).add(2).add(1)
  println(list2.toString)

  val alist1ofIntegers = EmptylsG
  val alist2 = list1ofIntegers.add(6).add(5).add(4)
  println(alist2.toString)

  val list1ofStrings = EmptylsG
  val list3 = list1ofStrings.add("Learning").add("Scala").add("3.0.0")
  println(list3.toString)

  val mappedInt = list2.map(new MyTransformer[Int,Int]{
    override def transform(n:Int):Int = n * 2
  })
  println(mappedInt)

  val filteredInt = list2.filter(new MyPredicate[Int] {
    override def test(n: Int): Boolean = n % 2 == 0
  }
  )
  println(filteredInt)

  println(list2 ++ alist2) //Concatenate list

  val aflatmap = list2.flatMap(new MyTransformer[Int,GList[Int]] {
    override def transform(elem:Int):GList[Int] = new consG(elem, new consG(elem+1,EmptylsG))
  })
  println(aflatmap.toString)

}
