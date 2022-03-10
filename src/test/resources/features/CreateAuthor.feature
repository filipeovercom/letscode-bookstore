# language: pt
# coding: utf-8
# encoding: utf-8

#noinspection NonAsciiCharacters
Funcionalidade: Cadastro de autor

  Como usuário do sistema,
  Preciso cadastrar um autor informando nome e sobrenome
  Para facilitar o gerenciamento de autores.

  Delineação do Cenário: <descricaoCenario> - <resultadoEsperado>
    Dado que desejo cadastrar um autor com as seguintes informações:
      | <name> | <surname> |
    Quando executar a ação POST para o endpoint "/authors"
    Então o sistema deverá retornar o status "<resultadoEsperado>"
    E deverá apresentar "<errors>" erros

    Exemplos:
      | descricaoCenario                       | resultadoEsperado | errors | name   | surname   |
      | Cadastrar autor com sucesso            | 201               | 0      | Filipe | Damasceno |
      | Erro ao cadastrar sem nome             | 400               | 1      |        | Damasceno |
      | Erro ao cadastrar sem sobrenome        | 400               | 1      | Filipe |           |
      | Erro ao cadastrar sem nome e sobrenome | 400               | 2      |        |           |