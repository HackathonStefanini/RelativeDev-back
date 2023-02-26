package com.stefanini.service;

import com.stefanini.dto.JogadorInsertDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.entity.Stefamon;
import com.stefanini.exceptions.GenericExceptions;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.repository.JogadorRepository;
import com.stefanini.repository.StefamonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class StefamonService {

    @Inject
    StefamonRepository repository;

    @Inject
    JogadorRepository jogadorRepository;

    public List<Stefamon> listarTodos(){
        return repository.listAll();
    }

    public Stefamon pegarPorId(Long id) {
        var stefamon =  repository.findById(id);
        if(Objects.isNull(stefamon)) {
            throw new RegraDeNegocioException("Não encontramos nada com o id " + id, Response.Status.NOT_FOUND);
        }
        return stefamon;
    }

    public String comprar(Long id, Long idJogador) {
        Stefamon stefamon = pegarPorId(id);
        Jogador jogador = jogadorRepository.findById(idJogador);
        double num = jogador.getSaldo().doubleValue();
        double valor = ((stefamon.getAtaque() + stefamon.getDefesa() + stefamon.getPoder() + stefamon.getVida() + stefamon.getVelocidade() + stefamon.getInteligencia()) / 6);
        if (valor > num) {
            throw new GenericExceptions(Response.Status.CONFLICT, "Você não possui saldo para comprar este stefamon");
        }
        if (jogador.getStefamons().size() < 6){
            jogador.setSaldo(new BigDecimal((num - valor)));
            jogador.getStefamons().add(stefamon);
            jogadorRepository.update(jogador);
            return "Compra realizada com sucesso!";
        } else {
            throw new GenericExceptions(Response.Status.CONFLICT, "Você Atingiu o limite máximo de 6 stefamons");
        }
    }

 }
