package vn.edu.iuh.fit.backend.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.models.OrderDetail;
import vn.edu.iuh.fit.backend.service.OrderDetailService;

import java.util.List;

@Path("/order-details")
public class OrderDetailResources {
    @Inject
    private OrderDetailService orderDetailService;
    @GET
    @Path("/{orderId}/{procId}")
    @Produces("application/json")
    public Response findById(@PathParam("orderId") Long orderId, @PathParam("procId") Long procId) {
        OrderDetail orderDetailDTO = orderDetailService.findById(orderId,procId);
        if (orderDetailDTO != null) {
            return Response.ok(orderDetailDTO).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @GET
    @Produces("application/json")
    public Response getAll() {
        List<OrderDetail> orderDetailServiceAll = orderDetailService.findAll();
        return Response.ok(orderDetailServiceAll).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(OrderDetail orderDetailDTO) {
        boolean save = orderDetailService.create(orderDetailDTO);
        if (save) {
            return Response.ok("Add success").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    //    http://localhost:8080/api/order-details/{id}/{id}
    @PUT
    @Path("/{orderId}/{procId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("orderId") Long orderId,@PathParam("procId") Long procId ,OrderDetail orderDetailDTO) {
        boolean save = orderDetailService.update(orderDetailDTO);
        if (save) {
            return Response.ok("Update success orderDetail orderId: " + orderId+" procId: "+procId).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    //    http://localhost:8080/api/order-details/{id}/{id}

}
