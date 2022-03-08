Passo a passo para um bom TDD

1) Bom entendimento dos Requisitos
2) Fazer a classe ser compilada (Criar classes e métodos sem implementações mais "profundas")
3) Executar testes - Devem falhar
4) Criar implementações que cumpram os requisitos
5) Executar testes - Devem passar


RF #001
Como Gerente de Estoque
Eu gostaria de poder cadastrar Editoras
Para que eu possa disponibilizar seus livros em minha loja

RF #002
Como Gerente de Estoque
Eu gostaria de poder adicionar Livros em suas respectivas editoras
Para que eu possa manter um estoque organizado

RNF #001
A entidade Editora deve possuir as informações de
nome e endereço.
O nome deve armazenar até 120 caracteres.
Uma editora deve obrigatoriamente possuir um nome e endereço.