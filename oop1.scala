package exercise


abstract class Mylist {

  def head :Int
  def tail:Mylist
  def isEmpty:Boolean
  def add(element:Int):Mylist
  def printelement:String
  def tostring:String = "[" + printelement +"]"

}

object Emptyls extends Mylist {

  def head: Int = throw new NoSuchElementException()
  def tail: Mylist = throw new NoSuchElementException()
  def isEmpty: Boolean = true
  def add(element: Int): Mylist = new cons(element,Emptyls)
  def printelement : String = ""

}

class cons(h:Int, t:Mylist) extends Mylist{

  def head: Int = h
  def tail: Mylist = t
  def isEmpty: Boolean = false
  def add(element: Int): Mylist = new cons(element,this)
  def printelement:String = {if (t.isEmpty == true) h + t.printelement else h + ","+ t.printelement }

}




object oop1 extends App {


  
  val list1 = Emptyls
  val list2 = list1.add(1).add(2).add(3)
  println(list2.printelement)

}
