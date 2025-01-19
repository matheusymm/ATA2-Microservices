-- CREATE DATABASE play_db;

\c play_db;

CREATE TABLE "Play" (
    id SERIAL PRIMARY KEY,
    played_at TIMESTAMP NOT NULL
);