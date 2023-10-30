
create table table_genre(

  id serial PRIMARY KEY,
  name VARCHAR(255) not null,
  description VARCHAR(255) not null, 
  created_at TIMESTAMP,
  updated_at TIMESTAMP, 
  is_deleted boolean default false, 
  created_by VARCHAR(255) not null,
  updated_by VARCHAR(255) not null 
);

CREATE SEQUENCE table_genre_seq
START 1
INCREMENT 1
OWNED BY table_genre.id;

create table table_movie(
  id serial PRIMARY KEY,
  name VARCHAR(255) not null,
  title VARCHAR(255) not null,
  description VARCHAR(255) not null,
  image VARCHAR(255) not null,
  short_description VARCHAR(255) not null,
  rating DECIMAL(3, 1),
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  is_deleted boolean default false, 
  created_by VARCHAR(255) not null,
  updated_by VARCHAR(255) not null,
  genre_id integer references table_genre(id)  ON DELETE CASCADE
);

CREATE SEQUENCE table_movie_seq
START 1
INCREMENT 1
OWNED BY table_movie.id;


