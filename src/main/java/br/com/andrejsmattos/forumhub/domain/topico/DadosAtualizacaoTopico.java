package br.com.andrejsmattos.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        @NotNull(message = "Id não pode ser null")
        Long id,
        @NotBlank(message = "Título não pode ser null ou em branco")
        String titulo,
        @NotBlank(message = "Mensagem não pode ser null ou em branco")
        String mensagem,
        @NotNull(message = "Status não pode ser nulo. Status possíveis: ABERTO, RESPONDIDO, ENCERRADO")
        Status status,
        Long idCurso
) {
    public DadosAtualizacaoTopico(Topico topico) {
        this(
            topico.getId(),
            topico.getTitulo(),
            topico.getMensagem(),
            topico.getStatus(),
            topico.getCurso().getId()
        );
    }
}
