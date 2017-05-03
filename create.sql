DROP DATABASE IF EXISTS temp;
CREATE DATABASE temp;
USE temp;

DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    user_id bigint(15) unsigned not null auto_increment primary key,
    username varchar(50) not null,
    password varchar(50) not null,
    sex varchar(20) not null,
    email varchar(100) not null,
    status tinyint(2) not null default '0',
    created timestamp not null default current_timestamp
);

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role
(
    user_role_id bigint(15) unsigned not null auto_increment primary key,
    user_id bigint(15) unsigned not null,
    role varchar(50) not null
);

DROP TABLE IF EXISTS topic;
CREATE TABLE topic
(
    topic_id bigint(15) unsigned not null auto_increment primary key,
    title varchar(50) not null,
    is_private tinyint(2) not null default '0',
    description varchar(300) not null default '',
    user_id bigint(15) unsigned not null,
    created timestamp not null default current_timestamp
);

DROP TABLE IF EXISTS reply;
CREATE TABLE reply
(
    reply_id bigint(15) unsigned not null auto_increment primary key,
    topic_id bigint(15) unsigned not null,
    user_id bigint(15) unsigned not null,
    content varchar(300) not null default '',
    created timestamp not null default current_timestamp
);

DROP TABLE IF EXISTS usergroup;
CREATE TABLE usergroup
(
    usergroup_id bigint(15) unsigned not null auto_increment primary key,
    name varchar(50) not null,
    description varchar(100) not null default ''
);

DROP TABLE IF EXISTS user_usergroup;
CREATE TABLE user_usergroup
(
    user_usergroup_id bigint(15) unsigned not null auto_increment primary key,
    user_id bigint(15) unsigned not null,
    usergroup_id bigint(15) unsigned not null
);

DROP TABLE IF EXISTS topic_usergroup;
CREATE TABLE topic_usergroup
(
    topic_usergroup_id bigint(15) unsigned not null auto_increment primary key,
    topic_id bigint(15) unsigned not null,
    usergroup_id bigint(15) unsigned not null
);


INSERT INTO user (username, password, sex, email, status) VALUES ('101', 'abc', 'male', 'zkyyo@outlook.com', 1);
INSERT INTO user_role (user_id, role) VALUES ('1', 'user');

INSERT INTO user (username, password, sex, email, status) VALUES ('102', 'abc', 'male', 'bingo@outlook.com', 1);
INSERT INTO user_role (user_id, role) VALUES ('2', 'admin');

INSERT INTO usergroup (name, description) VALUES ('male', 'all man');

INSERT INTO user_usergroup (user_id, usergroup_id) VALUES (1, 1);

