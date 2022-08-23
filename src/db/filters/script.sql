create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
    type_id int references type(id),
    expired_date date,
    price float
);

insert into type(name)
    values ('Сыр'), ('Молоко'), ('Мороженое'), ('Масло'), ('Творог');

insert into product(name, type_id, expired_date, price)
    values ('молоко простоквашино', 2, '2022-09-24', 87),
    ('сыр российский', 1, '2022-10-15', 180),
    ('мороженое чистая линия', 3, '2022-11-12', 77),
    ('масло подсолнечное злато', 4, '2023-12-01', 91),
    ('мороженое золотой стандарт', 3, '2022-07-15', 65),
    ('масло подсолнечное золотая семечка', 4, '2022-05-01', 91),
    ('сыр плавленный hochland', 1, '2023-01-10', 126),
    ('творог савушкин', 5, '2023-02-06', 180),
    ('молоко топленое', 2, '2022-10-21', 115),
    ('сыр творожный Violette', 1, '2022-10-15', 102);

select p.name, t.name as type, expired_date, price from product as p
    join type as t on p.type_id = t.id
    where t.name = 'Сыр';
select * from product where name like '%мороженое%';
select * from product where expired_date < current_date;
select * from product
    where price = (select max(price) from product);
select t.name as имя_типа, count(p.id) as количество
    from product as p
    join type as t on p.type_id = t.id
    group by t.name;
select p.name, t.name as type, expired_date, price from product as p
    join type as t on p.type_id = t.id
    where t.name = 'Сыр' or t.name = 'Молоко';
select t.name as имя_типа, count(p.id) as количество
    from product as p
    join type as t on p.type_id = t.id
    group by t.name
    having count(p.id) < 10;
select p.name, t.name as type, p.expired_date, p.price
    from product as p
    join type as t on p.type_id = t.id;