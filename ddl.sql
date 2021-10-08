CREATE DATABASE Users;

USE users;

CREATE TABLE LoginInformation(
                                 id int not null auto_increment primary key ,
                                 name varchar(256) not null,
                                 password varchar(20) not null
);