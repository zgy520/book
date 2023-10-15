CREATE TABLE book (
  id                  bigint AUTO_INCREMENT PRIMARY KEY NOT NULL,
  author              varchar(255) NOT NULL,
  isbn                varchar(255) UNIQUE NOT NULL,
  price               float NOT NULL,
  title               varchar(255) NOT NULL,
  created_date        timestamp NOT NULL,
  last_modified_date  timestamp NOT NULL,
  version             integer NOT NULL
);