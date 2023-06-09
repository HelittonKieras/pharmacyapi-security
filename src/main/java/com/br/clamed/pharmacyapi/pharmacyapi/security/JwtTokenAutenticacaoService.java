package com.br.clamed.pharmacyapi.pharmacyapi.security;

import com.br.clamed.pharmacyapi.pharmacyapi.Repository.usuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bouncycastle.jcajce.BCFKSLoadStoreParameter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
@Component
public class JwtTokenAutenticacaoService{

    /*A validade do token de 2 dias*/
    private static final long EXPIRATION_TIME = 24 * 60 * 60 * 2;

    /* Uma senha única para compor a autenticação e ajudar na segurança */
    private static final String SECRET = "SenhaExtremamenteSecretaEForte";

    /* Prefixo padrão do token */
    private static final String TOKEN_PREFIX = "Bearer";


    /* Cabeçalho do token */
    private static  final String HEADER_STRING = "Authorization";


    // Gerando token de autenticação e adicioando ao cabelho da reposta HTTP
    public void addAuthentication(HttpServletResponse response, String username) throws IOException {

        //Montagem do token
        String JWT =  Jwts.builder() // chamando o gerador de token
                .setSubject(username) // adicionamos o usuário ao token
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME)) // tempo de expiração do token
                .signWith(BCFKSLoadStoreParameter.SignatureAlgorithm.HS512, SECRET).compact(); // compacta o token usando o algoritmo de criptografia


        String token = TOKEN_PREFIX + " " + JWT; //Bearer asdfkjadsk.fasdfasdfkasjdçfljasd.kfgçjlsaçlkjasdf

        // adicionar no header http
        response.getWriter().write("{\"Authorization\": \""+token+"\"}");

    }


    //Método que retorna o usuario validado com token ou caso seja inválido retorna null
    public Authentication getAuthentication(HttpServletRequest request){

        // pegar o token enviado no cabeçalho http
        String token = request.getHeader(HEADER_STRING);

        if(token != null){

            String user = Jwts.parser().setSigningKey(SECRET) // Bearer asdfasdfasdfasdfasdfasdfasd
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, "")) // asdfasdfasdfasdfasdfasdfasd
                    .getBody().getSubject(); //brunomoura

            if (user != null){
                Usuario usuario = ApplicationContextLoad.getApplicationContext()
                        .getBean(usuarioRepository.class).findUserByLogin(user);

                System.out.println("Login do usuário: "+usuario.getLogin());

                if(usuario != null){
                    return new UsernamePasswordAuthenticationToken(
                            usuario.getLogin(),
                            usuario.getSenha(),
                            usuario.getAuthorities());
                }



            }

        }


        return null; // Usuário não esta autorizado.
    }



}