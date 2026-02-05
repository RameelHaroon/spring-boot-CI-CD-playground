
    set client_min_messages = WARNING;

    drop table if exists customer cascade;

    create table customer (
            version integer,
            created_date timestamp(6),
            update_date timestamp(6),
            id uuid not null,
            name varchar(255),
            primary key (id)
    );