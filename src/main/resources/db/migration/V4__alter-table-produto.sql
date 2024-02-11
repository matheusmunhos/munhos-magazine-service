alter table produtos add ativo tinyint not null;
update produtos set ativo = 1;