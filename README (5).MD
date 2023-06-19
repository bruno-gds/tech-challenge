<a name="readme-top"></a>
<br />
<div align="center">
  <a href="http://git.odontoprev.com.br/arquitetura/arquitetura-padroes/">
    <img src="https://odontoprevsite.com.br/site/wp-content/uploads/2020/11/odontoprev-logo.png" alt="Logo" width="150" height="80">
  </a>

<h3 align="center">cli-api-carteirinha-virtual</h3>

  <p align="center">
    <br />
    <a href="http://git.odontoprev.com.br/clinico/APIs/cli-api-carteirinha-virtual"><strong>Explore o projeto »</strong></a>
    <br />
    <br />
    <a href="http://git.odontoprev.com.br/clinico/APIs/cli-api-carteirinha-virtual/-/issues">Reportar um Bug</a>
  </p>
</div>

## Sumário
* [Sobre o Projeto](#sobre-o-projeto)
* [Banco de Dados](#banco-de-dados)
* [Aplicação](#aplicação)
  * [Contrato da API](#contrato-da-api)
  * [Exemplos de End-Points](#exemplos-de-end-points)
* [Configurações](#configurações)
* [SonarQube & Badges](#sonarqube-e-badges)

## Sobre o projeto
API responsável por gerar a carteirinha virtual dos beneficiários de todas as marcas. Obs.: esta API é a oficial, utilizada atualmente em produção.

### Tecnologias Utilizadas

* [![Java7][Java7]][Java7]
* [![Hibernate][Hibernate]][Hibernate]
* [![Oracle][Oracle]][Oracle]

## Banco de dados
[![Oracle][Oracle]][Oracle-url][![DbVersion]][Oracle-url]
<details>
  <summary>Tabelas Utilizadas</summary>
  <ul>
    <li><i>TBOD_ASSOCIADO_CONTRATO_PF</i></li>
    <li><i>TBOD_CONTATO_EMPRESA</i></li>
    <li><i>TBOD_CRITICA_MOV_BC_INCONSIST</i></li>
    <li><i>TBOD_LOG_IMPORTACAO</i></li>
    <li><i>TBOD_TXT_IMPORTACAO</i></li>
    <li><i>TBOD_TXT_IMPORTACAO TXT_IMPORTACAO</i></li>
    <li><i>TBOD_TXT_INFORM_RETORNO</i></li>

  </ul>
</details>

## Aplicação

![Localhost]![AppPort]

### Contrato da API
[Swagger UI 
](http://git.odontoprev.com.br/clinico/APIs/cli-api-carteirinha-virtual/-/blob/master/docs/swagger.json)

#### swagger.json: <font color="green">[diretorio_projeto]</font>\docs\swagger.json

### Exemplos de End-Points

 - <font color="orange">{baseURL}</font>/emitir/{codigoAssociado} [GET]
 - <font color="orange">{baseURL}</font>/emitir/{codigoAssociado}/{formato} [GET]
 - <font color="orange">{baseURL}</font>/emitir/{codigoAssociado}/{formato}/{comMoldura} [GET]
 - <font color="orange">{baseURL}</font>/emitir/{codigoAssociado}/{formato}/{comMoldura}/{idDesignCart}/{idLayoutCart} [GET]
 - <font color="orange">{baseURL}</font>/emitir/formato [POST]
 - <font color="orange">{baseURL}</font>/emitir/formatoComMoldura [POST]
 - <font color="orange">{baseURL}</font>/emitir/formatoComMolduraLayout [POST]
 - <font color="orange">{baseURL}</font>/emitir [POST]

---

## Configurações

Antes de rodar a api é necessário realizar o <font color="orange">build via maven</font> das seguintes dependências:

- [int-dcms-web-component-bom 
](http://git.odontoprev.com.br/internos/int-dcms-web-component-bom)

- [int-dcms-web-component-core 
](http://git.odontoprev.com.br/internos/int-dcms-web-component-core)

- [int-dcms-web-component-web 
](http://git.odontoprev.com.br/internos/int-dcms-web-component-web)


### Ambiente

Atualmente o projeto esta configurado para ser executado dentro do **RedHat JBOSS 6.1+**.
## SonarQube e Badges

[![Quality gate](http://172.18.10.66/api/project_badges/quality_gate?project=br.com.odontoprev.dcmsweb.carteirinhas.ws%3Adcmsweb-carteirinhas-ws)](http://172.18.10.66/dashboard?id=br.com.odontoprev.dcmsweb.carteirinhas.ws%3Adcmsweb-carteirinhas-ws)

- [![Reliability Rating](http://172.18.10.66/api/project_badges/measure?project=br.com.odontoprev.dcmsweb.carteirinhas.ws%3Adcmsweb-carteirinhas-ws&metric=reliability_rating)](http://172.18.10.66/dashboard?id=br.com.odontoprev.dcmsweb.carteirinhas.ws%3Adcmsweb-carteirinhas-ws)

- [![Security Rating](http://172.18.10.66/api/project_badges/measure?project=br.com.odontoprev.dcmsweb.carteirinhas.ws%3Adcmsweb-carteirinhas-ws&metric=security_rating)](http://172.18.10.66/dashboard?id=br.com.odontoprev.dcmsweb.carteirinhas.ws%3Adcmsweb-carteirinhas-ws)

- [![Maintainability Rating](http://172.18.10.66/api/project_badges/measure?project=br.com.odontoprev.dcmsweb.carteirinhas.ws%3Adcmsweb-carteirinhas-ws&metric=sqale_rating)](http://172.18.10.66/dashboard?id=br.com.odontoprev.dcmsweb.carteirinhas.ws%3Adcmsweb-carteirinhas-ws)

- [![Bugs](http://172.18.10.66/api/project_badges/measure?project=br.com.odontoprev.dcmsweb.carteirinhas.ws%3Adcmsweb-carteirinhas-ws&metric=bugs)](http://172.18.10.66/dashboard?id=br.com.odontoprev.dcmsweb.carteirinhas.ws%3Adcmsweb-carteirinhas-ws)

- [![Coverage](http://172.18.10.66/api/project_badges/measure?project=br.com.odontoprev.dcmsweb.carteirinhas.ws%3Adcmsweb-carteirinhas-ws&metric=coverage)](http://172.18.10.66/dashboard?id=br.com.odontoprev.dcmsweb.carteirinhas.ws%3Adcmsweb-carteirinhas-ws)

[⬆ Voltar ao topo](#)<br>

[forks-shield]: https://img.shields.io/github/forks/github_username/repo_name.svg?style=for-the-badge
[forks-url]: http://git.odontoprev.com.br/cadastro/CadFat/api-beneficiario2.0/network/members

[stars-shield]: https://img.shields.io/github/stars/github_username/repo_name.svg?style=for-the-badge
[stars-url]: http://git.odontoprev.com.br/cadastro/CadFat/api-beneficiario2.0/stargazers

[issues-shield]: https://img.shields.io/github/issues/github_username/repo_name.svg?style=for-the-badge
[issues-url]: http://git.odontoprev.com.br/clinico/APIs/cli-api-guiaReembolso/-/issues

[license-shield]: https://img.shields.io/github/license/github_username/repo_name.svg?style=for-the-badge
[license-url]: http://git.odontoprev.com.br/cadastro/CadFat/api-beneficiario2.0/blob/master/LICENSE.txt

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username

[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/

[jax-rs3]:  https://img.shields.io/badge/JAX--RS-3.0-red?style=for-the-badge&logo=buymeacoffee&logoColor=white
[jax-rs3-url]: https://jakarta.ee/specifications/restful-ws/3.0/

[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com 

[Java8]: https://img.shields.io/badge/Java-8-blue?style=for-the-badge&logo=buymeacoffee&logoColor=white
[Java8-url]: https://www.java.com/pt-BR/

[Java7]: https://img.shields.io/badge/Java-7-blue?style=for-the-badge&logo=buymeacoffee&logoColor=white
[Java7-url]: https://www.java.com/pt-BR/

[Java11]: https://img.shields.io/badge/Java-11-black?style=for-the-badge&logo=buymeacoffee&logoColor=white
[Java11-url]: https://www.java.com/pt-BR/

[SpringBoot]: https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white
[SpringBoot-url]: https://spring.io/

[Hibernate]: https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white
[SpringBoot-url]: https://hibernate.org

[Oracle]: https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white
[Oracle-url]: https://www.oracle.com/

[DbPort]: https://img.shields.io/badge/1332-blue?style=for-the-badge

[DbVersion]: https://img.shields.io/badge/v11.2-green?style=for-the-badge

[AppPort]: https://img.shields.io/badge/8080-blue?style=for-the-badge
[Localhost]: https://img.shields.io/badge/Localhost-orange?style=for-the-badge

[Swagger]: https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=white
[Swagger-url]: http://localhost:9088/portalempresa-cadastroOnline-pj/swagger-ui.html#
