
---------- SCRIPTS-----------
create table usuario(id serial,
                     login varchar(50) not null,
                     senha varchar(50) not null,
                     CONSTRAINT pkusuario primary key (id)
                     );

CREATE TABLE cidade(id serial,
                    descricao varchar(100) not null,
                    ativo char(1) not null,
                   constraint pkcidade primary key(id)
);

CREATE TABLE cliente (id serial ,
                     id_cidade int not null,
                     razao_social varchar(150) not null,
		tipo_cadastro CHAR(1) not null,
                     cpf_cnpj varchar(18) not null,
                     endereco varchar(150),
                     telefone varchar(15),
                     ativo char(1) not null,
                     constraint pkcliente primary key (id),
                     constraint fkid_cidadepessoa foreign key (id_cidade)
                     REFERENCES cidade
                     );

CREATE TABLE empresa (id serial ,
                     id_cidade int not null,
                     razao_social varchar(150) not null,
                     cnpj varchar(18) not null,
	         inscricao_estadual varchar(20),
                     endereco varchar(150),
                     telefone varchar(15),
                     ativo CHAR(1) not null,
                     constraint pkpessoa primary key (id),
                     constraint fkid_cidadepessoa foreign key (id_cidade)
                     REFERENCES cidade
                     );

CREATE TABLE forma_pagamento( id serial not null,
	descricao VARCHAR(100) not null,
	ativo CHAR(1) not null,
constraint pkforma_pagamento primary key (id)
);
                    
                     
CREATE TABLE mercadoria(id serial ,
                        referencia VARCHAR(45) not null,
                        descricao VARCHAR(100) not null,
                        estoque decimal(7,2) not null,
                        preco_custo decimal(7,2) not null,
                        preco_venda decimal(7,2) not null,
                        ativo char(1) not null,
                        CONSTRAINT pkmercadoria primary key (id)                       
);              

CREATE TABLE faturamento(id serial,
                         id_cliente int not null,
		id_forma_pagamento int not null,
                        id_empresa int not null,
                         numero_pedido int not null,
                         data_emissao timestamp not null,
                         fase char(1) not null,
                         desconto decimal(7,2),
                         valor_total decimal (7,2) not null,		
                         parcelas int not null,
                         constraint pkfaturamento primary key (id),
                         CONSTRAINT fkid_clientefaturamento foreign key(id_cliente)
                         references cliente,
                         constraint fkid_empresafaturamento foreign key(id_empresa)
                         references empresa,
		constraint fkid_forma_pagamento foreign key (id_forma_pagamento)
		references forma_pagamento
                         );
                                                  
create table faturamento_item(id serial,
                              id_faturamento int not null,
      id_mercadoria int not null,
                              quantidade decimal(7,2) not null,
                              valor_unitario decimal(7,2) not null,
		      desconto decimal(7,2),
		      valor_total decimal(7,2) not null,
                              constraint pkfaturamento_item primary key (id),
                              constraint fkid_mercadoriafaturamento foreign key (id_mercadoria)
                              references mercadoria,
                              constraint fkid_faturamentofaturamento foreign key (id_faturamento)
                              references faturamento
                              );


create table financeiro(id serial,
id_faturamento int not null,
		numero_titulo varchar(10) not null,
		data_emissao timestamp not null,
		data_vencimento timestamp not null,
		valor_provisorio decimal(7,2),
		valor_titulo decimal(7,2),
		valor_pago decimal(7,2),
		quitado char(1),
		recebido char(1) not null,
		ativo char(1) not null,
		constraint pkfinanceiro primary key (id),
		constraint fkid_faturamentofaturamento foreign key(id_faturamento)
references faturamento);


