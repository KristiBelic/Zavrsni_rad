package Silver;

import java.util.ArrayList;
import java.util.List;


import Silver.model.Racun;

public class ObradaRacun {

	private List<Racun> racuni;

	public List<Racun> getRacuni() {
		return racuni;
	}

	public ObradaRacun() {
		racuni = new ArrayList<>();
		if (Pomocno.dev) {
			testniPodaci();
		}

	}

	private void testniPodaci() {

		Racun.add(new Racun(1, "27.04.2023."));
		Racun.add(new Racun(2, "02.05.2023."));
		Racun.add(new Racun(3, "11.05.2023."));
		Racun.add(new Racun(4, "21.05.2023."));
		Racun.add(new Racun(5, "24.05.2023."));
	}

	public void prikaziIzbornik() {
		System.out.println("\n Račun izbornik");
		System.out.println("1. Pregled računa");
		System.out.println("2. Unos novog računa");
		System.out.println("3. Promjena postojećeg računa");
		System.out.println("4. Brisanje postojećeg raČuna");
		System.out.println("5. Povratak na prethodni izbornik");
		ucitajStavkuIzbornika();
	}

	private void ucitajStavkuIzbornika() {
		switch (Pomocno.unosRasponBroja("Odaberi stavku dobavljača izbornika: ", "Odabir mora biti 1-5", 1, 5)) {
		case 1:
			pregledRačuna();
			prikaziIzbornik();
			break;
		case 2:
			dodavanjeRačuna();
			prikaziIzbornik();
			break;
		case 3:
			promjenaRačuna();
			prikaziIzbornik();
			break;
		case 4:
			brisanjeRačuna();
			prikaziIzbornik();
			break;
		case 5:
			break;

		}
	}



	private void promjenaRačuna() {
		pregledRačuna();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj računa: ", "Nije dobar odabir", 1, racuni.size());
		Racun r = racuni.get(index - 1);
		r.setSifra(Pomocno.unosRasponBroja("Unesi šifru računa (" + r.getSifra() + "):", "Pozitivan broj", 1,
				Integer.MAX_VALUE));
		r.setDatumIzdavanja(Pomocno.unosString("Unesi datum izdavanja (" + r.getDatumIzdavanja() + "):", "Datum obavezan"));

	}

	private void dodavanjeRačuna() {
		Racun r = new Racun();
		r.setSifra(Pomocno.unosRasponBroja("Unesi šifru raČuna : ", "Pozitivan broj", 1, Integer.MAX_VALUE));
		r.setDatumIzdavanja(Pomocno.unosString("Unesi datum izdavanja računa", "Datum obavezan"));
		Racun.add(r);

	}

	private void pregledRačuna() {
		System.out.println("------------------");
		System.out.println("---- Računi ----");
		System.out.println("------------------");
		int b = 1;
		for (Racun r : racuni) {
			System.out.println(b++ + ". " + r.getSifra());
		}
		System.out.println("------------------");

	}

	private void brisanjeRačuna() {
		pregledRačuna();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj računa: ", "Nije dobar odabir", 1, racuni.size());
		racuni.remove(index - 1);
		
	}
}

