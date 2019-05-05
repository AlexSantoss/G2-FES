create table if not exists cliente(
    nome varchar(255) not null,
    cpf varchar(15) not null ,
    rua varchar(255) not null,
    cep varchar(9) not null,
    num int not null,
    primary key(cpf)
);

create table if not exists veiculo(
    modelo varchar(255) not null,
    classe char not null,
    disponiveis int not null,
    filialOrigem varchar(255),

    alugado boolean,
    inicioA date,
    fimA date,

    manutencao boolean,
    inicioM date,
    fimM date,
    primary key (modelo)
);