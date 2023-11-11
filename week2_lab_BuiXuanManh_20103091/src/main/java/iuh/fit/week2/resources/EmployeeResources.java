package iuh.fit.week2.resources;


import iuh.fit.week2.models.Employee;
import iuh.fit.week2.services.EmployeeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Path("/employees")
public class EmployeeResources {
    @Inject
    private EmployeeService employeeServices;
    private final Logger logger =
            LoggerFactory.getLogger(this.getClass().getName());

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getEmp(@PathParam("id") Long eid) {
        Optional<Employee> empOpt = employeeServices.findById(eid);
        if (empOpt.isPresent()) {
            return Response.ok(empOpt.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        //paging if possible
        List<Employee> lst = employeeServices.findAll();
        return Response.ok(lst).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Employee employee) {
        employeeServices.create(employee);
        return Response.ok(employee).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Optional<Employee> empOpt = employeeServices.findById(id);
        if (empOpt.isPresent()) {
            return Response.ok(empOpt.get()).build();
        }
        if (employeeServices.delete(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
