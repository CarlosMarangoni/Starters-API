INSERT INTO starter (endereco,letras,linguagem,nome,telefone) VALUES ("RUA DOS BOBOS","comd","JAVA","Carlos Mendes","11997516492");
INSERT INTO starter (endereco,letras,linguagem,nome,telefone) VALUES ("RUA DAS FLORES","dmer","JAVA","Darlan Ricardo","11997515666");
INSERT INTO starter (endereco,letras,linguagem,nome,telefone) VALUES ("RUA QUATRO","mamg","CSHARP","Marilza Marangoni","119973622798");
INSERT INTO starter (endereco,letras,linguagem,nome,telefone) VALUES ("RUA MONTEIRO LOBATO","joca","CSHARP","João Carlos","119954738756");
INSERT INTO desafio (descricao) VALUES ("CRUD Imobiliaria");
INSERT INTO desafio (descricao) VALUES ("CRUD Shows");
INSERT INTO desafio (descricao) VALUES ("CRUD Livros");
INSERT INTO desafio (descricao) VALUES ("CRUD Alunos");
INSERT INTO submissao_desafio (end_repositorio,desafio_codigo,starter_codigo) VALUES ("gitlab.gft.com/comd/imobiliaria",1,1);
INSERT INTO submissao_desafio (end_repositorio,desafio_codigo,starter_codigo) VALUES ("gitlab.gft.com/dmer/imobiliaria",1,2);
INSERT INTO submissao_desafio (end_repositorio,desafio_codigo,starter_codigo) VALUES ("gitlab.gft.com/mamg/shows",2,3);
INSERT INTO submissao_desafio (end_repositorio,desafio_codigo,starter_codigo) VALUES ("gitlab.gft.com/joca/shows",2,4);
INSERT INTO nota_desafio (nota_qualidade_do_codigo,nota_quantidade_entregada,submissao_desafio_codigo) VALUES (3,3,1);
INSERT INTO nota_desafio (nota_qualidade_do_codigo,nota_quantidade_entregada,submissao_desafio_codigo) VALUES (2,2,2);
INSERT INTO nota_desafio (nota_qualidade_do_codigo,nota_quantidade_entregada,submissao_desafio_codigo) VALUES (1,1,3);
INSERT INTO perfil (descricao) VALUES ('INSTRUTOR');
INSERT INTO perfil (descricao) VALUES ('STARTER');
INSERT INTO usuario (nome,senha,username) VALUES ('David','$2a$10$SebJ8dPJIOnul133qjEhoOfJbu/Lr4u7g.1A1LTRfa8BNGC89U23q','instrutor');
INSERT INTO usuario (nome,senha,username) VALUES ('Carlos','$2a$10$PV5oXyxk7C1jNNS0RB079u7FxFzGcibh1ZSP6G16evCM0AxLFOrGe','starter');
INSERT INTO usuario_perfis (usuario_id,perfis_id) VALUES (1,1);
INSERT INTO usuario_perfis (usuario_id,perfis_id) VALUES (2,2);