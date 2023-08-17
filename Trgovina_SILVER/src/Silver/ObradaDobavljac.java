package Silver;

import java.util.ArrayList;
import java.util.List;


import Silver.model.Dobavljac;

public class ObradaDobavljac {
	
	private List<Dobavljac> dobavljaci;
	

	public List<Dobavljac> getDobavljaci() {
		return dobavljaci;
	}
	public ObradaDobavljac() {
		dobavljaci = new ArrayList<>();
		if (Pomocno.dev) {
			testniPodaci();
		}
	}

	private void testniPodaci() {
		Dobavljac.add(new Dobavljac(1,"Factory","Josipa Kozarca 65,Zagreb","39865985471"));
		Dobavljac.add(new Dobavljac(2,"Petra","Matije Petra Katančića 103,Split","63265489754"));
		Dobavljac.add(new Dobavljac(3,"Vita","Dubrovačka ulica 79,Rijeka'","48756983210"));
		Dobavljac.add(new Dobavljac(4,"Nakit","Ive Lole Ribara 305,Osijek","12465986352"));
		
	}
	public void prikaziIzbornik() {
		System.out.println("\n Dobavljač izbornik");
		System.out.println("1. Pregled dobavljača");
		System.out.println("2. Unos novog dobavljača");
		System.out.println("3. Promjena postojećeg dobavljača");
		System.out.println("4. Brisanje postojećeg dobavljača");
		System.out.println("5. Povratak na prethodni izbornik");
		ucitajStavkuIzbornika();

		
	}
	private void ucitajStavkuIzbornika() {
		switch(Pomocno.unosRasponBroja("Odaberi stavku dobavljača izbornika: ",
				"Odabir mora biti 1-5", 1, 5)) {
		case 1:
			pregledDobavljača();
			prikaziIzbornik();
			break;
		case 2:
			dodavanjeDobavljača();
			prikaziIzbornik();
			break;
		case 3:
			promjenaDobavljača();
			prikaziIzbornik();
			break;
		case 4:
			brisanjeDobavljača();
			prikaziIzbornik();
			break;
		case 5:
			break;
		
	}

}
	private void dodavanjeDobavljača() {
		Dobavljac a = new Dobavljac();
		a.setSifra(Pomocno.unosRasponBroja("Unesi šifru dobavljača : ","Pozitivan broj", 1, Integer.MAX_VALUE));
		a.setNaziv(Pomocno.unosString("Unesi naziv dobavljača", "Naziv obavezan"));
		a.setAdresa(Pomocno.unosString("Unesi adresu dobavljača", "Adresa obavezna"));
		a.setOib(Pomocno.unosString("Unesi oib", "Oib obavezan"));
		Dobavljac.add(a);
		
		
	}
	private void promjenaDobavljača() {

		pregledDobavljača();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj dobavljača: ","Nije dobar odabir", 1, dobavljaci.size());
		Dobavljac a = dobavljaci.get(index -1);
		a.setSifra(Pomocno.unosRasponBroja("Unesi šifru dobavljača (" + a.getSifra() + "):" ,"Pozitivan broj", 1, Integer.MAX_VALUE));
		a.setNaziv(Pomocno.unosString("Unesi naziv dobavljača (" + a.getNaziv() + "):","Ime obavezno"));
		a.setAdresa(Pomocno.unosString("Unesi adresu dobavljača (" + a.getAdresa() + "):", "Prezime obavezno"));
		a.setOib(Pomocno.unosString("Unesi oib(" + a.getOib() + "):", "Oib obavezan"));
	}
		
	private void pregledDobavljača() {
		System.out.println("------------------");
		System.out.println("---- Dobavljači ----");
		System.out.println("------------------");
		int b=1;
		for(Dobavljac a : dobavljaci) {
			System.out.println(b++ + ". " + a.getNaziv());
		}
		System.out.println("------------------");
		
	}

	private void brisanjeDobavljača() {
		pregledDobavljača();
		int index= Pomocno.unosRasponBroja("Odaberi redni broj dobavljača: ","Nije dobar odabir", 1,dobavljaci.size());
		dobavljaci.remove(index -1);
}
		
	}

