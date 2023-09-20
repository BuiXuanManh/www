package com.example.week.resource;

import com.example.week.models.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
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
    public void deleteRole(Role a){
        tr = em.getTransaction();
        tr.begin();
        try {
            em.remove(a);
            tr.commit();
        } catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
    }
    public List<Role> getAll(){
        List<Role> l = em.createQuery("select a from Role a").getResultList();
        return l;
    }
    public Role find(String id){
        Role aa = (Role) em.createQuery("select a from Role a where a.role_id="+id).getSingleResult();
        return aa;
    }
}