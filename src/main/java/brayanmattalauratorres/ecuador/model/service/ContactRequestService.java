package brayanmattalauratorres.ecuador.model.service;


import brayanmattalauratorres.ecuador.model.dto.ContactRequestDTO;
import brayanmattalauratorres.ecuador.model.entity.ContactRequest;
import brayanmattalauratorres.ecuador.model.repository.ContactRequestRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactRequestService {

    @Autowired
    ContactRequestRepository repository;

    public List<ContactRequest> findAll() {
        return repository.findAll();
    }

    public Optional<ContactRequest> findById(Long id) {
        return repository.findById(id);
    }

    public void create(ContactRequestDTO contact) {
        repository.save(contact.toEntity());
    }

    public void delete(Long id) throws EntityNotFoundException {
        ContactRequest cr = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ContactRequest with id " + id + " not found"));
        repository.delete(cr);
    }
}
