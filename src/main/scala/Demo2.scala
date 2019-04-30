object Demo2 {

  def main(args: Array[String]): Unit = {
    //Showcasing type inference
    val string = "CS474"
    val aNumber = 3
    println(aNumber)

    val classAverages = 65 :: 70 :: "hello" :: 80 :: 90 :: Nil

    //Showcasing functional features such as map/foreach
    val averages2 = 65 :: 70 :: 80 :: 90 :: Nil
    println(averages2)
    val extraCredit = classAverages.map(x => x + "testing")
    println(extraCredit)

    //Showcasing how everything is an object and therefore inherits from from a class depending on its type
    val stringTest = "testing"
    stringTest
    val intTest = 1
    intTest

    val ap = new airplane()
    println(ap.name)
    ap.flyAirplane
  }
}

/*object testing{

  def main(args: Array[String]): Unit = {
    val test = List(Demo2, Demo2, Demo2)
    test.foreach(x => x.main(List().toArray))
  }
}*/

class airplane extends fly {
  var name = "init"
  def this(value: String){
    this();
    this.name = value
  }
}

//train is similar to an abstract class
trait fly{
  def flyAirplane(): Unit ={
    println("Look at me! I'm flying!")
  }

}