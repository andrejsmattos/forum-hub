CREATE TABLE usuarios (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    senha varchar(255) not null,
    primary key(id)
);

CREATE TABLE perfis (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    primary key(id)
);

CREATE TABLE usuario_perfil (
    usuario_id bigint not null,
    perfil_id bigint not null,
    primary key(usuario_id, perfil_id),
    constraint fk_usuario_perfil_usuario_id foreign key(usuario_id) references usuarios(id),
    constraint fk_usuario_perfil_perfil_id foreign key(perfil_id) references perfis(id)
);