package com.example;


import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Path("queries")
    @Produces(MediaType.TEXT_PLAIN)
    public String getExtraInfo(
            @QueryParam("name") String name,
            @QueryParam("address") @DefaultValue("Living on the streets") String address) {
        return "You asked about name " + name + " and address " + address;
    }


    @DELETE
    @Produces("text/plain")
    public String deleteOne() {
        return "Aaaargh, I'm deleted";
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteTwo() {
        return "{ \"result\" : \"Aaaargh, I'm deleted\" }";
    }

    @GET
    @Path("andmore")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSomeData() {
    	return "{ "
    			+ "\"name\" : \"Fred\","
    			+ "\"creditLimit\" : 2000"
    			+ "}";
    }

    @POST
    @Path("doMyForm")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String getForm(@FormParam("fname") String fName, @FormParam("lname") String lName) {
        return "Form contained fname " + fName + " and lName " + lName;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/customer/{id:\\d+}")
    public Response getOneCustomer(@Context HttpHeaders headers, @PathParam("id") int theId) {
        System.out.println("In getOneCustomer");

        Response.ResponseBuilder builder = Response.ok();
        StringBuilder outText = new StringBuilder();

        if (theId < 0 || theId > 2000) {
            builder.status(Response.Status.NOT_FOUND);

            MultivaluedMap<String, String> headerMap = headers.getRequestHeaders();
            final Set<String> headerSet = headerMap.keySet();
            for (String key : headerSet) {
                List<String> values = headerMap.get(key);
                System.out.println("Key: " + key + ": " + values);
                for (String val : values) {
                    outText.append(key + ": " + val + "\n");
                }
            }
            builder.entity(outText.toString());

        } else {
            builder
                    .entity("Found customer " + theId)
                    .header("x-simon-was-here", "Yup, sure was!");
        }
        return builder.build();
    }
    
}
