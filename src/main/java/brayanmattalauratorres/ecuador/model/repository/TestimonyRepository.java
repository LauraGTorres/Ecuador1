package brayanmattalauratorres.ecuador.model.repository;


import brayanmattalauratorres.ecuador.model.entity.Testimony;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestimonyRepository extends JpaRepository<Testimony, Long> {
}