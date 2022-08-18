create table employees(
    id serial primary key,
    firstname varchar(255),
    lastname varchar(255),
    age integer,
    position text
);

insert into employees(firstname, lastname, age, position) values('Андрей', 'Плахотин', 28, 'Java developer');

select * from employees;

update employees set position = 'Junior java developer';

delete from employees;