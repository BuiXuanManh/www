package iuh.fit.springtest.implement;

import iuh.fit.springtest.dao.EmployeeDao;
import iuh.fit.springtest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
@Component
public class EmployeeDaoEmplement implements EmployeeDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    @Override
    public boolean insert(Employee e) {
        String query = "INSERT INTO Employee (id, name, role) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, e.getId());
            preparedStatement.setString(2, e.getName());
            preparedStatement.setString(3, e.getRole());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Insertion successful");
                return true;
            } else {
                System.out.println("Insertion failed");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error while inserting employee", ex);
        }
        return false;
    }

    @Override
    public List<Employee> getAll() {
        String SQL ="SELECT * FROM Employee LIMIT 5 ";
        List<Employee> list = jdbcTemplate.query(SQL,new BeanPropertyRowMapper<>(Employee.class));
        return list;
    }

    @Override
    public Employee findById(int id) {
        String SQL ="SELECT * FROM Employee Where id= ?";
        Employee em = new Employee();
        try {
            em = jdbcTemplate.queryForObject(SQL, new BeanPropertyRowMapper<>(Employee.class), id);

        }catch (Exception e){

        }
        return em;
    }


    @Override
    public boolean update(Employee e) {
        Employee em =findById(e.getId());
        if(em!=null){
            deleteById(em.getId());

        }
        insert(e);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        String SQL ="DELETE FROM Employee WHERE Id= ?";
        jdbcTemplate.update(SQL,id);
        System.out.println("delete complete");
        return true;
    }

    @Override
    public int count() {
        String SQL ="SELECT count(*) FROM Employee";
        return jdbcTemplate.queryForObject(SQL,Integer.class);
    }

}
