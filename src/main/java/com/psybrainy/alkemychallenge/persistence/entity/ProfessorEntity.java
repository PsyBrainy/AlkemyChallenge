package com.psybrainy.alkemychallenge.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professor")
public class ProfessorEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prof_id")
    private Long profId;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dni")
    private String dni;

    @Column(name = "active")
    private boolean active;

    @OneToMany(mappedBy = "professor")
    private List<CourseEntity> courseList;

    public Long getProfId() {
        return profId;
    }

    public void setProfId(Long profId) {
        this.profId = profId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public List<CourseEntity> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseEntity> courseList) {
        this.courseList = courseList;
    }
}