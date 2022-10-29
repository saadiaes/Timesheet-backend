package com.example.timesheetbackend.dtos;

import com.example.timesheetbackend.entities.Projet;
import com.example.timesheetbackend.entities.User;

import lombok.Data;

@Data

    public class TaskDTO {
        private Long id;
        private String name;
        private String projet;
        private String status;
        private String user;
}
