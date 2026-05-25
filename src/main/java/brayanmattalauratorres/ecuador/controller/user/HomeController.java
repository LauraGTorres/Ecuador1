package brayanmattalauratorres.ecuador.controller.user;

import brayanmattalauratorres.ecuador.model.constant.ContactPurpose;
import brayanmattalauratorres.ecuador.model.constant.NewsState;
import brayanmattalauratorres.ecuador.model.dto.ContactRequestDTO;
import brayanmattalauratorres.ecuador.model.service.ContactRequestService;
import brayanmattalauratorres.ecuador.model.service.NewsService;
import brayanmattalauratorres.ecuador.model.service.TestimonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private TestimonyService testimonyService;

    @Autowired
    private ContactRequestService contactRequestService;

    @GetMapping({"/", "/home"})
    public String homePage(Model model) {
        model.addAttribute("publishedNews", newsService.findByState(NewsState.PURPOSE_PUBLISHED));
        model.addAttribute("testimonials", testimonyService.findAll());
        model.addAttribute("purposes", ContactPurpose.values());
        return "user/home";
    }

    @PostMapping("/contact")
    public String submitContact(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam ContactPurpose purpose,
            RedirectAttributes redirectAttributes) {

        ContactRequestDTO dto = new ContactRequestDTO(name, email, phone, purpose);
        contactRequestService.create(dto);
        redirectAttributes.addFlashAttribute("successMessage", "¡Gracias por contactarnos! Te responderemos pronto.");
        return "redirect:/#contact";
    }
}
