--read committed
begin transaction;

select * from person;

select * from person;

select * from person;

commit;

--repeatable read
begin transaction isolation level repeatable read;

update person set name = 'person_33' where age = 29;

commit;

--serializable
begin transaction isolation level serializable;

select * from person;

select avg(age) from person;
update person set age = 45 where name = 'person_5';

commit;
