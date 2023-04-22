DROP TABLE if exists profiles CASCADE;
DROP SEQUENCE if exists profiles_id_seq CASCADE;
CREATE SEQUENCE profiles_id_seq;
ALTER SEQUENCE profiles_id_seq OWNER TO postgres;
CREATE TABLE profiles (
    id INTEGER DEFAULT nextval('profiles_id_seq'::regclass),
    name VARCHAR(20) NOT NULL,
    gender VARCHAR(10),
    hobby VARCHAR(255),
    introduction TEXT,
    registered_date timestamp(4) with time zone NOT NULL,
    updated_date timestamp(4) with time zone NOT NULL,
    CONSTRAINT profiles_pk PRIMARY KEY (id)
);