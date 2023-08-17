package Silver;

import java.util.ArrayList;
import java.util.List;


import Silver.model.Stavka;

public class ObradaStavka {

	private List<Stavka> stavke;

	public List<Stavka> getStavke() {
		return stavke;
	}
	
	public ObradaStavka() {
		stavke = new ArrayList<Stavka>();
		if (Pomocno.dev) {
			testniPodaci();
		}
	}

	private void testniPodaci() {
		Stavka.add(new Stavka(1, "27.04.2023.", "Piercing", 6));
		Stavka.add(new Stavka(2, "02.05.2023.", "Ogrlica", 9));
		Stavka.add(new Stavka(3, "11.05.2023.", "Narukvica",10));
		Stavka.add(new Stavka(4, "21.05.2023.", "Prsten", 4));
	}
	
	public void prikaziIzbornik() {
		System.out.println("\n Stavka izbornik");
		System.out.println("1. Pregled stavki");
		System.out.println("2. Unos nove stavke");
		System.out.println("3. Promjena postojeće stavke");
		System.out.println("4. Brisanje postojeće stavke");
		System.out.println("5. Povratak na prethodni izbornik");
		ucitajStavkuIzbornika();
	}

	private void ucitajStavkuIzbornika() {
		switch (Pomocno.unosRasponBroja("Odaberi stavku dobavljača izbornika: ", "Odabir mora biti 1-5", 1, 5)) {
		case 1:
			pregledStavki();
			prikaziIzbornik();
			break;
		case 2:
			dodavanjeStavki();
			prikaziIzbornik();
			break;
		case 3:
			promjenaStavki();
			prikaziIzbornik();
			break;
		case 4:
			brisanjeStavki();
			prikaziIzbornik();
			break;
		case 5:
			break;
	}
		
	}


	private void promjenaStavki() {
		pregledStavki();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj stavke: ", "Nije dobar odabir", 1, stavke.size());
		Stavka s  = stavke.get(index - 1);
		s.setSifra(Pomocno.unosRasponBroja("Unesi šifru stavke (" + s.getSifra() + "):", "Pozitivan broj", 1,
				Integer.MAX_VALUE));
		s.setDatumIzdavanja(Pomocno.unosString("Unesi datum izdavanja (" + s.getDatumIzdavanja() + "):", "Datum obavezan"));
		s.setProizvod(Pomocno.unosString("Unesi proizvod (" + s.getProizvod() + "):", "Naziv obavezan"));
		s.setKolicina(Pomocno.unosFloat("Unesi količinu proizvoda(" + s.getKolicina()+  "):", "Količina obavezna"));


	}

	private void dodavanjeStavki() {
		Stavka s = new Stavka();
		s.setSifra(Pomocno.unosRasponBroja("Unesi šifru stavke : ", "Pozitivan broj", 1, Integer.MAX_VALUE));
		s.setProizvod(Pomocno.unosString("Unesi naziv proizvoda", "Naziv obavezan"));
		s.setKolicina(Pomocno.unosFloat("Unesi količinu", "Količina obavezna"));
		stavke.add(s);
		
	}

	private void pregledStavki() {
		System.out.println("------------------");
		System.out.println("---- Stavke ----");
		System.out.println("------------------");
		int b = 1;
		for (Stavka s : stavke) {
			System.out.println(b++ + ". " + s.getSifra());
		}
		System.out.println("------------------");

		
		
	}
	
	private void brisanjeStavki() {
		pregledStavki();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj stavke: ", "Nije dobar odabir", 1, stavke.size());
		stavke.remove(index - 1);
		

	}}
