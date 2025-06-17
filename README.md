# finance-scale-project
Projeto de desenvolvimento de sistema financeiro feito em Scala

Princípios Funcionais Implementados
Imutabilidade:

Todas as funções em Operacoes retornam novas instâncias ao invés de modificar os objetos existentes

Conta e Transacao são case classes imutáveis

Funções Puras:

Todas as funções em Operacoes são puras (sem efeitos colaterais, mesmo output para mesmo input)

Usam Either para lidar com erros de forma funcional

Funções de Alta Ordem:

Uso de flatMap e map na função de transferência

Operações em listas como sortBy e mkString no extrato