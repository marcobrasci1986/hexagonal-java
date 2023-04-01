CREATE TABLE IF NOT EXISTS Dossier
(
    id          SERIAL PRIMARY KEY,
    description varchar,
    dossierFase varchar NOT NULL
);

