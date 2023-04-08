CREATE TABLE IF NOT EXISTS Audit
(
    id        uuid PRIMARY KEY,
    event     varchar NOT NULL,
    timestamp TIMESTAMP
);

