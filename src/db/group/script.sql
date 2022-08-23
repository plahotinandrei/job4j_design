create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price)
    values ('Монитор', 14099),
    ('Смартфон', 31030),
    ('Часы', 10202),
    ('Ноутбук', 121310),
    ('Наушники', 5600),
    ('Мышь', 2300);

insert into people(name)
    values ('Иван'), ('Петр'), ('Дарья'), ('Андрей'), ('Светлана'), ('Дмитрий');

insert into devices_people(device_id, people_id)
    values (1, 1), (1, 3), (1, 4), (2, 1), (2, 2),
    (2, 3), (2, 4), (2, 5), (2, 6),
    (3, 6), (4, 2), (4, 3), (4, 5),
    (5, 3), (6, 2), (6, 3), (6, 5);

select avg(price) from devices;

select p.name as "Имя", avg(d.price) as "Средняя цена устройств"
    from devices_people as dp
    join people as p on dp.people_id = p.id
    join devices as d on dp.device_id = d.id
    group by p.name;

select p.name as "Имя", avg(d.price) as "Средняя цена устройств"
    from devices_people as dp
    join people as p on dp.people_id = p.id
    join devices as d on dp.device_id = d.id
    group by p.name
    having avg(d.price) > 5000