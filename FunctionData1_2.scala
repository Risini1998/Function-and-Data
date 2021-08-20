package Assignments

object FunctionData1_2 extends App {
  val x= new Rational(3,4)
  val y= new Rational(5,8)
  val z= new Rational(2,7)
  println("\n-x = " + x.neg)
  println("\nx - y - z = "+ x +" - "+ y +" - "+ z +" = "+ x.sub(y).sub(z))
}

class Rational(x:Int, y:Int=1){
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a.abs else gcd(b, a % b)
  val numer = x / gcd(x, y)
  val denom = y / gcd(x, y)

  def neg = new Rational(-this.numer,this.denom)

  def add(r:Rational) = new Rational(this.numer *
    r.denom +r.numer * this.denom, this.denom * r.denom)

  def sub(r:Rational) = this.add(r.neg)

  override def toString = numer + "/" + denom

}
