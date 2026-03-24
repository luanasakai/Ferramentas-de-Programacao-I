use db_jpa;
select * from pessoa;
select * from cargo;
INSERT INTO cargo (nome) VALUES ('Analista');
INSERT INTO cargo (nome) VALUES ('Gerente');
INSERT INTO cargo (nome) VALUES ('Diretor');

insert into veiculo (ano, nome, pessoa_id) VALUES (2006, 'Palio', 2);
insert into veiculo (ano, nome, pessoa_id) VALUES (2010, 'Uno', 3);
select * from veiculo;
-- delete from veiculo where id=1;

insert into servico (nome) VALUES ('Calibragem');
insert into servico (nome) VALUES ('Troca de de Pneu');
insert into servico (nome) VALUES ('Troca de Oleo');
select * from servico;

select * from manutencao;
