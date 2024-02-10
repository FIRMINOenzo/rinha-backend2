CREATE TABLE client (
  "id" SERIAL PRIMARY KEY,
  "limit" INT NOT NULL,
  "balance" INT NOT NULL DEFAULT 0
) WITH (autovacuum_enabled = false);

CREATE TABLE transaction (
  "id" SERIAL PRIMARY KEY,
  "client_id" INT NOT NULL,
  "value" INT NOT NULL,
  "type" CHAR(1) NOT NULL,
  "description" VARCHAR(10) NOT NULL,
  "date" TIMESTAMP NOT NULL,
  FOREIGN KEY ("client_id") REFERENCES client("id")
) WITH (autovacuum_enabled = false);

INSERT INTO 
  client("id", "limit")
VALUES 
  (1, 100000),
  (2, 80000),
  (3, 1000000),
  (4, 10000000),
  (5, 500000);