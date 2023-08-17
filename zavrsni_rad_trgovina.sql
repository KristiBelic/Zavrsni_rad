# c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Josip\Documents\EDUNOVA_JAVA_PROGRAMER\KRISTI\zavrsni_rad_trgovina.sql


drop database if exists trgovina_Silver;
create database trgovina_Silver;
use trgovina_Silver;

create table proizvod(
    sifra int not null primary key auto_increment,
    naziv varchar(50) not null,
    cijena decimal (18,2) not null,
    dobavljac int not null
);
create table dobavljac(
    sifra int not null primary key auto_increment,
    naziv varchar (50) not null,
    adresa varchar(70),
    oib char(11) not null
);
create table djelatnica(
    sifra int not null primary key auto_increment,
    ime varchar(50) not null,
    prezime varchar(60) not null,
    oib char(11) not null,
    email varchar(60)
);
create table stavka(
    sifra int not null primary key auto_increment,
    proizvod int,
    racun int,
    kolicina varchar(60)
);
create table racun(
    sifra int not null primary key auto_increment,
    datum date,
    djelatnica int
);
 alter table proizvod add foreign key(dobavljac) references dobavljac(sifra);
 alter table stavka add foreign key(proizvod) references proizvod(sifra);
 alter table stavka add foreign key(racun) references racun(sifra);
 alter table racun add foreign key(djelatnica) references djelatnica(sifra);

 insert into djelatnica (sifra,ime,prezime,oib,email) values
 (null,'Jana','Romić','236514569845','jromic@gmail.com'),
 (null,'Karolina','Novoselac','12436598652','karolinanovoselac@gmail.com'),
 (null,'Biba','Cvetković','65985645789','cvetkovicbiba@gmail.com');

 insert into dobavljac(sifra,naziv,adresa,oib) values
(null,'Factory','Josipa Kozarca 65,Zagreb','39865985471'),
(null,'Petra','Matije Petra Katančića 103,Split','63265489754'),
(null,'Vita','Dubrovačka ulica 79,Rijeka','48756983210'),
(null,'Nakit','Ive Lole Ribara 305,Osijek','12465986352');

insert into racun(sifra,datum,djelatnica) values
(null,2023-04-27,1),
(null,2023-05-02,1),
(null,2023-05-11,2),
(null,2023-05-21,3),
(null,2023-05-24,3);

insert into proizvod(sifra,naziv,cijena,dobavljac) values
(null,'Piercing',9.88,1),
(null,'Ogrlica',7.50,2),
(null,'Narukvica',8.75,3),
(null,'Prsten',6.98,4);

insert into stavka(sifra,proizvod,racun,kolicina) values
(null,1,5,30),
(null,2,2,16),
(null,3,1,20),
(null,4,3,9);


/*
# koje proizvode dostavljac dostavlja:

    select a.naziv,b.naziv
    from dobavljac a
    inner join proizvod b on a.sifra=b.dobavljac;
*/

/*
# koja djelatnica je izdala racun:

    select a.sifra,b.sifra
    from djelatnica a 
    inner join racun b on a.sifra=b.djelatnica;
*/

/*
# koji proizvod se nalazi na racunu

select a.naziv,b.proizvod,c.sifra
from proizvod a 
inner join stavka b on a.sifra=b.proizvod 
inner join racun c on c.sifra=b.racun;
*/