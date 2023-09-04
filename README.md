<a name="readme-top"></a>

# Introdução

Nossa empresa se especializa em equipamentos de monitoramento de energia para uso residencial e comercial. Nosso produto principal são os adaptadores elétricos que permitem monitorar o consumo de energia de aparelhos eletrônicos. Eles se conectam via WiFi e integram-se à nuvem, criando um painel online para visualização dos dados em tempo real e histórico de consumo elétrico.

Compatíveis com a maioria dos dispositivos, nossos adaptadores permitem que os usuários identifiquem e controlem aparelhos de alto consumo de energia. Utilizando tecnologia avançada para medição precisa, oferecem uma interface intuitiva e conectividade automática com redes WiFi, garantindo que os dados sejam enviados para serviços em nuvem e apresentados de forma acessível em um painel de controle online.

# Tech Challenge

**FASE 1**  
Na primeira fase do desafio técnico, desenvolvemos as APIs iniciais com foco na integridade dos dados. 
São três APIs principais: Pessoa, Endereço e Eletrodoméstico. O objetivo dessas APIs é gerenciar as informações pertinentes a cada uma delas, que serão cadastradas em nosso sistema.

**FASE 2**  
Na segunda fase, aprimoramos as APIs da fase anterior, incorporando armazenamento de dados em um banco **MySQL** e introduzindo funcionalidades para ler, modificar e excluir informações.


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
Além do cadastro de usuário principal, o mesmo, tem a opção de incluir outras pessoas relacionadas a ele, informando o grau de parentesco.
É importante ressaltar que o cadastro de pessoas relacionadas (usuários parentes) ao usuário principal não é obrigatório.

A API Usuario oferece validação de dados para garantir precisão e integridade. A plataforma também disponibiliza verbos GET, PUT e DELETE para consulta, edição e exclusão de informações. 
A busca pode ser personalizada por nome, parentesco, sexo ou qualquer dado relevante, enquanto a atualização de informações permite a edição completa dos registros. Além disso, a API é capaz de identificar relacionamentos familiares, permitindo a criação de laços familiares, como pai, mãe, irmão, e muito mais.

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``  
`*Para cadastro de Usuário Principal`

```
	/usuarios
```
<details>
  <summary>Exemplo Request:</summary>

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
  <summary>Exemplo Responses:</summary>

201 - _Created_
`- Será retornado o id do registro criado (id do usuário principal)`

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
`- Caso o CPF já esteja cadastrado`

```
{
	"code": "tc.usuario.CpfJaCadastrado",
	"message": "CPF já cadastrado."
}
```

500 - _Internal Server Error_

```
{
	"code": "tc.usuario.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``
`*Para cadastro de Usuário Parente`

```
	/usuarios/parentes
```
<details>
  <summary>Exemplo Request:</summary>

```
curl --location 'http://localhost:8080/usuarios/parentes' \
--data '{
    "idUsuarioPrincipal": 22,
    "nome": "Valentina Daniela Lima",
    "cpf": "34743126002",
    "dataNascimento": "1960-02-13",
    "genero": "FEMININO",
    "parentesco": "TIA"
}'

```
</details>

<details>
  <summary>Exemplo Responses:</summary>

201 - _Created_
`- Será retornado o id do registro criado (id do usuário parente)`

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
`- Caso o CPF já esteja cadastrado`

```
{
	"code": "tc.usuario.CpfJaCadastrado",
	"message": "CPF já cadastrado."
}
```

500 - _Internal Server Error_

```
{
	"code": "tc.usuario.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

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
  <summary>Exemplo Responses:</summary>

200 - _OK_
`- Será retornado o usuário`

```
{
    "id": 2,
    "nome": "Pedro Gonçalves Nunes",
    "cpf": "04127674733",
    "dataNascimento": "1990-10-02",
    "genero": "MASCULINO"
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


### ``GET``
`*Para busca de Usuário Parente`

```
	/usuarios/{idUsuarioPrincipal}/parentes
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location 'http://localhost:8080/usuarios/21/parentes?nome=Vera&cpf=15803531006&parentesco=MAE&dataNascimento=1960-02-13&genero=FEMININO'
```

`*Filtros disponíveis: nome, cpf, parentesco, dataNascimento, genero.`


</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_
`- Será retornado o usuário parente do usuário principal`

```
[
    {
        "id": 25,
        "nome": "Alícia Vera",
        "cpf": "15803531006",
        "dataNascimento": "1960-02-13",
        "genero": "FEMININO",
        "parentesco": "MAE"
    }
]
```
200 - _OK_
`- Retorna lista vazia quando não encontrar resultado da busca por usuário parente`

```
[]
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``PUT``
`*Para alteração de dados do Usuário Principal`

```
	/usuarios/{id}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location --request PUT 'http://localhost:8080/usuarios/21' \
--data '{
    "nome": "Milena Campos",
    "cpf": "96659131159",
    "dataNascimento": "1998-09-13",
    "genero": "FEMININO"
}'
```
</details>
<details>
  <summary>Exemplo Responses:</summary>

204 - _No Content_

```
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

### ``PUT``
`*Para alteração de dados do Usuário Parente`

```
	/usuarios/{id}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location --request PUT 'http://localhost:8080/usuarios/26' \
--data '{
    "nome": "Renato Bento Lima",
    "cpf": "55076441010",
    "dataNascimento": "1995-02-13",
    "genero": "MASCULINO",
    "parentesco": "IRMAO"
}'
```
</details>
<details>
  <summary>Exemplo Responses:</summary>

204 - _No Content_

```
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

