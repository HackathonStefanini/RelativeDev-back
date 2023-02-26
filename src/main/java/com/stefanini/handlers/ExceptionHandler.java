package com.stefanini.handlers;

import com.stefanini.exceptions.GenericExceptions;
import com.stefanini.exceptions.StandardError;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler  implements ExceptionMapper<GenericExceptions> {
    @Context
    private UriInfo uriInfo;

    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(GenericExceptions e) {
        StandardError error = new StandardError(System.currentTimeMillis(), e.getStatus().getStatusCode(), e.getMessage(), uriInfo.getRequestUri().toString());
        return Response.status(e.getStatus()).entity(error).build();
    }
}
