package br.com.digab.messageresume.controllers;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

import br.com.digab.messageresume.models.dtos.UserDto;
import br.com.digab.messageresume.models.forms.UserForm;
import br.com.digab.messageresume.services.UserService;

@Path("/user")
public class UserController {

    @Inject
    private UserService userService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<?> createUser(@Valid UserForm form, @Context UriInfo uriInfo) throws Exception {
        UserDto userDto = userService.save(form);
        return ResponseBuilder.created(uriInfo.getAbsolutePathBuilder().path(String.valueOf(userDto.id())).build()).entity(userDto).build();
    }
}
