package brayanmattalauratorres.ecuador.controller.admin;

import brayanmattalauratorres.ecuador.model.dto.TestimonyDTO;
import brayanmattalauratorres.ecuador.model.service.TestimonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/testimonials")
public class AdminTestimonialController {

    @Autowired
    private TestimonyService testimonyService;

    @GetMapping
    public String listAll(Model model) {
        model.addAttribute("testimonials", testimonyService.findAll());
        return "admin/testimonials-list";
    }

    @GetMapping("/new")
    public String createForm() {
        return "admin/testimonials-form";
    }

    @PostMapping("/new")
    public String createTestimony(
            @RequestParam String name,
            @RequestParam String imageUrl,
            @RequestParam(required = false) String instagramUrl,
            @RequestParam(required = false) String facebookUrl,
            RedirectAttributes redirectAttributes) {

        TestimonyDTO dto = new TestimonyDTO(name, imageUrl, instagramUrl, facebookUrl);
        testimonyService.create(dto);
        redirectAttributes.addFlashAttribute("successMessage", "Testimonio creado exitosamente.");
        return "redirect:/admin/testimonials";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        testimonyService.delete(id);
        redirectAttributes.addFlashAttribute("successMessage", "Testimonio eliminado exitosamente.");
        return "redirect:/admin/testimonials";
    }
}
