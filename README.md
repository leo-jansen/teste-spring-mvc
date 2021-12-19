# Projeto Utilizando spring-mvc :computer:

Projeto MVC de um sistema de pedidos utilzando tecnologias do mundo java para estudo pessoal.


## Tecnologias :toolbox:

Tecnologias utilizadas nesse projeto:
* [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
* [Spring Security](https://spring.io/projects/spring-security#overview)
* [Thymeleaf](https://www.thymeleaf.org/)  
* [PostgreSQL](https://www.postgresql.org/download/)
* [Maven](https://maven.apache.org/download.cgi)

## Instalação :hammer_and_wrench:

Clone o repositório do projeto 
```bash 
  git clone https://github.com/leo-jansen/teste-spring-mvc.git
  cd teste-spring-mvc
```
Altera as variáveis do banco de dados no arquivo ```application.properties``` no diretorio ``src/main/resources/``, depois instale as dependências do projeto
```bash 
  mvn install
```
Crie no banco de dados as seguintes tabelas:
```
  create table users(
    username varchar(50) not null primary key,
    password varchar(200) not null,
    enabled boolean not null
  );

  create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
  );
  create unique index ix_auth_username on authorities (username,authority);
```
Gere o jar do projeto:
```bash 
  mvn clean package
```
Execute a aplicação:
```bash 
  java -jar target/teste-spring-mvc-0.0.1-SNAPSHOT.jar
```
Por fim acesse a aplicação no endereço `https://localhost:8080/`


## License :balance_scale:

[MIT](https://choosealicense.com/licenses/mit/)