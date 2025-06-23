package operations

import models.Account

object AccountTransfer {
  def transfer(from: Account, to: Account, amount: BigDecimal): Either[String, (Account, Account)] = {
    AccountWithdraw.withdraw(from, amount).flatMap { updatedFrom =>
      AccountDeposit.deposit(to, amount).map { updatedTo =>
        (updatedFrom, updatedTo)
      }
    }
  }
}