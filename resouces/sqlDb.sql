



drop table if exists ruolo;
drop table if exists impiegato; 
drop table if exists storico; 


create table ruolo (
	idruolo bigint NOT NULL AUTO_INCREMENT, 
	descrizione VARCHAR(2000),
	primary key(idruolo)
);


create table impiegato (
	matricola bigint NOT NULL AUTO_INCREMENT, 
	nome VARCHAR(30),
	cognome VARCHAR(30),
	email VARCHAR(30),
	primary key(matricola)
);

create table storico (
    idstorico bigint primary key auto_increment,
    idmatricola bigint not null,
    idruolo bigint not null,
    datainizio Date not null,
    datafine Date not null,
    foreign key (idmatricola) references impiegato(matricola),
    foreign key (idruolo) references ruolo(idruolo)
);



