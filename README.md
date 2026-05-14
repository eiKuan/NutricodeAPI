# NutricodeAPI

API desenvolvida em Java com Spring Boot para o projeto Nutricode.

## 📌 Sobre o projeto

A NutricodeAPI é responsável por fornecer dados e regras de negócio para o sistema Nutricode, envolvendo funcionalidades de nutrição, treinos e acompanhamento de usuários.

A aplicação integra fontes externas de dados para enriquecer o sistema, incluindo exercícios físicos e informações nutricionais.

---

## ⚙️ Tecnologias utilizadas

* Java
* Spring Boot
* Spring Security
* JPA / Hibernate
* PostgreSQL
* Docker

---

## 📦 Integrações e dados

* **ExercisesDB (traduzido)**
  Base de dados de exercícios físicos com tradução para português.

* **TACO (Tabela Brasileira de Composição de Alimentos)**
  Fonte de dados nutricionais utilizada para informações de alimentos.

### 🚨 Imports - Dados
A nível de código, para utilizar os mesmos dados de alimentos e exercícios é necessário ativar os imports.
* Em infra/dataloader contém a ativação do import dos exercícios
* Em resources/backup_alimentos.sql há o import dos alimentos em Sql

---

## 🐳 Executando com Docker

### Pré-requisitos

* Docker
* Docker Compose

### Passos

```bash
git clone <URL_DO_REPOSITORIO>
cd NutricodeAPI

cp compose-example.yaml compose.yaml
cp .env.example .env

docker-compose up -d
```

---

## 🚀 Executando sem Docker

### Pré-requisitos

* Java 25
* Maven

### Passos

```bash
./mvnw spring-boot:run
```

---

## 🔐 Configuração

A aplicação utiliza variáveis de ambiente para:

* Banco de dados
* JWT Secret
* URL base

---

## 📁 Estrutura do projeto

```bash
src/main/java/com/tg/nutricode/
 ├── controller    # Endpoints da API
 ├── dto           # Objetos de transferência de dados
 ├── infra         # Configurações e segurança
 ├── model         # Entidades do sistema
 ├── repository    # Acesso ao banco de dados
 ├── service       # Regras de negócio
 └── NutricodeApplication.java

src/main/resources/
 ├── static
 ├── templates
 ├── application-example.properties
 └── application.properties (não versionado)
```

---

## 📃 Documentação dos Endpoints
O projeto API Nutricode utiliza Swagger para uma documentação simplificada dos endspoints.            
**Após executar o código**, visualizável em: localhost:8080/swagger-ui/index.html#/

---
## 📄 Licença

Projeto de uso acadêmico desenvolvido para o sistema Nutricode.
