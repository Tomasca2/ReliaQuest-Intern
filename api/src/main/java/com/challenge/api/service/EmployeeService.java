package com.challenge.api.service;

import com.challenge.api.model.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeByUuid(UUID uuid) {
        for (Employee e : employees) {
            if (e.getUuid() != null && e.getUuid().equals(uuid)) {
                return e;
            }
        }
        return null;
    }

    public Employee createEmployee(Employee employee) {
        if (employee.getUuid() == null) {
            employee.setUuid(UUID.randomUUID());
        }
        employees.add(employee);
        return employee;
    }
}