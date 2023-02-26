package com.stefanini.dto;

import com.stefanini.entity.Stefamon;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JogadorInsertDTO {

    @Column(unique = true)
    @NotBlank(message = "Nickname é obrigatório")
    private String nickname;

    @Column
    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 4, max = 10, message = "A senha deve ter entre 4 e 10 caracteres")
    private String password;

    @Column
    @NotBlank(message = "Saldo é obrigatório")
    private BigDecimal saldo;

    @ManyToMany
    @JoinTable(name = "Jogador_Stefamon",
            joinColumns = {@JoinColumn(name = "IdJogador")},
            inverseJoinColumns = {@JoinColumn(name = "IdStefamon")})
    private List<Stefamon> stefamons = new ArrayList<>();

    public JogadorInsertDTO() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Stefamon> getStefamons() {
        return stefamons;
    }

    public void setStefamons(List<Stefamon> stefamons) {
        this.stefamons = stefamons;
    }
}
