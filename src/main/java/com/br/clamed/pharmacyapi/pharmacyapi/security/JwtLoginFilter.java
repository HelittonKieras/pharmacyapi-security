package com.br.clamed.pharmacyapi.pharmacyapi.security;

import com.br.clamed.pharmacyapi.pharmacyapi.Entity.usuarioEntity;
import com.br.clamed.pharmacyapi.pharmacyapi.Service.usuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import java.io.IOException;

/* Estabelece nosso gerenciador de token */
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    protected  JwtLoginFilter(String url, AuthenticationManager authenticationManager){

        // Obrigamos a realizar a autenticação na URL
        super(new AntPathRequestMatcher(url));

        //Setamos o gerenciador de autenticação
        setAuthenticationManager(authenticationManager);

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        //Pegar o token do usuário para validar
        usuarioEntity usuarioEntity = new ObjectMapper().readValue(request.getInputStream(), usuarioEntity.class);

        // retornamos o login, senha e acessos para o autenticador
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
                usuarioEntity.getLogin(),
                usuarioService.getSenha()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        new JwtTokenAutenticacaoService().addAuthentication(response, authResult.getName());
    }
}