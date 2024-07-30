CREATE EXTENSION IF NOT EXISTS "pgcrypto";

create table cart (
        id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
        total_price numeric not null,
        user_id UUID not null ,
        foreign key (user_id) references tb_user(id)
);
