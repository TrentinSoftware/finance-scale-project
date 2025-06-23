# README.md Atualizado para o Projeto Financeiro em Scala

```markdown
# Sistema Financeiro em Scala

Projeto desenvolvido em Scala para simular operações bancárias básicas, implementando os princípios do paradigma funcional.

## 📋 Requisitos do Sistema

- Java JDK 17 ou superior
- Scala 3.3.1
- sbt (Scala Build Tool) 1.6.2

## 🚀 Como Executar o Projeto

Opção 1: Executando com sbt
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/finance-scala-project.git
   cd finance-scala-project
   ```

2. Execute o projeto:
   ```bash
   sbt run
   ```

### Opção 2: Executando com Docker
1. Construa a imagem Docker:
   ```bash
   docker build -t finance-scala .
   ```

2. Execute o container:
   ```bash
   docker run -it finance-scala
   ```

## 🏦 Funcionalidades Implementadas

- **Criação de contas** com saldo inicial
- **Depósitos** com validação de valores positivos
- **Saques** com verificação de saldo suficiente
- **Transferências** entre contas
- **Consulta de saldo** e dados da conta
- **Extrato bancário** com histórico de transações

## 🧩 Princípios Funcionais Implementados

### ✅ Imutabilidade
- Todas as estruturas de dados (`Account` e `Transaction`) são case classes imutáveis
- Operações retornam novas instâncias ao invés de modificar estado existente

### ✅ Funções Puras
- Todas as operações bancárias são implementadas como funções puras
- Uso de `Either` para tratamento funcional de erros
- Mesma entrada sempre produz mesma saída, sem efeitos colaterais

### ✅ Funções de Alta Ordem
- Uso de `map`, `flatMap` e composição funcional nas transferências
- Operações em listas como `sortBy`, `filter` e `mkString` para manipulação de transações

### ✅ Outras Boas Práticas
- Separação clara entre lógica de negócio e interface
- Mensagens de erro descritivas
- Validações rigorosas de entrada

## 🏗️ Estrutura do Projeto

```
finance-scala-project/
├── src/
│   ├── main/
│   │   └── scala/
│   │       ├── models/
│   │       │   ├── Account.scala
│   │       │   └── Transaction.scala
│   │       ├── operations/
│   │       │   ├── AccountOpen.scala
│   │       │   ├── AccountDeposit.scala
│   │       │   ├── AccountWithdraw.scala
│   │       │   ├── AccountTransfer.scala
│   │       │   └── AccountDataQuery.scala
│   │       └── Main.scala
│   └── test/
├── build.sbt
├── Dockerfile
└── README.md
```

## 🎯 Critérios de Avaliação Atendidos

1. **Organização do código e relatório**:
    - Código bem estruturado em módulos
    - Documentação clara no README

2. **Funcionamento do programa**:
    - Todas operações básicas funcionando
    - Interface de console intuitiva

3. **Funcionalidades completas**:
    - Criação/consulta de contas
    - Depósitos, saques e transferências
    - Consulta de extrato

4. **Facilidade de uso e configuração**:
    - Instruções claras de execução
    - Configuração via Docker simplificada

## 👨‍🏫 Pontos para avaliar

1. Execute o projeto seguindo as instruções acima
2. Interaja com o sistema através do menu console
3. Verifique os princípios funcionais nos arquivos:
    - `operations/` para funções puras
    - `models/` para imutabilidade
    - `Main.scala` para a interface

4. Para ver exemplos específicos dos princípios:
    - **Imutabilidade**: Verifique as case classes em `models/`
    - **Funções Puras**: Veja as operações em `operations/`
    - **Funções de Alta Ordem**: Verifique `AccountTransfer.scala` e `AccountDataQuery.scala`
