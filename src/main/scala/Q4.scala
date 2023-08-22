class Account2(initialBalance: Double) {
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

  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05 // Deposit interest
    } else if (balance < 0) {
      balance += balance * 0.1 // Overdraft interest

    }
  }
}

object Bank {
  def accountsWithNegativeBalances(accounts: List[Account2]): List[Account2] = {
    accounts.filter(account => account.getBalance < 0)
  }

  def totalBalance(accounts: List[Account2]): Double = {
    accounts.map(_.getBalance).sum
  }

  def applyInterestToAll(accounts: List[Account2]): Unit = {
    accounts.foreach(_.applyInterest())
  }
}

object Main extends App {
  val account1 = new Account2(3000)
  val account2 = new Account2(-1000)
  val account3 = new Account2(5000)

  val bankAccounts = List(account1, account2, account3)

  val negativeBalanceAccounts = Bank.accountsWithNegativeBalances(bankAccounts)
  val totalBankBalance = Bank.totalBalance(bankAccounts)

  println("Accounts with negative balances:")
  negativeBalanceAccounts.foreach(account => println(s"Account balance: ${account.getBalance}"))

  println(s"Total bank balance: $totalBankBalance")

  Bank.applyInterestToAll(bankAccounts)

  println("Balances after applying interest:")
  bankAccounts.foreach(account => println(s"Account balance: ${account.getBalance}"))
}
