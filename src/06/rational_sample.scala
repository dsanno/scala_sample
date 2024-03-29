implicit def intToRational(x: Int) = new Rational(x)

val x = new Rational(1, 4)
val y = new Rational(1, 6)
val z = new Rational(1, 12)

println("x = " + x)
println("y = " + y)
println("x = " + z)
println("x + y = " + (x + y))
println("x - z = " + (y - z))
println("x * y = " + x * y)
println("x / z = " + x / z)
println("x + 1 = " + (x + 1))
println("2 - x = " + (2 - x))
println("3 * x = " + 3 * x)
println("4 / x = " + 4 / x)