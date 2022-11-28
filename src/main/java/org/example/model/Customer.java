package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project projects;

}
