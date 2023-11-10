package com.example.week.repositories;

import com.example.week.models.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class RoleRepository {
    private EntityManager em;
    private EntityTransaction tr;
    public RoleRepository(){
        em=Connection.getInstance().getEmf().createEntityManager();
    }
    public boolean createRole(Role a){
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
    public boolean updateRole(Role a){
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
    public List<Role> getAll(){
        List<Role> l = em.createQuery("select a from Role a").getResultList();
        return l;
    }
    public Optional<Role> find(String id){
        return (Optional<Role>) em.createQuery("select a from Role a where a.role_id="+id).getSingleResult();

    }
    public List<Role> findByAccId(String id){
        return em.createNamedQuery("Role.findByAccId",Role.class).setParameter("id",id).getResultList();
    }
    public Role findByRoleName(String name){
        return em.createNamedQuery("Role.findByRoleName",Role.class).setParameter("name",name).getSingleResult();
    }

}