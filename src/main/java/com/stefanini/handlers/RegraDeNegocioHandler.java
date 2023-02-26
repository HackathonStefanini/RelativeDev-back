package com.stefanini.handlers;

import com.stefanini.exceptions.RegraDeNegocioException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RegraDeNegocioHandler implements ExceptionMapper<RegraDeNegocioException> {

    @Override
    public Response toResponse(RegraDeNegocioException e) {
        return Response
                .status(e.getStatus())
                .header("Content-Type", MediaType.TEXT_PLAIN)
                .entity(e.getMessage())
                .build();
    }

}
