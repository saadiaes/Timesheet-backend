package com.example.timesheetbackend.repositories;

import com.example.timesheetbackend.entities.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimesheetRepository extends JpaRepository<Timesheet,String> {
}
