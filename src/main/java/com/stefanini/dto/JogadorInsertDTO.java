package com.stefanini.dto;

import com.stefanini.entity.Stefamon;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JogadorInsertDTO {

    @NotBlank(message = "Nickname é obrigatório")
    private String nickname;

    @Column
    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 4, max = 10, message = "A senha deve ter entre 4 e 10 caracteres")
    private String password;

    @Column
    private String saldo;

    @ManyToMany
    @JoinTable(name = "Jogador_Stefamon",
            joinColumns = {@JoinColumn(name = "IdJogador")},
            inverseJoinColumns = {@JoinColumn(name = "IdStefamon")})
    private List<Stefamon> stefamons = new ArrayList<>();

    public JogadorInsertDTO() {
    }

    public JogadorInsertDTO(String nickname, String password, String saldo, List<Stefamon> stefamons) {
        this.nickname = nickname;
        this.password = password;
        this.saldo = saldo;
        this.stefamons = stefamons;
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

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public List<Stefamon> getStefamons() {
        return stefamons;
    }

    public void setStefamons(List<Stefamon> stefamons) {
        this.stefamons = stefamons;
    }
}
