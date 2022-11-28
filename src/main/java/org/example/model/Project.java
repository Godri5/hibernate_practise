package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id", nullable = false)
    private Long id;

    private String project_name;

    @ManyToMany
    @JoinTable(name = "projects_employees",
            joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employees_id", referencedColumnName = "employees_id"))
    private List<Employee> employees = new ArrayList<>();

}
