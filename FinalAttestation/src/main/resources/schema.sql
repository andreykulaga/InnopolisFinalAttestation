CREATE TABLE "user" (
                        id serial primary key,
                        email varchar(30),
                        password varchar(50)
);

CREATE TABLE movie (
                       id serial primary key,
                       title varchar(30),
                       release_date date check (release_date > '1896-01-06'),
                       genre varchar(10),
                       medium_score decimal(3, 1) check (medium_score between 0 and 10)
);

CREATE TABLE actor (
                       id serial primary key,
                       first_name varchar(15),
                       last_name varchar(15),
                       birthday date check (birthday > '1870-01-01')
);

CREATE TABLE actor_of_movie (
                                movie_id integer,
                                actor_id integer,
                                foreign key (movie_id) references movie(id),
                                foreign key (actor_id) references actor(id)
);

INSERT INTO movie (title, release_date, genre, medium_score)VALUES ('Зеленая миля', '1999-12-06', 'Драма', 10);
INSERT INTO movie (title, release_date, genre, medium_score)VALUES ('Форрест Гамп', '1994-06-23', 'Драма', 9.5);
INSERT INTO movie (title, release_date, genre, medium_score)VALUES ('Изгой', '2000-12-07', 'Драма', 9);
INSERT INTO movie (title, release_date, genre, medium_score)VALUES ('Скала', '1996-06-07', 'Боевик', 8);
INSERT INTO movie (title, release_date, genre, medium_score)VALUES ('Танцующая в темноте', '2000-09-28', 'Мюзикл', 7);


INSERT INTO actor (first_name, last_name, birthday) VALUES ('Том', 'Хэнкс', '1956-07-09');
INSERT INTO actor (first_name, last_name, birthday) VALUES ('Хелен', 'Хант', '1963-06-15');
INSERT INTO actor (first_name, last_name, birthday) VALUES ('Дэвид', 'Морс', '1953-10-11');
INSERT INTO actor (first_name, last_name, birthday) VALUES ('Бьорк', '', '1965-11-21');

INSERT INTO actor_of_movie (movie_id, actor_id) VALUES (1, 1);
INSERT INTO actor_of_movie (movie_id, actor_id) VALUES (1, 3);
INSERT INTO actor_of_movie (movie_id, actor_id) VALUES (2, 1);
INSERT INTO actor_of_movie (movie_id, actor_id) VALUES (3, 1);
INSERT INTO actor_of_movie (movie_id, actor_id) VALUES (3, 2);
INSERT INTO actor_of_movie (movie_id, actor_id) VALUES (4, 3);
INSERT INTO actor_of_movie (movie_id, actor_id) VALUES (5, 3);
INSERT INTO actor_of_movie (movie_id, actor_id) VALUES (5, 4);
