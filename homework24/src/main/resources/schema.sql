create table goods (
                       id serial primary key,
                       description varchar(20),
                       price decimal(15, 4) check (price > 0),
                       quantity_left integer check (quantity_left > 0)
);

insert into goods(description, price, quantity_left) values ('Стол', 1500, 50);
insert into goods(description, price, quantity_left) values ('Стул', 500, 100);
insert into goods(description, price, quantity_left) values ('Шкаф', 2500, 20);
insert into goods(description, price, quantity_left) values ('Кровать', 2000, 30);


create table customer (
                          id serial primary key,
                          name_surname varchar(20)
);

insert into customer(name_surname) values ('Иванов Иван');
insert into customer(name_surname) values ('Михайлов Михаил');
insert into customer(name_surname) values ('Сергеев Сергей');
insert into customer(name_surname) values ('Антонов Антон');
insert into customer(name_surname) values ('Андреев Андрей');

create table orders (
                        good_id integer,
                        foreign key (good_id) references goods(id),
                        customer_id integer,
                        foreign key (customer_id) references customer(id),
                        date date,
                        quantity integer check (quantity > 0)
);

insert into orders(good_id, customer_id, date, quantity) values (1, 1, '2021-11-01', 1);
insert into orders(good_id, customer_id, date, quantity) values (2, 1, '2021-11-01', 4);
insert into orders(good_id, customer_id, date, quantity) values (3, 1, '2021-11-05', 2);
insert into orders(good_id, customer_id, date, quantity) values (1, 2, '2021-11-03', 1);
insert into orders(good_id, customer_id, date, quantity) values (2, 2, '2021-11-04', 2);
insert into orders(good_id, customer_id, date, quantity) values (4, 2, '2021-11-04', 1);
insert into orders(good_id, customer_id, date, quantity) values (3, 3, '2021-11-10', 4);
insert into orders(good_id, customer_id, date, quantity) values (4, 3, '2021-11-10', 4);
insert into orders(good_id, customer_id, date, quantity) values (1, 4, '2021-11-04', 10);
insert into orders(good_id, customer_id, date, quantity) values (2, 4, '2021-11-04', 40);


-- показать все заказы в формате кто - когда - что - сколько
select (select name_surname from customer where id = orders.customer_id), date, (select description from goods where id = orders.good_id), quantity from orders;

-- тоже самое через join
select name_surname, date, description, quantity from (select * from (select * from orders o join customer c on o.customer_id = c.id) as foo join goods as g on foo.good_id = g.id) as foo2;

-- показать все заказы стульев (дата, имя, количество) отсортированные по дате
select date, (select name_surname from customer where id = orders.customer_id), quantity as "quantity of chairs" from orders where good_id = 2 order by date;

--показать на какую сумму продано каждого товара
select description, sum (quantity*price) from orders o join goods g on o.good_id = g.id group by description;