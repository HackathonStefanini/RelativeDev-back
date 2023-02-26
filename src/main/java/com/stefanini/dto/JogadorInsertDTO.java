package com.stefanini.dto;

import com.stefanini.entity.Stefamon;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JogadorDTO {


    private Long id;

    @Column(unique = true)
    private String nickname;

    @Column
    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 4, max = 10, message = "A senha deve ter entre 4 e 10 caracteres")
    private String password;

    @Column
    private BigDecimal saldo;


    @ManyToMany
    @JoinTable(name = "Jogador_Stefamon",
            joinColumns = {@JoinColumn(name = "IdJogador")},
            inverseJoinColumns = {@JoinColumn(name = "IdStefamon")})
    private List<Stefamon> stefamons = new ArrayList<>();

}
