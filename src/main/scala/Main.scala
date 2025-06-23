import operations.{AccountOpen, AccountDataQuery, AccountDeposit, AccountWithdraw, AccountTransfer}
import models.Account
import scala.io.StdIn

object Main extends App {
  private var accounts: Map[String, Account] = Map.empty

  def menu(): Unit = {
    println("\n=== Sistema Bancário Funcional ===")
    println("1. Criar conta")
    println("2. Consultar conta")
    println("3. Depositar")
    println("4. Sacar")
    println("5. Transferir")
    println("6. Ver extrato")
    println("7. Sair")
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
        println(s"\n=== Dados da Conta ===")
        println(s"ID: ${account.id}")
        println(s"Titular: ${account.holder}")
        println(s"Saldo atual: ${account.balance}")
        println(s"Total de transações: ${account.transactions.size}")
      case None =>
        println("Conta não encontrada")
    }
  }

  def deposit(): Unit = {
    print("ID da conta: ")
    val id = StdIn.readLine()
    print("Valor para depositar: ")
    val amount = BigDecimal(StdIn.readLine())

    accounts.get(id) match {
      case Some(account) =>
        AccountDeposit.deposit(account, amount) match {
          case Right(updatedAccount) =>
            accounts = accounts + (id -> updatedAccount)
            println(s"Depósito de $amount realizado com sucesso!")
          case Left(error) => println(s"Erro: $error")
        }
      case None => println("Conta não encontrada")
    }
  }

  def withdraw(): Unit = {
    print("ID da conta: ")
    val id = StdIn.readLine()
    print("Valor para sacar: ")
    val amount = BigDecimal(StdIn.readLine())

    accounts.get(id) match {
      case Some(account) =>
        AccountWithdraw.withdraw(account, amount) match {
          case Right(updatedAccount) =>
            accounts = accounts + (id -> updatedAccount)
            println(s"Saque de $amount realizado com sucesso!")
          case Left(error) => println(s"Erro: $error")
        }
      case None => println("Conta não encontrada")
    }
  }

  def transfer(): Unit = {
    print("ID da conta de origem: ")
    val fromId = StdIn.readLine()
    print("ID da conta de destino: ")
    val toId = StdIn.readLine()
    print("Valor para transferir: ")
    val amount = BigDecimal(StdIn.readLine())

    (accounts.get(fromId), accounts.get(toId)) match {
      case (Some(fromAccount), Some(toAccount)) =>
        AccountTransfer.transfer(fromAccount, toAccount, amount) match {
          case Right((updatedFrom, updatedTo)) =>
            accounts = accounts + (fromId -> updatedFrom) + (toId -> updatedTo)
            println(s"Transferência de $amount da conta $fromId para $toId realizada!")
          case Left(error) => println(s"Erro: $error")
        }
      case _ => println("Uma das contas não foi encontrada")
    }
  }

  def showStatement(): Unit = {
    print("Digite o ID da conta: ")
    val id = StdIn.readLine()

    accounts.get(id) match {
      case Some(account) =>
        println("\n=== Extrato Bancário ===")
        println(AccountDataQuery.generateStatement(account))
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
      case "3" => deposit()
      case "4" => withdraw()
      case "5" => transfer()
      case "6" => showStatement()
      case "7" => running = false
      case _   => println("Opção inválida, tente novamente")
    }
  }
  println("Sistema encerrado com sucesso.")
}