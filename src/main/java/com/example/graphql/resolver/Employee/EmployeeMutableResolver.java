package com.example.graphql.resolver.Employee;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.model.Department;
import com.example.graphql.model.Employee;
import com.example.graphql.model.EmployeeInput;
import com.example.graphql.repository.DepartmentRepository;
import com.example.graphql.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeMutableResolver implements GraphQLMutationResolver {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public Employee newEmployee(EmployeeInput employeeInput) {
        Department department = departmentRepository.findById(employeeInput.getDepartmentId()).get();
        return employeeRepository.save(new Employee(null, employeeInput.getFirstName(), employeeInput.getLastName(),
                employeeInput.getPosition(), employeeInput.getAge(), employeeInput.getSalary(),
                department));
    }

}
