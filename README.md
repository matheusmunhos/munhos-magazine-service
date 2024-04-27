
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
| `id`      | `string` | **Obrigatório**. O ID do item que você quer deletar |


POST /produto/

| Parâmetro                                       | Tipo       | Descrição                                   |
| :---------------------------------------------- | :--------- | :------------------------------------------ |
| ```json {"id":"76655","nome":"Armario","valor":"1200.0","quantidade":"10","tipoProduto":"Sofa de 3 lugares","codigoProduto":"76655"}```   | `string`   | JSON contendo os detalhes do produto.      |


## Stack utilizada


**Back-end:** Java 17, FlyWay e MySql

