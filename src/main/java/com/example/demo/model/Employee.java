package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Employee")  // Matches the MySQL table name
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private BigDecimal salary;

    private LocalDate joiningDate;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable= true, foreignKey = @ForeignKey(name = "FK_department"))
    private Department department;

    public Employee() {}

    public Employee(String name, String email, Department department, BigDecimal salary, LocalDate joiningDate) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public BigDecimal getSalary() { return salary; }
    public void setSalary(BigDecimal salary) { this.salary = salary; }

    public LocalDate getJoiningDate() { return joiningDate; }
    public void setJoiningDate(LocalDate joiningDate) { this.joiningDate = joiningDate; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}
