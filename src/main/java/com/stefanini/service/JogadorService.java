package com.stefanini.service;

import com.stefanini.dto.JogadorInsertDTO;
import com.stefanini.dto.JogadorReturnDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.exceptions.GenericExceptions;
import com.stefanini.exceptions.RegraDeNegocioException;
import com.stefanini.repository.JogadorRepository;
import com.stefanini.utils.Login;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

import static com.stefanini.utils.CryptPassword.verificarSenha;

@ApplicationScoped
public class JogadorService {

    @Inject
    JogadorRepository jogadorRepository;

    public void salvar(JogadorInsertDTO jogador) {
        jogadorRepository.save(new Jogador(jogador));
    }

    public Jogador pegarPorId(Long id) {
        var jogador = jogadorRepository.findById(id);
        if(Objects.isNull(jogador)) {
            throw new RegraDeNegocioException("Ocorreu um erro ao buscar o Jogador de id " + id, Response.Status.NOT_FOUND);
        }
        return jogador;
    }

    public void alterar(Jogador jogador) {
        jogadorRepository.update(jogador);
    }

    public void deletar(Long id) {
        jogadorRepository.delete(id);
    }

    public List<Jogador> listarTodos() {
        return jogadorRepository.listAll();
    }

    public JogadorReturnDTO loginValid(Login login) {
        List<Jogador> list = findByNickName(login.getLogin());
        if (list.isEmpty()) throw new GenericExceptions(Response.Status.UNAUTHORIZED, "Login ou senha inválidas!!");
        if (verificarSenha(login.getPassword(), list.get(0).getPassword())) {
            return new JogadorReturnDTO(list.get(0));
        } else {
            throw new GenericExceptions(Response.Status.UNAUTHORIZED, "Senha inválida!!");
        }
    }

    private List<Jogador> findByNickName(String login) {
        return jogadorRepository.findByNickName(login);
    }
}
