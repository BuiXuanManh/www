package vn.edu.iuh.fit.backend.resource;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.implement.ProductImplement;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Path("/products")
public class ProductResource {
    private ProductService productService;

    public ProductResource() {
        productService = new ProductImplement();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id") Long id) {
        Product productDTO = productService.findById(id);
        if (productDTO != null) {
            return Response.ok(productDTO).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        List<Product> productDTOAllProperties = productService.findAll();
        return Response.ok(productDTOAllProperties).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response add(Product productDTO) {
        boolean updated = productService.create(productDTO);
        if (updated) {
            return Response.ok("ADD SUCCESS").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("id")Long id,Product productDTO) {
        boolean updated = productService.update(productDTO);
        if (updated) {
            return Response.ok("UPDATE SUCCESS").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response delete(@PathParam("id") Long id) {
        boolean updated = productService.delete(id);
        if (updated) {
            return Response.ok("DELETE SUCCESS").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
