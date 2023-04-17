package com.pablox.citystatespart2.controllers;

import com.pablox.citystatespart2.models.Organization;
import com.pablox.citystatespart2.models.Person;
import com.pablox.citystatespart2.services.CityService;
import com.pablox.citystatespart2.services.OrganizationService;
import com.pablox.citystatespart2.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PersonController {
     @Autowired
     private CityService cityService;
     @Autowired
     private PersonService personService;

    @GetMapping("/person/create")
    public String CreatePerson(@ModelAttribute("person") Person person, Model model) {
        model.addAttribute("cities", cityService.getAll());
        return "create-person.jsp";
    }
    @PostMapping("/person/create")
    public String CreatePerson(
            @Valid @ModelAttribute("person")Person  person,
            BindingResult result
    ) {
        if(result.hasErrors()) {
            return "create-org.jsp";
        } else {
            personService.createOrUpdate(person);
            return "redirect:/";
        }
    }
    @GetMapping("/person/{id}")
    public String PersonView(
            @PathVariable("id") Long id, Model model) {
        model.addAttribute("person", personService.getOne(id));
        return "person.jsp";
    }

//    @GetMapping("/organizations/delete/{id}")
//    public String DeleteOrganization(@PathVariable("id") Long id) {
//        orgService.deleteOne(id);
//        return "redirect:/";
//    }

}
