package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

   @GetMapping
public List<Employee> getAllEmployees() {
    return employeeRepository.findAll().stream().distinct().collect(Collectors.toList());
}


    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }
    
    
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        existingEmployee.setJoiningDate(updatedEmployee.getJoiningDate());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());
    
        return employeeRepository.save(existingEmployee);
    }
    
    
    

    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
        
        employeeRepository.delete(employee);
    }
    

    public Employee saveEmployee(Employee employee) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'saveEmployee'");
        return employeeRepository.save(employee);
    }
    
}
