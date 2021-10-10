# Desafio-Java-Supera
Desafio em Java: construir uma camada de serviço de um pseudo ecommerce de games mobile.


<h2> Model Viem </h2>
<img src="https://photos-1630117967399.s3.sa-east-1.amazonaws.com/Model+View+New.png"/>

# Requisitos para rodar a aplicação
<ul>
  <li>Java 11</li>
</ul>

# Rodando a aplicação
A aplicação possui 3 profiles: test, dev, prod. A versão final presente neste repositório está no perfil de test.

<ul>
  <li>Para compilar o projeto use: </li>

``` 
./mvnw compile
  
```  


  <li>Para empacotar o projeto use: </li>

```
./mvnw package
  
```  


  <li>Para executar o projeto use: </li>

```
java -jar target/Desafio-Java-Supera-0.0.1-SNAPSHOT.jar
  
```  

  <li>Para executar os testes use: </li>

```
./mvnw clean test
  
```  
</ul>

# Endpoint
Foi disponibilizado 2 arquivos da API Postman, onde possui todos os endpoints do projeto. Lembrando que um arquivo está configurado 
para o profile de test da aplicação e o outro arquivo está configurado para a nuvem do Heroku(onde foi feito o deploy da aplicação).
Caso não tenha o Postman instalado, os principais endpoints são: 
<ul>
  <li> Perfil de Test: </li>
  <br>
  Checkout(frete, subtotal e total).
  <a href="http://localhost:8080/checkout">localhost:8080/checkout</a>
  <br>
  Adicionar produtos.
  <a href="http://localhost:8080/cart/1/addProduct/4?qtd=2">localhost:8080/cart/1/addProduct/4?qtd=2</a>
  <br>
  Remover produtos.
  <a href="http://localhost:8080/cart/1/removeProduct/1?qtd=2">localhost:8080/cart/1/removeProduct/1?qtd=2</a>
  <br>
  Ordenar produtos por preço.
  <a href="http://localhost:8080/products/order-by-price?page=0">localhost:8080/products/order-by-price?page=0</a>
  <br>
  Ordenar produtos por score.
  <a href="http://localhost:8080/products/order-by-score?page=0">localhost:8080/products/order-by-score?page=0</a>
  <br>
  Ordenar produtos por nome.
  <a href="http://localhost:8080/products/order-by-name?page=0">localhost:8080/products/order-by-name?page=0</a>
  <br>
  <br>
  <li> Perfil de Prod(heroku): </li>
  <br>
  Checkout(frete, subtotal e total).
  <a href="https://games-mobile.herokuapp.com/checkout">games-mobile.herokuapp.com/checkout</a>
  <br>
  Adicionar produtos.
  <a href="https://games-mobile.herokuapp.com/cart/1/addProduct/4?qtd=2">games-mobile.herokuapp.com/cart/1/addProduct/4?qtd=2</a>
  <br>
  Remover produtos.
  <a href="https://games-mobile.herokuapp.com/cart/1/removeProduct/1?qtd=2">games-mobile.herokuapp.com/cart/1/removeProduct/1?qtd=2</a>
  <br>
  Ordenar produtos por preço.
  <a href="https://games-mobile.herokuapp.com/products/order-by-price?page=0">games-mobile.herokuapp.com/products/order-by-price?page=0</a>
  <br>
  Ordenar produtos por score.
  <a href="https://games-mobile.herokuapp.com/products/order-by-score?page=0">games-mobile.herokuapp.com/products/order-by-score?page=0</a>
  <br>
  Ordenar produtos por nome.
  <a href="https://games-mobile.herokuapp.com/products/order-by-name?page=0">games-mobile.herokuapp.com/products/order-by-name?page=0</a>

</ul>
