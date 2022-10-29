package com.example.timesheetbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity

public class Projet{
    @Id

    private Long id;
    private String name;
    private Date date_debut;
    private Date date_fin;
    private String status;
    @OneToMany
   // @JoinColumn(name = "pt_fk",referencedColumnName = "id")
    private List<Task>tasks;







}
