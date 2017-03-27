
---executar antes----

create database easyPDV;

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
                         estoque DOUBLE PRECISION not null,
                         preco_custo DOUBLE PRECISION not null,
                         preco_venda DOUBLE PRECISION not null,
                         ativo char(1) not null,
                         CONSTRAINT pkmercadoria primary key (id)                       
                         );              

            CREATE TABLE faturamento(id serial,
                         id_cliente int not null,
                         id_forma_pagamento int not null,
                         id_empresa int not null,
                         data_emissao timestamp not null,
                         fase char(1) not null,
                         desconto DOUBLE PRECISION,
                         valor_total DOUBLE PRECISION not null,		
                         parcelas int not null,
                         constraint pkfaturamento primary key (id),
                         CONSTRAINT fkid_clientefaturamento foreign key(id_cliente)
                         references cliente,
                         constraint fkid_empresafaturamento foreign key(id_empresa)
                         references empresa,
                         constraint fkid_forma_pagamento foreign key (id_forma_pagamento)
                         references forma_pagamento
                         );
                                                  
            CREATE TABLE faturamento_item(id serial,
                         id_faturamento int not null,
                         id_mercadoria int not null,
                         quantidade DOUBLE PRECISION not null,
                         valor_unitario DOUBLE PRECISION not null,
                         desconto DOUBLE PRECISION,
                         valor_total DOUBLE PRECISION not null,
                         constraint pkfaturamento_item primary key (id),
                         constraint fkid_mercadoriafaturamento foreign key (id_mercadoria)
                         references mercadoria,
                         constraint fkid_faturamentofaturamento foreign key (id_faturamento)
                         references faturamento
                         );


            CREATE TABLE financeiro(id serial,
                         id_faturamento int not null,
                         numero_titulo varchar(10) not null,
                         data_emissao timestamp not null,
                         data_vencimento timestamp not null,
                         valor_provisorio DOUBLE PRECISION,
                         valor_titulo DOUBLE PRECISION,
                         valor_pago DOUBLE PRECISION,
                         quitado char(1),
                         recebido char(1) not null,
                         ativo char(1) not null,
                         constraint pkfinanceiro primary key (id),
          		 constraint fkid_faturamentofaturamento foreign key(id_faturamento)
                         references faturamento
                         );


---------------insert-------------------

insert into usuario values(default,'usuario','123456');
