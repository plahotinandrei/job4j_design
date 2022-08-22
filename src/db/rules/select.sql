select u.firstname, u.lastname, r.title from users as u join role as r on u.role_id = r.id;

select i.title as "Заголовок", i.description as "Описание", u.firstname as "Имя", u.lastname as "Фамилия" from item as i
join users as u on i.users_id = u.id;

select u.firstname as Имя, u.lastname as Фамилия, r.title as Роль from users as u join role as r on u.role_id = r.id;