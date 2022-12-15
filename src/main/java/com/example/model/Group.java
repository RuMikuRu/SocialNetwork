package com.example.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Group{
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
}

