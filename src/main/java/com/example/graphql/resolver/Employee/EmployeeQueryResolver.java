package com.example.graphql.resolver.Employee;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.model.Employee;
import com.example.graphql.model.Skill;
import com.example.graphql.repository.EmployeeRepository;
import com.example.graphql.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeQueryResolver implements GraphQLQueryResolver {

    private final EmployeeRepository employeeRepository;

    public Iterable<Employee> employees() {
        return employeeRepository.findAll();
    }

    public Employee employee(Integer id) {
        return employeeRepository.findById(id).get();
    }
}
