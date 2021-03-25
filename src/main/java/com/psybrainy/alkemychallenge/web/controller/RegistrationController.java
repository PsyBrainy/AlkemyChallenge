package com.psybrainy.alkemychallenge.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psybrainy.alkemychallenge.domain.CourseRequest;
import com.psybrainy.alkemychallenge.domain.RegistrationRequest;
import com.psybrainy.alkemychallenge.domain.StudentRequest;
import com.psybrainy.alkemychallenge.domain.service.CourseService;
import com.psybrainy.alkemychallenge.domain.service.RegistrationService;

@Controller
@RequestMapping("/views/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    private StudentRequest studentRequestDniAndFile;

    @Autowired
    private CourseService courseService;


    @GetMapping("/create")
    public String create(Model model){

        StudentRequest student = new StudentRequest();

        model.addAttribute("title","Formulario: Introduza su legajo y DNI");
        model.addAttribute("registration", student);

        return "/views/registration/createRegistration";
    }

    @GetMapping("/selection")
    public String selection(Model model , @ModelAttribute StudentRequest studentRequest){

        RegistrationRequest registration = new RegistrationRequest();
        registration.setStundentDni(studentRequest.getStundentDni());
        registration.setStudentFile(studentRequest.getStudentFile());

        List<CourseRequest> courseRequestList = courseService.getCoursesNotRegister(registration.getStundentDni())
                .orElse(new ArrayList<>());

        model.addAttribute("title", "Seleccione las materias a las que se quiere inscribir");
        model.addAttribute("registration", registration);
        model.addAttribute("courses", courseRequestList);

        this.studentRequestDniAndFile = studentRequest;

        return "/views/registration/getAllRegistation";
    }

    @GetMapping("/save/{courseID}")
    public String save(@ModelAttribute RegistrationRequest registrationRequest,
                       @PathVariable("courseID") Long courseID){

        registrationRequest.setStudentFile(this.studentRequestDniAndFile.getStudentFile());
        registrationRequest.setStundentDni(this.studentRequestDniAndFile.getStundentDni());

        registrationRequest.setCourseRequest(courseID);

        registrationService.save(registrationRequest);
        return "redirect:/views/registration/create";
    }
}