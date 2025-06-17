package operations

import models.Account

object AccountDataQuery {
  def findAccountById(accounts: Map[String, Account], accountId: String): Option[Account] = {
    accounts.get(accountId)
  }

  def getBalance(account: Account): BigDecimal = {
    account.balance
  }
  
  def generateStatement(account: Account): String = {
    val header = s"""
                    |=== Extrato Bancário ===
                    |Conta: ${account.id}
                    |Titular: ${account.holder}
                    |Saldo Atual: ${account.balance}
                    |
                    |Histórico de Transações:
                    |""".stripMargin

    val transactions = account.transactions
      .sortBy(_.integrateDate)(Ordering[String].reverse)
      .map { trans =>
        f"${trans.integrateDate} | ${trans.transactionType.padTo(10, ' ')} | ${trans.amountValue}%10.2f | ${trans.description}"
      }
      .mkString("\n")

    header + transactions
  }
  
  def listAllAccounts(accounts: Map[String, Account]): String = {
    if (accounts.isEmpty) "Nenhuma conta cadastrada"
    else {
      accounts.values
        .map(acc => s"${acc.id} - ${acc.holder} - Saldo: ${acc.balance}")
        .mkString("\n")
    }
  }
}