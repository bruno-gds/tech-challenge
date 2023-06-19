<a name="readme-top"></a>
<br />
<div align="center">
  <a href="http://git.odontoprev.com.br/arquitetura/arquitetura-padroes/">
    <img src="https://odontoprevsite.com.br/site/wp-content/uploads/2020/11/odontoprev-logo.png" alt="Logo" width="150" height="80">
  </a>

<h3 align="center">cli-api-redeCredenciada</h3>

  <p align="center">
    <br />
    <a href="http://git.odontoprev.com.br/clinico/APIs/cli-api-redeCredenciada"><strong>Explore o projeto »</strong></a>
    <br />
    <br />
    <a href="http://git.odontoprev.com.br/clinico/APIs/cli-api-redeCredenciada/-/issues">Reportar um Bug</a>
    ·
  </p>
</div>

## Sumário
* [Sobre o Projeto](#sobre-o-projeto)
* [Banco de Dados](#banco-de-dados)
* [Aplicação](#aplicação)
  * [Contrato da API](#contrato-da-api)
  * [Exemplos de End-Points](#exemplos-de-end-points)
* [Configurações](#configurações)
* [Utilizado Por](#utilizado-por)
* [SonarQube & Badges](#sonarqube-e-badges)

## Sobre o projeto
API de rede credenciada 1.0 responsável pela busca de rede credenciada da Odontoprev.

### Tecnologias Utilizadas

* [![jax-rs3][jax-rs3]][jax-rs3]
* [![Java8][Java8]][Java8]
## Banco de dados
[![Oracle][Oracle]][Oracle-url][![DbVersion]][Oracle-url]
<details>
  <summary>Tabelas Utilizadas</summary>
  <ul>
    <li><i>TBOD_ASSOCIADO</i></li>
    <li><i>TBOD_CD_ESPECIALIDADE</i></li>
    <li><i>TBOD_CD_UNIDADE</i></li>
    <li><i>TBOD_EMPRESA</i></li>
    <li><i>TBOD_PARAMETROS_VALORES</i></li>
    <li><i>TBOD_PROCESSOS</i></li>
    <li><i>TBOD_PRODUTO_ANS</i></li>
    <li><i>TBOD_PRODUTO_ANS_STATUS</i></li>
    <li><i>TBOD_TIPO_ABRANGENCIA</i></li>
    <li><i>TBOD_TIPO_CONTRATACAO</i></li>
  </ul>
</details>


## Aplicação
![Localhost]![AppPortWeblogic]
![Localhost]![AppPort]

### Contrato da API
```
Swagger UI: {baseURL}/redecredenciada/
swagger.json: {baseURL}/redecredenciada/api/swagger.json
```
### Exemplos de End-Points

 - {baseURL}/redecredenciada/api/dentistas [GET]
 - {baseURL}/redecredenciada/api/dentistas/substitutos [GET]
 - {baseURL}/redecredenciada/api/produtos/produtoAnsPadrao [GET]
 - {baseURL}/redecredenciada/api/produtos [GET]

---

Tipo: ``GET``

```
	GET  /dentistas
```

Busca dentistas por filtro

<details>
  <summary>Request</summary>

```yaml
 {baseURL}/redecredenciada/api/dentistas?privian=false&codigoBeneficiario={string}&codigoMarca=1&pagina=0&tamanhoPagina=1&codigoEspecialidade=1&latitude={string}&longitude={string}
```
</details>

<details>
  <summary>Response</summary>

```yaml
{
  "totalRegistros": 0,
  "dataAtualizacao": "2022-10-20T20:55:06.189Z",
  "dtAssContrato": "string",
  "codigoDentista": "string",
  "nomeDentista": "string",
  "idFavorito": "string",
  "numeroCRO": "string",
  "numeroFone": "string",
  "email": "string",
  "tipoPrestador": "string",
  "tipoPessoa": "string",
  "visualiza": "string",
  "dataDescredenciamento": "string",
  "webSite": "string",
  "nomeFantasia": "string",
  "cnpj": "string",
  "idPagina": "string",
  "boaconsultaUrl": "string",
  "codigoQualificacao": 0,
  "substituto": true,
  "mestrado": true,
  "possuiTituloEspecialidade": true,
  "unidade": {
    "nome": "string",
    "codigoUnidade": "string",
    "horarioAtendimento": "string",
    "facilidade": "string",
    "idMapa": "string",
    "saldoAtualPontos": 0,
    "regiao": {
      "codigo": 0,
      "descricao": "string"
    },
    "totalPontos": 0,
    "valorTotalUnidade": 0,
    "valorTotalEventosUnidade": 0,
    "valorTotalEventosAssociadoUnidade": 0
  },
  "especialidade": {
    "codigoEspecialidade": 0,
    "descricaoEspecialidade": "string"
  },
  "endereco": {
    "logradouro": "string",
    "numeroLogradouro": "string",
    "siglaUF": "string",
    "cep": "string",
    "telefoneComercial": "string",
    "bairro": "string",
    "codigoBairro": 0,
    "fax": "string",
    "regiao": "string",
    "complemento": "string",
    "enderecoCompleto": "string",
    "cidade": {
      "codigo": 0,
      "nome": "string",
      "siglaUF": "string",
      "matriz": 0,
      "regiao": [
        {}
      ],
      "microCod": 0,
      "latitude": "string",
      "longitude": "string",
      "ufCod": 0
    },
    "pontoReferencia": "string",
    "telefone2": "string",
    "celular": "string",
    "distanciaKm": "string",
    "enderecoFomularioParteFinal": "string",
    "enderecoFomularioParteInicial": "string"
  }
}
```
</details>

Tipo: ``GET``

```
	GET  /dentistas/substitutos
```

Busca dentistas por filtro

<details>
  <summary>Request</summary>

```yaml
 {baseURL}/redecredenciada/api/dentistas/substitutos?codigoMarca={integer}&siglaUf={string}&codigoCidade={integer}
```
</details>

<details>
  <summary>Response</summary>

```yaml
{
  "totalRegistros": 0,
  "dataAtualizacao": "2022-10-20T20:55:06.189Z",
  "dtAssContrato": "string",
  "codigoDentista": "string",
  "nomeDentista": "string",
  "idFavorito": "string",
  "numeroCRO": "string",
  "numeroFone": "string",
  "email": "string",
  "tipoPrestador": "string",
  "tipoPessoa": "string",
  "visualiza": "string",
  "dataDescredenciamento": "string",
  "webSite": "string",
  "nomeFantasia": "string",
  "cnpj": "string",
  "idPagina": "string",
  "boaconsultaUrl": "string",
  "codigoQualificacao": 0,
  "substituto": true,
  "mestrado": true,
  "possuiTituloEspecialidade": true,
  "unidade": {
    "nome": "string",
    "codigoUnidade": "string",
    "horarioAtendimento": "string",
    "facilidade": "string",
    "idMapa": "string",
    "saldoAtualPontos": 0,
    "regiao": {
      "codigo": 0,
      "descricao": "string"
    },
    "totalPontos": 0,
    "valorTotalUnidade": 0,
    "valorTotalEventosUnidade": 0,
    "valorTotalEventosAssociadoUnidade": 0
  },
  "especialidade": {
    "codigoEspecialidade": 0,
    "descricaoEspecialidade": "string"
  },
  "endereco": {
    "logradouro": "string",
    "numeroLogradouro": "string",
    "siglaUF": "string",
    "cep": "string",
    "telefoneComercial": "string",
    "bairro": "string",
    "codigoBairro": 0,
    "fax": "string",
    "regiao": "string",
    "complemento": "string",
    "enderecoCompleto": "string",
    "cidade": {
      "codigo": 0,
      "nome": "string",
      "siglaUF": "string",
      "matriz": 0,
      "regiao": [
        {}
      ],
      "microCod": 0,
      "latitude": "string",
      "longitude": "string",
      "ufCod": 0
    },
    "pontoReferencia": "string",
    "telefone2": "string",
    "celular": "string",
    "distanciaKm": "string",
    "enderecoFomularioParteFinal": "string",
    "enderecoFomularioParteInicial": "string"
  }
}
```
</details>

Tipo: ``GET``

```
	POST  /produtos/produtoAnsPadrao
```

Busca a carteirinha padrao por marca

<details>
  <summary>Request</summary>

```yaml
 {baseURL}/redecredenciada/api/produtoAnsPadrao?codigoMarca={integer}
```
</details>

<details>
  <summary>Response</summary>

```yaml
{
  "cdProdutoAns": 0,
  "registroProdutoAns": "string",
  "nmProdutoAns": "string",
  "abrangenciaAns": {
    "cdAbrangeciaAns": 0,
    "dsAbrangeciaAns": "string"
  },
  "contratacaoAns": {
    "cdContratacaoAns": 0,
    "dsContratacaoAns": "string"
  },
  "statusAns": {
    "codigo": 0,
    "descricao": "string"
  },
  "cdAssociado": "string"
}
```
</details>

Tipo: ``GET``

```
	GET  /produtos
```
Busca produtos por filtro

<details>
  <summary>Request</summary>

```yaml
{baseURL}/redecredenciada/api/produtos?codigoDentista={string}&codigoProduto={integer}&codigoMarca={integer}
```
</details>

<details>
  <summary>Response</summary>

```yaml
{
  "cdProdutoAns": 0,
  "registroProdutoAns": "string",
  "nmProdutoAns": "string",
  "abrangenciaAns": {
    "cdAbrangeciaAns": 0,
    "dsAbrangeciaAns": "string"
  },
  "contratacaoAns": {
    "cdContratacaoAns": 0,
    "dsContratacaoAns": "string"
  },
  "statusAns": {
    "codigo": 0,
    "descricao": "string"
  },
  "cdAssociado": "string"
}
```
</details>

## Configurações
O projeto foi contruído para ser executado tanto no JBOSS quanto no Weblogic.
Para escolher o servidor que irá rodar, a variavel APP_SERVER, presente na classe BaseDAO.java, deve ser configurada.
A configuração padrão é WEBLOGIC.

É necessário se atentar a respectiva {baseURL} para cada server, a prncipal diferença reside na porta em que ele opera.

No Weblogic temos:
```
http://localhost:7001
```
Se a preferência for pelo JBOSS:
```
http://localhost:8080
```
---

## Utilizado por

O projeto é utilizado pelos seguintes sistemas:

- URA_NOVOS_SERVICOS
- PORTAL_BENEFICIARIO
- APPS_BENEFICIARIOS
- BIA-BRADESCO

## SonarQube e Badges

[![Quality Gate Status](http://sonar.odontoprev.com.br/api/project_badges/measure?project=br.com.odontoprev%3Aapi-redeCredenciada&metric=alert_status)](http://sonar.odontoprev.com.br/dashboard?id=br.com.odontoprev%3Aapi-redeCredenciada)

- [![Reliability Rating](http://sonar.odontoprev.com.br/api/project_badges/measure?project=br.com.odontoprev%3Aapi-redeCredenciada&metric=reliability_rating)](http://sonar.odontoprev.com.br/dashboard?id=br.com.odontoprev%3Aapi-redeCredenciada)
- [![Security Rating](http://sonar.odontoprev.com.br/api/project_badges/measure?project=br.com.odontoprev%3Aapi-redeCredenciada&metric=security_rating)](http://sonar.odontoprev.com.br/dashboard?id=br.com.odontoprev%3Aapi-redeCredenciada)
- [![Maintainability Rating](http://sonar.odontoprev.com.br/api/project_badges/measure?project=br.com.odontoprev%3Aapi-redeCredenciada&metric=sqale_rating)](http://sonar.odontoprev.com.br/dashboard?id=br.com.odontoprev%3Aapi-redeCredenciada)
- [![Bugs](http://sonar.odontoprev.com.br/api/project_badges/measure?project=br.com.odontoprev%3Aapi-redeCredenciada&metric=bugs)](http://sonar.odontoprev.com.br/dashboard?id=br.com.odontoprev%3Aapi-redeCredenciada)
- [![Coverage](http://sonar.odontoprev.com.br/api/project_badges/measure?project=br.com.odontoprev%3Aapi-redeCredenciada&metric=coverage)](http://sonar.odontoprev.com.br/dashboard?id=br.com.odontoprev%3Aapi-redeCredenciada)

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

[SpringBoot]: https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white
[SpringBoot-url]: https://spring.io/

[Hibernate]: https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white
[SpringBoot-url]: https://hibernate.org

[Oracle]: https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white
[Oracle-url]: https://www.oracle.com/

[DbPort]: https://img.shields.io/badge/1332-blue?style=for-the-badge

[DbVersion]: https://img.shields.io/badge/v11.2-green?style=for-the-badge

[AppPort]: https://img.shields.io/badge/JBOSS-8080-blue?style=for-the-badge
[AppPortWeblogic]: https://img.shields.io/badge/WEBLOGIC-7001-blue?style=for-the-badge
[Localhost]: https://img.shields.io/badge/Localhost-orange?style=for-the-badge

[Swagger]: https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=white
[Swagger-url]: http://localhost:9088/portalempresa-cadastroOnline-pj/swagger-ui.html#
