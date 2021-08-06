package com.example.crud_springboot.service;

import com.example.crud_springboot.model.Employee;
import com.example.crud_springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public Optional<Employee> findEmployee(Long id) {
    return employeeRepository.findById(id);
    }


    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
