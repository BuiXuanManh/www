package com.example.week.resources;

import com.example.week.models.Account;
import com.example.week.models.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
public class AccountRepository {
    private EntityManager em;
    private EntityTransaction tr;
    public AccountRepository(){
        em=Connection.getInstance().getEmf().createEntityManager();
    }
    public boolean createAccount(Account a){
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
    public boolean updateAccount(Account a){
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
    public List<Account> getAll(){
        List<Account> l = em.createQuery("select a from Account a").getResultList();
        return l;
    }
    public Account find(String id){
        Account aa = (Account) em.createQuery("select a from Account a where a.account_id="+id).getSingleResult();
        return aa;
    }
    public List<Account> findAcByRole(){
        List<Account> l= em.createQuery("select a from Account a join GrantAccess g on a.account_id=g.account.account_id group by a having Count(g.role.role_id) = 1").getResultList();
        return l;
    }
    public Role findRole(String username){
        Role r= (Role) em.createQuery("select g.role from Account a join GrantAccess g on a.account_id=g.account.account_id where a.account_id= "+ username).getSingleResult();
        return r;
    }
}
