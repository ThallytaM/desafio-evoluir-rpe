# **Desafio - RPE TECH**



## Descrição

Sistema desenvolvido para o Desafio técnico Dev Java do programa de estágio EVOLUIR da RPE TECH.

Esta aplicação permite a manutenção do cadastro de pessoas (Funcionários e clientes) de uma empresa, contendo dados básicos, como: nome, telefone, endereço etc. 

[**Descrição completa do desafio!](https://gitlab.com/rangeldiego/desafio-estagiario-1)

## Funcionalidades

A API disponibiliza para o usuário as funcionalidades de criação, atualização, consulta e exclusão dos cadastros de Funcionários e clientes da empresa. 

## Estrutura do projeto

O projeto está estruturado em 3 camadas, sendo elas: 

* **Presentation:** Controller e DTO

* **Business:** Services 

* **Model:** Entities e Repositories

  

*Foi utilizado o Padrão DTO (Data Transfer Object), responsável por fazer o transporte dos dados.* 
*Para conversão das entidades em DTO foi utilizado o Model Mapper, que através do método map() faz essa conversão.* 

*Nos controllers estão os endpoints, responsáveis por liberar e receber as requisições HTTP da API.*
*Nos services estão as regras de negócio e nos repositories é feita toda a comunicação com o banco de dados e também estão disponíveis os métodos prontos do JpaRepository.*


## Tecnologias utilizadas

* Java 17;
* Maven;
* Spring Boot;
* Spring Data;
* PostgreSQL;
* Swagger;
* JUnit;

## Execução do projeto

Para executar o projeto siga as instruções a seguir: 

No git Bash, clone o repositório com o comando:

```
git clone https://github.com/ThallytaM/desafio-evoluir-rpe.git
```

Em seguida, abra o projeto em uma IDE (utilizei o [Spring Tool Suite](https://spring.io/tools) ) e aguarde o Maven baixar as dependências necessárias para execução do projeto.

Faça a alteração das variáveis de ambiente no arquivo application.properties, configurando o local, o nome de usuário e a senha do banco dados (utilizei PostgreSQL).

Após executar o projeto, basta acessar o seguinte endereço para visualizar e utilizar os endpoints da aplicação:

```
http://localhost:8080/swagger-ui.html#/
```

