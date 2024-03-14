package com.testSpringBootTwo;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping(value ="/")
    public ModelAndView homePage(Model model){
        model.addAttribute("message", "Hello");
        ModelAndView mav = new ModelAndView("homePage");
        return mav;
    }
}
