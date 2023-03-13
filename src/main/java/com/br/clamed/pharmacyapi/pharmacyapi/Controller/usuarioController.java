package com.br.clamed.pharmacyapi.pharmacyapi.Controller;


import com.br.clamed.pharmacyapi.pharmacyapi.Entity.usuarioEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000 ")
@RequestMapping("/usuario")
public class usuarioController {


    private final com.br.clamed.pharmacyapi.pharmacyapi.Service.usuarioService usuarioService;

    public usuarioController(com.br.clamed.pharmacyapi.pharmacyapi.Service.usuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrarUsuario(@Validated @RequestBody usuarioEntity usuario){
        return usuarioService.cadastrarUsuario(usuario);
    }

    @GetMapping("/login")
    public ResponseEntity<?> buscarPorEmailEsenha(@RequestParam ("email") String email, @RequestParam("senha") String senha){
        return usuarioService.buscarPorEmailEsenha(email,senha);
    }
}