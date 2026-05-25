package brayanmattalauratorres.ecuador.controller.user;

import brayanmattalauratorres.ecuador.model.service.TestimonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testimonials")
public class UserTestimonialController {

    @Autowired
    private TestimonyService testimonyService;

    @GetMapping
    public String listTestimonials(Model model) {
        model.addAttribute("testimonials", testimonyService.findAll());
        return "user/testimonials";
    }
}
