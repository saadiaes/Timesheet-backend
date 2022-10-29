package com.example.timesheetbackend.web;

import com.example.timesheetbackend.dtos.ProjetDTO;
import com.example.timesheetbackend.dtos.TaskDTO;
import com.example.timesheetbackend.dtos.UserDTO;
import com.example.timesheetbackend.exceptions.ProjetNotFoundException;
import com.example.timesheetbackend.exceptions.TaskNotFoundException;
import com.example.timesheetbackend.exceptions.UserNotFoundException;
import com.example.timesheetbackend.services.TimesheetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")

public class UserRestController {

    private TimesheetService timesheetService;

    @GetMapping("/user")
    public List<UserDTO> user() {
        return timesheetService.listUsers();
    }

    @GetMapping("/user/search")
    public List<UserDTO> searchUsers(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
        return timesheetService.searchUsers("%" + keyword + "%");
    }

    @PostMapping("/user")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return timesheetService.saveUser(userDTO);
    }

    @GetMapping("/user/{id}")
    public UserDTO getUser(@PathVariable(name = "id") Long userId) throws UserNotFoundException {
        return timesheetService.getUser(userId);
    }


    @PutMapping("/user/{userId}")
    public UserDTO updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        userDTO.setId(userId);
        return timesheetService.updateUser(userDTO);


    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        timesheetService.deleteUser(id);


    }

    @GetMapping("projet")
    public List<ProjetDTO> listProject() {
        return timesheetService.listProjets();
    }


    @GetMapping("/projet/search")
    public List<ProjetDTO> searchProjets(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
        return timesheetService.searchProjets("%" + keyword + "%");
    }

    @PostMapping("/projet")
    public ProjetDTO saveProjet(@RequestBody ProjetDTO projetDTO) {
        return timesheetService.saveProjet(projetDTO);
    }

    @GetMapping("/projet/{id}")
    public ProjetDTO getProjet(@PathVariable(name = "id") Long projetId) throws ProjetNotFoundException {
        return timesheetService.getProjet(projetId);
    }


    @DeleteMapping("/projet/{id}")
    public void deleteProjet(@PathVariable Long id) {
        timesheetService.deleteProjet(id);


    }


    @GetMapping("task")
    public List<TaskDTO> listTasks() {
        return timesheetService.listTask();
    }

    @GetMapping("/task/{id}")
    public TaskDTO getTask(@PathVariable(name = "id") String taskId) throws TaskNotFoundException {
        return timesheetService.getTask(taskId);
    }

    @PostMapping("/task")
    public TaskDTO saveTask(@RequestBody TaskDTO taskDTO) {
        return timesheetService.saveTask(taskDTO);
    }

    @GetMapping("/task/search")
    public List<TaskDTO> searchTasks(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
        return timesheetService.searchTasks("%" + keyword + "%");
    }


    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable String id) {
        timesheetService.deleteTask(id);


    }
}