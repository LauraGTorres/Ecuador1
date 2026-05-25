package brayanmattalauratorres.ecuador.model.repository;


import brayanmattalauratorres.ecuador.model.constant.NewsState;
import brayanmattalauratorres.ecuador.model.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findByState(NewsState state);
}