


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
                         id_cidade int,
                         razao_social varchar(150) not null,
                         tipo_cadastro CHAR(1) not null,
                         cpf_cnpj varchar(18) unique,
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
                         forma_avista CHAR(1) NOT NULL,
                         ativo CHAR(1) not null,
                         constraint pkforma_pagamento primary key (id)
                         );
                    
                     
            CREATE TABLE mercadoria(id serial ,
                         referencia VARCHAR(45) not null unique,
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
                         valor_total_liquido double not null,
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

--------procedure e triggers---------------

---atualiza estoque quando o pedido é encerrado ou cancelado
CREATE OR REPLACE FUNCTION fatuaizaestoque()
RETURNS trigger
AS $$
 
BEGIN

	if (NEW.fase = 'e') then
    update mercadoria m set estoque = (estoque - f.quantidade  )
    from faturamento_item f, faturamento fa
    where m.id = f.id_mercadoria and f.id_faturamento = fa.id and fa.id = new.id;

    
 end if;
    if (NEW.fase = 'c') then
  update mercadoria m set estoque = estoque
    from faturamento_item f, faturamento fa
    where m.id = f.id_mercadoria and f.id_faturamento = fa.id and fa.id = new.id;
end if;
RETURN null;
END;
$$ LANGUAGE plpgsql;

CREATE  TRIGGER tatuaizaestoquecancelamento
AFTER  UPDATE ON faturamento
FOR EACH ROW
EXECUTE PROCEDURE fatuaizaestoquecancelamento ()


--------testes---------------
update faturamento f set fase = 'c' where f.id = 9

update empresa e set id =1
delete from faturamento
update mercadoria m set estoque = (estoque - f.quantidade  )from faturamento_item f where m.id = f.id_mercadoria

select * from mercadoria 

select * from faturamento
select max(id) id from faturamento 

INSERT INTO public.faturamento(
	id, id_cliente, id_forma_pagamento, id_empresa, data_emissao, fase, desconto, valor_total, parcelas)
	VALUES (default, 10, 16, 2, '10/02/2017', '', 0, 100, 1);
    
    INSERT INTO public.faturamento_item(
	id, id_faturamento, id_mercadoria, quantidade, valor_unitario, desconto, valor_total)
	VALUES (default, 9, 6, 6, 16, 0, 32);