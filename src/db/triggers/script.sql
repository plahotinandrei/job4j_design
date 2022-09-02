create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace function tax()
    returns trigger as
    $$
        BEGIN
            update products
            set price = price + price * 0.2
            where id = (select id from inserted);
            return NEW;
        END;
    $$
LANGUAGE 'plpgsql';

create trigger tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax();

insert into products (name, producer, count, price) values ('milk', 'valio', 3, 150);

create or replace function tax_2()
    returns trigger as
$$
    BEGIN
        NEW.price = NEW.price + NEW.price * 0.05;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_2_trigger
    before insert
    on products
    for each row
    execute procedure tax_2();

insert into products (name, producer, count, price) values ('cheese', 'valio', 2, 100);

create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create or replace function add_to_history()
    returns trigger as
$$
    BEGIN
        insert into history_of_price (name, price, date)
        values (NEW.name, NEW.price, now());
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger insert_trigger
    after insert on products
    for each row
    execute procedure add_to_history();

insert into products (name, producer, count, price) values ('yogurt', 'valio', 4, 80);