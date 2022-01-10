package com.tqi.finalProject.repository;

import com.tqi.finalProject.model.Cliente;
import com.tqi.finalProject.model.Emprestimo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class QueryRepository {
    private final EntityManager em;

    public QueryRepository(EntityManager em) {
        this.em = em;
    }

    public List<Cliente> listaporId(Long id){
        String query ="select * from cliente where id_cliente = :id";
        var q = em.createNativeQuery(query, Cliente.class);
        q.setParameter("id",id);
        return q.getResultList();
    }

    public List<Emprestimo> listaById(Long id){
        String query = "select * from emprestimo where empcliente_id_cliente = :id";
        var q = em.createNativeQuery(query,Emprestimo.class);
        q.setParameter("id",id);
        return q.getResultList();
    }

}
