
CREATE SEQUENCE public.libraries_id_seq;

CREATE TABLE public.libraries (
                id INTEGER NOT NULL DEFAULT nextval('public.libraries_id_seq'),
                name VARCHAR(100) NOT NULL,
                CONSTRAINT libraries_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.libraries_id_seq OWNED BY public.libraries.id;

CREATE SEQUENCE public.framework_is_seq;

CREATE TABLE public.frameworks (
                id INTEGER NOT NULL DEFAULT nextval('public.framework_is_seq'),
                name VARCHAR(100) NOT NULL,
                CONSTRAINT frameworks_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.framework_is_seq OWNED BY public.frameworks.id;

CREATE SEQUENCE public.os_id_seq;

CREATE TABLE public.os (
                id INTEGER NOT NULL DEFAULT nextval('public.os_id_seq'),
                name VARCHAR(30) NOT NULL,
                CONSTRAINT os_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.os_id_seq OWNED BY public.os.id;

CREATE TABLE public.langages (
                id INTEGER NOT NULL,
                name VARCHAR(100) NOT NULL,
                CONSTRAINT langages_pk PRIMARY KEY (id)
);


CREATE TABLE public.permissions (
                id INTEGER NOT NULL,
                name VARCHAR(30) NOT NULL,
                CONSTRAINT permissions_pk PRIMARY KEY (id)
);


CREATE TABLE public.doc_content (
                id INTEGER NOT NULL,
                content VARCHAR NOT NULL,
                CONSTRAINT doc_content_pk PRIMARY KEY (id)
);


CREATE TABLE public.doc_frameworks (
                framework_id INTEGER NOT NULL,
                doc_content_id INTEGER NOT NULL,
                CONSTRAINT doc_frameworks_pk PRIMARY KEY (framework_id, doc_content_id)
);


CREATE TABLE public.doc_libraries (
                doc_content_id INTEGER NOT NULL,
                library_id INTEGER NOT NULL,
                CONSTRAINT doc_libraries_pk PRIMARY KEY (doc_content_id, library_id)
);


CREATE TABLE public.doc_os (
                doc_content_id INTEGER NOT NULL,
                os_id INTEGER NOT NULL,
                CONSTRAINT doc_os_pk PRIMARY KEY (doc_content_id, os_id)
);


CREATE TABLE public.doc_langages (
                doc_content_id INTEGER NOT NULL,
                langage_id INTEGER NOT NULL,
                CONSTRAINT doc_langages_pk PRIMARY KEY (doc_content_id, langage_id)
);


CREATE TABLE public.doc_permissions (
                permission_id INTEGER NOT NULL,
                doc_content_id_1 INTEGER NOT NULL,
                CONSTRAINT doc_permissions_pk PRIMARY KEY (permission_id, doc_content_id_1)
);


CREATE SEQUENCE public.users_id_seq;

CREATE TABLE public.users (
                id INTEGER NOT NULL DEFAULT nextval('public.users_id_seq'),
                email VARCHAR(100) NOT NULL,
                pseudo VARCHAR(30) NOT NULL,
                name VARCHAR(100) NOT NULL,
                surname VARCHAR(100) NOT NULL,
                CONSTRAINT id PRIMARY KEY (id)
);


ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;

CREATE TABLE public.users_permissions (
                users_id INTEGER NOT NULL,
                permissions_id INTEGER NOT NULL,
                CONSTRAINT users_permissions_pk PRIMARY KEY (users_id, permissions_id)
);


CREATE TABLE public.logs (
                id INTEGER NOT NULL,
                user_id INTEGER NOT NULL,
                last_connected TIMESTAMP NOT NULL,
                CONSTRAINT logs_pk PRIMARY KEY (id)
);


ALTER TABLE public.doc_libraries ADD CONSTRAINT libraries_doc_libraries_fk1
FOREIGN KEY (library_id)
REFERENCES public.libraries (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.doc_frameworks ADD CONSTRAINT frameworks_doc_frameworks_fk1
FOREIGN KEY (framework_id)
REFERENCES public.frameworks (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.doc_os ADD CONSTRAINT os_doc_os_fk1
FOREIGN KEY (os_id)
REFERENCES public.os (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.doc_langages ADD CONSTRAINT langages_doc_langages_fk1
FOREIGN KEY (langage_id)
REFERENCES public.langages (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.doc_permissions ADD CONSTRAINT permissions_doc_permissions_fk1
FOREIGN KEY (permission_id)
REFERENCES public.permissions (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.users_permissions ADD CONSTRAINT permissions_users_permissions_fk1
FOREIGN KEY (permissions_id)
REFERENCES public.permissions (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.doc_permissions ADD CONSTRAINT doc_content_doc_permissions_fk
FOREIGN KEY (doc_content_id)
REFERENCES public.doc_content (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.doc_permissions ADD CONSTRAINT doc_content_doc_permissions_fk1
FOREIGN KEY (doc_content_id_1)
REFERENCES public.doc_content (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.doc_langages ADD CONSTRAINT doc_content_doc_langages_fk1
FOREIGN KEY (doc_content_id)
REFERENCES public.doc_content (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.doc_os ADD CONSTRAINT doc_content_doc_os_fk1
FOREIGN KEY (doc_content_id)
REFERENCES public.doc_content (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.doc_libraries ADD CONSTRAINT doc_content_doc_libraries_fk1
FOREIGN KEY (doc_content_id)
REFERENCES public.doc_content (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.doc_frameworks ADD CONSTRAINT doc_content_doc_frameworks_fk1
FOREIGN KEY (doc_content_id)
REFERENCES public.doc_content (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.logs ADD CONSTRAINT users_logs_fk
FOREIGN KEY (user_id)
REFERENCES public.users (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.users_permissions ADD CONSTRAINT users_users_permissions_fk1
FOREIGN KEY (users_id)
REFERENCES public.users (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;