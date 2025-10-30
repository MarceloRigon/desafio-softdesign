# Teste técnico Softdesign 

Este projeto tem como objetivo automatizar os testes de uma API utilizando o framework **RestAssured** para testes de integração e **JUnit** para estrutura de testes. O projeto é organizado de forma a testar funcionalidades específicas de uma API.

## Estrutura do Projeto

O projeto é dividido naseguinte maneira:

- **src/test/java/org.test.api**: Contém os testes automatizados com o **JUnit**.
    - Nesta pasta constem os arquivos:
        - **ApiTestException**: Dados de configuração de exceção.
        - **AuthTest**: Script de teste de "criarTokenAutenticacao", "buscarStatusDaAplicacao".
        - **BaseTest**: Dados de configuração de URL Base da API.
        - **ProductTest**: Script de teste de "buscarProdutosComAutenticacao", "criarProduto", "buscarTodosOsProdutos", "buscarProdutoPorId".
        - **UserTest**: Script de teste "buscarUsuarios",

- **target**: Pasta gerada pelo Maven após a execução dos testes, contendo artefatos de compilação e relatórios de execução.
- **pom.xml**: Arquivo gerado automaticamente, onde configuramos as dependências, plugins, configurações de build e outros parâmetros necessários para construir e gerenciar o projeto
## Pré-Requisitos

Para rodar este projeto, você precisará de:

- **Java 8 ou superior**: Certifique-se de ter o **JDK 8** ou superior instalado.
- **Maven 3.6 ou superior**: Para gerenciar dependências e rodar os testes.
- **IDE de sua preferência**: Recomendado usar o IntelliJ IDEA ou Eclipse para facilitar a navegação no código e execução dos testes.

## Configuração do Projeto

**Instale as dependências**:

Use o Maven para instalar todas as dependências do projeto:
```bash
mvn install
```

**Caso tenha algum problema com as dependências, basta entrar no menu do Maven e efetuar um Reload dos arquivos.**

## Melhorias de arquitetura para um arojeto de testes escalável e de fácil manutenção

Atualmente, o projeto possui uma estrutura simples, com todos os testes localizados diretamente dentro de src/test/java/org.test.api, por se tratar de um projeto para conhecimento.
Para torná-lo mais escalável, modular e profissional, pode-se adotar uma estrutura em camadas e separação de responsabilidades, como a seguir:

```bash
 src
 └── test
      └── java
           └── org.test
                ├── base          → Classes base para configuração global e inicialização
                ├── config        → Configurações de ambiente e endpoints
                ├── model         → Classes modelo para requisições e respostas
                ├── services      → Implementações das chamadas de API 
                ├── utils         → Utilitários, geradores de dados e manipuladores de JSON
                ├── assertions    → Validações customizadas
                └── tests         → Classes de teste organizadas por funcionalidade
```
🔹 Benefícios dessa arquitetura

Escalabilidade: Facilita o crescimento do projeto com novos módulos e serviços.

Manutenibilidade: Centraliza configurações e facilita a correção de falhas sem impacto global.

Reutilização de código: Classes de serviço e utilitários podem ser usados por diversos testes.

Organização lógica: Torna o projeto mais legível e colaborativo, seguindo boas práticas de QA e Clean Code.
## Executando os Testes
Você pode rodar os testes utilizando o Maven ou diretamente pela IDE:

Usando o Maven:
Para rodar todos os testes de uma vez, execute:
```bash
mvn test
```
Isso executará os testes configurados no projeto e gerará um relatório de execução dentro da pasta target.

## Executando um Teste Específico:
Para rodar um teste específico, você pode usar o seguinte comando:

```bash
mvn -Dtest=NomeDaClasseDeTeste test
```
Exemplo para rodar o teste AuthTest:

```bash
mvn -Dtest=AuthTest test
```
## Bug Encontrado

Durante o teste de **"criarTokenAutenticacao"**, ao executar ele retorna o seguinte:

`org.test.api.ApiTestException: Erro ao criar token de autenticação: 1 expectation failed.
JSON path token doesn't match.
Expected: not null
  Actual: null`

Significa que a resposta da API não contém o campo "token". Ou seja, o login não deu certo — a API retornou algum erro (provavelmente 400 ou 401), e por isso o campo token é null.

Efetuado o mesmo teste via postman, o que retorna a mesma mensagem de retorno.

Por conta do problema de autenticação, consequentimente ocorre erro no teste "buscarProdutosComAutenticacao", por não conseguir autenticar.
## Logs
Implementado ao final de todos os scripts de test o metódo **log().all()**, para mostrar os dados de resultado do teste executado.

## Relatório
Foi implementado o plugin **Maven Surefire Report Plugin** para visualização dos resultados dos testes. Ao executar os testes o resultado fica armazenado na pasta:

```bash
target/surefire-reports
```
Terão os arquivos em XML dos testes que foram executados.

## Pipeline

Criado arquivo Jenkinsfile para executar os testes em ume esteira.