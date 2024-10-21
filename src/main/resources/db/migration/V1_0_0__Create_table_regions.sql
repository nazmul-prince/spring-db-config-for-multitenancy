CREATE SEQUENCE regions_id_sequence as integer START 9 INCREMENT 1;

CREATE TABLE IF NOT EXISTS regions
(
    id          INT4         DEFAULT nextval('regions_id_sequence') PRIMARY KEY,
    region_code INT4 UNIQUE                               NOT NULL,
    geo_code           VARCHAR(50),
    name_bn     VARCHAR(255)                              NOT NULL,
    name_en     VARCHAR(255)                              NOT NULL,
    is_active   boolean      DEFAULT TRUE,
    created_by  VARCHAR(255)                              ,
    updated_by  VARCHAR(255)                              ,
    created_at  TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP(6) ,
    updated_at  TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP(6)
);