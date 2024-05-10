package br.com.digab.messageresume.controllers;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

import br.com.digab.messageresume.models.forms.LoginForm;
import br.com.digab.messageresume.services.LoginService;

@Path("/login")
public class LoginController {

    @Inject
    private LoginService loginService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<?> login(@Valid LoginForm loginForm) throws Exception {
        return ResponseBuilder.ok(loginService.login(loginForm)).build();
    }
}
