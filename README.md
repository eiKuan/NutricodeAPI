# NutricodeAPI

API desenvolvida em Java com Spring Boot para o projeto Nutricode.

## 📌 Sobre o projeto

A NutricodeAPI é responsável por fornecer os dados e regras de negócio para o sistema Nutricode, que envolve funcionalidades relacionadas a nutrição, treinos e acompanhamento de usuários.

A API integra diferentes fontes de dados para enriquecer a experiência do usuário, incluindo exercícios físicos e informações nutricionais.

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

O projeto utiliza:

* **ExercisesDB (traduzido)**
  Base de dados de exercícios físicos com tradução para português.

* **TACO (Tabela Brasileira de Composição de Alimentos)**
  Fonte de dados nutricionais de alimentos amplamente utilizada no Brasil.

---

## 🐳 Executando com Docker

### Pré-requisitos

* Docker
* Docker Compose

### Passos

1. Clone o repositório:

```bash
git clone <URL_DO_REPOSITORIO>
cd NutricodeAPI
```

2. Crie os arquivos necessários:

```bash
cp compose-example.yaml compose.yaml
cp .env.example .env
```

3. Configure o arquivo `.env` com suas credenciais:

```env
DB_USER=seu_usuario
DB_PASS=sua_senha
JWT_SECRET=sua_chave_secreta
BASE_URL=http://localhost:8080
```

4. Suba os containers:

```bash
docker-compose up -d
```

---

## 🚀 Executando sem Docker

### Pré-requisitos

* Java 17+
* Maven

### Passos

1. Configure as variáveis de ambiente ou o `application.properties`

2. Execute o projeto:

```bash
./mvnw spring-boot:run
```

---

## 🔐 Configuração

A aplicação utiliza variáveis de ambiente para dados sensíveis, como:

* Credenciais do banco de dados
* JWT Secret
* URL base da aplicação

---

## 📁 Estrutura do projeto

```bash
src/
 ├── controller
 ├── service
 ├── repository
 ├── domain
```

---

## 📄 Licença

Este projeto é de uso acadêmico e faz parte do desenvolvimento do sistema Nutricode.
