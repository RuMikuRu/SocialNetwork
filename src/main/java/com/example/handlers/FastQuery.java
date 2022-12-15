package com.example.handlers;

public interface FastQuery {
    String DB_ALL_USERS = "SELECT \"id_user\", \"name\", \"password\", \"date_create_account\" FROM \"users\"";
    String DB_ALL_DIALOGS = "SELECT \"dialog_id\", \"message_text\", \"name_dialog\" FROM \"dialogs\"";
    String DB_ALL_POSTS = "SELECT \"id_post\",\"content\",\"post_created_date\",\"title\" FROM \"posts\"";
    String DB_ALL_GROUPS = "SELECT \"id_group\",\"group_create_date\",\"name_group\",\"number_of_participiants\" FROM \"groups\"";

    String DB_USER_FROM_KEY = "SELECT * FROM users where id_user =";
    String DB_DIALOG_FROM_KEY = "SELECT * FROM \"dialogs\" where \"dialog_id\"=";
    String DB_POST_FROM_KEY = "SELECT * FROM \"posts\" where \"post_id\"=";
    String DB_GROUP_FROM_KEY = "SELECT * FROM \"groups\" where \"group_id\"=";

    String DB_USER_ADD = "INSERT INTO users VALUES ";
    String DB_DIALOG_ADD = "INSERT INTO dialog VALUES ";
    String DB_POST_ADD = "INSERT INTO post VALUES ";
    String DB_GROUP_ADD = "INSERT INTO group VALUES ";
}
