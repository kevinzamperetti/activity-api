# Projeto activity-api

## Visão Geral
Este projeto utiliza Spring Boot como backend e SQLite como banco de dados. 
O banco de dados é carregado apenas uma vez e mantém os dados persistidos até que o endpoint `/api/v1/admin/reset-database` seja chamado, momento em que os dados serão reinicializados ao estado inicial.

Por se tratar de uma API criada para testes de API, ela possui alguns bugs, para que seja possível exercitar o conhecimento. :P

## Requisitos
Antes de executar o projeto, certifique-se de ter os seguintes itens instalados:

- [JDK 17+](https://adoptium.net/temurin/releases/?version=17) se não possuir, pode baixar e instalar o java 17 através deste link.

## Como Executar
1. Acessar a pasta onde está o JAR que lhe foi enviado atrvés do terminal/cmd:

2. Iniciar a API, executando o seguinte comando:

```sh
java -jar activity-api-0.0.1-SNAPSHOT.jar
```

Se iniciada com sucesso, será exibida no terminal a seguinte mensage: `Activity-api running!`

3. Conferir se a API está em funcionamento. Acessar a documentação da API através do Swagger: 

`http://localhost:8092/swagger-ui/index.html#/`

4. Para para a API, basta fazer `CTRL + C` no terminal. 

## Nota:
Sempre que desejar iniciar a API, basta fazer o passo 2.

## Banco de Dados
- O banco de dados utilizado é o **SQLite**.
- O banco é carregado apenas a primeira vez que inicia a API e os dados permanecem na base de dados enquanto a aplicação estiver rodando.
- Para resetar os dados e restaurar o estado inicial da API, utilize o endpoint:

```http
POST http://localhost:8092/api/v1/admin/reset-database
```

## Contato
Para dúvidas, problemas ou donativos :). Entre em contato com Kevin Zamperetti Schepke através do LinkedIn "https://www.linkedin.com/in/kevin-zamperetti-schepke/" ou se preferir abra uma issue no repositório do git https://github.com/kevinzamperetti/activity-api.

