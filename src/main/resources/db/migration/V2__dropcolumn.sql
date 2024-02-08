ALTER TABLE produtos
DROP COLUMN tipoProduto;
alter table produtos add tipo_produto varchar(100) not null;
