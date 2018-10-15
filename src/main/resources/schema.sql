-- ======================================== PROCESSOS ========================================

CREATE TABLE IF NOT EXISTS APP_OWNER.PROCESSOS (
  ID          BIGINT PRIMARY KEY   NOT NULL,
  NAME        VARCHAR(100)         NOT NULL,
  DESCRIPTION VARCHAR(1000)        NOT NULL
);
-- DROP TABLE APP_OWNER.PROCESSOS;

CREATE SEQUENCE IF NOT EXISTS APP_OWNER.SEQ_PROCESSOS
  INCREMENT BY 1
  MINVALUE 1
  MAXVALUE 1000000
  START WITH 1;
--DROP SEQUENCE APP_OWNER.SEQ_PROCESSOS;

-- ======================================== PARECERES ========================================

CREATE TABLE IF NOT EXISTS APP_OWNER.PARECERES (
  ID          BIGINT PRIMARY KEY   NOT NULL,
  I_PROCESSOS BIGINT               NOT NULL,
  PARECER     VARCHAR(1000),
  CONSTRAINT FK_PARECERES_PROCESSOS FOREIGN KEY (I_PROCESSOS) REFERENCES APP_OWNER.PROCESSOS (ID)
);
-- DROP TABLE APP_OWNER.PARECERES;

CREATE INDEX IF NOT EXISTS IDX_PARECERES_PROCESSOS
  ON APP_OWNER.PARECERES (I_PROCESSOS);
-- DROP INDEX IDX_PARECERES_PROCESSOS;

CREATE SEQUENCE IF NOT EXISTS APP_OWNER.SEQ_PARECERES
  INCREMENT BY 1
  MINVALUE 1
  MAXVALUE 1000000
  START WITH 1;
--DROP SEQUENCE APP_OWNER.SEQ_PARECERES;
