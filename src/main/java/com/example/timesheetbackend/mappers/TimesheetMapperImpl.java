package com.example.timesheetbackend.mappers;

import com.example.timesheetbackend.dtos.ProjetDTO;
import com.example.timesheetbackend.dtos.TaskDTO;
import com.example.timesheetbackend.dtos.UserDTO;
import com.example.timesheetbackend.entities.Projet;
import com.example.timesheetbackend.entities.Task;
import com.example.timesheetbackend.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class TimesheetMapperImpl {
    public UserDTO fromuser(User user){
     UserDTO userDTO=new UserDTO();
     BeanUtils.copyProperties(user,userDTO);


        return userDTO;

    }
    public User fromUserDto(UserDTO userDTO){
        User user=new User();
        BeanUtils.copyProperties(userDTO,user);


        return user;
    }

    public Projet fromProjetDTO(ProjetDTO projetDTO) {
        Projet  projet=new Projet();
        BeanUtils.copyProperties(projetDTO,projet);


        return projet;
    }

    public ProjetDTO fromprojet(Projet projet) {
        ProjetDTO projetDTO=new ProjetDTO();
        BeanUtils.copyProperties(projet,projetDTO);


        return projetDTO;
    }
    public Task fromTaskDTO(TaskDTO taskDTO)
    {
        Task task = new Task();
        BeanUtils.copyProperties(taskDTO, task);
        return task;
    }
    public TaskDTO fromTask(Task task)
    {
        TaskDTO taskDTO = new TaskDTO();
        BeanUtils.copyProperties(task, taskDTO);
        return taskDTO;
    }



}
