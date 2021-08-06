package com.example.crud_springboot.controll;

import com.example.crud_springboot.model.Employee;
import com.example.crud_springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeControll {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String employeePage(@ModelAttribute("Employee") Employee employee, Model model){
        model.addAttribute("listEmployee",employeeService.getEmployees());
        return "index";
    }

    @GetMapping("/employeeForm")
    public String employeeForm(Model model){
        Employee employee= new Employee();
    model.addAttribute("employee",employee);
    return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/employeeFormUpdate/{id}")
    public String employeeUpdate(@PathVariable Long id, Model model){
        Optional<Employee> employee = employeeService.findEmployee(id);
        model.addAttribute("employee",employee);
        return "update_employee";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

}
