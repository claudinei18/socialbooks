CREATE SEQUENCE livros_id_seq START 1 INCREMENT 1;

CREATE SEQUENCE comentarios_id_seq START 1 INCREMENT 1;

CREATE SEQUENCE autor_id_seq START 1 INCREMENT 1;

CREATE TABLE autor(
   id INTEGER PRIMARY KEY ,
   nome text,
   nascimento date,
   nacionalidade text
);

CREATE TABLE livro(
   id INTEGER PRIMARY KEY ,
   nome text,
   publicacao date,
   editora text,
   resumo text,
   autor text,
   AUTOR_ID integer not null references autor(id)
);

CREATE TABLE comentario(
   id INTEGER PRIMARY KEY ,
   texto text,
   usuario text,
   data timestamp,
   LIVRO_ID integer not null references livro(id)
);

-- heroku pg:psql --app socialbooks1 < V1__Criar.sql