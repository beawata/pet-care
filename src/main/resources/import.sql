INSERT INTO tb_especie(nome, descricao) VALUES ('Cachorro', 'Os melhores amigos do homem');
INSERT INTO tb_especie(nome, descricao) VALUES ('Pássaro', 'Lindos cantos');
INSERT INTO tb_especie(nome, descricao) VALUES ('Lagarto', 'Lagartos lindos');
INSERT INTO tb_especie(nome, descricao) VALUES ('Serpentes', 'Serpentes são legais');
INSERT INTO tb_especie(nome, descricao) VALUES ('Isópodes', 'Tatuzinhos');

INSERT INTO tb_pet(nome, data_nascimento, microchip, especie_id) VALUES ('Bob', '2018-03-31', 'N/A', 1);
INSERT INTO tb_pet(nome, data_nascimento, microchip, especie_id) VALUES ('Thor', '2018-03-27', 'N/A', 1);
INSERT INTO tb_pet(nome, data_nascimento, microchip, especie_id) VALUES ('Mel', '2018-11-17', 'N/A', 1);
INSERT INTO tb_pet(nome, data_nascimento, microchip, especie_id) VALUES ('Nina', '2020-03-31', 'N/A', 2);
INSERT INTO tb_pet(nome, data_nascimento, microchip, especie_id) VALUES ('Max', '2025-03-17', 'N/A', 4);


INSERT INTO tb_rotina(pet_id, observacao, data, peso, alimentacao) VALUES (1, 'Vomitou e comeu pouco', '2026-08-25', 20.5, true);
INSERT INTO tb_rotina(pet_id, observacao, data, peso, alimentacao) VALUES (1, 'Comeu mais e está mais ativo', '2026-08-27', 20.5, true);
INSERT INTO tb_rotina(pet_id, observacao, data, peso, alimentacao) VALUES (3, 'Ganhou peso', '2026-08-26', 5.0, true);
INSERT INTO tb_rotina(pet_id, observacao, data, peso, alimentacao) VALUES (2, 'Está mais quieto', '2026-08-25', 4.5, true);
INSERT INTO tb_rotina(pet_id, observacao, data, peso, alimentacao) VALUES (4, 'Está mais ativo', '2026-08-25', 4.0, true);
