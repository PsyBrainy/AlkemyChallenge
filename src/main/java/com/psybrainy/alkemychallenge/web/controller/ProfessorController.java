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
import com.psybrainy.alkemychallenge.domain.ProfessorRequest;
import com.psybrainy.alkemychallenge.domain.service.ProfessorService;

@Controller
@RequestMapping("/views/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService service;


    @GetMapping
    public String getAll(Model model){

        List<ProfessorRequest> listProfessor = service.getAll();

        model.addAttribute("title", "Lista de Profesores");
        model.addAttribute("professors", listProfessor);

        return "/views/professor/getAllProfessor";
    }

    @GetMapping("/create")
    public String create(Model model){

        ProfessorRequest professor = new ProfessorRequest();

        model.addAttribute("title","Formulario: Nuevo Profesor");
        model.addAttribute("professor" , professor);

        return "/views/professor/createProfessor";
    }

    @PostMapping("/save")
    public  String saveProfessor(@ModelAttribute ProfessorRequest professorRequest){

        professorRequest.setActive(true);

        service.save(professorRequest);

        return "redirect:/views/professor";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){

        ProfessorRequest professor = service.getById(id).orElseThrow(EntityExeption::new);

        model.addAttribute("title","Formulario: Editar Profesor");
        model.addAttribute("professor" , professor);

        return "/views/professor/createProfessor";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long profId){
        service.delete(profId);

        return "redirect:/views/professor";
    }
}
