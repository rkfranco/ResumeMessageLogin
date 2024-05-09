package org.acme.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.models.forms.LoginForm;
import org.acme.services.LoginService;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

@Path("/login")
public class LoginController {

    @Inject
    private LoginService loginService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<?> login(LoginForm loginForm) throws Exception {
        return ResponseBuilder.ok(loginService.login(loginForm)).build();
    }
}
