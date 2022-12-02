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
    @Column(name = "employee_id", nullable = false)
    private Long id;

    private String employee_name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "employees_projects",
            joinColumns = {@JoinColumn(name = "employees_id", referencedColumnName = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "projects_ids", referencedColumnName = "project_id")})
    private List<Project> projects_ids;

    private Long position_id;

}