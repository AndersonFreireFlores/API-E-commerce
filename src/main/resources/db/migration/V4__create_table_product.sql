CREATE EXTENSION IF NOT EXISTS "pgcrypto";

create table product(
    id          UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name        text    not null,
    description text    not null,
    img_url     text    not null,
    price       numeric not null
);

