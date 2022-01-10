package com.tqi.finalProject.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Emprestimo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_emp;

    private double vlremprestimo;
    private String data;
    private Long qtdparcelas;

    @ManyToOne
    private Cliente empcliente;

    public Cliente getEmpcliente() {
        return empcliente;
    }

    public void setEmpcliente(Cliente empcliente) {
        this.empcliente = empcliente;
    }

    public Emprestimo() {
    }

    public Long getId_emp() {
        return id_emp;
    }

    public void setId_emp(Long id_emp) {
        this.id_emp = id_emp;
    }

    public double getVlremprestimo() {
        return vlremprestimo;
    }

    public void setVlremprestimo(double vlremprestimo) {
        this.vlremprestimo = vlremprestimo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getQtdparcelas() {
        return qtdparcelas;
    }

    public void setQtdparcelas(Long qtdparcelas) {
        this.qtdparcelas = qtdparcelas;
    }

}
