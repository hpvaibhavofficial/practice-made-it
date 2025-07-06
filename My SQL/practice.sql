create database practice;
show databases;

use practice;

create table student(
	reg int primary key ,
    name varchar(40) not null,
    age int check(age>0),
	branch varchar(100),
    address varchar(100),
    section varchar(50),
    gpa decimal(2,2)
);

desc student;
 
ALTER TABLE student modify column gpa decimal(3,2);
alter table student change column address state varchar(50);
insert into student values(12218284,"Vaibhav Bhardwaj", 21,"CSE","HP","K22MZ",8.4);
select * from student;

INSERT INTO student 
VALUES
(12218285, 'Varun Kumar', 20, 'CSE', 'Delhi', 'K22MZ', 8.2),
(12218286, 'Vikram Rana', 21, 'ECE', 'Punjab', 'K22EZ', 7.9),
(12218287, 'Aarav Mehta', 22, 'ME', 'Mumbai', 'K22ME', 7.4),
(12218288, 'Neha Sharma', 20, 'CSE', 'Haryana', 'K22CZ', 8.6),
(12218289, 'Riya Kapoor', 21, 'IT', 'Chandigarh', 'K22IT', 8.0);

show tables;
SELECT * FROM STUDENT;

delete FROM STUDENT where reg = 12218284;
insert into student value (12218284,'Vaibhav Bharwaj',21,'CSE','HP','K2S01',8.4);

alter table student add column email varchar(100);
desc student;
select * from student;

alter table student drop email;
alter table student add column Email varchar(100);

update student
set Email = "vaibhav.12218284@lpu.in"
where reg = 12218284;

update student set email = concat(substring_index(name,' ',1),".",reg,"@lpu.in");
update student set email = lower(email);

alter table student modify column section varchar(20);
desc student;

alter table student rename column state to address;
alter table student change column address state varchar(50);

select * from student where branch = 'cse';
select * from student where gpa > 8;
select distinct branch from student;

delete from student where branch = 'ece';  
select * from student;
set autocommit =0;

select * from student where gpa between 4.5 and 8.2;
select * from student where branch in('cse','it');

select * from student where gpa between 4.5 and 8.2 and branch in('cse','it');
select * from student where name like "v%";

select * from student where name between 'V' and 'vzzzzzzzzzzzzzz';

select Count(*) as ts from student;


-- Practice Question
-- Retrieve all student records.
select * from student; 
-- Show the name and GPA of all students.
select name , gpa from student;
-- How many students are there in total?
select count(*) from student;
-- List all distinct branches available in the student table.
select distinct branch from student;
-- Fetch students who belong to the 'CSE' branch.
select * from student where branch = 'cse';
-- Display students whose GPA is more than 8.
select * from student where gpa > 8;
-- Get students whose names start with 'V'.
select * from student where name like "v%";
-- Show students whose section is 'K22MZ'.
select * from student where section = 'K22MZ';
-- List students whose state is 'HP'.
select * from student where state ='HP';
-- Show the student with registration number 12218284.
select * from student where reg =12218284;
-- Count the number of students in each branch
select branch , count(*) from student group by branch;
-- Get the average GPA of students in each section.
select section, avg(gpa) from student group by section;
-- List the total number of students from each state.
select state,count(*) from student group by state;
-- Find the maximum GPA in each branch.
select branch , max(gpa) from student group by branch;
-- Get the number of students in each section whose GPA is greater than 7.5.
select count(*), section from student where gpa >7.5 group by section;
-- Count how many students are there in each branch where total count is more than 1.
select count(*) , branch from student group by branch having count(*) >1;
-- Show total students grouped by state and branch.
select count(*), branch,state from student group by branch,state; 
-- Get all students whose GPA is between 7 and 8.5.
select * from student where gpa between 7 and 8.5;
-- List students whose name falls between ‘A’ and ‘Mzzzz’.
select * from student where name between 'A' and 'Mzzzz';
-- List all students whose name starts from letters b/w 'A' to 'M'
select * from student where left(name,1) between 'a' and 'w';
select * from student where substring(name ,1,1) between 'a' and 'u';
-- Fetch students whose GPA is greater than all students in the IT branch.
select* from student where gpa > (select max(gpa) from student where branch = 'it');
-- List students from 'CSE' and 'IT' branches whose GPA is greater than 8.
select * from student where branch = ('cse' or 'it') and gpa > 8;
-- Find all students where the email is missing (null).
select * from student where email is null;
-- Get students whose names contain the word 'Rana'.
select * from student where name like "%rana%";
-- List students who live in states ending with 'a':
select * from student where state like "%a";
--  Find all students whose first name starts with 'N'
select * from  student where name like "N%";
select * from student where substring_index(name,' ',1) like 'n%';
--  Fetch the GPA of the student(s) with the highest GPA:
select max(gpa) from student ;  -- only gpa
select * from student where gpa = (select max(gpa) from student);
-- List students whose branch is not 'CSE':
select * from student where branch != 'cse';
-- Get students who have the second highest GPA.
select * from student where gpa = (select max(gpa) 
from student 
where gpa  < (select max(gpa) from student));
-- List students whose name does not contain any spaces.
select * from student where name not like "% %";
-- Find students whose GPA is equal to the GPA of any IT student.
select * from student where gpa in (select gpa from student where branch = 'it');
-- List students who have the same GPA as someone in the CSE branch, but are not in CSE themselves.
select * from student 
where branch != 'cse' 
and gpa in(select gpa  from student where branch = 'cse');
--  Get all students whose email ends with @gmail.com.
select * from student where email like "%@gmail.com";
-- Find students who live in a state with exactly 5 letters.
select * from student where length(state) = 5;
-- List students whose first and last names start with the same letter.
-- Fetch the GPA of the student(s) with the highest GPA.
select * from student order by gpa desc limit 2;
select * from student where gpa = (select max(gpa) from student);
-- Fetch all students who have no GPA recorded.
select * from student where gpa is null;
-- Get students whose branch is not in CSE, IT, or ECE.
select * from student where branch not in("cse","it","ece");
--  Find students who have the longest name.
select * from student where length(name) = (select max(length(name)) from student);
-- List students with a GPA higher than the average GPA of their branch.
select * from student s where gpa > (select avg(gpa) from student where s.branch = branch);
-- Show students where name is the same as email prefix.
select * from student where name;
-- Fetch students whose GPA is above average, but not the highest.
select * from student 
where gpa > (select avg(gpa) from student) 
and gpa  < (select max(gpa) from student);
-- Find students whose branch has fewer than 3 students.
select * from student
where branch in
(select branch from student group by branch having count(*) <3);














