package com.spring.sample.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Person controller.
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping({"/", "/login", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("persons", personService.listAllPersons());
        return "persons";
    }

    @RequestMapping("person/{id}")
    public String showPerson(@PathVariable Integer id, Model model) {
        model.addAttribute("person", personService.getPersonById(id));
        return "personshow";
    }

    @RequestMapping("person/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("person", personService.getPersonById(id));
        return "personform";
    }

    @RequestMapping("person/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "personform";
    }

    @RequestMapping(value = "person", method = RequestMethod.POST)
    public String savePerson(Person person) {
        personService.savePerson(person);
        return "redirect:/person/" + person.getId();
    }

    @RequestMapping("person/delete/{id}")
    public String delete(@PathVariable Integer id) {
        personService.deletePerson(id);
        return "redirect:/persons";
    }

}
