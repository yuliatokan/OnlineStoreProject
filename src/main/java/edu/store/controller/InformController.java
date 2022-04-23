package edu.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InformController {
    @RequestMapping("/campaign")
    public String campaign(){
        return "campaign";
    }

    @RequestMapping("/about_us")
    public String aboutUs(){
        return "about_us";
    }

    @RequestMapping("/contacts")
    public String contacts(){
        return "contacts";
    }
}
