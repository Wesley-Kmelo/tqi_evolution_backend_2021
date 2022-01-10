package com.tqi.finalProject.controller;

import com.tqi.finalProject.config.ImplementsUserDetailsService;
import com.tqi.finalProject.model.Cliente;
import com.tqi.finalProject.model.Emprestimo;
import com.tqi.finalProject.repository.ClienteRepository;
import com.tqi.finalProject.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private QueryRepository queryRepository;

    @Autowired
    private ImplementsUserDetailsService userDetailsService;



    @RequestMapping("/cadastrocliente")
    public String formCadastro(Model model) {
        model.addAttribute("cliente",new Cliente());
        return "cadastro";
    }
    @RequestMapping("/registra")
    public String registraCLiente(Cliente cliente){
        BCryptPasswordEncoder senha = new BCryptPasswordEncoder();
        String senhacodificada = senha.encode(cliente.getSenha());
        cliente.setSenha(senhacodificada);

        clienteRepository.save(cliente);
        return "redirect:/home";
    }

    @RequestMapping(value="/cliente",method = RequestMethod.GET)
    public ModelAndView dadosCliente(){
        ModelAndView mv = new ModelAndView("cliente");
        List<Cliente> listacliente = clienteRepository.findAll();
        mv.addObject("listacliente",listacliente);

        return mv;
    }

    @RequestMapping(value ="/cliente/{id}", method = RequestMethod.GET)
    public ModelAndView umcliente(@PathVariable ("id") long id){
          Cliente umcliente = clienteRepository.getById(id);
          ModelAndView mv = new ModelAndView("porid");
          mv.addObject("porid", umcliente);
          mv.addObject("usr", umcliente.getNome());

          List<Emprestimo> emprestimos = queryRepository.listaById(id);
          mv.addObject("lstemprestimos", emprestimos);
          return mv;
    }

    @RequestMapping(value ="/email/{email}", method=RequestMethod.GET)
    public String login (@PathVariable ("email") String email) {
        Cliente cliente= clienteRepository.getByEmail(email);
        return "redirect:/cliente/"+cliente.getId_cliente();
    }

    /*@RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }*/
}
