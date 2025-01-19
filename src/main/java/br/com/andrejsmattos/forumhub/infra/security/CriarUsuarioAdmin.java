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

        var usuario = new Usuario(null, "Andre", "andre@mail.com", senha);
        usuarioRepository.save(usuario);

        System.out.println("Usuário admin criado com sucesso!");
    }
}