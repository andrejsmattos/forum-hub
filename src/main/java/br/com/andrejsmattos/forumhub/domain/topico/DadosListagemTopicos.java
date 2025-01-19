package br.com.andrejsmattos.forumhub.domain.topico;

import java.time.LocalDateTime;

public record DadosListagemTopicos(
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        Status status,
        Long idAutor,
        Long idCurso
) {

    public DadosListagemTopicos(Topico topico) {
        this(
            topico.getTitulo(),
            topico.getMensagem(),
            topico.getDataCriacao(),
            topico.getStatus(),
            topico.getAutor().getId(),
            topico.getCurso().getId()
        );
    }
}
