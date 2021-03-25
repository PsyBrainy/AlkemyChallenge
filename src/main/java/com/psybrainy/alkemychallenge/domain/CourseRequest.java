package com.psybrainy.alkemychallenge.domain;

import java.time.LocalTime;

public class CourseRequest {


    private Long courseID;

    private String name;

    private LocalTime date;

    private Long professor;

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

    public Long getProfessor() {
        return professor;
    }

    public void setProfessor(Long professor) {
        this.professor = professor;
    }

    public Integer getLimitShare() {
        return limitShare;
    }

    public void setLimitShare(Integer limitShare) {
        this.limitShare = limitShare;
    }
}
