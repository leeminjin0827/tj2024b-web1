drop database if exists mydb0122;
create database mydb0122;
use mydb0122;

create table board(
	bno int auto_increment ,
    btitle varchar(30) not null,
    bcontent varchar(255) not null,
    bwriter  varchar(10),  
    bview  int default(0),
    bpwd varchar(12) not null,
    bdate datetime default now(),
    constraint primary key(bno)
);

select * from board;

# DML : insert , select , update , delete
#(1) 게시물 등록
insert into board(btitle,bcontent,bwriter,bpwd) values('테스트제목','테스트내용','테스트작성자1','테스트비밀번호1');
#(2) 게시물 전체 조회
select * from board;
#(3) 게시물 개별 조회
select * from board where bno = 1;
#(4) 게시물 개별 수정
update board set btitle = '수정제목1' , bcontent = '수정내용1' where bno = 1;
#(5) 게시물 개별 삭제
delete from board where bno = 1;
