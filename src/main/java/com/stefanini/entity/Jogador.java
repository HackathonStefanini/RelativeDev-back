package com.stefanini.entity;

import com.stefanini.dto.JogadorInsertDTO;
import com.stefanini.utils.CryptPassword;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "tb_jogador")
public class Jogador implements Serializable {

    @Id
    @Column(name = "Id_jogador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nickname;

    @Column
    private String password;

    @Column
    @NotNull
    private BigDecimal saldo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Jogador_Stefamon",
            joinColumns = {@JoinColumn(name = "Id_jogador")},
            inverseJoinColumns = {@JoinColumn(name = "Id_stefamon")})
    private List<Stefamon> stefamons = new ArrayList<>();

    public Jogador() {
    }

    public Jogador(JogadorInsertDTO jogador) {
        this.id = null;
        this.nickname = jogador.getNickname();
        this.password = CryptPassword.criptografarSenha(jogador.getPassword());
        this.saldo = new BigDecimal(jogador.getSaldo());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
