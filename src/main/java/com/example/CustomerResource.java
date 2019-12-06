package com.example;

import com.example.domain.Customer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/customer")
public class CustomerResource {

    private static final Map<Integer, Customer> custDB = new HashMap<>();
    static {
        custDB.put(1234, new Customer("Fred Jones", 1000));
        custDB.put(1235, new Customer("Jim Smith", 2000));
        custDB.put(2046, new Customer("Sheila Armstrong", 10000));
    }

    @Path("/{id:\\d+}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getOneCustomer(@PathParam("id") int theCustomerId) {
        System.out.println("Invoked getOneCustomer with id of " + theCustomerId);
        return custDB.get(theCustomerId).toString();
    }

    @Path("/{id:\\d+}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getOneCustomerStruct(@PathParam("id") int theCustomerId) {
        System.out.println("Invoked getOneCustomer with id of " + theCustomerId);
        return Response
                .ok()
                .status(201)
                .header("x-simon-woz-ere", "TODAY")
                .entity(custDB.get(theCustomerId))
                .build();
    }
}
