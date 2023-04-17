package com.pablox.citystatespart2.controllers;

import com.pablox.citystatespart2.models.City;
import com.pablox.citystatespart2.models.State;
import com.pablox.citystatespart2.services.CityService;
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
public class CityController {
     @Autowired
     private CityService cityService;
     @Autowired
     private StateService stateService;

    @GetMapping("/cities/create")
    public String CreateCity(@ModelAttribute("city") City city, Model model) {
        model.addAttribute("states", stateService.getAll());
        return "create-city.jsp";
    }
    @PostMapping("/cities/create")
    public String CreateState(
            @Valid @ModelAttribute("city")City  city,
            BindingResult result
    ) {
        if(result.hasErrors()) {
            return "create-city.jsp";
        } else {
            cityService.createOrUpdate(city);
            return "redirect:/";
        }
    }
    @GetMapping("/cities/{city_id}/view")
    public String ViewMatch(
                            @PathVariable("city_id") Long city_id,
                            Model model) {

        // get the specific match
        // load the match onto the page
        City oneCity = cityService.getOne(city_id);
        model.addAttribute("oneCity", oneCity);
        // return the page
        return "city.jsp";
    }
    @GetMapping("/cities/delete/{id}")
    public String DeleteCity(@PathVariable("id") Long id) {
        cityService.deleteOne(id);
        return "redirect:/";
    }

}
