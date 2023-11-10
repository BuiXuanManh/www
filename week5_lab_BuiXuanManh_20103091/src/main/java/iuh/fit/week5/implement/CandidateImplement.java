package iuh.fit.week5.implement;

import iuh.fit.week5.entities.Candidate;
import iuh.fit.week5.enums.CandidateStatus;
import iuh.fit.week5.repositories.CandidateRepository;
import iuh.fit.week5.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CandidateImplement implements CandidateService {
    @Autowired
    private CandidateRepository repository;
    @Override
    public List<Candidate> findAll() {
        return repository.getAll();
    }

    @Override
    public Optional<Candidate> find(Long id) {
        return repository.findById(id);
    }

    @Override
    public Candidate save(Candidate candidate) {
        return repository.save(candidate);
    }

    @Override
    public Page<Candidate> findPage(int pageNo, int size, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        PageRequest p = PageRequest.of(pageNo, size, sort);

        Specification<Candidate> activeCandidates = (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("candidateStatus"), 0);
        };

        return repository.findAll(activeCandidates, p);
    }

    @Override
    public void delete(Long id) {
        Optional<Candidate> a = find(id);
        Candidate b = a.get();
        b.setCandidateStatus(CandidateStatus.DELETED);
        repository.save(b);
    }
}
