create table patients(
    id bigint not null auto_increment,
    name varchar(40) not null,
    email varchar(40) not null unique,
    phone varchar(15) not null,
    cpf varchar(15) not null,
    street varchar(100) not null,
    neighborhood varchar(100) not null,
    zip varchar(9) not null,
    complement varchar(100),
    number varchar(20),
    postal char(2) not null,
    city varchar(100) not null,

    primary key(id)
);