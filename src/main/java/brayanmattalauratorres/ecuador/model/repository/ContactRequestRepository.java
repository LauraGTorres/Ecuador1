package brayanmattalauratorres.ecuador.model.repository;

import brayanmattalauratorres.ecuador.model.constant.ContactPurpose;
import brayanmattalauratorres.ecuador.model.entity.ContactRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRequestRepository extends JpaRepository<ContactRequest, Long> {
    List<ContactRequest> findByPurpose(ContactPurpose purpose);
}