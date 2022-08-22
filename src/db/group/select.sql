select avg(price) from devices;
select p.name as "Имя", avg(d.price) as "Средняя цена устройств" from devices_people as dp
join people as p on dp.people_id = p.id join devices as d on dp.device_id = d.id group by p.name having avg(d.price) > 5000