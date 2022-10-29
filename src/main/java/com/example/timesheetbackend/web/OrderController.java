package com.example.timesheetbackend.web;

import com.example.timesheetbackend.dtos.ProjetDTO;
import com.example.timesheetbackend.entities.Projet;
import com.example.timesheetbackend.repositories.ProjetRepository;
import com.example.timesheetbackend.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class OrderController {
    @Autowired
private ProjetRepository projetRepository;


@Autowired
    private TaskRepository taskRepository;
//@PostMapping("/placeOrder")
  //public Projet placceOrder(@RequestBody ProjetDTO request){
      //return projetRepository.save(request.getProjet());

 // }

  @GetMapping("/findAllTask")
  public List<Projet> findAlTask(){
    return projetRepository.findAll();

  }
}
