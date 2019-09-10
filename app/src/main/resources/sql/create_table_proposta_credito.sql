CREATE TABLE public.proposta_credito(
  id bigserial NOT NULL,
  nome varchar(255) NULL,
  cpf varchar(255) NULL,
  idade numeric NULL,
  estado varchar(255)  NULL,
  dependentes numeric  NULL,
  renda numeric(19,2) null,
  sexo varchar(255)  NULL,
  estadoCivil varchar(255)  NULL,
  statusProposta varchar(255)  NULL,
  constraint proposta_credito_pk primary key (id)
);