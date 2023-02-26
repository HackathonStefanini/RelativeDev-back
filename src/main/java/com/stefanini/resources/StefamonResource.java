package com.stefanini.resources;

import com.stefanini.dto.JogadorInsertDTO;
import com.stefanini.service.JogadorService;
import com.stefanini.service.StefamonService;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/stefamon")
public class StefamonResource {

    @Inject
    StefamonService service;

    @GET
    @Path("/todos")
    public Response listarTodos() {
        return Response.status(Response.Status.OK).entity(service.listarTodos()).build();
    }

    @GET
    @Path("/{id}")
    public Response pegarPorId(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(service.pegarPorId(id)).build();
    }

    @GET
    @Path("/comprar/{id}/{usuario}")
    public Response comprar(@PathParam("id") Long id, @PathParam("usuario") Long idJogador) {
        return Response.status(Response.Status.OK).entity(service.comprar(id, idJogador)).build();
    }

}
