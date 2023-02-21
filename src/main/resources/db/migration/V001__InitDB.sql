create sequence if not exists inventories_id_seq start 1 increment 1;

create table inventories
(
    id       bigint primary key default nextval('inventories_id_seq'),
    sku_code varchar not null unique ,
    quantity int     not null
);