create table produtos(

    id bigint not null auto_increment,
    nome varchar(100) not null,
   
    valor double not null,
    quantidade bigint(100) not null,
    tipoProduto varchar(100) not null,
 
    primary key(id)

);
create table clientes(

  
    cpf bigint not null,
    nome varchar(100) not null,
   email varchar(100) not null,
   telefone varchar(100) not null,
   
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,
 
    primary key(cpf)

);
create table administradores(

  
      id bigint not null auto_increment,
    nome varchar(100) not null,
   email varchar(100) not null,
   senha varchar(100) not null,
    cpf varchar(100) not null,

 
    primary key(id)

);