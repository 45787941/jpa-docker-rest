ALTER TABLE PERSONNE DROP CONSTRAINT FK_PERSONNE_DOG_IDC
ALTER TABLE CHIEN DROP CONSTRAINT FK_CHIEN_CHENIL_IDCHENIL
ALTER TABLE CHIEN_PATHOLOGIE DROP CONSTRAINT FK_CHIEN_PATHOLOGIE_listePathologie_IDPATHOLOGIE
ALTER TABLE CHIEN_PATHOLOGIE DROP CONSTRAINT FK_CHIEN_PATHOLOGIE_listeChiens_IDC
DROP TABLE PERSONNE CASCADE
DROP TABLE CHIEN CASCADE
DROP TABLE CHENIL CASCADE
DROP TABLE PATHOLOGIE CASCADE
DROP TABLE CHIEN_PATHOLOGIE CASCADE
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN_TABLE'
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
