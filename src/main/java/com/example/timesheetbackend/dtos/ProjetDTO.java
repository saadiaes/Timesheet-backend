package com.example.timesheetbackend.dtos;

import com.example.timesheetbackend.entities.Projet;
import com.example.timesheetbackend.entities.Task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjetDTO {

    private Long id;
    private String name;
    private Date date_debut;
    private Date date_fin;
    private String status;
    private List<Task> tasks;

}
