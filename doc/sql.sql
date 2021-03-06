drop table observadores;
drop table locacao;
drop table jogo;
drop table cliente;
create table if not exists cliente(
    nome varchar(50) not null,
    email varchar(50) not null unique,
    cpf varchar(15) not null,
    primary key(cpf)
);

create table jogo(
    idDoJogo serial,
    nomeDoJogo varchar(50) not null,
    genero varchar(30) not null,
    estado varchar(40) not null,   
    primary key(idDoJogo)
);

create table if not exists locacao(
    idDaLocacao serial,
    idDoCliente varchar(50),
    idDoJogo int,
    dataDaLocacao varchar(15) not null, 
    dataDeDevolucao varchar(15),
    estrategia varchar(30) not null,
    foreign key(idDoJogo) references jogo(idDoJogo) on update cascade on delete restrict,
    foreign key(idDoCliente) references cliente(cpf) on update cascade on delete restrict,
    primary key(idDaLocacao)
);
create table if not exists observadores(
    idDoObservador serial,
    idDoJogo bigint,
    idDoCliente varchar(50),
    foreign key(idDoJogo) references jogo(idDoJogo) on update cascade on delete restrict,
    foreign key(idDoCliente) references cliente(cpf) on update cascade on delete restrict,
    primary key(idDoObservador)
);
insert into cliente values('Root', 'root@hotmail.com','123');


