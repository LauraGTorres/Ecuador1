package brayanmattalauratorres.ecuador.controller.user;

import brayanmattalauratorres.ecuador.model.constant.NewsState;
import brayanmattalauratorres.ecuador.model.entity.News;
import brayanmattalauratorres.ecuador.model.service.NewsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news")
public class UserNewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public String listPublishedNews(Model model) {
        model.addAttribute("newsList", newsService.findByState(NewsState.PURPOSE_PUBLISHED));
        return "user/news-list";
    }

    @GetMapping("/{id}")
    public String newsDetail(@PathVariable Long id, Model model) {
        News news = newsService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("News not found"));
        model.addAttribute("news", news);
        return "user/news-detail";
    }
}