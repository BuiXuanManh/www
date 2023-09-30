package vn.edu.iuh.fit.backend.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Path("/employees")
public class EmployeeResources {
    @Inject
    private EmployeeService employeeService;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id") Long id) {
        Optional<Employee> employeeDTO = employeeService.findById(id);
        if (employeeDTO.isPresent()) {
            return Response.ok(employeeDTO).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        List<Employee> employeeDTOs = employeeService.findAll();
        return Response.ok(employeeDTOs).build();
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response save(Employee employeeDTO) {
        boolean save = employeeService.create(employeeDTO);
        if (save) {
            return Response.ok("Add success").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("id") long id, Employee employeeDTO) {
        boolean save = employeeService.update(employeeDTO);
        if (save) {
            return Response.ok("Update success employee id: "+id).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Response delete(@PathParam("id") long id) {
        boolean save = employeeService.delete(id);
        if (save) {
            return Response.ok("delete success employee id: "+id).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
