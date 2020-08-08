package me.herrlestrate.writeups.controller;

import me.herrlestrate.writeups.model.Writeup;
import me.herrlestrate.writeups.service.WriteupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/writeup")
public class WriteupController {

    private WriteupService writeupService;

    @Autowired
    public void setWriteupService(WriteupService writeupService){
        this.writeupService = writeupService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    ModelAndView homeContent() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("writeup");
        List<Writeup> writeups = writeupService.allWriteups();
        Collections.reverse(writeups);
        modelAndView.addObject("writeups", writeups);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ModelAndView writeupContent(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("writeup_profile");
        Writeup writeup = writeupService.getById(id);
        modelAndView.addObject("writeup", writeup);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    ModelAndView editWriteupPage(@PathVariable int id) {
        Writeup writeup = writeupService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editWriteupPage");
        modelAndView.addObject("writeup", writeup);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    ModelAndView editWriteup(@PathVariable int id, @ModelAttribute("writeup") Writeup writeup) {
        writeup.setDate(new Date());
        writeupService.update(writeup);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/writeup/" + id);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    ModelAndView deleteWriteup(@PathVariable int id) {
        Writeup writeup = writeupService.getById(id);
        writeupService.delete(writeup);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/writeup/");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    ModelAndView addWriteupPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addWriteupPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    ModelAndView addWriteup(@ModelAttribute("writeup") Writeup writeup) {
        writeup.setDate(new Date());
        writeupService.create(writeup);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
