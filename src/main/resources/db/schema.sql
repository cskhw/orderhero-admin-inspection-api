DROP TABLE user IF EXISTS;
DROP TABLE roles IF EXISTS;
DROP TABLE refreshtoken IF EXISTS;

create table user (
    id bigint generated by default as identity,
    username varchar(255),
    password varchar(255) not null,
);

create table roles{
    id bigint generated by default as identity,
    name varchar(255),
}

create table roles (
    id bigint generated by default as identity,
    token varchar(255),
    expiryDate date
    user_id varchar(255),
)