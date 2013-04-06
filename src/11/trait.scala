trait Philosophical {
  def philosophize() {
    println("I consume memory, therefore I am!")
  }
}

class Frog extends Philosophical {
  override def toString = "green"
}

val frog = new Frog
frog.philosophize()

val phil: Philosophical = frog;
phil.philosophize()

class Animal
class Frog2 extends Animal with Philosophical {
  override def toString = "green"
  override def philosophize() {
    println("It ain't easy being " + toString + "!")
  }
}

val phrog: Philosophical = new Frog2
phrog.philosophize()

trait HasLegs {
  val countLegs = 4;
}
class Frog3 extends Animal with Philosophical with HasLegs {
  override def toString = "green"
}

val frog3 = new Frog3
println("leg count: " + frog3.countLegs)
