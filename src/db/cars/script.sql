create table car_bodies(
    id serial primary key,
    name varchar(255)
);

create table car_engines(
    id serial primary key,
    name varchar(255)
);

create table car_transmissions(
    id serial primary key,
    name varchar(255)
);

create table cars(
    id serial primary key,
    name varchar(255),
    body_id int references car_bodies(id),
    engine_id int references car_engines(id),
    transmission_id int references car_transmissions(id)
);

insert into car_bodies(name)
    values ('седан'), ('хэтчбек'), ('универсал'), ('пикап'), ('кроссовер');
insert into car_engines(name)
    values ('v8'), ('v6'), ('гибрид'), ('электродвигатель');
insert into car_transmissions(name)
    values ('автоматическая'), ('механическая'), ('вариатор');
insert into cars(name, body_id, engine_id, transmission_id)
    values ('bmw', 1, 2, 1), ('kia', 2, 3, 2), ('toyota', 4, 1, 1),
    ('honda', 4, null, 2), ('ford', 1, 3, 1), ('chevrolet', 3, 3, 2),
    ('nissan', 1, 1, 1), ('mazda', null, 2, 2), ('subaru', 1, 2, 1),
    ('renault', 2, 1, 2), ('volkswagen', 1, 2, 2), ('mercedes', 3, 3, null);

select c.id, c.name as car_name, b.name as body_name, e.name as engine_name, t.name as transmission_name
    from cars as c
    left join car_bodies as b on c.body_id = b.id
    left join car_engines as e on c.engine_id = e.id
    left join car_transmissions as t on c.transmission_id = t.id;
select b.id, b.name from cars as c
    right join car_bodies as b on c.body_id = b.id
    where c.name is null;
select e.id, e.name from cars as c
    right join car_engines as e on c.engine_id = e.id
    where c.name is null;
select t.id, t.name from cars as c
    right join car_transmissions as t on c.transmission_id = t.id
    where c.name is null;