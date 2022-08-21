insert into role(title) values('Менеджер по продажам');
insert into role(title) values('Старший менеджер по продажам');
insert into role(title) values('Руководитель отдела');

insert into users(firstname, lastname, role_id) values('Иван', 'Иванов', 1);
insert into users(firstname, lastname, role_id) values('Светлана', 'Петрова', 1);
insert into users(firstname, lastname, role_id) values('Дмитрий', 'Терентьев', 1);
insert into users(firstname, lastname, role_id) values('Денис', 'Павлов', 2);
insert into users(firstname, lastname, role_id) values('Василий', 'Сидоров', 3);

insert into rules(title) values('Взять в работу');
insert into rules(title) values('Изменить приоритет');
insert into rules(title) values('Закрыть');

insert into role_rules(role_id, rules_id) values(1, 1);
insert into role_rules(role_id, rules_id) values(2, 1);
insert into role_rules(role_id, rules_id) values(2, 2);
insert into role_rules(role_id, rules_id) values(3, 1);
insert into role_rules(role_id, rules_id) values(3, 2);
insert into role_rules(role_id, rules_id) values(3, 3);

insert into category(title) values('Нормальная');
insert into category(title) values('Приоритетная');
insert into category(title) values('Критичная');

insert into state(title) values('Запланирована');
insert into state(title) values('В работе');
insert into state(title) values('Закрыта');

insert into item(title, description, users_id, category_id, state_id) values('Позввонить клиенту X', 'Уточнить детали по заказу 1', 1, 2, 2);
insert into item(title, description, users_id, category_id, state_id) values('Позввонить клиенту Y', 'Уточнить детали по заказу 2', 2, 1, 1);
insert into item(title, description, users_id, category_id, state_id) values('Позввонить клиенту Z', 'Уточнить детали по заказу 3', 3, 2, 3);
insert into item(title, description, users_id, category_id, state_id) values('Договориться о доставке ....', 'Детали...', 4, 3, 2);
insert into item(title, description, users_id, category_id, state_id) values('Обучение сотрудников отдела', 'Детали...', 5, 1, 2);

insert into comments(description, item_id) values('Коммент 1 ...', 2);
insert into comments(description, item_id) values('Коммент 2 ...', 4);

insert into attachs(title, link, item_id) values('Photo 1', '/files/items/order1/photo3.jpg', 1);
insert into attachs(title, link, item_id) values('Plan 12', '/files/items/learn/plan12.pdf', 5);