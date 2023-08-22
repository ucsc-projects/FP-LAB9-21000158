class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator must not be zero")

  private val gcdValue: Int = gcd(n.abs, d.abs)
  val numer: Int = n / gcdValue
  val denom: Int = d / gcdValue

  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def neg: Rational2 = new Rational2(-numer, denom)

  override def toString: String = s"$numer/${denom.abs}"
}

object Rational {
  def apply(n: Int, d: Int): Rational2 = new Rational2(n, d)
}

object Q1 extends App {
  val x = Rational2(5, 20)
  val negX = x.neg

  println(s"x: $x")
  println(s"Negation of x: $negX")
}


