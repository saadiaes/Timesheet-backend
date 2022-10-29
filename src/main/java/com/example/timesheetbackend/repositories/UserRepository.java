package com.example.timesheetbackend.repositories;

import com.example.timesheetbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository <User,Long>{
       @Query("select  u from User u where u.name like:kw")
        List<User> searchUsers(@Param("kw") String Keyword);


}
