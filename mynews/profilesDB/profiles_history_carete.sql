DROP TABLE if exists profiles_histories CASCADE;
DROP SEQUENCE if exists prifiles_history_id_seq CASCADE;
CREATE SEQUENCE profiles_history_id_seq;
ALTER SEQUENCE profiles_history_id_seq OWNER TO postgres;
CREATE TABLE profiles_histories (
    id INTEGER DEFAULT nextval('profiles_history_id_seq'::regclass),
    profiles_id INTEGER NOT NULL,
    edited_date timestamp(4) with time zone NOT NULL,
    CONSTRAINT profiles_histories_profiles_id_fk FOREIGN KEY (profiles_id)
        REFERENCES profiles (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);