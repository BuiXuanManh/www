package vn.edu.iuh.fit.backend.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.models.ProductPrice;
import vn.edu.iuh.fit.backend.service.ProductPriceService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Path("/product-prices")
public class ProductPriceResources {
    @Inject
    private ProductPriceService productPriceService;

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response findById(@PathParam("id") String id) {
        LocalDateTime localDateTime = LocalDateTime.parse(id);
        Optional<ProductPrice> productPriceDTO = productPriceService.findById(localDateTime);
        if (productPriceDTO != null) {
            return Response.ok(productPriceDTO).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        List<ProductPrice> priceDTOS = productPriceService.findAll();
        return Response.ok(priceDTOS).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response add(ProductPrice productPriceDTO) {
        productPriceDTO.setPriceDatetime(LocalDateTime.now());
        boolean updated = productPriceService.create(productPriceDTO);
        if (updated) {
            return Response.ok("ADD SUCCESS").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("id") String id, ProductPrice productPriceDTO) {
        productPriceDTO.setPriceDatetime(LocalDateTime.parse(id));
        boolean updated = productPriceService.update(productPriceDTO);
        if (updated) {
            return Response.ok("UPDATE SUCCESS").build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
