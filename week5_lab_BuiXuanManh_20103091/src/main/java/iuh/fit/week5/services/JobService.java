package iuh.fit.week5.services;

import iuh.fit.week5.entities.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface JobService {
    List<Job> getAll();
    Optional<Job> find(Long id);
    Job save(Job job);
}