### ``DELETE``
`*Para excluir Usuário`

```
	/usuarios/{id}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location --request DELETE 'http://localhost:8080/usuarios/27'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

204 - _No Content_

```
```
422 - _Unprocessable Entity_  

```
{
  "code": "tc.usuario.erroAoExcluirUsuario",
  "message": "ATENÇÃO: Antes de excluir o usuário, por favor excluir os Endereços e Parentes associados à ele."
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


A API Endereço tem como objetivo facilitar o gerenciamento de informações relacionadas aos endereços cadastrados pelos usuários principais. 
Para garantir a qualidade dos registros, é indispensável que sejam fornecidos obrigatoriamente os seguintes dados: rua, número, bairro, cidade e estado. 
Com a API de Endereço, torna-se mais fácil e eficiente gerenciar e manter atualizadas as informações essenciais para uma correta identificação e localização dos endereços.
Cada usuário principal pode ter mais de um endereço cadastrado em nosso sistema. A plataforma também disponibiliza verbos GET, PUT e DELETE para consulta, edição e exclusão de informações. A busca pode ser personalizada por rua, bairro, cidade ou qualquer dado relevante, enquanto a atualização de informações permite a edição de qualquer dado sobre o endereço.

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``

```
	usuarios/{idUsuario}/enderecos
```
<details>
  <summary>Exemplo Request Body:</summary>

```
curl --location 'http://localhost:8080/usuarios/23/enderecos' \
--data '{
    "rua": "Rua Presidente Costa e Silva",
    "numero": 690,
    "bairro": "Centro",
    "cidade": "Camboriú",
    "estado": "SC",
    "cep": "88340404"
}'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

201 - _Created_
`- Será retornado o id do registro criado`

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
	"code": "tc.endereco.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``PUT``

```
	usuarios/{idUsuario}/enderecos/{id}
```
<details>
  <summary>Exemplo Request Body:</summary>

```
curl --location --request PUT 'http://localhost:8080/usuarios/28/enderecos/12' \
--header 'Content-Type: application/json' \
--data '{
    "rua": "Travessa São Pedro",
    "numero": 200,
    "bairro": "Bebedouro",
    "cidade": "Parnaíba",
    "estado": "PI",
    "cep": "64895236"
}'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

204 - _No Content_

```
```

404 - _Not Found_  

