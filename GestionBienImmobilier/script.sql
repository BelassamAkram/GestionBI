DROP TABLE Affectation
/
DROP TABLE AGENT
/
DROP TABLE Transaction
/
DROP TABLE RDV
/
drop table interaction
/
drop table preference
/
drop table client
/
DROP TABLE BienImmobilier
/
alter SESSION set nls_date_format = 'dd-mm-yyyy'
/

--Creation de la table bien immobilier
CREATE TABLE BienImmobilier (
    Num varchar2(20) PRIMARY KEY NOT NULL,
    typeBI varchar2(20) NOT NULL,
    Surface varchar2(20) NOT NULL,
    Localisation varchar2(20) NOT NULL,
    Prix varchar2(20) NOT NULL,
    Description varchar2(100)
    )
/


-- Création de la table client
CREATE TABLE client (
    nom VARCHAR2(20) NOT NULL,
    prenom VARCHAR2(20) NOT NULL,
    type VARCHAR2(20) NOT NULL,
    numTel VARCHAR2(20) NOT NULL,
    AdresseEmail VARCHAR2(30) NOT NULL,
    PRIMARY KEY (nom, prenom)
)
/

-- Création de la table preference
CREATE TABLE preference (
    nom VARCHAR2(20) NOT NULL,
    prenom VARCHAR2(20) NOT NULL,
    type VARCHAR2(20) NOT NULL,
    surface VARCHAR2(20) NOT NULL,
    prix_max VARCHAR2(20) NOT NULL,
    localisation VARCHAR2(50) NOT NULL,
    CONSTRAINT fk_preference_client FOREIGN KEY (nom, prenom)
        REFERENCES client (nom, prenom)
)
/

-- Création de la table interaction
CREATE TABLE interaction (
    nom VARCHAR2(20) NOT NULL,
    prenom VARCHAR2(20) NOT NULL,
    date_INT date NOT NULL,
    description VARCHAR2(100) NOT NULL,
    CONSTRAINT fk_interaction_client FOREIGN KEY (nom, prenom)
        REFERENCES client (nom, prenom)
)
/

CREATE TABLE Transaction(
    TransID varchar2(20) PRIMARY KEY NOT NULL,
    NomCL varchar2(20) NOT NULL,
    PrenomCL varchar2(20) NOT NULL,
    Type varchar2(20) NOT NULL,
    NumBI varchar2(20) NOT NULL,
    DateD date NOT NULL ,
    DateF date,
    Montant varchar2(20) NOT NULL,
    CONSTRAINT fk_Transaction_BI FOREIGN KEY (NumBI)
    REFERENCES BienImmobilier (Num), 
    CONSTRAINT fk_Transaction_Client FOREIGN KEY (NomCL, PrenomCL)
    REFERENCES Client (Nom, Prenom)
)
/

CREATE TABLE Agent(
    NomAG varchar2(20) NOT NULL,
    PrenomAG varchar2(20) NOT NULL,
    Phone varchar2(20) NOT NULL,
    Email varchar2(30) NOT NULL,
    PRIMARY KEY (NomAG, PrenomAG)
)
/
CREATE TABLE Affectation(
    NomAG varchar2(20) NOT NULL,
    PrenomAG varchar2(20) NOT NULL,
    NumBI varchar2(20) NOT NULL,
    constraint fk_affectation_agent FOREIGN KEY (NomAG, PrenomAG)
    REFERENCES Agent(NomAG, PrenomAG),
    constraint fk_affectation_BI FOREIGN KEY (NumBI)
    REFERENCES BienImmobilier (Num)
)
/
CREATE TABLE RDV(
    NomCL varchar2(20) NOT NULL,
    PrenomCL varchar2(20) NOT NULL,
    DateRDV date NOT NULL,
    DESCRIPTION varchar2(100) NOT NULL,
    constraint fk_rdv_client FOREIGN KEY (NomCL, PrenomCL)
    REFERENCES Client(Nom, Prenom)
)
/