CREATE SEQUENCE livros_id_seq START 1 INCREMENT 1;

CREATE TABLE livro(
   id INTEGER,
   nome text,
   publicacao date,
   editora text,
   resumo text,
   autor text
);