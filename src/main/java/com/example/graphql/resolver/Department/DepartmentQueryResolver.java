package com.example.graphql.resolver.Department;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.model.Department;
import com.example.graphql.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DepartmentQueryResolver implements GraphQLQueryResolver {

    private final DepartmentRepository departmentRepository;

    @Transactional
    public Iterable<Department> departments() {
        return departmentRepository.findAll();
    }

    public Department department(int id) {
        return departmentRepository.findById(id).orElseThrow();
    }
}
