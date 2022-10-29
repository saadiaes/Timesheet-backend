package com.example.timesheetbackend.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy  =InheritanceType.JOINED)

@Data @NoArgsConstructor @AllArgsConstructor
public class Timesheet {
    @Id
    private String id;
    private Date createdAt;



   private String status;
    @ManyToOne
    private User user;
    /*@ManyToOne
    private Projet projet;*/




}
