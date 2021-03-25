package com.psybrainy.alkemychallenge.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psybrainy.alkemychallenge.EntityExeption;
import com.psybrainy.alkemychallenge.domain.CourseRequest;
import com.psybrainy.alkemychallenge.domain.ProfessorRequest;
import com.psybrainy.alkemychallenge.domain.service.CourseService;
import com.psybrainy.alkemychallenge.domain.service.ProfessorService;

@Controller
@RequestMapping("/views/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @Autowired
    private ProfessorService professorService;


    @GetMapping
    public String getAll(Model model){
        List<CourseRequest> listCourses = service.getAll();

        model.addAttribute("title","Lista de Materias");
        model.addAttribute("courses",listCourses);

        return "/views/course/getAllCourses";
    }

    @GetMapping("/create")
    public String create(Model model){

        CourseRequest course = new CourseRequest();
        List<ProfessorRequest> professorRequestList = professorService.getAll();

        model.addAttribute("title","Formulario: Nueva Materia");
        model.addAttribute("course" , course);
        model.addAttribute("professors" , professorRequestList);

        return "/views/course/createCourse";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute CourseRequest courseRequest){

        service.save(courseRequest);

        return "redirect:/views/course";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){

        CourseRequest course = service.getById(id).orElseThrow(EntityExeption::new);

        model.addAttribute("title","Formulario: Editar Materia");
        model.addAttribute("course" , course);

        return "/views/course/createCourse";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long courseId){
        service.delete(courseId);

        return "redirect:/views/course";
    }
}
