CREATE DATABASE IF NOT EXISTS cinema;
USE cinema;
CREATE TABLE IF NOT EXISTS roles
(
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR(80) NOT NULL,
	delete_flag BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user
(
	id INTEGER NOT NULL AUTO_INCREMENT,
    account VARCHAR(30) NOT NULL,
    password VARCHAR(60) NOT NULL,
    delete_flag BOOLEAN DEFAULT FALSE,
    role_id INTEGER NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(role_id) REFERENCES roles(id)
);

CREATE TABLE IF NOT EXISTS movie
(
	id INTEGER NOT NULL AUTO_INCREMENT,
    duration INTEGER  NOT NULL,
    title VARCHAR(256) NOT NULL,
    delete_flag BOOLEAN DEFAULT FALSE,
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS hall
(
	id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL,
    delete_flag BOOLEAN DEFAULT FALSE,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS seat
(
	id INTEGER NOT NULL AUTO_INCREMENT,
    row INTEGER NOT NULL,
    col INTEGER NOT NULL,
    hall_id INTEGER NOT NULL,
    delete_flag BOOLEAN DEFAULT FALSE,
    PRIMARY KEY(id),
    FOREIGN KEY(hall_id) REFERENCES hall(id)
);

CREATE TABLE IF NOT EXISTS projection
(
	id INTEGER NOT NULL AUTO_INCREMENT,
    start_time DATETIME NOT NULL,
    hall_id INTEGER NOT NULL,
    movie_id INTEGER NOT NULL,
    delete_flag BOOLEAN DEFAULT FALSE,
    PRIMARY KEY(id),
    FOREIGN KEY(hall_id) REFERENCES hall(id),
    FOREIGN KEY(movie_id) REFERENCES movie(id)
);

CREATE TABLE IF NOT EXISTS reservation
(
	id INTEGER NOT NULL AUTO_INCREMENT,
    status INTEGER NOT NULL,
    seat_price INTEGER,
    blocked_time DATETIME NOT NULL,
	user_id INTEGER NOT NULL,
    projection_id INTEGER NOT NULL,
    seat_id INTEGER NOT NULL,
    delete_flag BOOLEAN DEFAULT FALSE,
    PRIMARY KEY(id),
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (projection_id) REFERENCES projection(id),
    FOREIGN KEY (seat_id) REFERENCES seat(id)
);


INSERT INTO roles(name) VALUE ('user');
INSERT INTO roles(name) VALUES('admin');

INSERT INTO user(account, password, role_id)
VALUES('user1', '$2a$06$33F8qcSI5789jAc4tOh9cOtm4K0fPlQwTRzeB/qgjdmrTP1MxuOoC', (SELECT id FROM roles WHERE name LIKE 'user'));

INSERT INTO user(account, password, role_id)
VALUES('admin1', '$2a$06$33F8qcSI5789jAc4tOh9cOtm4K0fPlQwTRzeB/qgjdmrTP1MxuOoC', (SELECT id FROM roles WHERE name LIKE 'admin'));

INSERT INTO movie(duration, title) VALUES(161, 'Harry Potter and the Chamber of Secrets');
INSERT INTO movie(duration, title) VALUES(108, 'Deadpool');
INSERT INTO movie(duration, title) VALUES(123, 'Warcraft');

INSERT INTO hall(name) VALUE('hall1');
INSERT INTO hall(name) VALUE('hall2');
INSERT INTO hall(name) VALUE('hall3');

/*SEATS FOR hall1*/
INSERT INTO seat(row, col, hall_id) VALUES(1,1, (SELECT id FROM hall WHERE name LIKE 'hall1'));
INSERT INTO seat(row, col, hall_id) VALUES(1,2, (SELECT id FROM hall WHERE name LIKE 'hall1'));
INSERT INTO seat(row, col, hall_id) VALUES(1,3, (SELECT id FROM hall WHERE name LIKE 'hall1'));
INSERT INTO seat(row, col, hall_id) VALUES(1,4, (SELECT id FROM hall WHERE name LIKE 'hall1'));
INSERT INTO seat(row, col, hall_id) VALUES(1,5, (SELECT id FROM hall WHERE name LIKE 'hall1'));
INSERT INTO seat(row, col, hall_id) VALUES(2,1, (SELECT id FROM hall WHERE name LIKE 'hall1'));
INSERT INTO seat(row, col, hall_id) VALUES(2,2, (SELECT id FROM hall WHERE name LIKE 'hall1'));
INSERT INTO seat(row, col, hall_id) VALUES(2,3, (SELECT id FROM hall WHERE name LIKE 'hall1'));
INSERT INTO seat(row, col, hall_id) VALUES(2,4, (SELECT id FROM hall WHERE name LIKE 'hall1'));
INSERT INTO seat(row, col, hall_id) VALUES(2,5, (SELECT id FROM hall WHERE name LIKE 'hall1'));
INSERT INTO seat(row, col, hall_id) VALUES(3,1, (SELECT id FROM hall WHERE name LIKE 'hall1'));
INSERT INTO seat(row, col, hall_id) VALUES(3,2, (SELECT id FROM hall WHERE name LIKE 'hall1'));
INSERT INTO seat(row, col, hall_id) VALUES(3,3, (SELECT id FROM hall WHERE name LIKE 'hall1'));
INSERT INTO seat(row, col, hall_id) VALUES(3,4, (SELECT id FROM hall WHERE name LIKE 'hall1'));
INSERT INTO seat(row, col, hall_id) VALUES(3,5, (SELECT id FROM hall WHERE name LIKE 'hall1'));
/*SEATS FOR hall2*/
INSERT INTO seat(row, col, hall_id) VALUES(1,1, (SELECT id FROM hall WHERE name LIKE 'hall2'));
INSERT INTO seat(row, col, hall_id) VALUES(1,2, (SELECT id FROM hall WHERE name LIKE 'hall2'));
INSERT INTO seat(row, col, hall_id) VALUES(1,3, (SELECT id FROM hall WHERE name LIKE 'hall2'));
INSERT INTO seat(row, col, hall_id) VALUES(1,4, (SELECT id FROM hall WHERE name LIKE 'hall2'));
INSERT INTO seat(row, col, hall_id) VALUES(1,5, (SELECT id FROM hall WHERE name LIKE 'hall2'));
INSERT INTO seat(row, col, hall_id) VALUES(2,1, (SELECT id FROM hall WHERE name LIKE 'hall2'));
INSERT INTO seat(row, col, hall_id) VALUES(2,2, (SELECT id FROM hall WHERE name LIKE 'hall2'));
INSERT INTO seat(row, col, hall_id) VALUES(2,3, (SELECT id FROM hall WHERE name LIKE 'hall2'));
INSERT INTO seat(row, col, hall_id) VALUES(2,4, (SELECT id FROM hall WHERE name LIKE 'hall2'));
INSERT INTO seat(row, col, hall_id) VALUES(2,5, (SELECT id FROM hall WHERE name LIKE 'hall2'));
INSERT INTO seat(row, col, hall_id) VALUES(3,1, (SELECT id FROM hall WHERE name LIKE 'hall2'));
INSERT INTO seat(row, col, hall_id) VALUES(3,2, (SELECT id FROM hall WHERE name LIKE 'hall2'));
INSERT INTO seat(row, col, hall_id) VALUES(3,3, (SELECT id FROM hall WHERE name LIKE 'hall2'));
INSERT INTO seat(row, col, hall_id) VALUES(3,4, (SELECT id FROM hall WHERE name LIKE 'hall2'));
INSERT INTO seat(row, col, hall_id) VALUES(3,5, (SELECT id FROM hall WHERE name LIKE 'hall2'));
/*SEATS FOR hall3*/
INSERT INTO seat(row, col, hall_id) VALUES(1,1, (SELECT id FROM hall WHERE name LIKE 'hall3'));
INSERT INTO seat(row, col, hall_id) VALUES(1,2, (SELECT id FROM hall WHERE name LIKE 'hall3'));
INSERT INTO seat(row, col, hall_id) VALUES(1,3, (SELECT id FROM hall WHERE name LIKE 'hall3'));
INSERT INTO seat(row, col, hall_id) VALUES(1,4, (SELECT id FROM hall WHERE name LIKE 'hall3'));
INSERT INTO seat(row, col, hall_id) VALUES(1,5, (SELECT id FROM hall WHERE name LIKE 'hall3'));
INSERT INTO seat(row, col, hall_id) VALUES(2,1, (SELECT id FROM hall WHERE name LIKE 'hall3'));
INSERT INTO seat(row, col, hall_id) VALUES(2,2, (SELECT id FROM hall WHERE name LIKE 'hall3'));
INSERT INTO seat(row, col, hall_id) VALUES(2,3, (SELECT id FROM hall WHERE name LIKE 'hall3'));
INSERT INTO seat(row, col, hall_id) VALUES(2,4, (SELECT id FROM hall WHERE name LIKE 'hall3'));
INSERT INTO seat(row, col, hall_id) VALUES(2,5, (SELECT id FROM hall WHERE name LIKE 'hall3'));
INSERT INTO seat(row, col, hall_id) VALUES(3,1, (SELECT id FROM hall WHERE name LIKE 'hall3'));
INSERT INTO seat(row, col, hall_id) VALUES(3,2, (SELECT id FROM hall WHERE name LIKE 'hall3'));
INSERT INTO seat(row, col, hall_id) VALUES(3,3, (SELECT id FROM hall WHERE name LIKE 'hall3'));
INSERT INTO seat(row, col, hall_id) VALUES(3,4, (SELECT id FROM hall WHERE name LIKE 'hall3'));
INSERT INTO seat(row, col, hall_id) VALUES(3,5, (SELECT id FROM hall WHERE name LIKE 'hall3'));

INSERT INTO projection(hall_id, start_time, movie_id) 
VALUES(
	(SELECT id FROM hall WHERE name LIKE 'hall1'),
    current_time(),
    (SELECT id FROM movie WHERE title LIKE 'Harry Potter and the Chamber of Secrets')
);

INSERT INTO projection(hall_id, start_time, movie_id) 
VALUES(
	(SELECT id FROM hall WHERE name LIKE 'hall2'),
    current_time(),
    (SELECT id FROM movie WHERE title LIKE 'Deadpool')
);

INSERT INTO projection(hall_id, start_time, movie_id) 
VALUES(
	(SELECT id FROM hall WHERE name LIKE 'hall3'),
    current_time(),
    (SELECT id FROM movie WHERE title LIKE 'Warcraft')
);

