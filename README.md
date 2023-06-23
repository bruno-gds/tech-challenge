# Tech Challenge - Fase 1

Na primeira fase do desafio técnico, desenvolvemos as APIs iniciais com foco na integridade dos dados. 
São três APIs principais: Pessoa, Endereço e Eletrodoméstico. O objetivo dessas APIs é gerenciar as informações pertinentes a cada uma delas, que serão cadastradas em nosso sistema.


## Sumário Documentação de APIs
* [Instruções](#instruções)
* [Funcionalidades do projeto](#funcionalidades-do-projeto)
* [Tecnologias](#tecnologias)
* [Desafios](#desafios)


### API Pessoa

>[ Base URL: http://localhost:8080 ]


A API Pessoa tem como objetivo permitir o registro e gerenciamento das informações dos usuários cadastrados.
Além do cadastro principal, o usuário tem a opção de incluir outras pessoas relacionadas a ele, informando o grau de parentesco.
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
