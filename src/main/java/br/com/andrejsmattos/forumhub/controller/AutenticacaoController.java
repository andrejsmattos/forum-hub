package br.com.andrejsmattos.forumhub.controller;

import br.com.andrejsmattos.forumhub.domain.usuario.DadosAutenticacao;
import br.com.andrejsmattos.forumhub.domain.usuario.Usuario;
import br.com.andrejsmattos.forumhub.infra.security.DadosTokenJWT;
import br.com.andrejsmattos.forumhub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
            System.out.println("Tentando autenticar usuário: " + dados.email());

            var authentication = manager.authenticate(authenticationToken);
            System.out.println("Autenticação bem sucedida");

            var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
            System.out.println("Token gerado com sucesso");

            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
        } catch (Exception e) {
            System.out.println("Erro na autenticação: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
