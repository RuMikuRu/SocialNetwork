package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dialog implements SocialObject{
    private int id;

    private String nameDialog;

    private String messageText;

    public Dialog(int id, String nameDialog, String messageText)
    {
        this.id = id;
        this.nameDialog = nameDialog;
        this.messageText = messageText;
    }

    @Override
    public Object getObject() {
        Dialog dialog = new Dialog(this.id,this.nameDialog, this.messageText);
        return dialog;
    }
}
