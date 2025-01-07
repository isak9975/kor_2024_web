# [1] 데이터베이스 생성
drop database if exists mydb0102;	#1. 만약에 생성할 db명이 존재하면 삭제
create database mydb0102;			#2. db 생성
use mydb0102;						#3. db 활성화

#[2] 테이블 생성
create table board(
	bno int unsigned auto_increment, 	#게시물 번호_int(정수타입), unsigned(부호없음), auto_increment(자동번호부여)
    btitle varchar(100) not null,		#게시물 제목_varchar(100) : 최대 100글자까지, not null : null 대입 불가능
	bcontent longtext,					#게시물 내용_longtext : 최대 4G 까지 지원한다
	bdate datetime default now(),		#게시물 날짜_datetime(날짜시간타입), dafault 기본값, now() : 시스템 날짜/시간
    bwriter varchar(30) not null,		#개시물 작성자_varchar(30)
    bpwd varchar(30) not null,		#게시물 패스워드_varchar(30) 
    primary key (bno)					#게시물 번호를 PK로 선정
);

#[3] 샘플코드
insert into board(btitle,bcontent,bwriter,bpwd) values('안녕제목1', '안녕내용1', '유재석', '1234');
insert into board(btitle,bcontent,bwriter,bpwd) values('안녕제목2', '안녕내용2', '강호동', '5678');
insert into board(btitle,bcontent,bwriter,bpwd) values('안녕제목3', '안녕내용3', '하하', '1345');
insert into board(btitle,bcontent,bwriter,bpwd) values('안녕제목4', '안녕내용4', '이수근', '1456');
insert into board(btitle,bcontent,bwriter,bpwd) values('안녕제목5', '안녕내용5', '나영석', '2345');

select *from board;
select * from board where bno = 3;

update board set btitle ='수정한이름', bcontent = '수정한내용' where bno=3;