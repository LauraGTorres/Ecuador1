package brayanmattalauratorres.ecuador.model.service;


import brayanmattalauratorres.ecuador.model.dto.TestimonyDTO;
import brayanmattalauratorres.ecuador.model.entity.Testimony;
import brayanmattalauratorres.ecuador.model.repository.TestimonyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestimonyService {

    @Autowired
    TestimonyRepository repository;

    public List<Testimony> findAll() {
        return repository.findAll();
    }

    public Optional<Testimony> findById(Long id) {
        return repository.findById(id);
    }

    public void create(TestimonyDTO dto) {
        repository.save(dto.toEntity());
    }

    public void update(Long id, TestimonyDTO request) throws EntityNotFoundException {
        Testimony testimony = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Testimony with id " + id + " not found"));

        testimony.setName(request.name());
        testimony.setPhotoUrl(request.toEntity().getPhotoUrl());
        testimony.setInstagramUrl(request.instagramUrl());
        testimony.setFacebookUrl(request.facebookUrl());

        repository.save(testimony);
    }

    public void delete(Long id) throws EntityNotFoundException {
        Testimony testimony = repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Testimony with id " + id + " not found"));
        repository.delete(testimony);
    }
}
