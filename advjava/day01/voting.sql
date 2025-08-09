-- DB URL : jdbc:mysql://localhost:3306/dacdb
	
-- users table
create table users (id int primary key auto_increment,first_name varchar(20),last_name varchar(20),
email varchar(20) unique,password varchar(20),dob date,status boolean,role varchar(20));

insert into users values(default,'Rama','Kher','rama@gmail.com','ram#123','1999-1-1',0,'admin');
insert into users values(default,'Shekhar','Patil','shekhar@gmail.com','shk#123','1992-10-20',0,'voter');
insert into users values(default,'Medha', 'Khole','medha@gmail.com','mad$234','1990-11-21',0,'voter');
insert into users values(default,'Nilesh', 'Ghule','nilesh@gmail.com','nilesh','1983-09-28',0,'voter');

-- candidates table 
create table candidates(id int primary key auto_increment,
name varchar(20) unique,party varchar(20),votes int);

insert into candidates values(default,'Ravi','bjp',50);
insert into candidates values(default,'Asha','ncp',40);
insert into candidates values(default,'Kiran','congress',48);
insert into candidates values(default,'Riya','sp',69);
insert into candidates values(default,'Subhash','aap',14);
insert into candidates values(default,'Pratik','bjp',56);
insert into candidates values(default,'Nirmal','congress',60);
insert into candidates values(default,'Sameer','bjp',71);

-- test
show tables;

select * from users;

select * from candidates;