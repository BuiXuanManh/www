package iuh.fit.week5.repositories;

import iuh.fit.week5.entities.Candidate;
import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Long>, JpaSpecificationExecutor<Candidate> {
    @Query("select c from Candidate c where c.candidateStatus=0")
    List<Candidate> getAll();
}
