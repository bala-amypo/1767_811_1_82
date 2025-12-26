package com.example.demo.repository;

import com.example.demo.model.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Long> {
    boolean existsByEmail(String email);
    boolean existsByEmployeeId(String employeeId);
    Optional<EmployeeProfile> findByEmployeeId(String employeeId);
}
