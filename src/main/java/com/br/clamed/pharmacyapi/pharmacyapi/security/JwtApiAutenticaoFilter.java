package com.br.clamed.pharmacyapi.pharmacyapi.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;


import java.io.IOException;

// Filtro onde todas as requisições serão capturadas para autenticar
public class JwtApiAutenticaoFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // estabelecer a autenticação para requisição
        Authentication authentication = new JwtTokenAutenticacaoService()
                .getAuthentication((HttpServletRequest) request);

        // colocar o processo de autenticação no spring security
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Continua o processo
        chain.doFilter(request, response);
    }
}