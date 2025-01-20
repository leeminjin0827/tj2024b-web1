drop database if exists mydb0120;
create database mydb0120;
use mydb0120;

create table waiting(
	son int auto_increment ,
    phone longtext ,
    number int ,
    constraint primary key(son)
);
select * from waiting;