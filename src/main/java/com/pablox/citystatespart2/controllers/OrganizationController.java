package com.pablox.citystatespart2.controllers;

import com.pablox.citystatespart2.models.City;
import com.pablox.citystatespart2.models.Organization;
import com.pablox.citystatespart2.models.Person;
import com.pablox.citystatespart2.services.CityService;
import com.pablox.citystatespart2.services.OrganizationService;
import com.pablox.citystatespart2.services.PersonService;
import com.pablox.citystatespart2.services.StateService;
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
public class OrganizationController {
    @Autowired
    private CityService cityService;
    @Autowired
    private PersonService personService;
    @Autowired
    private OrganizationService orgService;

    @GetMapping("/organizations/create")
    public String CreateOrganization(@ModelAttribute("organization") Organization organization, Model model) {
        model.addAttribute("cities", cityService.getAll());
        return "create-org.jsp";
    }

    @PostMapping("/organizations/create")
    public String CreateOrganization(
            @Valid @ModelAttribute("organization") Organization organization,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "create-org.jsp";
        } else {
            orgService.createOrUpdate(organization);
            return "redirect:/";
        }
    }

    @GetMapping("/organizations/join/{org_id}/{person_id}")
    public String JoinOrg(
            @PathVariable("org_id") Long org_id,
            @PathVariable("person_id") Long person_id
    ) {
        Organization o = orgService.getOne(org_id);
        Person p = personService.getOne(person_id);

        o.getOrgMembers().add(p);
        orgService.createOrUpdate(o);
        return "redirect:/person/" + person_id;
    }

    @GetMapping("/organizations/remove/{org_id}/{person_id}")
    public String RemoveOrg(
            @PathVariable("org_id") Long org_id,
            @PathVariable("person_id") Long person_id
    ) {
        Organization o = orgService.getOne(org_id);
        Person p = personService.getOne(person_id);

        o.getOrgMembers().remove(p);
        orgService.createOrUpdate(o);
        return "redirect:/person/" + person_id;
    }

    @GetMapping("/organizations/delete/{id}")
    public String DeleteOrganization(@PathVariable("id") Long id) {
        orgService.deleteOne(id);
        return "redirect:/";
    }

}
