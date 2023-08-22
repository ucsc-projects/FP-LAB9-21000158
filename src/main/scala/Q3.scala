class Account(initialBalance: Double) {
  private var balance: Double = initialBalance

  def getBalance: Double = balance

  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
  }

  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    require(amount <= balance, "Insufficient balance")
    balance -= amount
  }

  def transfer(amount: Double, targetAccount: Account): Unit = {
    withdraw(amount)
    targetAccount.deposit(amount)
  }
}

object Q3 extends App {
  val account1 = new Account(1000)
  val account2 = new Account(4500)

  println(s"Account 1 balance: ${account1.getBalance}")
  println(s"Account 2 balance: ${account2.getBalance}")

  account1.deposit(4000)
  account2.withdraw(1500)

  println(s"Account 1 balance after deposit: ${account1.getBalance}")
  println(s"Account 2 balance after withdrawal: ${account2.getBalance}")

  account1.transfer(400, account2)

  println(s"Account 1 balance after transfer: ${account1.getBalance}")
  println(s"Account 2 balance after transfer: ${account2.getBalance}")
}
