package com.tqi.finalProject.config;

import com.tqi.finalProject.model.Cliente;
import com.tqi.finalProject.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.getByEmail(username);

        if(cliente == null){
            throw new UsernameNotFoundException("Cliente não encontrado");
        }

        return cliente;
    }
}
