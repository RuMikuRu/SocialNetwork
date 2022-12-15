package com.example.handlers;

public interface FastQuery {
    String DB_ALL_USERS = "SELECT \"id_user\", \"name\", \"password\", \"date_create_account\" FROM \"users\"";
    String DB_ALL_DIALOGS = "SELECT \"dialog_id\", \"message_text\", \"name_dialog\" FROM \"dialogs\"";
    String DB_ALL_POSTS = "SELECT \"id_post\",\"content\",\"post_created_date\",\"title\" FROM \"posts\"";
    String DB_ALL_GROUPS = "SELECT \"id_group\",\"group_create_date\",\"name_group\",\"number_of_participiants\" FROM \"groups\"";
}
