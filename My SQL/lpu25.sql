create database lpu25;
use lpu25;
create table student
(
roll int primary key,
name varchar(100),
branch varchar(100),
phone varchar(40) 
);

insert into student values(101, 'Amit', 'CSE', '6554213265');
insert into student values(102, 'Vaibhav', 'CSE', '6554213266');
insert into student values(103, 'Dipesh', 'CSE', '9053113728');
insert into student values(104, 'Mohit', 'CSE', '87218181927');
insert into student values(105, 'Yash', 'CSE', '87218181929');

select * from student;

select * from book;
use lpu25;

set AUTOCOMMIT =0;
INSERT INTO book Values(3,"Let us C","SHane Murphey",190);
INSERT INTO book Values(4,"Let us C++","SHane Murphey",200);
commit;
rollback;
INSERT INTO book Values(5,"Let us C++","SHane Murphey",200);
INSERT INTO book Values(6,"Let us Kotlin","SHane Murphey",200);
INSERT INTO book Values(7,"Let us Python","SHane Murphey",250);
INSERT INTO book Values(8,"Let us java","SHane Murphey",200);
select * from book;
INSERT INTO book Values(9,"Let us javaa","SHane Murphey",200);

-- change the balance of  
select * from student where roll =101 or roll = 103;
select * from student where roll  in(101,102,103,104,107);
select * from student where roll  not in(101,102,103,104,107);
select * from student where roll  between 101 and 107;

select * from student;
commit;
update student set name ='Harsh Yadav' where roll = 107;
update student set name ='Harsh Vardhan', branch ="BCA",phone = "78872878272" where roll = 108;
update student set branch ="CSE";


-- Alter commands
alter table student modify name varchar(140) not null;
alter table student rename column name to sname;
desc student;
alter table student add dob date;
select * from student;
update student set dob = '20041002' where roll in (103,105,107,101);

rollback;
alter table student add marks int not null default 60;
alter table student add constraint markscon check(marks>=40 and marks <=100);

update student set marks = 99 where roll = 101;
update student set marks = 98 where roll = 102;
update student set marks = 58 where roll = 104;
update student set marks = 48 where roll = 105;
update student set marks = 67 where roll = 103;
update student set marks = 72 where roll = 109;
update student set marks = 60 where roll = 107;
update student set marks = 77 where roll = 108;
-- 5 aggregate functions min max count sum avg
select count(*) from student;
select count(dob) from student;
select count(marks) from student;

select min(marks) from student;
select max(marks) from student;
select avg(marks) from student;

-- select name of student which got maximun marks
select max(marks) ,count(*),min(marks) from student where roll <110;
select sname , marks from student where marks = (select max(marks) from student);
select sname ,marks from student order by marks desc limit 1;
select * from student;



-- create table customers (custid, name, phone, address) without any primary key.
create table Customers(
	custId int,
    name varchar(20),
    phone varchar(10),
    address varchar(50)
);

desc Customers;
alter table Customers add primary key(custid);
alter table Customers modify name varchar(20) not null;
insert into Customers values (1011, "Vaibhav Bhardwaj",838,"23 Dp Street 1ui");
INSERT INTO Customers VALUES (1011, 'Vaibhav Bhardwaj', '8383838383', '23 Dp Street 1ui');
INSERT INTO Customers VALUES (1012, 'Anjali Mehta',      '9876543210', '14 Lotus Road, Delhi');
INSERT INTO Customers VALUES (1013, 'Ravi Kumar',        '9123456789', '88 Market Street, Pune');
INSERT INTO Customers VALUES (1014, 'Sneha Sharma',      '9988776655', '202 Cyber Park, Noida');
INSERT INTO Customers VALUES (1015, 'Arjun Verma',       '8899776655', '11B Green Park, Jaipur');
INSERT INTO Customers VALUES (1016, 'Pooja Sinha',       '9090909090', '4 Rose Lane, Bhopal');
INSERT INTO Customers VALUES (1017, 'Karan Thakur',      '8765432109', '77 Sunset Blvd, Chandigarh');
INSERT INTO Customers VALUES (1018, 'Neha Desai',        '9345678921', '501 Galleria, Mumbai');
INSERT INTO Customers VALUES (1019, 'Amit Joshi',        '9001122334', 'Block A, Sector 62, Noida');
INSERT INTO Customers VALUES (1020, 'Ritika Gupta',      '7894561230', 'MG Road, Bengaluru');
INSERT INTO Customers VALUES (1021, 'Siddharth Malhotra','7008009001', 'Park Avenue, Kolkata');

-- alter table Customers modify ;

create table student2 as select * from student;
select * from student2;
select * from customers;

select * from  Customers where name like 'n%';
select * from  Customers where name like '%i';
select * from  Customers where name like 'n%i';
select * from  Customers where name like '%sh%';

use lpu25;
select * from student order by branch;

--  sum avg count min max
-- select sum(marks) , name from student; //wrong
-- select sname from student group by branch; //again wrong

select branch,count(*) from student group by branch;
select s.branch ,count(*) as numstudents from student s where roll >101 group by s.branch;

-- Joins in SQL {1,2,3} X {a,b}








