package com.example.timesheetbackend.dtos;

import com.example.timesheetbackend.entities.Timesheet;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
public class UserDTO {

    private Long id;
    private String name;
    private String email;


}
