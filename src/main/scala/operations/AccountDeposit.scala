package operations

import models.{Account, Transaction}

object AccountDeposit {
  def deposit(account: Account, amount: BigDecimal): Either[String, Account] = {
    if (amount <= 0) Left("O valor do depósito deve ser positivo")
    else {
      val newTransaction = Transaction(
        transactionType = "DEPOSITO",
        amountValue = amount,
        description = s"Depósito de $amount"
      )
      Right(account.copy(
        balance = account.balance + amount,
        transactions = newTransaction :: account.transactions
      ))
    }
  }
}