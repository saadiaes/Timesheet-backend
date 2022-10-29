package com.example.timesheetbackend.dtos;

import com.example.timesheetbackend.entities.User;

import lombok.Data;

import java.util.Date;

@Data
public class TimesheetDTO {
    private String id;
    private Date createdAt;
    private String status;
    private User user;

}
