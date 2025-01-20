-- CREATE DATABASE play_db;

\c play_db;

CREATE TABLE play (
    id SERIAL PRIMARY KEY,
    video VARCHAR(255) NOT NULL,
    played_at TIMESTAMP NOT NULL
);