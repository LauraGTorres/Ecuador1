package brayanmattalauratorres.ecuador.model.dto;

import brayanmattalauratorres.ecuador.model.constant.NewsState;
import brayanmattalauratorres.ecuador.model.entity.News;

import java.time.LocalDateTime;

public record NewsDTO(
        String title,
        String summary,
        String content,
        String imageUrl,
        String author,
        NewsState state
) {
    public News toEntity() {
        News news = new News();
        news.setTitle(title);
        news.setSummary(summary);
        news.setContent(content);
        news.setImageUrl(imageUrl);
        news.setAuthor(author);
        news.setState(state);
        news.setPublicationDate(LocalDateTime.now());
        return news;
    }
}