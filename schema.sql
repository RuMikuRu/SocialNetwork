
DROP TABLE IF EXISTS Users;
CREATE TABLE Users (id_user int NOT NULL PRIMARY KEY,
name varchar NOT NULL,
password varchar NOT NULL,
date_create_account date NOT NULL);

DROP TABLE IF EXISTS Groups;
CREATE TABLE Groups
(id_group int NOT NULL PRIMARY KEY,
number_of_participiants bigint NOT NULL,
group_create_date date NOT NULL,
name_group varchar NOT NULL);

DROP TABLE IF EXISTS Dialogs;
CREATE TABLE Dialogs
(dialog_id int NOT NULL PRIMARY KEY,
name_dialog varchar NOT NULL,
message_text varchar NOT NULL);

DROP TABLE IF EXISTS Posts;
CREATE TABLE Posts
(id_post int NOT NULL PRIMARY KEY,
content varchar NOT NULL,
post_created_date date NOT NULL,
title varchar NOT NULL);
