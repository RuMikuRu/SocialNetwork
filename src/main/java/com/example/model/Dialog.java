package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dialog{
    private int id;

    private String nameDialog;

    private String messageText;

    public Dialog(int id, String nameDialog, String messageText)
    {
        this.id = id;
        this.nameDialog = nameDialog;
        this.messageText = messageText;
    }
}
