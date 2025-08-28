CREATE TABLE universes (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE series (
    id BIGINT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    year INT,
    type VARCHAR(50),
    hours_length DOUBLE,
    universe_id BIGINT,
    FOREIGN KEY (universe_id) REFERENCES universes(id)
);