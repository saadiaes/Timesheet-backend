package com.example.timesheetbackend.services;

import com.example.timesheetbackend.dtos.ProjetDTO;
import com.example.timesheetbackend.dtos.TaskDTO;
import com.example.timesheetbackend.dtos.UserDTO;
import com.example.timesheetbackend.entities.Projet;
import com.example.timesheetbackend.entities.Task;
import com.example.timesheetbackend.entities.User;
import com.example.timesheetbackend.exceptions.ProjetNotFoundException;
import com.example.timesheetbackend.exceptions.TaskNotFoundException;
import com.example.timesheetbackend.exceptions.UserNotFoundException;
import com.example.timesheetbackend.mappers.TimesheetMapperImpl;
import com.example.timesheetbackend.repositories.ProjetRepository;
import com.example.timesheetbackend.repositories.TaskRepository;
import com.example.timesheetbackend.repositories.TimesheetRepository;
import com.example.timesheetbackend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class TimesheetServiceImpl implements TimesheetService {

    private UserRepository userRepository;

    private ProjetRepository projetRepository;
    private TaskRepository taskRepository;

    private TimesheetRepository timesheetRepository;
    private TimesheetMapperImpl dtoMapper;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        log.info("Saving new user");
        User user = dtoMapper.fromUserDto(userDTO);
        User savedUser = userRepository.save(user);

        return dtoMapper.fromuser(savedUser);

    }


    @Override
    public List<UserDTO> listUsers() {

        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = users.stream()
                .map(user -> dtoMapper.fromuser(user))
                .collect(Collectors.toList());

        return userDTOS;
    }


    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        log.info("Saving new user");
        User user = dtoMapper.fromUserDto(userDTO);
        User savedUser = userRepository.save(user);

        return dtoMapper.fromuser(savedUser);


    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


    @Override
    public UserDTO getUser(Long userId) throws UserNotFoundException {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User Not found"));
        return dtoMapper.fromuser(user);
    }


    @Override
    public List<UserDTO> searchUsers(String keyword) {
        List<User> user = userRepository.searchUsers(keyword);
        List<UserDTO> userDTOS = user.stream().map(usr -> dtoMapper.fromuser(usr)).collect(Collectors.toList());
        return userDTOS;

    }
    @Override
    public List<ProjetDTO> searchProjets(String keyword) {
        List<Projet> projet = projetRepository.searchProjets(keyword);

        List<ProjetDTO> projetDTOS = projet.stream().map(prj-> dtoMapper.fromprojet(prj)).collect(Collectors.toList());
        return projetDTOS;

    }
    @Override
    public List<TaskDTO> searchTasks(String keyword) {
        List<Task> task = taskRepository.searchTasks(keyword);
        List<TaskDTO> taskDTOS = task.stream().map(tsk -> dtoMapper.fromTask(tsk)).collect(Collectors.toList());
        return taskDTOS;

    }
    @Override
    public ProjetDTO saveProjet(ProjetDTO projetDTO) {
        log.info("Saving new projet");
        Projet projet = dtoMapper.fromProjetDTO(projetDTO);

        Projet savedProjet = projetRepository.save(projet);


        return dtoMapper.fromprojet(savedProjet);
    }


    @Override
    public List<ProjetDTO> listProjets() {

        List<Projet> projets = projetRepository.findAll();
        List<ProjetDTO> projetDTOS = projets.stream()
                .map(projet -> dtoMapper.fromprojet(projet))
                .collect(Collectors.toList());

        return projetDTOS;
    }


    @Override
    public void deleteProjet(Long projetId) {
        projetRepository.deleteById(projetId);
    }


    @Override
    public ProjetDTO getProjet(Long projetId) throws ProjetNotFoundException {

        Projet projet = projetRepository.findById(projetId)
                .orElseThrow(() -> new ProjetNotFoundException("projet Not found"));
        return dtoMapper.fromprojet(projet);
    }
    @Override
    public TaskDTO getTask(String taskId) throws TaskNotFoundException {
        Task task=taskRepository.findById(Integer.valueOf(taskId))

                .orElseThrow(() -> new TaskNotFoundException("task Not found"));
        return dtoMapper.fromTask(task);
    }

    @Override
    public TaskDTO saveTask(TaskDTO taskDTO) {
        log.info("saving new task ");
        Task task = dtoMapper.fromTaskDTO(taskDTO);

        Task savedTask = taskRepository.save(task);
        return dtoMapper.fromTask(savedTask);
    }
    @Override
    public List<TaskDTO> listTask() {

        List<Task> tasks = taskRepository.findAll();
        List<TaskDTO> taskDTOS = tasks.stream()
                .map(task -> dtoMapper.fromTask(task))
                .collect(Collectors.toList());
        return taskDTOS;


    }



    @Override
    public void deleteTask(String taskId) {
        taskRepository.deleteById(Integer.valueOf(taskId));
    }

    }







