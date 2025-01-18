package br.com.andrejsmattos.forumhub.domain.topico;

import br.com.andrejsmattos.forumhub.domain.ValidacaoException;
import br.com.andrejsmattos.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public DadosDetalhamentoTopico cadastrar(DadosCadastroTopico dados) {
        if (topicoRepository.existsByTitulo(dados.titulo())) {
            throw new ValidacaoException("Um tópico com este mesmo título já foi cadastrado");
        }

        if (topicoRepository.existsByMensagem(dados.mensagem())) {
            throw new ValidacaoException("Um tópico com esta mesma mensagem já foi cadastrado");
        }

        var dataCriacao = LocalDateTime.now();
        var status = Status.ABERTO;
        var autor = usuarioRepository.getReferenceById(dados.idAutor());
        var topico = new Topico(null, dados.titulo(), dados.mensagem(), dataCriacao, status, autor, null);
        topicoRepository.save(topico);

        return new DadosDetalhamentoTopico(topico);
    }
}
