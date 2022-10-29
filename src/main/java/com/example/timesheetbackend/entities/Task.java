package com.example.timesheetbackend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Task {
    @Id
   @GeneratedValue
    private Long id;
    private String name;
    private String status;

   // @OneToOne
    private String projet;

   // @OneToOne

    private String user;


}
