package vl.klepikov.spring.boot.ex.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vl.klepikov.spring.boot.ex.model.Person;
import vl.klepikov.spring.boot.ex.service.PersonService;


@Controller
@RequestMapping("/users")
public class UsersController {

    private final PersonService service;

    @Autowired
    public UsersController(PersonService service) {
        this.service = service;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", service.index());
        return "users";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", service.show(id));
        return "show";
    }
    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());

        return "new";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        service.save(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id")int id) {
        model.addAttribute(service.show(id));
        return "edit";
    }
    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("person") @Valid Person user, BindingResult bindingResult, @PathVariable("id")int id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        service.update(user);
        return "redirect:/users";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id) {
        service.delete(id);
        return "redirect:/users";
    }
}