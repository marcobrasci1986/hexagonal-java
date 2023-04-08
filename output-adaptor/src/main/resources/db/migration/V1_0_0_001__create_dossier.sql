CREATE TABLE IF NOT EXISTS Dossier
(
    id          uuid PRIMARY KEY,
    description varchar,
    dossierfase varchar NOT NULL
);

