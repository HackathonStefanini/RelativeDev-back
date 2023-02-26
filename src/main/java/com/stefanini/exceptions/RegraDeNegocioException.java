package com.stefanini.exceptions;

import javax.ws.rs.core.Response;

public class RegraDeNegocioException extends RuntimeException {

    private Response.Status status;

    public RegraDeNegocioException(String message) {
        super(message);
        this.status = Response.Status.BAD_REQUEST;
    }

    public RegraDeNegocioException(String message, Response.Status status) {
        super(message);
        this.status = status;
    }

    public Response.Status getStatus() {
        return status;
    }
}
