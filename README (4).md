<a name="readme-top"></a>
<br />
<div align="center">
  <a href="http://git.odontoprev.com.br/arquitetura/arquitetura-padroes/">
    <img src="https://odontoprevsite.com.br/site/wp-content/uploads/2020/11/odontoprev-logo.png" alt="Logo" width="150" height="80">
  </a>

<h3 align="center">cli-api-receber-imagens</h3>

  <p align="center">
    <br />
    <a href="http://git.odontoprev.com.br/clinico/APIs/cli-api-receber-imagens"><strong>Explore o projeto »</strong></a>
    <br />
    <br />
    <a href="http://git.odontoprev.com.br/clinico/APIs/cli-api-receber-imagens/-/issues">Reportar um Bug</a>
  </p>
</div>

## Sumário
* [Sobre o Projeto](#sobre-o-projeto)
* [Aplicação](#aplicação)
  * [Contrato da API](#contrato-da-api)
  * [Exemplos de End-Points](#exemplos-de-end-points)
* [Configurações](#configurações)
* [SonarQube & Badges](#sonarqube-e-badges)

## Sobre o projeto
API para recebimento das imagens enviadas pelo portal Rede UNNA

### Tecnologias Utilizadas

* [![Java11][Java11]][Java11]
* [![SpringBoot][SpringBoot]][SpringBoot]

## Aplicação

![Localhost]![AppPort]

### Contrato da API
#### Swagger UI (Local): {baseURL}/swagger-ui.html

#### Endpoint swagger.json: {baseURL}/v2/api-docs

### Exemplos de End-Points

 - {baseURL}/receberImagensPortal [POST]

---
---

Tipo: ``POST``

```
	POST  /receberImagensPortal
```

Endpoint utilizado para receber a imagens enviadas pelor Portal Rede Unna

<details>
  <summary>Request</summary>

```yaml
{
  "arquivo": "string",
  "ficha": "string",
  "gto": true,
  "nome_arquivo": "string"
}
```
</details>

<details>
  <summary>Response</summary>

```yaml
{
  "STATUS": 200
  "SUCESSO_IMAGEM_RECEBIDA"
}
```
Response headers
</details>

## Configurações

Caso queira rodar o projeto pela porta 8084 é necessário descomentar a  linha server.port=8084.

### Ambiente

Atualmente o projeto esta configurado para ser executado via Tomcat embarcado no SpringBoot.

## SonarQube e Badges

[![Quality gate](http://sonar.odontoprev.com.br/api/project_badges/quality_gate?project=br.com.odontoprev%3Areceber.imagens)](http://sonar.odontoprev.com.br/dashboard?id=br.com.odontoprev%3Areceber.imagens)

- [![Reliability Rating](http://sonar.odontoprev.com.br/api/project_badges/measure?project=br.com.odontoprev%3Areceber.imagens&metric=reliability_rating)](http://sonar.odontoprev.com.br/dashboard?id=br.com.odontoprev%3Areceber.imagens)

- [![Security Rating](http://sonar.odontoprev.com.br/api/project_badges/measure?project=br.com.odontoprev%3Areceber.imagens&metric=security_rating)](http://sonar.odontoprev.com.br/dashboard?id=br.com.odontoprev%3Areceber.imagens)

- [![Maintainability Rating](http://sonar.odontoprev.com.br/api/project_badges/measure?project=br.com.odontoprev%3Areceber.imagens&metric=sqale_rating)](http://sonar.odontoprev.com.br/dashboard?id=br.com.odontoprev%3Areceber.imagens)

- [![Bugs](http://sonar.odontoprev.com.br/api/project_badges/measure?project=br.com.odontoprev%3Areceber.imagens&metric=bugs)](http://sonar.odontoprev.com.br/dashboard?id=br.com.odontoprev%3Areceber.imagens)

- [![Coverage](http://sonar.odontoprev.com.br/api/project_badges/measure?project=br.com.odontoprev%3Areceber.imagens&metric=coverage)](http://sonar.odontoprev.com.br/dashboard?id=br.com.odontoprev%3Areceber.imagens)

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

[AppPort]: https://img.shields.io/badge/8084-blue?style=for-the-badge
[Localhost]: https://img.shields.io/badge/Localhost-orange?style=for-the-badge

[Swagger]: https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=white
[Swagger-url]: http://localhost:9088/portalempresa-cadastroOnline-pj/swagger-ui.html#
