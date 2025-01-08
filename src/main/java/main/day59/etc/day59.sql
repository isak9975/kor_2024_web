#1. 데이터 베이스 준비
drop database if exists mydb0109;
create database mydb0109;
use mydb0109;

#2. 테이블 생성
create table member(
	mno  int auto_increment,
    mid varchar(30),
    mpwd varchar(30),
    mname varchar(30),
    mphone varchar(30),
    primary key (mno));
    
    select * from member;