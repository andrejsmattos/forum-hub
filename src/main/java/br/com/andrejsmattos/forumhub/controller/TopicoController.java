package br.com.andrejsmattos.forumhub.controller;

import br.com.andrejsmattos.forumhub.domain.topico.*;
import br.com.andrejsmattos.forumhub.infra.exception.ValidacaoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        var topico = service.cadastrar(dados);
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.id()).toUri();
        return ResponseEntity.created(uri).body(topico);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicos>> listar(
            @PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao
    ) {
        var pagina = repository.findAll(paginacao).map(topico -> new DadosListagemTopicos(topico));
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopico> atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados) {
        var dto = service.atualizar(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
