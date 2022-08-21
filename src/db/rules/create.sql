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

create table rules(
    id serial primary key,
    title varchar(255)
);

create table role_rules(
    id serial primary key,
    role_id integer references role(id),
    rules_id integer references rules(id)
);

create table category(
    id serial primary key,
    title varchar(255)
);

create table state(
    id serial primary key,
    title varchar(255)
);

create table item(
    id serial primary key,
    title varchar(255),
    description text,
    users_id integer references users(id),
    category_id integer references category(id),
    state_id integer references state(id)
);

create table comments(
    id serial primary key,
    description text,
    item_id integer references item(id)
);

create table attachs(
    id serial primary key,
    title varchar(255),
    link varchar(255),
    item_id integer references item(id)
);