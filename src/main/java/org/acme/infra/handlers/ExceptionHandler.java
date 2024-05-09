package org.acme.infra.handlers;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.acme.models.exceptions.UserAuthenticationException;

@Provider
public class ExceptionHandler implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable throwable) {
        return switch (throwable) {
            case UserAuthenticationException e ->
                    Response.status(Status.UNAUTHORIZED).entity("Name or password invalid").build();
            default -> Response.status(Status.INTERNAL_SERVER_ERROR).build();
        };
    }
}
