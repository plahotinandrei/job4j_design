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

create view show_types_products_less_than_5
    as select t.name as type, count(p.id) as amount
        from product as p
        join type as t on p.type_id = t.id
        group by t.name
        having count(p.id) < 5;

select * from show_types_products_less_than_5;