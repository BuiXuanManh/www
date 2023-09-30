package vn.edu.iuh.fit.backend.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.service.OrderService;

import java.util.List;

@Path("/orders")
public class OrderResources {
    @Inject
    private OrderService orderService;

    //    http://localhost:8080/api/orders/1
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id") Long id) {
        Order orderDTO = orderService.findById(id);
        if (orderDTO != null) {
            return Response.ok(orderDTO).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    //    http://localhost:8080/api/orders
    @GET
    @Produces("application/json")
    public Response getAll() {
        List<Order> orderDTOList = orderService.findAll();
        return Response.ok(orderDTOList).build();
    }

//        http://localhost:8080/api/orders
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(Order orderDTO) {
        boolean save = orderService.create(orderDTO);
        if (save) {
            return Response.ok("Add success").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    //    http://localhost:8080/api/customers/{id}
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("id") long id, Order orderDTO) {
        orderDTO.setOrderId(id);
        boolean save = orderService.update(orderDTO);
        if (save) {
            return Response.ok("Update success order id: " + id).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
