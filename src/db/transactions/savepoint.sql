create table accounts(
    id serial primary key,
    owner varchar(50),
    balance integer
);

insert into accounts (owner, balance) values ('user_1', 100);
insert into accounts (owner, balance) values ('user_2', 70);
insert into accounts (owner, balance) values ('user_3', 120);

begin transaction;

insert into accounts (owner, balance) values ('user_4', 210);
savepoint first_savepoint;
delete from accounts where owner = 'user_1';
savepoint second_savepoint;
update accounts set balance = 80 where owner = 'user_2';
select * from accounts;
rollback to savepoint second_savepoint;
select * from accounts;
rollback to savepoint first_savepoint;
select * from accounts;
delete from accounts where owner = 'user_2';
savepoint third_savepoint;
insert into accounts (owner, balance) values ('user_5', 220);
release savepoint third_savepoint;

commit;

select * from accounts;