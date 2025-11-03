CREATE TABLE "public".document_template
(
    id          serial PRIMARY KEY,
    file_id     serial       NOT NULL,
    model       jsonb        NOT NULL,
    format      varchar(10)  NOT NULL,
    clazz       varchar(300) NOT NULL,
    created_at  timestamp    NOT NULL,
    updated_at  timestamp    NOT NULL
)
