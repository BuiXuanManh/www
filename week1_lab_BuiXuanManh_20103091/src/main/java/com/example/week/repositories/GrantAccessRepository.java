package com.example.week.repositories;

import com.example.week.enums.GrantStatus;
import com.example.week.models.GrantAccess;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.Optional;

public class GrantAccessRepository {
    private EntityManager em;
    private EntityTransaction tr;
    public GrantAccessRepository() {
        em=Connection.getInstance().getEmf().createEntityManager();
    }
    public boolean grantAccess(GrantAccess a){
        tr = em.getTransaction();
        tr.begin();
        try {
            em.persist(a);
            tr.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public boolean update(GrantAccess a){
        tr = em.getTransaction();
        tr.begin();
        try {
            em.merge(a);
            tr.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public void grantCancel(GrantAccess a){
        a.setGrantStatus(GrantStatus.DISABLED);
        update(a);
    }
    public Optional<GrantAccess> findByAR(String id, String name) {
        try {
            GrantAccess result = em.createNamedQuery("GrantAccess.findByAR", GrantAccess.class)
                    .setParameter("id", id)
                    .setParameter("name", name)
                    .getSingleResult();
            return Optional.ofNullable(result);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
