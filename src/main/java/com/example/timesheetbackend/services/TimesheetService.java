package com.example.timesheetbackend.services;

import com.example.timesheetbackend.dtos.ProjetDTO;
import com.example.timesheetbackend.dtos.TaskDTO;
import com.example.timesheetbackend.dtos.UserDTO;
import com.example.timesheetbackend.entities.Projet;
import com.example.timesheetbackend.entities.User;
import com.example.timesheetbackend.exceptions.ProjetNotFoundException;
import com.example.timesheetbackend.exceptions.TaskNotFoundException;
import com.example.timesheetbackend.exceptions.UserNotFoundException;

import java.util.List;

public interface TimesheetService {
    UserDTO saveUser(UserDTO userDTO);
    void deleteUser(Long userId);
    List<UserDTO> listUsers();
    List<UserDTO> searchUsers(String keyword);

    UserDTO updateUser(UserDTO userDTO);
    UserDTO getUser(Long userId) throws UserNotFoundException;

    List<ProjetDTO> searchProjets(String keyword);

    ProjetDTO saveProjet(ProjetDTO projetDTO);

    List<ProjetDTO> listProjets();



    void deleteProjet(Long projetId);


    TaskDTO saveTask(TaskDTO taskDTO);
    List<TaskDTO> listTask();


    ProjetDTO getProjet(Long projetId) throws ProjetNotFoundException;

    TaskDTO getTask(String taskId)throws TaskNotFoundException;

    void deleteTask(String taskId);

    List<TaskDTO> searchTasks(String keyword);
}
