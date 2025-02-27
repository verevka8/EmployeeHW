package org.example.employee.controller;

import org.example.employee.entity.Employee;
import org.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeRepository.findAll());
        return "index";
    }

    @GetMapping("/addNewEmployee")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/";
    }

    @GetMapping("/updateEmployee/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeRepository.findById(id).get();
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        Employee employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return "redirect:/";
    }
}