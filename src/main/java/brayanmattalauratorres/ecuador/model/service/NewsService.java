package brayanmattalauratorres.ecuador.model.service;

import brayanmattalauratorres.ecuador.model.constant.NewsState;
import brayanmattalauratorres.ecuador.model.dto.NewsDTO;
import brayanmattalauratorres.ecuador.model.entity.News;
import brayanmattalauratorres.ecuador.model.repository.NewsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    @Autowired
    NewsRepository repository;

    public List<News> findAll() {
        return repository.findAll();
    }

    public List<News> findByState(NewsState state) {
        return repository.findByState(state);
    }

    public Optional<News> findById(Long id) {
        return repository.findById(id);
    }

    public void create(NewsDTO dto) {
        repository.save(dto.toEntity());
    }

    public void update(Long id, NewsDTO request) throws EntityNotFoundException {
        News news = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("News with id " + id + " not found"));

        news.setTitle(request.title());
        news.setSummary(request.summary());
        news.setContent(request.content());
        news.setImageUrl(request.imageUrl());
        news.setAuthor(request.author());
        news.setState(request.state());

        repository.save(news);
    }

    public void delete(Long id) throws EntityNotFoundException {
        News news = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("News with id " + id + " not found"));
        repository.delete(news);
    }
}