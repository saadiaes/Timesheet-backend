package com.example.timesheetbackend.repositories;

import com.example.timesheetbackend.entities.Projet;
import com.example.timesheetbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjetRepository extends JpaRepository <Projet,Long>{
    @Query("select  p from Projet p where p.name like:kw")
    List<Projet> searchProjets(@Param("kw") String Keyword);
}
