create table if not exists Cliente(
  cpf varchar(15) not null,
  nome varchar(255) not null,
  nascimento date not null,
  emissaoCNH date not null,
  primary key (cpf)
);

create table if not exists Veiculo(
    placa varchar(8) not null,
    filial varchar(255) not null,
    modelo varchar(255) not null,
    grupo char not null,
    kmRodados int not null,
    ultManutencao date not null,
    primary key (placa)
);

create table if not exists Manutencao(
    id int not null auto_increment,
    inicio date not null,
    fim date not null,
    placa varchar(8) not null ,
	constraint fk foreign key (placa) references Veiculo (placa) on update cascade on delete cascade,
	primary key (id)
);

create table if not exists Aluguel(
  placa varchar(8) not null,
  cpf varchar(15) not null,
  inicio date not null,
  fim date not null,
  retorno date,
  id int not null auto_increment,
  constraint fk_placa foreign key (placa) references Veiculo (placa) on update cascade on delete cascade,
  constraint fk_cpf foreign key (cpf) references Cliente (cpf) on update cascade on delete cascade,
  primary key (id)
);

create table if not exists Historico(
    cpf varchar(15) not null,
    id_aluguel int not null,
    observacao varchar(255) not null,
    constraint fk_aluguel foreign key (id_aluguel) references Aluguel(id) on update cascade on delete cascade,
    primary key (cpf)
)


# create table if not exists cliente(
#     nome varchar(255) not null,
#     cpf varchar(15) not null ,
#     rua varchar(255) not null,
#     cep varchar(9) not null,
#     num int not null,
#     primary key(cpf)
# );
#
# create table if not exists veiculo(
#     placa varchar(255) not null,
#     modelo varchar(255) not null,
#     classe varchar(10) not null,
#     disponiveis int not null,
#     filialOrigem varchar(255),
#
#     alugado boolean,
#     inicioA date,
#     fimA date,
#
#     manutencao boolean,
#     inicioM date,
#     fimM date,
#     primary key (placa)
# );
#
