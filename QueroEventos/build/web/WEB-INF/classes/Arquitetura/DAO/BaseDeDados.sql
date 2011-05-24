/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     23/05/2011 22:35:56                          */
/*==============================================================*/


DROP TABLE IF EXISTS TB_AVALIACAO_EVT;

DROP TABLE IF EXISTS TB_CATEGORIA;

DROP TABLE IF EXISTS TB_CIDADE;

DROP TABLE IF EXISTS TB_CONTA;

DROP TABLE IF EXISTS TB_ESTADO;

DROP TABLE IF EXISTS TB_EVENTO;

DROP TABLE IF EXISTS TB_HISTORICO_EVENTO;

DROP TABLE IF EXISTS TB_LISTA_CONTATO;

DROP TABLE IF EXISTS TB_PARTICIPA_EVENTO;

DROP TABLE IF EXISTS TB_PERFIL;

DROP TABLE IF EXISTS TB_STATUS;

DROP TABLE IF EXISTS TB_TAGS;

DROP TABLE IF EXISTS TB_TAG_EVENTO;

DROP TABLE IF EXISTS TB_USUARIO;

DROP TABLE IF EXISTS TB_USU_PERTENCE_LISTA;

/*==============================================================*/
/* Table: TB_AVALIACAO_EVT                                      */
/*==============================================================*/
CREATE TABLE TB_AVALIACAO_EVT
(
   AVT_ID               int not null AUTO_INCREMENT,
   USU_ID               int not null,
   EVT_ID               int not null,
   AVT_NUM_NOTA         int not null,
   AVT_TXT_COMENTARIO   varchar(200) not null,
   primary key (AVT_ID)
);

/*==============================================================*/
/* Table: TB_CATEGORIA                                          */
/*==============================================================*/
CREATE TABLE TB_CATEGORIA
(
   CTG_ID               int not null AUTO_INCREMENT,
   CTG_TXT_NOME         varchar(30) not null,
   primary key (CTG_ID)
);

/*==============================================================*/
/* Table: TB_CIDADE                                             */
/*==============================================================*/
CREATE TABLE TB_CIDADE
(
   CID_ID               int not null,
   EST_UF               char(2) not null,
   CID_TXT_NOME         varchar(30) not null,
   primary key (CID_ID)
);

/*==============================================================*/
/* Table: TB_CONTA                                              */
/*==============================================================*/
CREATE TABLE TB_CONTA
(
   USU_ID               int not null,
   CNT_TXT_LOGIN        varchar(50) not null,
   STS_ID               int not null,
   PRF_ID               int not null,
   CNT_TXT_SENHA        varchar(32) not null,
   primary key (USU_ID, CNT_TXT_LOGIN)
);

/*==============================================================*/
/* Table: TB_ESTADO                                             */
/*==============================================================*/
CREATE TABLE TB_ESTADO
(
   EST_UF               char(2) not null,
   EST_TXT_NOME         varchar(30) not null,
   primary key (EST_UF)
);

/*==============================================================*/
/* Table: TB_EVENTO                                             */
/*==============================================================*/
CREATE TABLE TB_EVENTO
(
   EVT_ID               int not null AUTO_INCREMENT,
   STS_ID               int not null,
   CID_ID               int not null,
   USU_ID               int,
   CTG_ID               int not null,
   EVT_DT_INICIO        datetime not null,
   EVT_DT_FIM           datetime not null,
   EVT_TXT_NOME         varchar(100) not null,
   EVT_TXT_DESCRICAO    varchar(500) not null,
   EVT_FLG_TIPO         char(1) not null,
   EVT_TXT_ENDERECO     varchar(150) not null,
   EVT_FLG_MAIORIDADE   char(1),
   EVT_IMG_ARQUIVO      longblob,
   EVT_IMG_TIPO         varchar(3),
   primary key (EVT_ID)
);

/*==============================================================*/
/* Table: TB_HISTORICO_EVENTO                                   */
/*==============================================================*/
CREATE TABLE TB_HISTORICO_EVENTO
(
   HEV_ID               int not null AUTO_INCREMENT,
   USU_ID               int not null,
   EVT_ID               int not null,
   HEV_TXT_DESCRICAO    varchar(500) not null,
   HEV_DT_ALTERACAO     datetime not null,
   primary key (HEV_ID)
);

/*==============================================================*/
/* Table: TB_LISTA_CONTATO                                      */
/*==============================================================*/
CREATE TABLE TB_LISTA_CONTATO
(
   LTC_ID               int not null AUTO_INCREMENT,
   USU_ID               int not null,
   LTC_NOME_LISTA       char(50) not null,
   LTC_PRIVADA          char(1),
   primary key (LTC_ID)
);

/*==============================================================*/
/* Table: TB_PARTICIPA_EVENTO                                   */
/*==============================================================*/
CREATE TABLE TB_PARTICIPA_EVENTO
(
   USU_ID               int not null,
   EVT_ID               int not null,
   primary key (USU_ID, EVT_ID)
);

/*==============================================================*/
/* Table: TB_PERFIL                                             */
/*==============================================================*/
CREATE TABLE TB_PERFIL
(
   PRF_ID               int not null AUTO_INCREMENT,
   PRF_TXT_NOME         varchar(15) not null,
   primary key (PRF_ID)
);

/*==============================================================*/
/* Table: TB_STATUS                                             */
/*==============================================================*/
CREATE TABLE TB_STATUS
(
   STS_ID               int not null AUTO_INCREMENT,
   STS_COD              char(3) not null,
   STS_DESCRICAO        varchar(100) not null,
   primary key (STS_ID)
);

