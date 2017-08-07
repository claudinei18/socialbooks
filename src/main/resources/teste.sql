CREATE SEQUENCE livros_id_seq START 1 INCREMENT 1;

CREATE SEQUENCE comentarios_id_seq START 1 INCREMENT 1;

CREATE TABLE livro(
   id INTEGER,
   nome text,
   publicacao date,
   editora text,
   resumo text,
   autor text
);

CREATE TABLE comentario(
   id INTEGER,
   texto text,
   usuario text,
   data date,
   LIVRO_ID integer
);