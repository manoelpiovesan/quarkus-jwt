package io.github.manoelpiovesan.resources;

import io.github.manoelpiovesan.utils.Role;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.jwt.JsonWebToken;


/**
 * @author Manoel Rodrigues
 */
@Path("/test")
@RequestScoped
public class TestResource {

    @Inject
    JsonWebToken jwt;

    /**
     * Test if the token is working for users
     *
     * @return String
     */
    @GET
    @Path("/protected-for-users")
    @RolesAllowed({Role.USER})
    public String testUser() {
        return "Hello, World! This is a protected resource for users! Your username is: " + jwt.getClaim("firstName");
    }

    /**
     * Test if the token is working for admins
     *
     * @return String
     */
    @GET
    @Path("/protected-for-admins")
    @RolesAllowed({Role.ADMIN})
    public String testAdmin() {
        return "Hello, World! This is a protected resource for admins! Your username is: " + jwt.getClaim("firstName");
    }


    /**
     * Test if the token is working for public resources
     *
     * @return String
     */
    @GET
    @PermitAll
    @Path("/public")
    public String publicTest() {
        return "Hello, World! This is a public resource!";
    }
}