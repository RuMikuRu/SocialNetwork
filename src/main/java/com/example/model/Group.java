package com.example.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Group implements SocialObject{
    private int id;

    private String nameGroup;

    private int numberOfParticipants;

    private Date groupCreateDate;


    public Group(int id, String nameGroup, int numberOfParticipants, Date groupCreateDate)
    {
        this.id = id;
        this.nameGroup = nameGroup;
        this.numberOfParticipants = numberOfParticipants;
        this.groupCreateDate = groupCreateDate;
    }

    @Override
    public Object getObject() {
        Group group = new Group(this.id, this.nameGroup, this.numberOfParticipants, this.groupCreateDate);
        return group;
    }
}

