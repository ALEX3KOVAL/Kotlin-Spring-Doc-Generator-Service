CREATE TABLE "public".document
(
    id          serial PRIMARY KEY,
    file_id     serial       NOT NULL,
    template_id serial REFERENCES "public".document_template (id),
    model       jsonb        NOT NULL,
    format      varchar(10)  NOT NULL,
    clazz       varchar(300) NOT NULL,
    created_at  timestamp    NOT NULL,
    updated_at  timestamp    NOT NULL
)
