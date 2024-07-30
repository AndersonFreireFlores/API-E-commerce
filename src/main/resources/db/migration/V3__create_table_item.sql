CREATE EXTENSION IF NOT EXISTS "pgcrypto";

create table item (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    quantity integer not null,
    cart_id UUID not null,
    product_id UUID not null,
    foreign key (cart_id) references cart(id),
    foreign key (product_id) references product(id)
);
