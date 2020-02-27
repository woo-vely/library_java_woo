desc book;
create table book(
    bookNo number generated always as identity,
    lib_idid varchar2(50) primary key,
    title varchar2(512) not null,
    auth varchar2(512),
    publ varchar2(512),
    pyb varchar2(10),
    call_no varchar2(50) not null,
    brch_code number not null
);

select * from book;

--bookNo이 마지막인 컬럼 보기
select * from(
    select * from book order by book.bookno desc)
where rownum = 1;

--book테이블의 행 갯수 확인
select count(bookNo) from book;