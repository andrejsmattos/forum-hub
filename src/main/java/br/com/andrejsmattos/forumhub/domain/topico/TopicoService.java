package br.com.andrejsmattos.forumhub.domain.topico;

import br.com.andrejsmattos.forumhub.domain.curso.Curso;
import br.com.andrejsmattos.forumhub.domain.curso.CursoRepository;
import br.com.andrejsmattos.forumhub.infra.exception.ValidacaoException;
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

    @Autowired
    private CursoRepository cursoRepository;

    public DadosDetalhamentoTopico cadastrar(DadosCadastroTopico dados) {
        if (!usuarioRepository.existsById(dados.idAutor())) {
            throw new ValidacaoException("Autor não encontrado com este id: " + dados.idAutor());
        }

        if (topicoRepository.existsByTitulo(dados.titulo())) {
            throw new ValidacaoException("Um tópico com este mesmo título já foi cadastrado");
        }

        if (topicoRepository.existsByMensagem(dados.mensagem())) {
            throw new ValidacaoException("Um tópico com esta mesma mensagem já foi cadastrado");
        }

        var curso = cursoRepository.findByNome(dados.nomeCurso());

        if (curso == null) {
            curso = new Curso();
            curso.setNome(dados.nomeCurso());
            cursoRepository.save(curso);
        }

        var dataCriacao = LocalDateTime.now();
        var status = Status.ABERTO;
        var autor = usuarioRepository.getReferenceById(dados.idAutor());
        var topico = new Topico(null, dados.titulo(), dados.mensagem(), dataCriacao, status, autor, curso);
        topicoRepository.save(topico);

        return new DadosDetalhamentoTopico(topico);
    }

    public DadosDetalhamentoTopico atualizar(DadosAtualizacaoTopico dados) {
        var topico = topicoRepository.findById(dados.id())
                .orElseThrow(() -> new ValidacaoException("Tópico não encontrado com este id: " + dados.id()));

        if (dados.titulo() != null) {
            topico.setTitulo(dados.titulo());
        }
        if (dados.mensagem() != null) {
            topico.setMensagem(dados.mensagem());
        }
        if (dados.status() != null) {
            topico.setStatus(dados.status());
        }
        topicoRepository.save(topico);

        return new DadosDetalhamentoTopico(topico);
    }

    public void deletar(Long id) {
        if(!topicoRepository.existsById(id)) {
            throw new ValidacaoException("Tópico não encontrado com este id: " + id);
        }
        topicoRepository.deleteById(id);
    }
}
