create table departments(
    id serial primary key,
    name varchar(255)
);

create table employees(
    id serial primary key,
    name varchar(255),
    departments_id int references departments(id)
);

insert into departments(name)
    values ('Департамент 1'), ('Департамент 2'), ('Департамент 3'),
    ('Департамент 4'), ('Департамент 5'), ('Департамент 6'),
    ('Департамент 7'), ('Департамент 8'), ('Департамент 9');

insert into employees(name, departments_id)
    values ('Иван', 1), ('Андрей', 2), ('Петр', 3),
    ('Анатолий', 5), ('Мария', 7), ('Свеилана', 9),
    ('Елена', null), ('Артур', null), ('Дмитрий', null);

select e.name, d.name as department from employees as e
    left join departments as d on e.departments_id = d.id;
select e.name, d.name as department from employees as e
    right join departments as d on e.departments_id = d.id;
select e.name, d.name as department from employees as e
    full join departments as d on e.departments_id = d.id;
select e.name, d.name as department from employees as e
    cross join departments as d;

select d.name as department from departments as d
    left join employees as e on e.departments_id = d.id
    where e.name is null;

select e.name, d.name as department from employees as e
    left join departments as d on e.departments_id = d.id;
select e.name, d.name as department from departments as d
    right join employees as e on e.departments_id = d.id;

create table teens(
    id serial primary key,
    name varchar(255),
    gender varchar(255)
);

insert into teens(name, gender)
    values ('Иван', 'М'), ('Андрей', 'М'), ('Петр', 'М'),
    ('Анатолий', 'М'), ('Мария', 'Ж'), ('Свеилана', 'Ж'), ('Елена', 'Ж');

select t1.name, t1.gender, t2.name, t2.gender from teens as t1
    cross join teens as t2
    where t2.gender = 'Ж' and t1.gender != t2.gender;