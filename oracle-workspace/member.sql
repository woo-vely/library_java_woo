create table member(
    no number generated always as identity,
    id varchar2(512) primary key,
    password varchar2(512) not null,
    name varchar2(512) not null,
    gender varchar2(1) default 'M'
);

select * from member;

commit;