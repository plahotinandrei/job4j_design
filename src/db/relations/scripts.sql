/* one to one */

create table person(
    id serial primary key,
    firstname varchar(255),
    lastname varchar(255),
    age integer,
    requisites integer,
    email varchar(255)
);

insert into person(firstname, lastname, age, requisites, email) values('Андрей', 'Плахотин', 28, 2289000, 'plahotin@gmail.com');

select * from person;

create table personage(
    id serial primary key,
    nickname varchar(255),
    level int,
    class varchar(255),
    person_id int references person(id) unique
);

insert into personage(nickname, level, class, person_id) values('Raven', 10, 'human', 1);

select * from personage;

/* many to many */

create table players(
    id serial primary key,
    nickname varchar(255) unique
);

insert into players(nickname) values('User21');
insert into players(nickname) values('Raven');
insert into players(nickname) values('Jack777');

select * from players;

create table tournaments(
    id serial primary key,
    title varchar(255) unique
);

insert into tournaments(title) values('Blackjack');
insert into tournaments(title) values('Roulette');
insert into tournaments(title) values('Slots');

select * from tournaments;

create table players_tournaments(
    id serial primary key,
    players_id int references players(id),
    tournaments_id int references tournaments(id)
);

insert into players_tournaments(players_id, tournaments_id) values (1, 1);
insert into players_tournaments(players_id, tournaments_id) values (1, 2);
insert into players_tournaments(players_id, tournaments_id) values (1, 3);
insert into players_tournaments(players_id, tournaments_id) values (2, 1);
insert into players_tournaments(players_id, tournaments_id) values (2, 2);
insert into players_tournaments(players_id, tournaments_id) values (3, 3);

select * from players_tournaments;

/* many to one */

create table users(
    id serial primary key,
    firstname varchar(255),
    lastname varchar(255)
);

insert into users(firstname, lastname) values ('Андрей', 'Плахотин');

select * from users;

create table social_networks(
    id serial primary key,
    title varchar(255),
    link varchar(255),
    user_id int references users(id)
);

insert into social_networks(title, link, user_id) values ('fb', 'fb.com/123', 1);
insert into social_networks(title, link, user_id) values ('vk', 'vk.ru/4563', 1);
insert into social_networks(title, link, user_id) values ('instagram', 'instagram.com/313', 1);

select * from social_networks;
