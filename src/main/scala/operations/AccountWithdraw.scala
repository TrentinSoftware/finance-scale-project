package operations

import models.{Account, Transaction}

object AccountWithdraw {
  def withdraw(account: Account, amount: BigDecimal): Either[String, Account] = {
    if (amount <= 0) Left("O valor do saque deve ser positivo")
    else if (amount > account.balance) Left("Saldo insuficiente")
    else {
      val newTransaction = Transaction(
        transactionType = "SAQUE",
        amountValue = -amount,
        description = s"Saque de $amount"
      )
      Right(account.copy(
        balance = account.balance - amount,
        transactions = newTransaction :: account.transactions
      ))
    }
  }
}