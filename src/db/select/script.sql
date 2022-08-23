create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values ('Canada goose', 4000, '1983-06-24');
insert into fauna(name, avg_age, discovery_date) values ('Squirrel, pine', 8000, '1985-03-26');
insert into fauna(name, avg_age, discovery_date) values ('Eurasian beaver', 25000, '2010-05-24');
insert into fauna(name, avg_age, discovery_date) values ('Booby, masked', 13000, '1992-12-16');
insert into fauna(name, avg_age, discovery_date) values ('African skink', 21000, '1998-09-22');
insert into fauna(name, avg_age, discovery_date) values ('Swordfish, red-necked', 24000, '1926-08-20');
insert into fauna(name, avg_age, discovery_date) values ('Kookaburra, laughing', 13000, '1971-09-18');
insert into fauna(name, avg_age, discovery_date) values ('Asiatic wild ass', 9000, null);
insert into fauna(name, avg_age, discovery_date) values ('Pintail, bahama', 9000, '1992-09-19');

select * from fauna where name like '%fish%';
select * from fauna where avg_age >=10000 and avg_age <= 20000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '01.01.1950';