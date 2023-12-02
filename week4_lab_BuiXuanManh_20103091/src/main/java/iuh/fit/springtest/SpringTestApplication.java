package iuh.fit.springtest;

import iuh.fit.springtest.dao.EmployeeDao;
import iuh.fit.springtest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringTestApplication implements CommandLineRunner {
    @Autowired
    private EmployeeDao employeeDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee e= new Employee(5,"employee","hung");
//        employeeDao.insert(e);
        System.out.println("ok");

//        Employee l = employeeDao.findById(3);
//        employeeDao.update(e);
//        employeeDao.findById(3);

//        System.out.println(employeeDao.count());
        employeeDao.deleteById(4);
        List<Employee> l = employeeDao.getAll();
        l.forEach(p -> System.out.println(p));

    }
}
