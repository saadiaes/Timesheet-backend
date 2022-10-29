package com.example.timesheetbackend;

import com.example.timesheetbackend.dtos.ProjetDTO;
import com.example.timesheetbackend.dtos.TaskDTO;
import com.example.timesheetbackend.dtos.UserDTO;
import com.example.timesheetbackend.entities.Timesheet;
import com.example.timesheetbackend.entities.User;

import com.example.timesheetbackend.repositories.TimesheetRepository;
import com.example.timesheetbackend.repositories.UserRepository;
import com.example.timesheetbackend.services.TimesheetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class TimesheetBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimesheetBackendApplication.class, args);
    }
  // @Bean
            CommandLineRunner commandLineRunner(TimesheetService timesheetService){
       return args->{
           Stream.of("Saadia","Nada","Manale").forEach(name->{
               UserDTO user=new UserDTO();
               user.setName(name);
               user.setEmail(name+"@gmail.com");
               timesheetService.saveUser(user);

               ProjetDTO projet = new ProjetDTO();

               projet.setName( name);
               projet.setDate_debut(new Date());
               projet.setDate_fin(new Date());
               projet.setStatus("ToDo");

               projet.setTasks(null);
               timesheetService.saveProjet(projet);

               TaskDTO task = new TaskDTO();
               task.setName( name);
               task.setProjet(null);
               task.setStatus("ToDo");
               task.setUser(null);
               timesheetService.saveTask(task);


           });
       };
    }

   // @Bean
    /*CommandLineRunner start(UserRepository userRepository, TimesheetRepository timesheetRepository) {
        return args -> {
            Stream.of("Saadia", "Nada", "Manale").forEach(name -> {
                User user = new User();
                user.setName(name);
                user.setEmail(name + "@gmail.com");
                userRepository.save(user);
            });
            userRepository.findAll().forEach(usr-> {
                Timesheet timesheet = new Timesheet();
                timesheet.setId(UUID.randomUUID().toString());
                timesheet.setStatus(TimesheetStatus.ToDo);
                timesheet.setCreatedAt(new Date());
                timesheet.setUser(usr);
                timesheetRepository.save(timesheet);




        });
    };
    }*/

}



