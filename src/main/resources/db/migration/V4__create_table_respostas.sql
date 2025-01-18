CREATE TABLE respostas (
    id bigint not null auto_increment,
    mensagem varchar(1000) not null,
    data_criacao datetime not null,
    topico_id bigint not null,
    autor_id bigint not null,
    solucao varchar(1) not null default 'N',
    primary key(id),
    constraint fk_respostas_topico_id foreign key(topico_id) references topicos(id),
    constraint fk_respostas_autor_id foreign key(autor_id) references usuarios(id)
);