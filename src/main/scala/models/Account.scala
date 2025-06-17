package models

case class Account(
                    id: String,
                    holder: String,
                    balance: BigDecimal,
                    transactions: List[Transaction] = Nil
                  ) {
  override def toString: String =
    s"Account(ID: $id, Holder: $holder, Balance: $balance)"
}