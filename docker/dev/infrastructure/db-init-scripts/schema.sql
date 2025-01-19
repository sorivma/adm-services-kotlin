CREATE EXTENSION IF NOT EXISTS  "uuid-ossp";

CREATE TABLE IF NOT EXISTS movies(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title VARCHAR(50) NOT NULL,
    director VARCHAR(50) NOT NULL,
    genre VARCHAR(50) NOT NULL,
    release_year INT NOT NULL
);

INSERT INTO movies (title, director, genre, release_year)
VALUES ('The Shawshank Redemption', 'Frank Darabont', 'Drama', 1994),
       ('The Godfather', 'Francis Ford Coppola', 'Crime', 1972),
       ('The Dark Knight', 'Christopher Nolan', 'Action', 2008),
       ('Forrest Gump', 'Robert Zemeckis', 'Drama', 1994);
