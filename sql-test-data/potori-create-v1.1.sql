drop table PURCHASE_ALBUM;
drop table PURCHASE;
drop table ALBUM;
drop table CUSTOMER;

create table CUSTOMER (
    id serial primary key,
    cemail varchar(50) not null,
    cpassword varchar(50) not null,
    cname varchar(50) not null,
    caddress varchar(100) not null,
    ccity varchar(50) not null,
    czipcode varchar(10) not null,
    ccountry varchar(30) not null
);

create table ALBUM (
    id serial primary key,
    title varchar(50) not null,
    band varchar(50) not null,
    release integer not null,
    details text not null,
    photo_url text,
    quantity integer not null,
    price double precision not null
);

create table PURCHASE (
    id serial primary key,
    customer_id integer not null,
    date_placed date not null,
    total_amount double precision not null,
    purchase_status varchar(10) not null,
    date_shipped date,
    foreign key (customer_id) references CUSTOMER(id)
);

create table PURCHASE_ALBUM (
    purchase_id integer not null,
    album_id integer not null,
    primary key (purchase_id,album_id),
    foreign key (purchase_id) references PURCHASE(id),
    foreign key (album_id) references ALBUM(id)
);



