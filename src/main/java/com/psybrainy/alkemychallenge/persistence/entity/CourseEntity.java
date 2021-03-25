package com.psybrainy.alkemychallenge.persistence.entity;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "course")
public class CourseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseID;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private LocalTime date;

    @ManyToOne
    @JoinColumn(name = "prof_id")
    private ProfessorEntity professor;

    @Column(name = "limit_share")
    private Integer limitShare;

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getDate() {
        return date;
    }

    public void setDate(LocalTime date) {
        this.date = date;
    }

    public ProfessorEntity getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorEntity professor) {
        this.professor = professor;
    }

    public Integer getLimitShare() {
        return limitShare;
    }

    public void setLimitShare(Integer limitShare) {
        this.limitShare = limitShare;
    }
}