package br.com.andrejsmattos.forumhub.infra.security;

import br.com.andrejsmattos.forumhub.domain.usuario.Usuario;
import br.com.andrejsmattos.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CriarUsuarioAdmin implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        var senha = new BCryptPasswordEncoder().encode("123456");
        var email = "andre@mail.com";

        if (!usuarioRepository.existsByEmail(email)) {
            var usuario = new Usuario(null, "Andre", email, senha);
            usuarioRepository.save(usuario);
        } else {
            System.out.println("Usuário com o email: " + email + " já foi cadastrado");
        }

        System.out.println("Usuário admin criado com sucesso!");
    }
}