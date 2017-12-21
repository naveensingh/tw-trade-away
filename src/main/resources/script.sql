
-- CREATE DATABASE "tradeAway"
-- WITH
-- OWNER = postgres
-- ENCODING = 'UTF8'
-- LC_COLLATE = 'C'
-- LC_CTYPE = 'C'
-- TABLESPACE = pg_default
-- CONNECTION LIMIT = -1;

create table users (
    id  bigserial not null,
    address varchar(255),
    dob timestamp,
    email_id varchar(255),
    experience varchar(255),
    gender varchar(255),
    mobile varchar(255),
    name varchar(255),
    pan_number varchar(255),
    password varchar(255),
    user_type varchar(255),
    username varchar(255),
    primary key (id)
);
    
  