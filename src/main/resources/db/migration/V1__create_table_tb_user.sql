CREATE EXTENSION IF NOT EXISTS "pgcrypto";

create table tb_user (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name text not null,
    email text not null,
    address text not null,
    role smallint not null,
    password text not null
);
