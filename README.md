<a name="readme-top"></a>
# Tech Challenge

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

<a name="funcionalidades-do-projeto"></a>
## 🔨  Funcionalidades do projeto

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

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------
### API Eletrodoméstico

>[ Base URL: http://localhost:8080 ]


A API Eletrodoméstico oferece a funcionalidade de cadastro das informações dos eletrodomésticos utilizados pelos usuários registrados. 
É imprescindível fornecer obrigatoriamente os seguintes dados: nome, tipo, modelo, potência e voltagem. O campo cor, é opcional.
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
