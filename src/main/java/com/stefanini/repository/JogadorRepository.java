package com.stefanini.repository;

import com.stefanini.dao.GenericDAO;
import com.stefanini.entity.Jogador;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class JogadorRepository extends GenericDAO<Jogador, Long> {

    public List<Jogador> findByNickName(String login) {
        TypedQuery<Jogador> query = createQuery("SELECT obj FROM Jogador obj WHERE obj.nickname = :nickname");
        query.setParameter("nickname", login);
        return query.getResultList();
    }

}
