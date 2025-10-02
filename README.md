# Auth Service - Spring Boot + MySQL + Docker

Este projeto é uma aplicação **full stack** simples que implementa um sistema de cadastro e login de usuários.  
O front-end foi desenvolvido com HTML5 e CSS3, enquanto o back-end utiliza Java 21 com Spring Boot e um banco de dados MySQL rodando em container Docker.
A ideia de utilizar uma imagem do MySQL conteinerizada com Docker é que a aplicação seja rápida e simples de executar, sem a necessidade de instalar o MySQL diretamente na máquina.

## Tecnologias Utilizadas

- **Front-end**
  - HTML5
  - CSS3

- **Back-end**
  - Java 21
  - Spring Boot
  - Spring Data JPA

- **Banco de Dados**
  - MySQL (via Docker)

- **Outros**
  - Maven (gerenciamento de dependências)
  - Docker (containerização do banco)

---

## Funcionalidades

- Cadastro de novos usuários no banco de dados  
- Login de usuário com autenticação básica via cookies  

> Implementações futuras:
> - Criptografia de senhas (BCrypt)
> - Integração com Spring Security

---

## Estrutura do Projeto
```
├── src/
│   ├── main/
│   │   ├── java/com/leonardoteixeira/cadastroDeUsuarios/
│   │   │   ├── controller/       # Controllers responsáveis por rotas e lógica de autenticação
│   │   │   ├── repository/       # Repositório JPA para persistência de dados
│   │   │   └── service/          # Serviços (ex: manipulação de cookies e autenticação)
│   │   └── resources/
│   │       ├── static/           # Arquivos estáticos (CSS, JS, imagens)
│   │       ├── templates/        # Páginas HTML renderizadas pelo Thymeleaf
│   │       └── application.yml   # Configuração do Spring Boot (datasource, JPA, etc.)
│   └── test/                     # Testes unitários e de integração
├── docker-compose.yml            # Orquestração do container MySQL
├── pom.xml                       # Gerenciador de dependências Maven
└── README.md                     # Documentação do projeto
```

---

## Como Executar o Projeto localmente

### Requisitos

-Java 21

-Maven 3.9+

-Docker + Docker Compose

### Clone o repositório
```bash
git clone https://github.com/LeonardoTeixeiraa/auth-service-springboot.git
```
### Navegue até o diretório do projeto
```bash
cd auth-service-springboot
```
### Suba o banco MySql com Docker compose
```bash
docker compose up -d
```
### Execute a aplicação SpringBoot
```bash
./mvnw spring-boot:run
```
### No navegador, acesse o endereço
http://localhost:8080/login

## Desenvolvido por:
- [LeonardoTeixeiraa](https://github.com/LeonardoTeixeiraa)

