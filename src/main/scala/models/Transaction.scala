package models

import java.time.LocalDate

case class Transaction(
                      transactionType: String,
                      amountValue: BigDecimal,
                      description: String,
                      integrateDate: String = LocalDate.now.toString
                    )