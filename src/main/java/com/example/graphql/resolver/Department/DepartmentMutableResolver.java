package com.example.graphql.resolver.Department;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.model.Department;
import com.example.graphql.model.DepartmentInput;
import com.example.graphql.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DepartmentMutableResolver implements GraphQLMutationResolver {

    private final DepartmentRepository departmentRepository;


    public Department newDepartment(DepartmentInput departmentInput) {
        return departmentRepository.save(
                Department.builder().name(departmentInput.getName()).build()
        );
    }

}
