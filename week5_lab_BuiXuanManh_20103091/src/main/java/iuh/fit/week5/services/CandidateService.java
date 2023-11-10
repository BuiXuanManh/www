package iuh.fit.week5.services;

import iuh.fit.week5.entities.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CandidateService {
    List<Candidate> findAll();
    Optional<Candidate> find(Long id);
    Candidate save(Candidate candidate);
    Page<Candidate> findPage(int pageNo, int size , String sortBy, String sortDirection);
    void delete(Long id);
}
