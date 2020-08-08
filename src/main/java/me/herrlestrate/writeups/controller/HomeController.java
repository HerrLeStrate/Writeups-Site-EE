package me.herrlestrate.writeups.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/about"}, method = RequestMethod.GET)
    public ModelAndView homeContent() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/about");
        return modelAndView;
    }
}
