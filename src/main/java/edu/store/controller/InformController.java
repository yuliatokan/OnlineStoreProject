package edu.store.controller;

import edu.store.ui.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InformController {
    @RequestMapping("/campaign")
    public String campaign() {
        return Pages.PAGE_CAMPAIGN;
    }

    @RequestMapping("/about_us")
    public String aboutUs() {
        return Pages.PAGE_ABOUT_US;
    }

    @RequestMapping("/contacts")
    public String contacts() {
        return Pages.PAGE_CONTACT;
    }
}
