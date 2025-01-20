package br.com.andrejsmattos.forumhub.domain.topico;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        Long idAutor,
        Long idCurso,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataCriacao,
        Status status
) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(
            topico.getId(),
            topico.getTitulo(),
            topico.getMensagem(),
            topico.getAutor().getId(),
            topico.getCurso().getId(),
            topico.getDataCriacao(),
            topico.getStatus()
        );
    }
}
