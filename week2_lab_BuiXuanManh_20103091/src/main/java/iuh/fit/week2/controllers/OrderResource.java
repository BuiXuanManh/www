//package iuh.fit.week2.controllers;
//
//import iuh.fit.week2.implement.OrderDetailImplement;
//import iuh.fit.week2.implement.OrderImplement;
//import iuh.fit.week2.models.Order;
//import iuh.fit.week2.models.OrderDetail;
//import iuh.fit.week2.services.OrderDetailService;
//import iuh.fit.week2.services.OrderService;
//import jakarta.validation.constraints.Positive;
//import jakarta.ws.rs.GET;
//import jakarta.ws.rs.POST;
//import jakarta.ws.rs.Path;
//import jakarta.ws.rs.PathParam;
//import jakarta.ws.rs.core.Response;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
//@Path("/order")
//public class OrderResource {
//    private final OrderDetailService o = new OrderDetailImplement();
//    private final OrderService service= new OrderImplement();
//    @GET
//    public List<Order> findAll(){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        List<Order> l = service.findAll();
//        return l;
//    }
//    @POST
//    @Path("/create")
//    public Response createOrder(OrderDetail order){
//        boolean b = o.create(order);
//        return b? Response.ok().build():Response.status(Response.Status.NOT_FOUND).build();
//    }
//    @GET
//    @Path("/{date}")
//    public List<Order> findOrdersByDate(@PathParam("date") String date){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//            LocalDate localDate = LocalDate.parse(date, formatter);
//        List<Order> l = service.findOrdersByDate(localDate);
//        return l;
//    }
//    @GET
//    @Path("/{dateS}/{dateE}")
//    public List<Order> findOrdersByDateRange(@PathParam("dateS") String dateS,  @PathParam("dateE") String dateE){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate localDateS = LocalDate.parse(dateS, formatter);
//        LocalDate localDateE = LocalDate.parse(dateE, formatter);
//        List<Order> l = service.findOrdersByDateRange(localDateS, localDateE);
//        return l;
//    }
//    @GET
//    @Path("/{dateS}/{dateE}/{empId}")
//    public List<Order> findOrdersByDateRange(@PathParam("dateS") String dateS,  @PathParam("dateE") String dateE, @PathParam("empId") String empId){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate localDateS = LocalDate.parse(dateS, formatter);
//        LocalDate localDateE = LocalDate.parse(dateE, formatter);
//        List<Order> l = service.findOrdersByEmployeeDateAndRange(localDateS, localDateE,empId);
//        return l;
//    }
//}
