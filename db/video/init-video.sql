-- CREATE DATABASE video_db;

\c video_db;

CREATE TABLE video (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    time FLOAT NOT NULL
);

INSERT INTO video (name, time) VALUES ('Video 1', 180);
INSERT INTO video (name, time) VALUES ('Video 2', 360);