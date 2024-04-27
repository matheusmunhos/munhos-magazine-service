
# Munhos Magazine Service

Serviço de gerenciamento e controle de vendas e entradas de um comércio


## Funcionalidades

- Cadastro de Produtos
- Cadastro de Clientes
- Controle de Estoque
- Venda de Produtos


## Documentação da API




#### Cria um produto

```http
  POST /produto/
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| [Json](https://frequent-flute-9c9.notion.site/API-Reference-55b45a1efa2d4fc7822ec8fb28785112?pvs=4)      | `json` | **Cadastro do produto**. |

#### Retorna todos os produtos

```http
  GET /produto
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
|  | `Lista de produtos <Json>` | **Retorno** de todos os produtos cadastrados |


```http
  PUT /produto/atualizar{cdProduto}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
|  [Código do produto](https://frequent-flute-9c9.notion.site/API-Reference-55b45a1efa2d4fc7822ec8fb28785112?pvs=4)| `json` | **Retorno** de todos os produtos cadastrados |



#### Deleta o produto pelo seu ID

```http
  DELETE /produto/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id do produto`      | `json` | **Obrigatório**. O ID do item que você quer deletar |



#### Repor Produto

```http
  PUT /produto/repor{cdProduto}{quantidade}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `Código do produto e Quantidade`      | `json` | **Obrigatório** o código e a quantidade |

#### Cadastro De Cliente

```http
  POST /cliente
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| [Json](https://frequent-flute-9c9.notion.site/API-Reference-55b45a1efa2d4fc7822ec8fb28785112?pvs=4)      | `json` | **Cadastro** de cliente |

#### Listagem de clientes

```http
  GET /cliente
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
|       | `Lista de clientes <Json>` | **Retorna** a lista de clientes cadastrados |

#### Atualização de clientes

```http
  PUT /cliente
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
|   [Json](https://frequent-flute-9c9.notion.site/API-Reference-55b45a1efa2d4fc7822ec8fb28785112?pvs=4)    | `Json` | **Atualiza** os dados do cliente |


#### Deleta o cliente pelo seu CPF

```http
  DELETE /cliente/{cpf}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `CPF`      |  | **Deleta** o cliente a partir de seu CPF |

#### Detalha os dados do cliente

```http
  GET /cliente/{cpf}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `CPF`      |  | **Detalha** os dados do cliente |


#### Realizar vendas

```http
  POST /vendas
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
|  [Json](https://frequent-flute-9c9.notion.site/API-Reference-55b45a1efa2d4fc7822ec8fb28785112?pvs=4)     |  json| **Realiza a venda** do produto para o cliente |

#### Listas vendas

```http
  GET /vendas
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
|      |  Lista de vendas <Json>| **Retorna todas** as vendas |



## Stack utilizada



**Back-end:** Java 17, Flyway e MySql

## Suporte

Para suporte, mande um email para munhosdev@gmail.com

