-- Active: 1670958096471@@127.0.0.1@5432@socialNetwork@public
insert into users (
    id_user,
    name,
    password,
    date_create_account
)

VALUES
    (1, 'Iliya', 'rfhiujf', '04.07.2001'),
    (2, 'Ivan', 'hfiudhfg', '03.12.2002'),
    (3,'Egor', 'fgdtfhg', '01.02.2003'),
    (4,'Kostya', 'gbfgn', '21.09.2004'),
    (5,'Victor', 'fmgkldfg', '07.01.2002'),
    (6,'Nastya', 'ekfdfmko', '02.06.2008') ON CONFLICT DO NOTHING;

INSERT into groups (
    id_group,
    number_of_participiants,
    group_create_date,
    name_group
)
VALUES
    (1,10000, '01.03.2012','4ch'),
    (2,2342, '02.04.2013', 'TverSU'),
    (3,34235, '04.01.2007', 'Cats') ON CONFLICT DO NOTHING;

INSERT into posts(
    id_post,
    content,
    post_created_date,
    title
)
VALUES
    (1, 'Help me, Postgres not support Rus', '15.12.2022', 'baaaaaad'),
    (2, 'ahahahha nice video', '22.10.2007', 'Cats') ON CONFLICT DO NOTHING;

INSERT into dialogs(
    dialog_id,
    name_dialog,
    message_text
)

VALUES
    (1, 'Иван', 'Привет, как дела?'),
    (2, 'Анастасия', 'Привет, всё хорошо, вот убираюсь дома') ON CONFLICT DO NOTHING;
