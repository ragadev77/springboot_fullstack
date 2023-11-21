package test.app.konsumen.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import test.app.konsumen.Models.Konsumen;
import test.app.konsumen.Repositories.KonsumenRepository;

@Controller
public class WebController {
    @Autowired
    KonsumenRepository konsumenRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("konsumens", konsumenRepository.findAll());
        model.addAttribute("konsumen", new Konsumen());
        return "index";
    }

    // @RequestMapping("/error")
    // public String handleError() {
    //     // do something like logging
    //     return "error"; 
    // }

    // @RequestMapping("/hello")
    // public String hello() {
    //     return "hi";
    // }

}
