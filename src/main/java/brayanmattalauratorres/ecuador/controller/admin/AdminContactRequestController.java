package brayanmattalauratorres.ecuador.controller.admin;

import brayanmattalauratorres.ecuador.model.service.ContactRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/requests")
public class AdminContactRequestController {

    @Autowired
    private ContactRequestService contactRequestService;

    @GetMapping
    public String listAll(Model model) {
        model.addAttribute("requests", contactRequestService.findAll());
        return "admin/requests-list";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        contactRequestService.delete(id);
        redirectAttributes.addFlashAttribute("successMessage", "Solicitud eliminada exitosamente.");
        return "redirect:/admin/requests";
    }
}
