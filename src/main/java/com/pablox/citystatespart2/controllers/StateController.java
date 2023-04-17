package com.pablox.citystatespart2.controllers;

import com.pablox.citystatespart2.models.State;
import com.pablox.citystatespart2.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StateController {
     @Autowired
     private StateService stateService;

    @GetMapping("/states/create")
    public String CreateState(@ModelAttribute("state") State state) {
        return "create-state.jsp";
    }
    @PostMapping("/states/create")
    public String CreateState(
            @Valid @ModelAttribute("state")State  state,
            BindingResult result
    ) {
        if(result.hasErrors()) {
            return "create-state.jsp";
        } else {
            stateService.createOrUpdate(state);
            return "redirect:/";
        }
    }
    @GetMapping("/states/delete/{id}")
    public String DeleteState(@PathVariable("id") Long id) {
        stateService.deleteOne(id);
        return "redirect:/";
    }


}