/*==============================================================*/
/* Table: TB_TAGS                                               */
/*==============================================================*/
CREATE TABLE TB_TAGS
(
   TAG_ID               int not null AUTO_INCREMENT,
   TAG_TXT_NOME         varchar(100) not null,
   primary key (TAG_ID)
);

/*==============================================================*/
/* Table: TB_TAG_EVENTO                                         */
/*==============================================================*/
CREATE TABLE TB_TAG_EVENTO
(
   TAG_ID               int not null,
   EVT_ID               int not null,
   primary key (TAG_ID, EVT_ID)
);

/*==============================================================*/
/* Table: TB_USUARIO                                            */
/*==============================================================*/
CREATE TABLE TB_USUARIO
(
   USU_ID               int not null AUTO_INCREMENT,
   CID_ID               int not null,
   USU_TXT_NOME         varchar(100) not null,
   USU_TXT_EMAIL        varchar(50) not null,
   USU_TXT_WEB_PAGE     varchar(100),
   USU_DT_NASCIMENTO    date not null,
   USU_FLG_SEXO         char(1) not null,
   USU_DT_CADASTRO      datetime not null,
   USU_FLG_TWITTER      char(1),
   USU_FLG_FACEBOOK     char(1),
   USU_IMG_ARQUIVO      longblob,
   USU_IMG_TIPO         varchar(3),
   primary key (USU_ID)
);

/*==============================================================*/
/* Table: TB_USU_PERTENCE_LISTA                                 */
/*==============================================================*/
CREATE TABLE TB_USU_PERTENCE_LISTA
(
   LTC_ID               int not null,
   USU_ID               int not null,
   primary key (LTC_ID, USU_ID)
);

ALTER TABLE TB_AVALIACAO_EVT ADD CONSTRAINT FK_AVALIACAO_EVENTO FOREIGN KEY (EVT_ID)
      REFERENCES TB_EVENTO (EVT_ID) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_AVALIACAO_EVT ADD CONSTRAINT FK_EVENTO_USUARIO FOREIGN KEY (USU_ID)
      REFERENCES TB_USUARIO (USU_ID) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_CIDADE ADD CONSTRAINT FK_ESTADO_CIDADE FOREIGN KEY (EST_UF)
      REFERENCES TB_ESTADO (EST_UF) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_CONTA ADD CONSTRAINT FK_PERFIL_CONTA FOREIGN KEY (PRF_ID)
      REFERENCES TB_PERFIL (PRF_ID) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_CONTA ADD CONSTRAINT FK_STATUS_CONTA FOREIGN KEY (STS_ID)
      REFERENCES TB_STATUS (STS_ID) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_CONTA ADD CONSTRAINT FK_USUARIO_CONTA FOREIGN KEY (USU_ID)
      REFERENCES TB_USUARIO (USU_ID) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_EVENTO ADD CONSTRAINT FK_CATEGORIA_EVENTO FOREIGN KEY (CTG_ID)
      REFERENCES TB_CATEGORIA (CTG_ID) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_EVENTO ADD CONSTRAINT FK_EVENTO_CIDADE FOREIGN KEY (CID_ID)
      REFERENCES TB_CIDADE (CID_ID) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_EVENTO ADD CONSTRAINT FK_STATUS_EVENTO FOREIGN KEY (STS_ID)
      REFERENCES TB_STATUS (STS_ID) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_EVENTO ADD CONSTRAINT FK_USU_CRIA_EVENTO FOREIGN KEY (USU_ID)
      REFERENCES TB_USUARIO (USU_ID) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_HISTORICO_EVENTO ADD CONSTRAINT FK_HISTORICO_EVT_ID FOREIGN KEY (EVT_ID)
      REFERENCES TB_EVENTO (EVT_ID) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_HISTORICO_EVENTO ADD CONSTRAINT FK_HISTORICO_USU_ID FOREIGN KEY (USU_ID)
      REFERENCES TB_USUARIO (USU_ID) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_LISTA_CONTATO ADD CONSTRAINT FK_USU_POSSUI_LISTA FOREIGN KEY (USU_ID)
      REFERENCES TB_USUARIO (USU_ID) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_PARTICIPA_EVENTO ADD CONSTRAINT FK_PARTICIPA_EVENTO FOREIGN KEY (USU_ID)
      REFERENCES TB_USUARIO (USU_ID) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_PARTICIPA_EVENTO ADD CONSTRAINT FK_PARTICIPA_EVENTO2 FOREIGN KEY (EVT_ID)
      REFERENCES TB_EVENTO (EVT_ID) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_TAG_EVENTO ADD CONSTRAINT FK_TAG_EVENTO FOREIGN KEY (TAG_ID)
      REFERENCES TB_TAGS (TAG_ID) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_TAG_EVENTO ADD CONSTRAINT FK_TAG_EVENTO2 FOREIGN KEY (EVT_ID)
      REFERENCES TB_EVENTO (EVT_ID) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_USUARIO ADD CONSTRAINT FK_USUARIO_CIDADE FOREIGN KEY (CID_ID)
      REFERENCES TB_CIDADE (CID_ID) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_USU_PERTENCE_LISTA ADD CONSTRAINT FK_USU_PERTENCE_LISTA FOREIGN KEY (LTC_ID)
      REFERENCES TB_LISTA_CONTATO (LTC_ID) ON DELETE restrict ON UPDATE restrict;

ALTER TABLE TB_USU_PERTENCE_LISTA ADD CONSTRAINT FK_USU_PERTENCE_LISTA2 FOREIGN KEY (USU_ID)
      REFERENCES TB_USUARIO (USU_ID) ON DELETE restrict ON UPDATE restrict;

