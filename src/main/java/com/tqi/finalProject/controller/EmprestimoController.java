package com.tqi.finalProject.controller;

import com.tqi.finalProject.model.Cliente;
import com.tqi.finalProject.model.Emprestimo;
import com.tqi.finalProject.repository.ClienteRepository;
import com.tqi.finalProject.repository.EmprestimoRepository;
import com.tqi.finalProject.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EmprestimoController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private QueryRepository queryRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.POST)
    public String salvaEmp(@PathVariable("id") long id, Emprestimo emprestimo){
        Cliente cliente = clienteRepository.getById(id);
        emprestimo.setEmpcliente(cliente);

        emprestimoRepository.save(emprestimo);

        return "redirect:/cliente/{id}";
    }

}
