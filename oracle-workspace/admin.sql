drop table admin;

create table admin(
    no number generated always as identity,
    id VARCHAR2(50) primary key,
    password VARCHAR2(50) not null,
    name varchar2(50) not null,
    birth varchar2(50) not null
);

select * from admin;

