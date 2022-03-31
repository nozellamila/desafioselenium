# Sobre o projeto - Desafio Automação - Selenium Webdriver
### Este é um projeto de automação de testes que visa atender aos requisitos do desafio da Base2 de automação web com Selenium. Os testes foram feitos no gerenciador de bugs, Mantis, utilizando a linguagem Java.

# Tabela de conteúdos
<!--ts-->
   * [Sobre o projeto](#sobre-o-projeto---desafio-automação---apis-rest)
   * [Tabela de conteúdos](#tabela-de-conteúdos)
   * [Objeto de teste](#objeto-de-teste)
   * [Requisitos realizados](#requisitos-realizados)
      * [Suíte de testes](#suíte-de-testes)
      * [Data-Driven testing](#data-driven-testing)
      * [Utilização de REGEX](#utilização-de-regex)
      * [Relatório de testes](#relatório-de-testes)
        * [Visualização do relatório de testes localmente](#visualização-do-relatório-de-testes-localmente)
        * [Visualização do relatório na ferramenta de CI](#visualização-do-relatório-na-ferramenta-de-ci)
      * [Gerenciamento de ambientes](#gerenciamento-de-ambientes)
      * [Gerenciamento de massa de dados](#gerenciamento-de-massa-de-dados)
      * [Execução paralela dos testes](#execução-paralela-dos-testes)
      * [Integração Contínua](#integração-contínua)
   * [Lista de tecnologias utilizadas](#lista-de-tecnologias-utilizadas)
<!--te-->

# Objeto de teste
O sistema sob teste deste projeto é o [Mantis](https://www.mantisbt.org/). Trata-se de um sistema de gerenciamento de bugs e, para construção deste projeto, ele foi instalado localmente e executado utilizando o [WampServer](https://www.wampserver.com/en/). Os testes foram divididos em três partes principais, são elas o gerenciamento de issues, gerenciamento do sistema (como parâmetros e perfis) e gerenciamento dos usuários.

# Requisitos realizados

## Suíte de testes
Foram construídos 50 testes, separados por issues, management e account/login.

![image](https://user-images.githubusercontent.com/53572999/161057523-d47cac64-76b7-44b1-a792-f901eb4a2ceb.png)

## Data-Driven testing
Para testes de parâmetros inválidosfoi utilizada a abordagem de Data-Driven Testing, consumindo dados de planilhas. 

![image](https://user-images.githubusercontent.com/53572999/161057718-71e50433-e632-499a-a540-69b700bfdf77.png)

![image](https://user-images.githubusercontent.com/53572999/161057786-64d4f5a3-a82f-4099-a778-8145419d24e0.png)


## Selenium Grid
O Selenium Grid foi instalado localmente e executado durante a execução dos testes

![image](https://user-images.githubusercontent.com/53572999/161058298-10fa3b32-1075-410d-b209-1cd247f3279d.png)

Existe o browser padrão, no print acima é o chrome, mas há configuração para utilizar três navegadores diferentes

![image](https://user-images.githubusercontent.com/53572999/161058499-b3154be0-f267-4421-9862-221aaece12ff.png)

## Gravar screenshots
Os screenshots são tirados junto aos métodos dos testes e nomeado conforme os mesmos, desta forma, o nome dos prints correspondem ao passo que está sendo executado

![image](https://user-images.githubusercontent.com/53572999/161059105-d00a8e19-311a-434f-b7de-b532d8c34bd2.png)

## Relatório de testes

### Visualização do relatório de testes localmente
Para rodar os testes com maven, basta clonar o projeto na máquina, acessar a raiz do projeto e executar o comando 'mvn test'. Para visualizar o relatório com Allure Reports localmente é preciso tê-lo instalado e configurado previamente.

A [documentação](https://docs.qameta.io/allure/#_installing_a_commandline) sugere utilizar o [Scoop](http://scoop.sh/) para facilitar a instalação e configuração no ambiente Windows.

Com o Allure commandline configurado, basta escrever o comando 'allure serve /home/path/to/project/target/allure-results/' no cmd, este comando irá iniciar um servidor e mostrará o resultado da execução dos testes realizados pelo comando 'mvn test'. O caminho mostrado (/home/path/to/project/target/allure-results/) é o diretório raiz do projeto + target\allure-results.

### Visualização do relatório na ferramenta de CI
Os testes são executados sempre que um novo commit é feito. A configuração da pipeline foi feita utilizando o Jenkins e com o plugin do Allure Reports é possível visualizar o relatório gerado sempre que o pipeline é rodado

![image](https://user-images.githubusercontent.com/53572999/161059409-5e411ae9-cf10-4ec6-9333-984bdf096c72.png)

## Gerenciamento de massa de dados
A estratégia de gerenciamento de massa de dados escolhida foi carregar nova massa a cada execução do teste e, logo após, excluí-la. Como mostrado abaixo

![image](https://user-images.githubusercontent.com/53572999/161062131-debbd696-1f85-41ae-92c3-9a060c9151b4.png)

## Executar comandos com javascript
O javascript foi utilizado para realizar ações nos testes, como mostrado abaixo

![image](https://user-images.githubusercontent.com/53572999/161062647-52c3c54a-1968-40ab-8b40-9363c72b2b2a.png)

![image](https://user-images.githubusercontent.com/53572999/161062835-f1deb2dd-6319-49f8-a580-848d49624934.png)

## Integração Contínua 
A integração contínua foi feita com o Jenkins. A cada commit o pipeline será rodado e será disponibilizando o resultado em um relatório através do Allure Report.

![image](https://user-images.githubusercontent.com/53572999/161063105-c2628dff-7dec-4b8f-9d9f-9c40ed81b04f.png)

# Lista de tecnologias utilizadas
- Java
- Maven
- Maven Surefire Plugin
- Junit
- Selenium Grid
- OpenCsv
- Allure Reports
 
