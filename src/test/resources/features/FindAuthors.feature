# language: pt
# coding: utf-8
# encoding: utf-8

#noinspection NonAsciiCharacters
Funcionalidade: Busca de Autores de Livros

  Como usuário do sistema,
  Preciso buscar os autores cadastrados no sistema
  Para facilitar o gerenciamento de autores

  Cenário: Deve buscar todos os autores cadastrados
    Dado que eu solicite os autores cadastrados
    Quando executar a ação GET para o endpoint "/authors"
    Então deverá retornar os autores cadastros no sistema
    E o status da resposta deve ser "200"