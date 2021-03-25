package com.psybrainy.alkemychallenge.domain;

public class RegistrationRequest {

    private Long registrationId;
    private String studentFile;
    private String stundentDni;
    private Long courseRequest;

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

    public Long getCourseRequest() {
        return courseRequest;
    }

    public void setCourseRequest(Long courseRequest) {
        this.courseRequest = courseRequest;
    }
}
