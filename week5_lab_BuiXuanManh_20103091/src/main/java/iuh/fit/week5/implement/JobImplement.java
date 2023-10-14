package iuh.fit.week5.implement;

import iuh.fit.week5.entities.Job;
import iuh.fit.week5.repositories.JobRepository;
import iuh.fit.week5.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JobImplement implements JobService {
    @Autowired
    private JobRepository repository;

    @Override
    public List<Job> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Job> find(Long id) {
        return repository.findById(id);
    }

    @Override
    public Job save(Job job) {
        return repository.save(job);
    }
}
