package com.example.week.resource;

import com.example.week.models.Log;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class LogRepository {
    private EntityManager em;
    private EntityTransaction tr;
    public LogRepository(){
        em=Connection.getInstance().getEmf().createEntityManager();
    }
    public boolean createLog(Log a){
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
    public List<Log> findLogByA(String u){
        List<Log> l = em.createQuery("select l from Log l where l.account.account_id= " + u).getResultList();
        return l;
    }
    
}
