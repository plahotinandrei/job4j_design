CREATE TABLE company (
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person (
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name)
    values (1, 'MTS'), (2, 'Megafon'), (3, 'Tele2'), (4, 'Beeline'), (5, 'RTK');

insert into person(id, name, company_id) values (1, 'Иван', 2);
insert into person(id, name, company_id) values (2, 'Андрей', 4);
insert into person(id, name, company_id) values (3, 'Петр', 4);
insert into person(id, name, company_id) values (4, 'Анатолий', 1);
insert into person(id, name, company_id) values (5, 'Мария', 3);
insert into person(id, name, company_id) values (6, 'Светлана', 5);
insert into person(id, name, company_id) values (7, 'Елена', 5);
insert into person(id, name, company_id) values (8, 'Артур', 4);
insert into person(id, name, company_id) values (9, 'Дмитрий', 1);
insert into person(id, name, company_id) values (10, 'Евгений', 1);

select p.name, c.name as company from person as p
    join company as c on p.company_id = c.id
    where p.company_id != 5;

select c.name as company, count(*) as persons from person as p
    join company as c on p.company_id = c.id
    group by c.name
    having count(*) = (select count(*) from person
        group by company_id
        order by count desc limit 1);