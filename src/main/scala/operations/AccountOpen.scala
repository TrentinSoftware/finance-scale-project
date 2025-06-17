package operations

import models.{Account, Transaction}

object AccountOpen {
  def open(id: String, holder: String, initialBalance: BigDecimal): Account = {
    require(id.nonEmpty, "Account ID cannot be empty")
    require(holder.nonEmpty, "Account holder name cannot be empty")
    require(initialBalance >= 0, "Initial balance cannot be negative")

    val initialTransaction = Transaction(
      transactionType = "OPENING",
      amountValue = initialBalance,
      description = "Account opened with initial balance"
    )

    Account(
      id = id,
      holder = holder,
      balance = initialBalance,
      transactions = List(initialTransaction)
    )
  }
}