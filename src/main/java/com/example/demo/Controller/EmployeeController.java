package com.example.demo.Controller;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Model.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/employees")

public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @GetMapping("/")
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    @PostMapping("/")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeebyId(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found with id:" + id));
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Employee> postEmployeeById1(@PathVariable long id,@RequestBody Employee employee) {
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:" + id));
        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setSecondName(employee.getSecondName());
        updateEmployee.setEmail(employee.getEmail());
        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteMapping(@PathVariable long id) {
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:" + id));
        employeeRepository.delete(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }
}
