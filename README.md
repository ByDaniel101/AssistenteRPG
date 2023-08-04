# AssistenteRPG

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

Este projeto foi criado para auxiliar uma seção de RPG, armazenando infromações das fichas, relacionamentos e detalhes da crônica.
Para uso completo, será necessario um front para uma melhor experiencia de usuário, o que será feita em outro projeto.

## Conteúdos
- Instalação
- Configuração
- Uso
- API Endpoints
- Autenticação
- Database

## Instalação

1. Clonar o repositório
2. Instalar as dependencias com o Maven
3. Instalar o Postgres (https://www.postgresql.org/)

## Configuração
No application.properties estão as configurações da base de dados como usuário e senha de acesso ao Postgres.
As configurações devem ser alteradas de acordo com o seu usuario e senha no Postgres, porta de acesso e nome da base de dados.

## API Endpoints
Esta API fornece os seguintes Endpoints:

```markdown
GET /cronica - Retorna todas as cronicas (Acesso de ADMIN).

GET /cronica/{id} - Retorna a cronica do id em questão (Acesso de ADMIN).

GET /cronica/byname/{nome} - Retorna a cronica com o nome em questão (Acesso de ADMIN).

POST /auth/login - Login na aplicação

POST /auth/register - Registrar um novo usuário com nivel de acesso USER.
```

## Autenticação
Esta API utiliza o Spring Security para altenticação, os seguintes niveis de acesso estão disponiveis:

```
USER -> Padrão para uso da API.
ADMIN -> Acesso de gerenciamento dos recursos das cronicas e recursos.
```

Para acessar os endpoints de nível ADMIN sera necessario prover o token adequado pelo header da requisição.

## Database
Este projeto utiliza o Postgres como base de dados.

## Contribuições
Este projeto é uma ideia que eu tenho a algum tempo e gostaria de trabalhar nela para uso proprio e de outros jogadores e narradores de RPG,
contribuições são muito bem vindas, e principalmente o feedback de consumo dos endpoits em cenários reais de uso.

