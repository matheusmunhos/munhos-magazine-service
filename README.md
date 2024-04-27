
# Munhos Magazine Service

Serviço de gerenciamento e controle de vendas e entradas de um comércio


## Funcionalidades

- Cadastro de Produtos
- Cadastro de Clientes
- Controle de Estoque
- Venda de Produtos


## Documentação da API

#### Retorna todos os produtos

```http
  GET /produto
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
|  | `json` | **Retorno** de todos os produtos cadastrados |

#### Deleta o produto pelo seu ID

```http
  DELETE /produto/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id do produto`      | `json` | **Obrigatório**. O ID do item que você quer deletar |


```http
  POST /produto/
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| [Json](https://frequent-flute-9c9.notion.site/API-Reference-55b45a1efa2d4fc7822ec8fb28785112?pvs=4)      | `json` | **Cadastro do produto**. |






## Stack utilizada



**Back-end:** Java 17, Flyway e MySql
