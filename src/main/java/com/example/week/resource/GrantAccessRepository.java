package com.example.week.resource;

import com.example.week.models.GrantAccess;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
}
