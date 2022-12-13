package gr.pmm.pmmhr2022.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Role role;
    @ManyToMany
    private List<Project> projects;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Employee manager;

    @OneToMany(mappedBy = "manager")
    private List<Employee> supervisorees;

}
