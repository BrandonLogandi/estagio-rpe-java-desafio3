# Estágio RPE - Java - Desafio 3

Este repositório contém a solução do desafio 3 da seleção de estagiários da RPE para Backend em Java. O projeto tem como objetivo disponibilizar uma API para o cadastro de veículos de diferentes portes para uma empresa. Os dados dos veículos são mantidos em um banco de dados relacional.
A descrição completa do projeto pode ser encontrada [aqui.](https://gitlab.com/rangeldiego/desafio-estagiario-3/-/blob/main/README.md)

## Tecnologias utilizadas

- Java 17
- Maven
- Spring Boot
- Spring Web
- OpenAPI/Swagger
- PostgreSQL
- MeanBean
- JUnit

## Estrutura do projeto

Foi utilizado o padrão MVC para a separação das camadas de apresentação, modelo e dados juntamente com recursos do Spring Framework para facilitar a implementação das mesmas. Como os diferentes tipos de veículos possuem atributos em comum, também foi utilizada uma classe mãe para manter esses atributos juntamente com a configuração necessária dos repositórios de acesso ao banco de dados para trabalhar com as classes filhas.

## Rodando o projeto

Clone o repositório usando Git

```bash
git clone https://github.com/BrandonLogandi/estagio-rpe-java-desafio3.git
```

O projeto depende de algumas variáveis de ambiente que configuram a conexão com o banco de dados. São elas:

- **DB_URL** = HOST:PORT/DB_NAME (ex.: localhost:5432/mydb)
- **DB_USERNAME** = Nome do usuário do banco (ex.: postgres)
- **DB_PASSWORD** = Senha de acesso ao banco

Você deve configurar essas variáveis de ambiente em seu editor para rodar o projeto. No VSCode, você pode criar um arquivo `.vscode/launch.json` no projeto e colar a seguinte configuração:

```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "Launch Desafio3Application",
            "request": "launch",
            "mainClass": "rpe.estagio.desafio3.Desafio3Application",
            "projectName": "desafio3",
            "env": {
                "DB_URL": "HOST:PORT/DB_NAME",
                "DB_USERNAME": "DB_USERNAME",
                "DB_PASSWORD": "DB_PASSWORD"
            }
        }
    ]
}
```

Se preferir, você pode exportar um `.jar` rodando o comando `mvn package` na raiz do projeto e rodar o arquivo com o seguinte comando:

WINDOWS:

```batch
${env:DB_URL}='host:port/db_name'; ${env:DB_USERNAME}='db_username'; ${env:DB_PASSWORD}='db_password'; & java -jar .\target\desafio3-0.0.1-SNAPSHOT.jar
```

LINUX:

```batch
/usr/bin/env/ DB_URL=host:port/db_name DB_USERNAME=db_username DB_PASSWORD=db_password java -jar ./target/desafio3-0.0.1-SNAPSHOT.jar
```

Após inicializar o projeto, você pode visitar a página `http://localhost:8080/swagger-ui/index.html` para visualizar a página do Swagger e interagir com os endpoints da aplicação.
