package com.example.demo;

import com.example.demo.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Demo1Application  implements CommandLineRunner {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public Demo1Application(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        Employee em1 = new Employee();
        em1.setFirstName("hemanth");
        em1.setSecondName("kumar");
        em1.setEmail("hk926");
        employeeRepository.save(em1);

        Employee em2 = new Employee();
        em2.setFirstName("hemanth1");
        em2.setSecondName("kumar1");
        em2.setEmail("hk9262");
        employeeRepository.save(em2);
    }
}
