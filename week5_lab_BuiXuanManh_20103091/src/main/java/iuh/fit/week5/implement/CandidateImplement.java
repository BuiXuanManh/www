package iuh.fit.week5.implement;

import iuh.fit.week5.entities.Candidate;
import iuh.fit.week5.repositories.CandidateRepository;
import iuh.fit.week5.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CandidateImplement implements CandidateService {
    @Autowired
    private CandidateRepository repository;
    @Override
    public List<Candidate> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Candidate> find(Long id) {
        return repository.findById(id);
    }

    @Override
    public Candidate save(Candidate candidate) {
        return repository.save(candidate);
    }
}
