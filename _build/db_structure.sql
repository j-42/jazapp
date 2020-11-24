
CREATE TABLE users (
                id INTEGER NOT NULL,
                email VARCHAR(12) NOT NULL,
                name VARCHAR(30),
                surname VARCHAR(30),
                pseudo VARCHAR(30),
                permissions VARCHAR(30) DEFAULT noob NOT NULL,
                CONSTRAINT id PRIMARY KEY (id)
);


CREATE UNIQUE INDEX user_idx
 ON users
 ( id, email );

CREATE TABLE logs (
                id INTEGER NOT NULL,
                user_id INTEGER NOT NULL,
                connected TIMESTAMP NOT NULL,
                CONSTRAINT logs PRIMARY KEY (id)
);


CREATE TABLE doc_content (
                id INTEGER NOT NULL,
                permissions VARCHAR(30) DEFAULT noob NOT NULL,
                os VARCHAR(30),
                langage VARCHAR(30),
                framework VARCHAR(30),
                library VARCHAR(30),
                content VARCHAR NOT NULL,
                CONSTRAINT id PRIMARY KEY (id)
);


ALTER TABLE logs ADD CONSTRAINT users_sessions_fk
FOREIGN KEY (user_id)
REFERENCES users (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
