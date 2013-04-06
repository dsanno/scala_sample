class Point(val x: Int, val y: Int)

trait Rectangular {
  val topLeft: Point
  def bottomRight: Point
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
  def top = topLeft.y
  def bottom = bottomRight.y
  def height = bottom - top
}

abstract class Component extends Rectangular {
  def area = width * height
}

class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular {
  def area = width * height
}

val rect = new Rectangle(new Point(1, 1), new Point(10, 10))
println("(left, top, right, bottm): (" + rect.left + ", " + rect.top + ", " + rect.right + ", " + rect.bottom + ")")
println("area: " + rect.area)
