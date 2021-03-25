package com.psybrainy.alkemychallenge.persistence.entity;


import javax.persistence.*;

@Entity
@Table(name = "course_registration")
public class CourseRegistrationEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Long registrationId;

    @Column(name = "student_file")
    private String studentFile;

    @Column(name = "stundent_dni")
    private String stundentDni;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity courseEntity;

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public String getStudentFile() {
        return studentFile;
    }

    public void setStudentFile(String studentFile) {
        this.studentFile = studentFile;
    }

    public String getStundentDni() {
        return stundentDni;
    }

    public void setStundentDni(String stundentDni) {
        this.stundentDni = stundentDni;
    }

    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }
}

