# demo-integration-api

![GitHub repo size](https://img.shields.io/github/repo-size/valfrido-dev/estante-critica-api?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/valfrido-dev/estante-critica-api?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/valfrido-dev/estante-critica-api?style=for-the-badge)
![Bitbucket open issues](https://img.shields.io/bitbucket/issues/valfrido-dev/estante-critica-api?style=for-the-badge)
![Bitbucket open pull requests](https://img.shields.io/bitbucket/pr-raw/valfrido-dev/estante-critica-api?style=for-the-badge)

Projeto API de integração de informações na pesquisa de CEP's. O projeto possui uma lista
de CEP's e uma lista de Municípios com algumas informações desses conteúdos.
Esta listas estão configurados como mocks simulando API's externas.
Os endpoints propõe buscar as informações dos CEP's e respectivos municípios
e retorná-las agrupadas. Por exemplo ao consultar um CEP no endpoint de consulta
`</api/ceps/find>` ele retorna além das informações do CEP, algumas informações
sobre o município ao qual pertence o CEP consultado, como população.

O projeto foi proposto como um teste para solução de integração de API.

## Skills
![Static Badge](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Static Badge](https://img.shields.io/badge/maven-2496ED?style=for-the-badge)
![Static Badge](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Static Badge](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)


## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

- É necessário `<Java / JDK21 / Docker>`
- Para `<Windows>` é necessário instalar o `<WSL>` para que seja instalado e executado o docker.

## 🚀 Instalando demo-integration-api

Para instalar o estante-critica-api, siga estas etapas:

- Criar um arqvuivo `<.env>`no diretório `</docker>` para definir as variáveis de ambiente:

```
APP_VERSION: <your-app-version>
APP_CONSUMER_KEY: <your-secret-app-key>
APP_CONSUMER_OWNER: <your-client-consumer>
APP_CONSUMER_LIMIT: <your-limit-request>

```
- Executar os comandos abaixo no diretório `<docker>`

```
<docker compose build>
```
Após sucesso do comando anterior executar:
```
<docker compose up>
```

## ☕ Usando demo-integration-api

Utilizar uma ferramenta de testes de API para interagir com o projeto, como o `<postman>`.

- O acesso aos endpoints requer autorização via `<APP-KEY>`.
- Ao executar a aplicação pela primeira vez ele gera o cadastro em memória
do `<APP-KEY>` que é configurado através das variáveis de ambiente `APP_CONSUMER...`.
- O valor da variável `APP_CONSUMER_KEY` adicionado ao arqivo `<.env>` deve ser
utilizada para passar no parâmetro `<APP-KEY>` via `<HEADER>` da requisição.
- O projeto expõe os endpoints `</api/ceps/list>` e `</api/ceps/find?cep=123456>`.
