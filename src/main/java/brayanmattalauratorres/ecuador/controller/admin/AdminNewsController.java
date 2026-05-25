package brayanmattalauratorres.ecuador.controller.admin;

import brayanmattalauratorres.ecuador.model.constant.NewsState;
import brayanmattalauratorres.ecuador.model.dto.NewsDTO;
import brayanmattalauratorres.ecuador.model.entity.News;
import brayanmattalauratorres.ecuador.model.service.NewsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/news")
public class AdminNewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public String listAll(Model model) {
        model.addAttribute("newsList", newsService.findAll());
        model.addAttribute("states", NewsState.values());
        return "admin/news-list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("states", NewsState.values());
        return "admin/news-form";
    }

    @PostMapping("/new")
    public String createNews(
            @RequestParam String title,
            @RequestParam String summary,
            @RequestParam String content,
            @RequestParam(required = false) String imageUrl,
            @RequestParam String author,
            @RequestParam NewsState state,
            RedirectAttributes redirectAttributes) {

        NewsDTO dto = new NewsDTO(title, summary, content, imageUrl, author, state);
        newsService.create(dto);
        redirectAttributes.addFlashAttribute("successMessage", "Noticia creada exitosamente.");
        return "redirect:/admin/news";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        News news = newsService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("News not found"));
        model.addAttribute("news", news);
        model.addAttribute("states", NewsState.values());
        return "admin/news-form";
    }

    @PostMapping("/edit/{id}")
    public String updateNews(
            @PathVariable Long id,
            @RequestParam String title,
            @RequestParam String summary,
            @RequestParam String content,
            @RequestParam(required = false) String imageUrl,
            @RequestParam String author,
            @RequestParam NewsState state,
            RedirectAttributes redirectAttributes) {

        NewsDTO dto = new NewsDTO(title, summary, content, imageUrl, author, state);
        newsService.update(id, dto);
        redirectAttributes.addFlashAttribute("successMessage", "Noticia actualizada exitosamente.");
        return "redirect:/admin/news";
    }

    @PostMapping("/delete/{id}")
    public String deleteNews(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        newsService.delete(id);
        redirectAttributes.addFlashAttribute("successMessage", "Noticia eliminada exitosamente.");
        return "redirect:/admin/news";
    }
}