create table movie (
    id SERIAL PRIMARY KEY,
    name text,
    director text
);

create table book (
    id SERIAL PRIMARY KEY,
    title text,
    author text
);

insert into movie (name, director)
values ('Марсианин', 'Ридли Скотт'),
       ('Матрица', 'Братья Вачовски'),
       ('Властелин колец', 'Питер Джексон'),
       ('Гарри Поттер и узник Азкабана', 'Альфонсо Куарон'),
       ('Железный человек', 'Джон Фавро');

insert into book (title, author)
values ('Гарри Поттер и узник Азкабана', 'Джоан Роулинг'),
       ('Властелин колец', 'Джон Толкин'),
       ('1984', 'Джордж Оруэлл'),
       ('Марсианин', 'Энди Уир'),
       ('Божественная комедия', 'Данте Алигьери');

select name from movie
intersect
select title from book;

select title from book
except
select name from movie;

select name from movie
union all
select title from book
except
(select name from movie
intersect
select title from book);