# Conteúdo

-   A API construída em Java 17 utilizando Spring Framework 3.1.0
-   Padrões REST na construção das rotas e retornos
-   Utilização de código limpo e princípios  **SOLID**
-   Boas práticas da Linguagem/Framework
-   Clean architecture


# Instruções

-   Maven: para build do projeto. Para buildar: mvn clean install
-   Foi utilizado Lombok, portanto é necessário adicionar o plugin na IDE

### POST - Cadastro de Endereço

http://localhost:8080/adresses

O Cadastro de Endereço, tem como objetivo permitir o gerenciamento de informações sobre os endereços que serão cadastrados. Nesse endpoint, é OBRIGATÓRIO informar os dados: rua, número, bairro, cidade e estado. 

_Exemplo Request:_

```
curl --location 'http://localhost:8080/adresses' \
--header 'Content-Type: application/json' \
--data '{
"street": "Av dos devs",
"number": "30",
"neighborhood": "Jardins",
"city": "São Paulo",
"state": "SP"
}'
```

### Cadastro de Pessoa

>[ Base URL: localhost:8080/ ]

O Cadastro de Pessoa tem como objetivo possibilitar o registro e gerenciamento das informações dos usuários cadastrados, bem como das pessoas relacionadas a eles. 
Neste endpoint, o usuário pode se cadastrar fornecendo os seguintes dados: nome, CPF, data de nascimento e gênero. 
Além do próprio cadastro, o usuário tem a opção de incluir outras pessoas relacionadas a ele, informando os campos: nome, grau de parentesco e gênero.

É importante ressaltar que o cadastro de pessoas relacionadas (parentes) ao usuário não é obrigatório.

### ``POST``

```
	/people
```

**Body** raw (json)

```
{
    "name": String,
    "cpf": String,
    "birthDate": String,
    "gender": String",
    "relatives":[
        {
            "name": String,
            "parentage": String,
            "gender": String
        }
    ]
}
```


<details>
  <summary>Exemplo Request Body:</summary>


```
curl --location 'http://localhost:8080/people' \
--data '{
    "name": "Stwart Litle",
    "cpf": "123.456.789-00",
    "birthDate": "1990-10-02",
    "gender": "Masculino",
    "relatives":[
        {
            "name": "Lili Litle",
            "parentage": "Mãe",
            "gender": "Feminino"
        }
    ]
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
