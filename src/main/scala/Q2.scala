class Rational2(n: Int, d: Int) {
  require(d != 0, "Denominator must not be zero")

  private val gcdValue: Int = gcd(n.abs, d.abs)
  val numer: Int = n / gcdValue
  val denom: Int = d / gcdValue

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def neg: Rational2 = new Rational2(-numer, denom)

  def sub(other: Rational2): Rational2 = new Rational2(
    numer * other.denom - other.numer * denom,
    denom * other.denom
  )

  override def toString: String = s"$numer/${denom.abs}"
}

object Rational2 {
  def apply(n: Int, d: Int): Rational2 = new Rational2(n, d)
}

object Q2 extends App {
  val x = Rational2(2, 3)
  val y = Rational2(1, 2)
  val z = Rational2(2, 5)

  val result = y.sub(z).sub(x)

  println(s"x: $x")
  println(s"y: $y")
  println(s"z: $z")
  println(s"Result of (y - z) - x: $result")
}