```
{
    "code": "tc.endereco.enderecoNaoEcontrado",
    "message": "Endereço não encontrado."
}
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
	"code": "tc.endereco.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``GET``
```
usuarios/{idUsuario}/enderecos
```
<details>
  <summary>Exemplo Request:</summary>
  
```
curl --location 'http://localhost:8080/usuarios/21/enderecos?rua=Travessa&bairro=bebedouro&cidade=parnaiba&estado=PI&cep=64895236'
```

`*Filtros disponíveis:** rua, bairro, cidade, estado, cep.`

</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_

```
[
    {
        "id": 12,
        "rua": "Travessa São Pedro",
        "numero": "200",
        "bairro": "Bebedouro",
        "cidade": "Parnaíba",
        "estado": "PI",
        "cep": "64895236",
        "usuario": {
            "id": 21
        }
    }
]
```

200 - _OK_
`- Caso o endereço não exista.`

```
[]
```

500 - _Internal Server Error_

```
{
	"code": "tc.endereco.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>


<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``DELETE``

```
	usuarios/{idUsuario}/enderecos/{id}
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location --request DELETE 'http://localhost:8080/usuarios/21/enderecos/12'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

204 - _No Content_

```
```
404 - _Not Found_  

```
{
    "code": "tc.endereco.enderecoNaoEcontrado",
    "message": "Endereço não encontrado."
}
```
422 - _Unprocessable Entity_

```
{
    "code": "tc.endereco.erroAoExcluirEndereco",
    "message": "ATENÇÃO: Antes de excluir o endereço, por favor excluir os Eletrodomésticos associados à ele."
}
```

500 - _Internal Server Error_

```
{
	"code": "tc.endereco.errorToAccessDatabase",
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

Cada usuário pode ter vários aparelhos eletrônicos cadastrados em nosso sistema. A plataforma também disponibiliza verbos GET, PUT e DELETE para consulta, edição e exclusão de informações. A busca pode ser personalizada por nome, modelo, marca ou qualquer dado relevante, enquanto a atualização de informações permite a edição de qualquer dado sobre o aparelho eletrônico.

A API Eletrodoméstico permite registrar o consumo de energia de aparelhos cadastrados. Um adaptador envia regularmente leitura do consumo atual à API. O intervalo de envio pode ser personalizado pelo usuário no adaptador, podendo ser configurado para envios a cada hora.

A plataforma permite o usuário realizar consultas sobre o consumo de energia de aparelhos cadastrados. 
É possível obter o consumo total do aparelho sem a necessidade de fornecer data/hora ou período específico. Além disso, é possível obter informações sobre o consumo em um período específico ao informar a data/hora desejada.


<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``
`*Para cadastro de Eletrodoméstico`

```
	enderecos/{idEndereco}/eletrodomesticos
```
<details>
  <summary>Exemplo Request Body:</summary>

```
curl --location 'http://localhost:8080/enderecos/16/eletrodomesticos' \
--header 'Content-Type: application/json' \
--data '{
    "nome": "TELEVISAO",
    "marca": "Samsung",
    "modelo": "PCC20",
    "cor": "Preta",
    "potencia": 1000,
    "voltagem": 220
}'
```
</details>

<details>
  <summary>Responses:</summary>

201 - _Created_
`- Será retornado o id do registro criado`

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
    "code": "tc.eletrodomestico.IllegalArgumentVoltage",
    "message": "Voltagem inválida, aceito apenas '110' e '220'."
}
```

500 - _Internal Server Error_

```
{
	"code": "tc.eletrodomestico.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``PUT``

```
	usuarios/{idUsuario}/eletrodomesticos/{idEletrodomestico}
```
<details>
  <summary>Exemplo Request Body:</summary>

```
curl --location --request PUT 'http://localhost:8080/usuarios/21/eletrodomesticos/15' \
--header 'Content-Type: application/json' \
--data '{
    "nome": "Purificador de Água",
    "marca": "IBBL",
    "modelo": "FR600",
    "cor": "Branco",
    "potencia": 90,
    "voltagem": 110
}'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

204 - _No Content_

```
```
400 - _Bad Request_

```
{
    "code": "tc.argumentNotValid",
    "message": "nome:não deve estar em branco;"
}
```
422 - _Unprocessable Entity_

```
{
    "code": "tc.eletrodomestico.eletrodomesticoNaoEcontrado",
    "message": "Eletrodomestico não encontrado."
}
```

500 - _Internal Server Error_

```
{
	"code": "tc.eletrodomestico.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``DELETE``
`*Para excluir Eletrodoméstico`

```
	usuarios/{idUsuario}/eletrodomesticos/{idEletrodomestico}
```
<details>
  <summary>Exemplo Request:</summary>

```
curl --location --request DELETE 'http://localhost:8080/usuarios/21/eletrodomesticos/10'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

204 - _No Content_

```
```
422 - _Unprocessable Entity_

```
{
    "code": "tc.eletrodomestico.erroAoExcluirEletrodomestico",
    "message": "ATENÇÃO: Antes de excluir o eletrodoméstico, por favor excluir suas Leituras de Consumo."
}
```

422 - _Unprocessable Entity_

```
{
    "code": "tc.eletrodomestico.eletrodomesticoNaoEcontrado",
    "message": "Eletrodomestico não encontrado."
}
```
500 - _Internal Server Error_

```
{
	"code": "tc.eletrodomestico.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``GET``
`*Para busca de Eletrodoméstico`

```
	usuarios/{idUsuario}/eletrodomesticos
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location 'http://localhost:8080/usuarios/21/eletrodomesticos?nome=Air%20Fryer&modelo=AFN&marca=mondial&potencia=1500'
```

`*Filtros disponíveis:** nome, modelo, marca, potencia.`

</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_

```
[
    {
        "id": 8,
        "nome": "Air Fryer",
        "modelo": "AFN-40-BI",
        "marca": "Mondial",
        "cor": "Preto/Inox",
        "potencia": 1500,
        "voltagem": 110,
        "endereco": {
            "id": 12
        }
    }
]
```
200 - _OK_
`- Caso o endereço não exista.`

```
[]
```


500 - _Internal Server Error_

```
{
	"code": "tc.eletrodomestico.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>
<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``
`*Para cadastrar Leitura de Consumo do Eletrodoméstico`

```
	eletrodomesticos/{id}/consumos
```

<details>
  <summary>Exemplo Request Body:</summary>

```
curl --location 'http://localhost:8080/eletrodomesticos/27/consumos' \
--header 'Content-Type: application/json' \
--data '{
    "consumo": 1.99
}'
```
</details>

<details>
  <summary>Responses:</summary>

201 - _Created_
`- Será retornado o id do registro criado`

```
1
```
422 - _Unprocessable Entity_

```
{
    "code": "tc.eletrodomestico.eletrodomesticoNaoEcontrado",
    "message": "Eletrodomestico não encontrado."
}
```

500 - _Internal Server Error_

```
{
	"code": "tc.eletrodomestico.errorToAccessDatabase",
	"message": "Ocorreu um erro ao acessar o banco de dados."
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``GET``
`*Para buscar Leitura de Consumo do Eletrodoméstico`

```
	eletrodomesticos/{id}/consumo-total-periodo"
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location 'http://localhost:8080/eletrodomesticos/10/consumo-total-periodo?dataInicio=2023-09-02T20%3A31%3A39&dataFim=2023-09-02T23%3A59%3A00'
```
`*Filtros disponíveis:** dataInicio, dataFim`

</details>

<details>
  <summary>Responses:</summary>

200 - _OK_

```
1.0 kWh
```
200 - _OK_
`- Caso o registro de consumo não exista.`

```
0.0 kWh
```

500 - _Internal Server Error_

```
{
	"code": "tc.eletrodomestico.errorToAccessDatabase",
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

**FASE 1**  
No desenvolvimento da primeira fase, nosso principal desafio foi criar uma estrutura que refletisse as melhores práticas utilizadas atualmente no mercado de desenvolvimento de software, indo além do foco acadêmico abordado nas aulas.

Adotamos o Clean Achitecture. 
Seguimos o princípio de separação de responsabilidades, como a divisão em camadas(Controller, UseCase, Gateway) para facilitar a manutenção e escalabilidade do sistema.

Utilizamos um interceptador de exceptions para garantir maior confiabilidade do sistema. Essa funcionalidade permite capturar e tratar exceções que ocorrem durante a execução, fornecendo respostas adequadas ao cliente e registrando informações úteis para análise posterior.

Incluímos logs nas classes utilizando a biblioteca de logging SLF4J. A utilização de logs nos permite registrar informações relevantes em diferentes níveis. Isso nos possibilita melhor visibilidade do comportamento do fluxo do sistema durante a execução. O que também facilita identificar e resolver problemas.

Adotamos o padrão Rest para expor os recursos da aplicação através da utilização de verbos HTTP apropriados. Estrutura adequada das URLs e retorno das respostas no formato JSON.


**FASE 2**  
Na segunda fase do projeto, optamos por realizar uma transição completa do código, que estava originalmente em inglês, para o português. Essa decisão visava melhorar a comunicação e a compreensão entre os membros do projeto. 
Durante essa etapa, enfrentamos um desafio central, que era estabelecer os relacionamentos entre as entidades. 
O código passou por várias iterações de refatoração para se adaptar e atender aos requisitos estabelecidos da melhor forma possível.

Para aplicar nossos conhecimentos, empregamos tanto o Criteria Builder quanto o JPQL para realizar consultas com filtros de pesquisa, garantindo assim uma abordagem eficaz na obtenção dos dados necessários para o projeto. 

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>
