create table customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);

insert into customers(first_name, last_name, age, country) values ('Анна', 'Медведева', 29, 'Польша');
insert into customers(first_name, last_name, age, country) values ('Тимур', 'Романов', 35, 'Россия');
insert into customers(first_name, last_name, age, country) values ('Фёдор', 'Жданов', 41, 'Казахстан');
insert into customers(first_name, last_name, age, country) values ('Артём', 'Зайцев', 22, 'США');
insert into customers(first_name, last_name, age, country) values ('Арсений', 'Соколов', 18, 'Канада');
insert into customers(first_name, last_name, age, country) values ('Анастасия', 'Тарасова', 41, 'Польша');
insert into customers(first_name, last_name, age, country) values ('Артур', 'Николаев', 18, 'Россия');
insert into customers(first_name, last_name, age, country) values ('Вероника', 'Соболева', 36, 'США');
insert into customers(first_name, last_name, age, country) values ('Юлия', 'Верещагина', 30, 'Канада');
insert into customers(first_name, last_name, age, country) values ('Андрей', 'Щербаков', 24, 'Россия');

select * from customers where age=(select min(age) from customers);

create table orders(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);

insert into orders(amount, customer_id) values (2, 1);
insert into orders(amount, customer_id) values (1, 3);
insert into orders(amount, customer_id) values (3, 4);
insert into orders(amount, customer_id) values (2, 6);
insert into orders(amount, customer_id) values (2, 8);
insert into orders(amount, customer_id) values (1, 9);

select * from customers as c where c.id not in (select customer_id from orders);