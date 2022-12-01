package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employees_id", nullable = false)
    private Long id;

    private String employee_name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "employees_projects",
            joinColumns = {@JoinColumn(name = "employees_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private List<Project> projects;

    @OneToMany(mappedBy = "employee")
    private List<Position> positions;

}