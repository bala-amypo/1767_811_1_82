package com.example.demo.repository;

import com.example.demo.model.*;
import java.util.*;

public interface EmployeeProfileRepository {
    Optional<EmployeeProfile> findByEmployeeId(String employeeId);
}
