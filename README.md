# Tech Challenge - Fase 1

Na primeira fase do desafio técnico, desenvolvemos as APIs iniciais com foco na integridade dos dados. 
São três APIs principais: Pessoa, Endereço e Eletrodoméstico. O objetivo dessas APIs é gerenciar as informações pertinentes a cada uma delas, que serão cadastradas em nosso sistema.


## Sumário
* [Instruções](#instruções)
* [API Pessoa](#api-pessoa)
* [API Endereço](#api-endereço)
* [API Eletrodoméstico](#api-eletrodoméstico)
* [Tecnologias](#tecnologias)
* [Desafios](#desafios)


## Instruções

- Maven: para build do projeto. **Para buildar:** mvn clean install
- Foi utilizado Lombok e Validation, portanto é necessário adicionar os plugins na IDE

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>


### API Pessoa

>[ Base URL: http://localhost:8080 ]


A API Pessoa tem como objetivo permitir o registro e gerenciamento das informações dos usuários cadastrados.
Além do cadastro principal, o usuário tem a opção de incluir outras pessoas relacionadas a ele, informando o grau de parentesco.
É importante ressaltar que o cadastro de pessoas relacionadas (parentes) ao usuário não é obrigatório.

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``

```
	/people
```

**Body** raw (json)

```
{
    "name": "string",
    "cpf": "string",
    "birthDate": "string",
    "gender": "string"",
    "relatives":[
        {
            "name": "string",
            "parentage": "string",
            "gender": "string"
        }
    ]
}
```


<details>
  <summary>Exemplo Request Body:</summary>


```
curl --location 'http://localhost:8080/people' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Pedro Gonçalves Nunes",
    "cpf": "041.276.747-33",
    "birthDate": "1990-10-02",
    "gender": "Masculino",
    "relatives": [
        {
            "name": "Marcos Medeiros Nunes",
            "parentage": "Pai",
            "gender": "Masculino"
        },
        {
            "name": "Fernanda Gonçalves Nunes",
            "parentage": "Mãe",
            "gender": "Feminino"
        }
    ]
}'
```
</details>



<details>
  <summary>Responses:</summary>

201	 _Created_

```
 Será retornado o id do registro criado.
```

500  _Internal Server Error_

```
{
	"code": "tc.person.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```

400  _Bad Request_
``(Caso o CPF já esteja cadastrado)``

```
{
	"code": "tc.person.CpfAlreadyRegistered",
	"message": "CPF já cadastrado."
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
	/adresses
```

**Body** raw (json)

```
{
    "street": "string",
    "number": "string",
    "neighborhood": "string",
    "city": "string",
    "state": "string"
}
```

<details>
  <summary>Exemplo Request Body:</summary>


```
curl --location 'http://localhost:8080/adresses' \
--header 'Content-Type: application/json' \
--data '{
    "street": "Rua Dezoito",
    "number": "5698",
    "neighborhood": "São José",
    "city": "Blumenau",
    "state": "SC"
}
'
```
</details>

<details>
  <summary>Responses:</summary>

201	 _Created_

```
 Será retornado o id do registro criado.
```

500  _Internal Server Error_

```
{
	"code": "tc.address.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```

400  _Bad Request_

</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------
### API Eletrodoméstico

A API Eletrodoméstico oferece a funcionalidade de cadastro das informações dos eletrodomésticos utilizados pelos usuários registrados. 
É imprescindível fornecer obrigatoriamente os seguintes dados: tipo, marca, modelo, potência e voltagem. 
Com essa API, é possível simplificar o processo de gerenciamento e manutenção dos dados dos eletrodomésticos, garantindo a correta identificação e utilização desses equipamentos. 


<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``

```
	/homeAppliances
```

**Body** raw (json)

```
{
    "name": String,
    "brand": String,
    "model": String,
    "color": String,
    "power": Long,
    "voltage": Long
}
```

<details>
  <summary>Exemplo Request Body:</summary>


```
curl --location 'http://localhost:8080/homeAppliances' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Geladeira",
    "brand": "Eletrolux",
    "model": "TF39",
    "color": "Branca",
    "power": 120,
    "voltage": 127
}'
```
</details>

<details>
  <summary>Responses:</summary>

201	 _Created_

```
 Será retornado o id do registro criado.
```

500  _Internal Server Error_

```
{
	"code": "tc.homeAppliance.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```

400  _Bad Request_

</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>
