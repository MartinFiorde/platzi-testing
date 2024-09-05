CREATE TABLE IF NOT EXISTS movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    director VARCHAR(50) NOT NULL,
    minutes INT NOT NULL,
    genre VARCHAR(50) NOT NULL
);

insert into movies (name, director, minutes, genre)
values ('Dark Knight', 'Director 1', 152, 'ACTION'), ('Memento', 'Director 2', 113, 'THRILLER'), ('Matrix', 'Director 3', 136, 'ACTION');
