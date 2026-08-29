INSERT INTO tb_user (nome, email, telefone, data_nascimento, password) VALUES ('Maria Brown', 'maria@gmail.com', '988888888', '2000-01-01', '$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO');
INSERT INTO tb_user (nome, email, telefone, data_nascimento, password) VALUES ('Alex Green', 'alex@gmail.com', '977777777', '1990-04-30', '$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO');

INSERT INTO tb_role (authority) VALUES ('ROLE_TUTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);


INSERT INTO tb_especie(nome, descricao) VALUES ('Cachorro', 'Os melhores amigos do homem');
INSERT INTO tb_especie(nome, descricao) VALUES ('Pássaro', 'Lindos cantos');
INSERT INTO tb_especie(nome, descricao) VALUES ('Lagarto', 'Lagartos lindos');
INSERT INTO tb_especie(nome, descricao) VALUES ('Serpentes', 'Serpentes são legais');
INSERT INTO tb_especie(nome, descricao) VALUES ('Isópodes', 'Tatuzinhos');

INSERT INTO tb_pet(nome, data_nascimento, microchip, especie_id, tutor_id) VALUES ('Bob', '2018-03-31', 'N/A', 1, 1);
INSERT INTO tb_pet(nome, data_nascimento, microchip, especie_id, tutor_id) VALUES ('Thor', '2018-03-27', 'N/A', 1, 1);
INSERT INTO tb_pet(nome, data_nascimento, microchip, especie_id, tutor_id) VALUES ('Mel', '2018-11-17', 'N/A', 1, 1);
INSERT INTO tb_pet(nome, data_nascimento, microchip, especie_id, tutor_id) VALUES ('Nina', '2020-03-31', 'N/A', 2, 2);
INSERT INTO tb_pet(nome, data_nascimento, microchip, especie_id, tutor_id) VALUES ('Max', '2025-03-17', 'N/A', 4, 1);


INSERT INTO tb_rotina(pet_id, observacao, data, peso, alimentacao) VALUES (1, 'Vomitou e comeu pouco', '2026-08-25', 20.5, true);
INSERT INTO tb_rotina(pet_id, observacao, data, peso, alimentacao) VALUES (1, 'Comeu mais e está mais ativo', '2026-08-27', 20.5, true);
INSERT INTO tb_rotina(pet_id, observacao, data, peso, alimentacao) VALUES (3, 'Ganhou peso', '2026-08-26', 5.0, true);
INSERT INTO tb_rotina(pet_id, observacao, data, peso, alimentacao) VALUES (2, 'Está mais quieto', '2026-08-25', 4.5, true);
INSERT INTO tb_rotina(pet_id, observacao, data, peso, alimentacao) VALUES (4, 'Está mais ativo', '2026-08-25', 4.0, true);

