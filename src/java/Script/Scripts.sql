-- inclusão de dados -->

insert into usuario (idusuario,nome,login,senha,email,tipo) values (1,'José Henrique','usuario1','123','a@','comum');
insert into usuario (idusuario,nome,login,senha,email,tipo) values (2,'Petro Paulo','usuario2','123', 'b@', 'adm');
insert into usuario (idusuario,nome,login,senha,email,tipo) values (3,'São Luiz','usuario3','123', 'c@', 'Locadora 1');

insert into locadora (idlocadora,nome,cnpj,rua,numero,complemento,bairro,
cidade,estado,cep,telefoneComercial, telefoneContato, email, site) 
values (1,'Locadora 1','11111111111', 'rua A', 1, 'complemento 1', 'bairro 1',
'cidade 1', 'estado 1', 'cep 1', 'tel 1', 'tel 2', 'email 1', 'site 1');

insert into locadora (idlocadora,nome,cnpj,rua,numero,complemento,bairro,
cidade,estado,cep,telefoneComercial, telefoneContato, email, site) 
values (2,'Locadora 2','11111111111', 'rua B', 2, 'complemento 2', 'bairro 2',
'cidade 2', 'estado 2', 'cep 2', 'tel 1', 'tel 2', 'email 2', 'site 2');

insert into locadora (idlocadora,nome,cnpj,rua,numero,complemento,bairro,
cidade,estado,cep,telefoneComercial, telefoneContato, email, site) 
values (3,'Locadora 3','11111111111', 'rua B', 3, 'complemento 3', 'bairro 3',
'cidade 3', 'estado 3', 'cep 3', 'tel 1', 'tel 2', 'email 3', 'site 3');

insert into filme (idFilme, idLocadora, nome, descricao, ano, genero, situacao, quantidade)
values (1,1,'Filme 1', 'destricao', 2000, 'ACAO', 'Disponivel', 5);

insert into filme (idFilme, idLocadora, nome, descricao, ano, genero, situacao, quantidade)
values (2,2,'Filme 2', 'destricao', 2004, 'AVENTURA', 'Disponivel', 3);

insert into filme (idFilme, idLocadora, nome, descricao, ano, genero, situacao, quantidade)
values (3,1,'Filme 3', 'destricao', 2001, 'TERROR', 'Disponivel', 10);