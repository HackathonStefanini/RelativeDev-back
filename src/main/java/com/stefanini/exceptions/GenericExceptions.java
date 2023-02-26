package com.stefanini.exceptions;

import javax.ws.rs.core.Response;

public class GenericExceptions extends RuntimeException{

    private Response.Status status;

    public GenericExceptions(Response.Status status, String message) {
        super(message);
        this.status = status;
    }

    public Response.Status getStatus() {
        return status;
    }

    public void setStatus(Response.Status status) {
        this.status = status;
    }
}
