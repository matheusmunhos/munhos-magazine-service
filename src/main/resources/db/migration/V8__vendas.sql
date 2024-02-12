create table vendas (
id bigint not null auto_increment,
codigo_produto varchar(100) not null,
cliente_cpf bigint not null,
data datetime not null,

primary key(id),
constraint fk_vendas_codigo_produto foreign key(codigo_produto) references produtos(codigo_produto),
constraint fk_vendas_cliente_cpf foreign key(cliente_cpf) references clientes(cpf)


);