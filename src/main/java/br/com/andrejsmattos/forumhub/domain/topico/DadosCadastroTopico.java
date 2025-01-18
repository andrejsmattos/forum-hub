package br.com.andrejsmattos.forumhub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(
    @NotNull
    String titulo,

    @NotNull
    String mensagem,

    @NotNull
    Long idAutor,

    String nomeCurso
) {
}
