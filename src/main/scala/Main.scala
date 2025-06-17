import operations.{AccountOpen, AccountDataQuery}
import models.Account
import scala.io.StdIn

object Main extends App {
  private var accounts: Map[String, Account] = Map.empty

  def menu(): Unit = {
    println("\n=== Sistema Bancário ===")
    println("1. Criar conta")
    println("2. Consultar conta")
    println("3. Sair")
    print("Escolha: ")
  }

  def accountOpen(): Unit = {
    print("ID da conta: ")
    val id = StdIn.readLine()
    print("Titular: ")
    val holder = StdIn.readLine()
    print("Saldo inicial: ")
    val balance = BigDecimal(StdIn.readLine())

    try {
      val newAccount = AccountOpen.open(id, holder, balance)
      accounts = accounts + (id -> newAccount)
      println(s"Conta criada com sucesso: $newAccount")
    } catch {
      case e: IllegalArgumentException => println(s"Erro: ${e.getMessage}")
    }
  }

  def queryAccount(): Unit = {
    print("Digite o ID da conta: ")
    val id = StdIn.readLine()

    AccountDataQuery.findAccountById(accounts, id) match {
      case Some(account) =>
        println(s"\nDados da Conta:")
        println(s"ID: ${account.id}")
        println(s"Titular: ${account.holder}")
        println(s"Saldo: ${account.balance}")
      case None =>
        println("Conta não encontrada")
    }
  }

  // Loop principal
  var running = true
  while(running) {
    menu()
    StdIn.readLine() match {
      case "1" => accountOpen()
      case "2" => queryAccount()
      case "3" => running = false
      case _   => println("Opção inválida")
    }
  }
  println("Sistema encerrado.")
}