//strategy pattern

/*
Here you pass algorithms around just like you pass objects around,
there is no need for the Strategy Pattern.

By passing the function as an object, you eliminate the need for patterns like strategy. There is no need for a separate class for another
algorithm.
 */

object ScalaStrategy extends App {

  def addition(x: Int, y: Int) = x + y
  def subtraction(x: Int, y: Int) = x - y
  def multiplication(x: Int, y: Int) = x * y
  def division (x: Int, y: Int) : Int = x / y
  def mod(x: Int, y: Int): Int = x % y

  def execute(callback:(Int, Int) => Int, x: Int, y: Int) = callback(x, y)

  println("Add:      " + execute(addition, 1, 1))
  println("Subtract: " + execute(subtraction, 3, -18))
  println("Multiply: " + execute(multiplication, 4, 6))
  println("Divide: " + execute(division, 20, 4))
  println("Mod: " + execute(mod, 3, 4))

}