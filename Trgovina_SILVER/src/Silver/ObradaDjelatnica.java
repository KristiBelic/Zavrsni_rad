package Silver;

import java.util.ArrayList;
import java.util.List;

import Silver.model.Djelatnica;

public class ObradaDjelatnica {

	private List<Djelatnica> djelatnice;

	public List<Djelatnica> getDjelatnice() {
		return djelatnice;
	}

	public ObradaDjelatnica() {
		djelatnice = new ArrayList<>();
		if (Pomocno.dev) {
			testniPodaci();
		}

	}

	private void testniPodaci() {
		Djelatnica.add(new Djelatnica("Jana", "Romić", "236514569845", "jromic@gmail.com"));
		Djelatnica.add(new Djelatnica("Karolina", "Novoselac", "12436598652", "karolinanovoselac@gmail.com"));
		Djelatnica.add(new Djelatnica("Biba", "Cvetković", "65985645789", "cvetkovicbiba@gmail.com"));
		
	}

	public void prikaziIzbornik() {
		System.out.println("\nDjelatnica izbornik");
		System.out.println("1. Pregled djelatnica");
		System.out.println("2. Unos nove djelatnice");
		System.out.println("3. Promjena postojeće djelatnice");
		System.out.println("4. Brisanje postojeće djelatnice");
		System.out.println("5. Povratak na prethodni izbornik");
		ucitajStavkuIzbornika();

	}

	private void ucitajStavkuIzbornika() {
		switch(Pomocno.unosRasponBroja("Odaberi stavku djelatnica izbornika: ",
				"Odabir mora biti 1-5", 1, 5)) {
		case 1:
			pregledDjelatnica();
			prikaziIzbornik();
			break;
		case 2:
			dodavanjeDjelatnice();
			prikaziIzbornik();
			break;
		case 3:
			promjenaDjelatnica();
			prikaziIzbornik();
			break;
		case 4:
			brisanjeDjelatnice();
			prikaziIzbornik();
			break;
		case 5:
			break;
		}
		
	}

	private void dodavanjeDjelatnice() {
		Djelatnica d = new Djelatnica();
		d.setSifra(Pomocno.unosRasponBroja("Unesi šifru djelatnice : ","Pozitivan broj", 1, Integer.MAX_VALUE));
		d.setIme(Pomocno.unosString("Unesi ime djelatnice", "Ime obavezno"));
		d.setPrezime(Pomocno.unosString("Unesi prezime djelatnice", "Prezime obavezno"));
		d.setOib(Pomocno.unosString("Unesi oib", "Oib obavezan"));
		d.setEmail(Pomocno.unosString("Unesi email", "Email obavezan"));
		Djelatnica.add(d);
		
	}

	private void promjenaDjelatnica() {
		
		pregledDjelatnica();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj djelatnice: ","Nije dobar odabir", 1, djelatnice.size());
		Djelatnica d = djelatnice.get(index -1);
		d.setSifra(Pomocno.unosRasponBroja("Unesi šifru djelatnice (" + d.getSifra() + "):" ,"Pozitivan broj", 1, Integer.MAX_VALUE));
		d.setIme(Pomocno.unosString("Unesi ime djelatnice (" + d.getIme() + "):","Ime obavezno"));
		d.setPrezime(Pomocno.unosString("Unesi prezime (" + d.getPrezime() + "):", "Prezime obavezno"));
		d.setOib(Pomocno.unosString("Unesi oib(" + d.getOib() + "):", "Oib obavezan"));
	}

	private void pregledDjelatnica() {
		System.out.println("------------------");
		System.out.println("---- Djelatnice ----");
		System.out.println("------------------");
		int b=1;
		for(Djelatnica d : djelatnice) {
			System.out.println(b++ + ". " + d.getIme());
		}
		System.out.println("------------------");
	}

	private void brisanjeDjelatnice() {
		pregledDjelatnica();
		int index= Pomocno.unosRasponBroja("Odaberi redni broj djelatnice: ","Nije dobar odabir", 1,djelatnice.size());
		djelatnice.remove(index -1);
}
}