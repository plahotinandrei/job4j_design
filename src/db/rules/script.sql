create table role(
    id serial primary key,
    title varchar(255)
);

create table users(
    id serial primary key,
    firstname varchar(255),
    lastname varchar(255),
    role_id integer references role(id)
);

create table item(
    id serial primary key,
    title varchar(255),
    description text,
    users_id integer references users(id)
);

insert into role(title) values('Менеджер по продажам');
insert into role(title) values('Старший менеджер по продажам');
insert into role(title) values('Руководитель отдела');

insert into users(firstname, lastname, role_id) values('Иван', 'Иванов', 1);
insert into users(firstname, lastname, role_id) values('Светлана', 'Петрова', 1);
insert into users(firstname, lastname, role_id) values('Дмитрий', 'Терентьев', 1);
insert into users(firstname, lastname, role_id) values('Денис', 'Павлов', 2);
insert into users(firstname, lastname, role_id) values('Василий', 'Сидоров', 3);

insert into item(title, description, users_id) values('Позввонить клиенту X', 'Уточнить детали по заказу 1', 1);
insert into item(title, description, users_id) values('Позввонить клиенту Y', 'Уточнить детали по заказу 2', 2);
insert into item(title, description, users_id) values('Позввонить клиенту Z', 'Уточнить детали по заказу 3', 3);
insert into item(title, description, users_id) values('Договориться о доставке ....', 'Детали...', 4);
insert into item(title, description, users_id) values('Обучение сотрудников отдела', 'Детали...', 5);

select u.firstname, u.lastname, r.title from users as u
    join role as r on u.role_id = r.id;

select i.title as "Заголовок", i.description as "Описание", u.firstname as "Имя", u.lastname as "Фамилия"
    from item as i
    join users as u on i.users_id = u.id;

select u.firstname as Имя, u.lastname as Фамилия, r.title as Роль
    from users as u
    join role as r on u.role_id = r.id;