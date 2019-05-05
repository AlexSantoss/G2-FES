create table if not exists cliente(
    nome varchar(255) not null,
    cpf varchar(15) not null ,
    rua varchar(255) not null,
    cep varchar(9) not null,
    num int not null,
    primary key(cpf)
);