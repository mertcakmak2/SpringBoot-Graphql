package com.example.graphql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String position;
    private int salary;
    private int age;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @OneToMany( fetch = FetchType.EAGER, mappedBy = "employee")
    private List<Skill> skills;

}
