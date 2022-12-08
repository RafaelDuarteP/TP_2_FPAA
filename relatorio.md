# Modelagens

## Problema 1

- Método Guloso:
    
    Primeiro devemos ordenar as rotas por sua distancia, da maior para menor e adicionamos sempre no caminhão que estiver percorrendo a menor distancia até não ter mais rotas para distribuir.

- Backtracking:
    
    descrição...

- Programação dinâmica:
  
    O primeiro passo é somar todas as distancias das rotas e dividir pelo número de caminhões disponíveis e colocar uma margem de 1%. Depois, enquanto houver rotas para distribuir cria-se uma tabela onde as linhas representam as rotas com suas distancias, as colunas são os valores de 0 até a média obtida no primeiro passo. Cada célula armazena qual é a maior distancia que pode ser percorrida em cada tamanho máximo de rotas. Depois de completar a tabela, faz-se o processo para descobrir quais as rotas que entraram na solução, adiciona essas rotas no caminhão que estiver vazio e remove da lista de rotas.

## Problema 2

- Divisão e conquista:
  
    descrição...