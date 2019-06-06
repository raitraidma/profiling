CREATE TABLE IF NOT EXISTS author (
  id         SERIAL                   NOT NULL
, name       VARCHAR(60)              NOT NULL
, is_active  BOOLEAN                  NOT NULL DEFAULT TRUE
, created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

ALTER TABLE author ADD CONSTRAINT pk_author PRIMARY KEY (id);



CREATE TABLE IF NOT EXISTS post (
  id         SERIAL                   NOT NULL
, title      VARCHAR(60)              NOT NULL
, author_id  INTEGER                  NOT NULL
, content    TEXT                     NOT NULL
, created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

ALTER TABLE post ADD CONSTRAINT pk_post PRIMARY KEY (id);

ALTER TABLE post ADD CONSTRAINT fk_post_author FOREIGN KEY (author_id) REFERENCES author(id);



CREATE TABLE IF NOT EXISTS comment (
  id         SERIAL                   NOT NULL
, post_id    INTEGER                  NOT NULL
, author_id  INTEGER                  NOT NULL
, content    TEXT                     NOT NULL
, created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

ALTER TABLE comment ADD CONSTRAINT pk_comment PRIMARY KEY (id);

ALTER TABLE comment ADD CONSTRAINT fk_comment_post FOREIGN KEY (post_id) REFERENCES post(id);

ALTER TABLE comment ADD CONSTRAINT fk_comment_author FOREIGN KEY (author_id) REFERENCES author(id);
