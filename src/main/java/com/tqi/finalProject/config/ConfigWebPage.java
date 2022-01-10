package com.tqi.finalProject.config;

//classe que configura um acesso de ADMIN as paginas desse MVC, com execeção das paginas
//anotadas no authorize requests.

//a função do bean é popular um acesso de admin as paginas

import com.tqi.finalProject.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ConfigWebPage extends WebSecurityConfigurerAdapter {

    @Autowired
    private ImplementsUserDetailsService userDetailsService;

    @Override
    public void configure (HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/cadastrocliente","/home","/cadastro",
                             "/registra","/webjars/**","/css/**","/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin().loginPage("/loginadm").permitAll()
                .and()
                .logout().permitAll();


    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth ) throws Exception{
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());

    }

       /* @Bean
        @Override
        public UserDetailsService userDetailsService() {
               UserDetails user = User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("123")
                        .roles("USER")
                        .build();
                return new InMemoryUserDetailsManager(user);
        }*/
}
