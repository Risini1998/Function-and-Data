package Assignments

object FunctionData3_4 extends App {

  var a1 = new Account("987263823v", "15220085563248", 200000)
  var a2 = new Account("782515272v", "28500396655652", 500000)
  var a3 = new Account("657837644v", "45680056002365", -100000)
  var a4 = new Account("782515272v", "8560080065652", -50000)

  a2.transfer(a4,10000)
  println("After transfer-")
  println("\ta2 - " + a2)
  println("\ta4 - " + a4)

  var bank:List[Account]=List(a1,a2,a3,a4)

  val bal = bank.map(_.balance)

  val overdraft=(b:List[Account])=> b.filter(x=>x.balance<0)

  val totalbalance=(b:List[Double])=> b.reduce((a1, a2) => a1 + a2)

  val interest=(b:List[Account])=>b.map(x=> if(x.balance>=0) x.balance*105/100 else x.balance*110/100)

  println("\n->List of Accounts with negative balances-\n\t" + overdraft(bank))
  println("->Calculate the sum of all account balances- " + totalbalance(bal))
  println("->Final balances of all accounts after apply the interest-\n\t" + interest(bank))
}

class Account(id:String,n: String, b: Double) {
  val nic=id
  val acnumber = n
  var balance = b

  def withdraw(a:Double) = this.balance=this.balance-a

  def deposit(a:Double) = this.balance=this.balance+a

  def transfer(a:Account,b:Double)={
    this.withdraw(b)
    a.deposit(b)
  }

  override def toString = "["+nic+":"+acnumber +":"+ balance+"]"
}