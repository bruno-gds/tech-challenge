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

### POST - Cadastro de Pessoa
http://localhost:8080/people

O Cadastro de Pessoa tem como objetivo permitir o cadastro e gerenciamento de informações sobre os usuários cadastrados e as pessoas relacionadas aos mesmos.
Nesse endpoint o usuário irá se cadastrar informando seus dados: nome, cpf, data nascimento, gênero. 
Além do seu próprio cadastro, o usuário poderá incluir as demais pessoas relacionadas à ele, informando os campos: nome,  grau de parentesco e gênero.

Não é obrigatório o cadastro de pessoas relacionadas (parentes) ao usuário.

_Exemplo Request:_

```
curl --location 'http://localhost:8080/people' \
--data '{
    "name": "Fulano de Tal",
    "cpf": "143.162.450-07",
    "birthDate": "2000-10-02",
    "gender": "Masculino",
    "relatives":[
        {
            "name": "Ciclano",
            "parentage": "tio",
            "gender": "Masculino"
        }
    ]
}
'
```


_Exemplo Response:_
- 201 - Created:
	* Será retornado o id do registro criado.

- 500 - Internal Server Error:

```
{
	"code": "tc.person.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```

- 400 - Bad Request:
_(Caso o usuário já possua cadastro)_

```
{
	"code": "tc.person.CpfAlreadyRegistered",
	"message": "CPF já cadastrado."
}
```
