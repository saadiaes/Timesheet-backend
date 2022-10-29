package com.example.timesheetbackend.repositories;

import com.example.timesheetbackend.entities.Projet;
import com.example.timesheetbackend.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository <Task,Integer> {


    @Query("select  t from Task t where t.name like:kw")
    List<Task> searchTasks(@Param("kw") String Keyword);
}

