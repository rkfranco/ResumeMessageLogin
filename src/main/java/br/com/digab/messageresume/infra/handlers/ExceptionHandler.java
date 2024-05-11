package br.com.digab.messageresume.infra.handlers;

import br.com.digab.messageresume.models.exceptions.UserAllreadyExistsException;
import br.com.digab.messageresume.models.exceptions.UserAuthenticationException;
import jakarta.ws.rs.NotAllowedException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable throwable) {
        throwable.printStackTrace();
        return switch (throwable) {
            case UserAuthenticationException e -> Response.status(Status.UNAUTHORIZED).entity("Name or password invalid").build();
            case UserAllreadyExistsException e -> Response.status(Status.CONFLICT).entity("User Allready exists").build();
            case NotAllowedException e -> Response.status(Status.METHOD_NOT_ALLOWED).entity("Method not allowed").build();
            default -> Response.status(Status.INTERNAL_SERVER_ERROR).build();
        };
    }
}
