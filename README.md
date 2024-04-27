
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






## Stack utilizada



**Back-end:** Java 17, Flyway e MySql
