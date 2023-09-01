<a name="readme-top"></a>
# Tech Challenge

Na primeira fase do desafio técnico, desenvolvemos as APIs iniciais com foco na integridade dos dados. 
São três APIs principais: Pessoa, Endereço e Eletrodoméstico. O objetivo dessas APIs é gerenciar as informações pertinentes a cada uma delas, que serão cadastradas em nosso sistema.


## Sumário
* [Instruções](#instruções)
* [API Usuário](#api-usuário)
* [API Endereço](#api-endereço)
* [API Eletrodoméstico](#api-eletrodoméstico)
* [Tecnologias](#tecnologias)
* [Desafios](#desafios)


## Instruções

- Maven: Para build do projeto. **Para buildar:** mvn clean install
- Docker: Subindo DB. **Para iniciar o Bando de Dados:**
```
- Acesse o diretório 'docker' do projeto
- Crie o diretório 'db-data' para armazenar os seus dados do DB
- Após estes passos, execute: 'docker-compose up -d'
```
- Foi utilizado Lombok e Validation, portanto é necessário adicionar os plugins na IDE

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

<a name="funcionalidades-do-projeto"></a>
## 🔨  Funcionalidades do projeto

### API Usuário

>[ Base URL: http://localhost:8080 ]


A API Usuario tem como objetivo permitir o registro e gerenciamento das informações dos usuários cadastrados.
Além do cadastro principal, o usuário tem a opção de incluir outras pessoas relacionadas a ele, informando o grau de parentesco.
É importante ressaltar que o cadastro de pessoas relacionadas (parentes) ao usuário não é obrigatório.

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``

```
	/usuarios
```

**Body** raw (json)

```
{
    "nome": "string",
    "cpf": "string",
    "dataNascimento": "string",
    "genero": "string"
}
```


<details>
  <summary>Exemplo Request Body:</summary>


```
curl --location 'http://localhost:8080/usuarios' \
--header 'Content-Type: application/json' \
--data '{
    "nome": "Pedro Gonçalves Nunes",
    "cpf": "041.276.747-33",
    "dataNascimento": "1990-10-02",
    "genero": "MASCULINO"
}'
```
</details>



<details>
  <summary>Responses:</summary>

201 - _Created_
- Será retornado o id do registro criado

```
1
```

400 - _Bad Request_

```
{
  "code": "tc.argumentNotValid",
  "message": "birthDate:deve ser uma data passada;"
}
```

422 - _Unprocessable Entity_
- Caso o CPF já esteja cadastrado

```
{
	"code": "tc.person.CpfAlreadyRegistered",
	"message": "CPF já cadastrado."
}
```

500 - _Internal Server Error_

```
{
	"code": "tc.person.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>

### ``GET``

```
	/usuarios/{CPF}
```

<details>
  <summary>Exemplo Request:</summary>


```
curl --location --request GET 'http://localhost:8080/usuarios/041.276.747-33' \
--header 'Content-Type: application/json'
```
</details>



<details>
  <summary>Responses:</summary>

200 - _OK_
- Será retornado o usuário

```
{
    "id": 2,
    "nome": "Pedro Gonçalves Nunes",
    "cpf": "04127674733",
    "dataNascimento": "1990-10-02",
    "genero": "MASCULINO",
    "parentes": null
}
```

404 - _Not Found_

```
{
    "code": "tc.usuario.usuarioNaoEncontrado",
    "message": "Usuario não encontrado."
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------
### API Endereço

>[ Base URL: http://localhost:8080 ]


A API Endereço tem como objetivo facilitar o gerenciamento de informações relacionadas aos endereços cadastrados pelos usuários. 
Para garantir a qualidade dos registros, é indispensável que sejam fornecidos obrigatoriamente os seguintes dados: rua, número, bairro, cidade e estado. 
Com a API de Endereço, torna-se mais fácil e eficiente gerenciar e manter atualizadas as informações essenciais para uma correta identificação e localização dos endereços.

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>


### ``POST``

```
	/enderecos
```

**Body** raw (json)

```
{
    "rua": "string",
    "numero": "string",
    "bairro": "string",
    "cidade": "string",
    "estado": "string",
    "cep": "string",
    "usuario": {
        "id": Long
    }
}
```

<details>
  <summary>Exemplo Request Body:</summary>


```
curl --location 'http://localhost:8080/enderecos' \
--header 'Content-Type: application/json' \
--data '{
	"rua": "Rua 7",
    "numero": "22",
	"bairro": "Copa Cabana",
	"cidade": "Rio de Janeiro",
	"estado": "RJ",
    "cep": "09876345",
    "usuario": {
        "id": 1
    }
}'
```
</details>

<details>
  <summary>Responses:</summary>

201 - _Created_
- Será retornado o id do registro criado

```
1
```

400 - _Bad Request_

```
{
  "code": "tc.argumentNotValid",
  "message": "state:O estado deve estar no formato 'SP';"
}
```

500 - _Internal Server Error_

```
{
	"code": "tc.address.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>

### ``PUT``

```
	/enderecos/{idEndereco}
```

**Body** raw (json)

```
{
    "rua": "string",
    "numero": "string",
    "bairro": "string",
    "cidade": "string",
    "estado": "string",
    "cep": "string",
    "usuario": {
        "id": Long
    }
}
```

<details>
  <summary>Exemplo Request Body:</summary>


```
curl --location --request PUT 'http://localhost:8080/enderecos/2' \
--header 'Content-Type: application/json' \
--data '{
	"rua": "Rua 2 alterada",
    "numero": "22",
	"bairro": "Copa Cabana",
	"cidade": "Rio de Janeiro",
	"estado": "RJ",
    "cep": "09876345",
    "usuario": {
        "id": 1
    }
}'
```
</details>

<details>
  <summary>Responses:</summary>

204 - _No Content_

400 - _Bad Request_

```
{
  "code": "tc.argumentNotValid",
  "message": "state:O estado deve estar no formato 'SP';"
}
```

500 - _Internal Server Error_

```
{
	"code": "tc.address.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>

### ``DELETE``

```
	/enderecos/{idEndereco}
```

<details>
  <summary>Exemplo Request:</summary>


```
curl --location --request DELETE 'http://localhost:8080/enderecos/3' \
--data ''
```
</details>

<details>
  <summary>Responses:</summary>

204 - _No Content_

500 - _Internal Server Error_

```
{
	"code": "tc.address.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------
### API Eletrodoméstico

>[ Base URL: http://localhost:8080 ]


A API Eletrodoméstico oferece a funcionalidade de cadastro das informações dos eletrodomésticos utilizados pelos usuários registrados. 
É imprescindível fornecer obrigatoriamente os seguintes dados: nome, modelo, marca, potência e voltagem. O campo cor, é opcional.
Com essa API, é possível simplificar o processo de gerenciamento e manutenção dos dados dos eletrodomésticos, garantindo a correta identificação e utilização desses equipamentos. 


<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``

```
	/eletrodomesticos
```

**Body** raw (json)

```
{
    "nome": String,
    "modelo": String,
    "marca": String,
    "cor": String,
    "potencia": Long,
    "voltagem": Long,
    "endereco": {
        "id": Long
    }
}
```

<details>
  <summary>Exemplo Request Body:</summary>


```
curl --location 'http://localhost:8080/eletrodomesticos' \
--header 'Content-Type: application/json' \
--data '{
    "nome": "Geladeira",
    "modelo": "Frost Free Duplex",
    "marca": "Consul",
    "cor": "Branca",
    "potencia": 90,
    "voltagem": 110,
    "endereco": {
        "id": 2
    }
}'
```
</details>

<details>
  <summary>Responses:</summary>

201 - _Created_
- Será retornado o id do registro criado

```
1
```

400 - _Bad Request_

```
{
  "code": "tc.argumentNotValid",
  "message": "voltage:não deve ser nulo;"
}
```

422 - _Unprocessable Entity_

```
{
    "code": "tc.homeAppliance.IllegalArgumentVoltage",
    "message": "Voltagem inválida, aceito apenas '110' e '220'."
}
```

500 - _Internal Server Error_

```
{
	"code": "tc.homeAppliance.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>

### ``PUT``

```
	/eletrodomesticos/{idEletrodomestico}
```

**Body** raw (json)

```
{
    "nome": String,
    "modelo": String,
    "marca": String,
    "cor": String,
    "potencia": Long,
    "voltagem": Long,
    "endereco": {
        "id": Long
    }
}
```

<details>
  <summary>Exemplo Request Body:</summary>


```
curl --location --request PUT 'http://localhost:8080/eletrodomesticos/2' \
--header 'Content-Type: application/json' \
--data '{
    "nome": "Iphone alterado",
    "modelo": "14",
    "marca": "Apple",
    "cor": "Azul marinho",
    "potencia": 51,
    "voltagem": 110,
    "endereco": {
        "id": 2
    }
}'
```
</details>

<details>
  <summary>Responses:</summary>

204 - _No Content_

400 - _Bad Request_

```
{
  "code": "tc.argumentNotValid",
  "message": "voltage:não deve ser nulo;"
}
```

422 - _Unprocessable Entity_

```
{
    "code": "tc.homeAppliance.IllegalArgumentVoltage",
    "message": "Voltagem inválida, aceito apenas '110' e '220'."
}
```

500 - _Internal Server Error_

```
{
	"code": "tc.homeAppliance.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>

### ``DELETE``

```
	/eletrodomesticos/{idEletrodomestico}
```

<details>
  <summary>Exemplo Request:</summary>


```
curl --location --request DELETE 'http://localhost:8080/eletrodomesticos/2' \
--data ''
```
</details>

<details>
  <summary>Responses:</summary>

204 - _No Content_

500 - _Internal Server Error_

```
{
	"code": "tc.homeAppliance.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>

### ``GET``

```
	/eletrodomesticos/{idUsuario}
```

**Filtros disponíveis:** nome, modelo, marca, potencia. Ex.:
>/eletrodomesticos/{idUsuario}?marca=apple

<details>
  <summary>Exemplo Request:</summary>


```
curl --location --request GET 'http://localhost:8080/eletrodomesticos/1' \
--header 'Content-Type: application/json' \
--data ''
```
</details>

<details>
  <summary>Responses:</summary>

200 - _OK_

```
[
    {
        "id": 2,
        "nome": "Iphone alterado",
        "modelo": "14",
        "marca": "Apple",
        "cor": "Azul marinho",
        "potencia": 51,
        "voltagem": 110,
        "endereco": {
            "id": 2
        }
    },
    {
        "id": 3,
        "nome": "Geladeira",
        "modelo": "Frost Free Duplex",
        "marca": "Consul",
        "cor": "Branca",
        "potencia": 90,
        "voltagem": 110,
        "endereco": {
            "id": 2
        }
    }
]
```

500 - _Internal Server Error_

```
{
	"code": "tc.homeAppliance.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>

### ``POST``

```
	/eletrodomesticos/{idEletrodomestico}/consumos
```

**Body** raw (json)

```
{
    "consumo": Double
}
```

<details>
  <summary>Exemplo Request Body:</summary>


```
curl --location 'http://localhost:8080/eletrodomesticos/1/consumos' \
--header 'Content-Type: application/json' \
--data '{
    "consumo": 12.2
}'
```
</details>

<details>
  <summary>Responses:</summary>

201 - _Created_
- Será retornado o id do registro criado

```
1
```

500 - _Internal Server Error_

```
{
	"code": "tc.homeAppliance.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>

### ``GET``

```
	/eletrodomesticos/{idEletrodomestico}/consumo-total-periodo
```

**Filtros disponíveis:** dataInicio, dataFim. Ex.:
>/eletrodomesticos/{idEletrodomestico}/consumo-total-periodo?dataInicio=2023-08-30T22:36:00&dataFim=2023-08-30T22:39:15

<details>
  <summary>Exemplo Request:</summary>


```
curl --location --request GET 'http://localhost:8080/eletrodomesticos/1/consumo-total-periodo?dataInicio=2023-08-30T22%3A36%3A00&dataFim=2023-08-30T22%3A39%3A15' \
--header 'Content-Type: application/json' \
--data ''
```
</details>

<details>
  <summary>Responses:</summary>

200 - _OK_

```
1.0 kWh
```

500 - _Internal Server Error_

```
{
	"code": "tc.homeAppliance.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------

<a name="tecnologias"></a>
## 📍️ Tecnologias

- As API's foram construídas em Java 17 utilizando Spring Framework 3.1.0
- Padrão REST na construção das rotas e retornos
- SLF4J para registro de logs
- Utilização de código limpo e princípios **SOLID**
- Boas práticas da Linguagem/Framework
- Clean architecture
- Docker
- Banco de Dados MySQL

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------

<a name="desafios"></a>
## 📍️ Desafios

No desenvolvimento deste projeto, nosso principal desafio foi criar uma estrutura que refletisse as melhores práticas utilizadas atualmente no mercado de desenvolvimento de software, indo além do foco acadêmico abordado nas aulas.

Adotamos o Clean Achitecture. 
Seguimos o princípio de separação de responsabilidades, como a divisão em camadas(Controller, UseCase, Gateway) para facilitar a manutenção e escalabilidade do sistema.

Utilizamos um interceptador de exceptions para garantir maior confiabilidade do sistema. Essa funcionalidade permite capturar e tratar exceções que ocorrem durante a execução, fornecendo respostas adequadas ao cliente e registrando informações úteis para análise posterior.

Incluímos logs nas classes utilizando a biblioteca de logging SLF4J. A utilização de logs nos permite registrar informações relevantes em diferentes níveis. Isso nos possibilita melhor visibilidade do comportamento do fluxo do sistema durante a execução. O que também facilita identificar e resolver problemas.

Adotamos o padrão Rest para expor os recursos da aplicação através da utilização de verbos HTTP apropriados. Estrutura adequada das URLs e retorno das respostas no formato JSON.


<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>
