package vn.edu.iuh.fit.backend;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import vn.edu.iuh.fit.backend.implement.EmployeeImplement;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.repositories.Connection;
import vn.edu.iuh.fit.backend.service.EmployeeService;

@ApplicationPath("/api")
public class RootConApplication extends Application {
//    public static void main(String[] args) {
//        EntityManager em = Connection.getInstance().getEmf().createEntityManager();
//        EntityTransaction tr = em.getTransaction();
//        tr.begin();
//        try {
//            tr.commit();
//        }catch (Exception e){
//            tr.rollback();
//        }
//    }
}
