create table person(
    id serial primary key,
    name varchar(255),
    age integer,
    email varchar(255)
);

insert into person (name, age, email) values ('person_1', 30, 'email_1');
insert into person (name, age, email) values ('person_2', 25, 'email_2');
insert into person (name, age, email) values ('person_3', 29, 'email_3');

--read committed
begin transaction;

select * from person;
insert into person (name, age, email) values ('person_4', 35, 'email_4');
delete from person where age = 30;
update person set name = 'person_22' where age = 25;

select * from person;

commit;

--repeatable read
begin transaction isolation level repeatable read;

select * from person;
insert into person (name, age, email) values ('person_5', 32, 'email_5');
delete from person where age = 25;
update person set name = 'person_33' where age = 29;
select * from person;

commit;

--serializable
begin transaction isolation level serializable;

select * from person;

select avg(age) from person;
update person set age = 21 where name = 'person_33';

commit;