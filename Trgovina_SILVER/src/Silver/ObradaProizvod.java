package Silver;

import java.util.ArrayList;
import java.util.List;

import Silver.model.Proizvod;

public class ObradaProizvod {

	private List<Proizvod> proizvodi;

	public List<Proizvod> getProizvodi() {
		return proizvodi;
	}

	public ObradaProizvod() {
		proizvodi = new ArrayList<>();
		if (Pomocno.dev) {
			testniPodaci();
		}
	}

	private void testniPodaci() {
		Proizvod.add(new Proizvod(1, "Piercing", 9.88));
		Proizvod.add(new Proizvod(2, "Ogrlica", 7.50));
		Proizvod.add(new Proizvod(3, "Narukvica", 8.75));
		Proizvod.add(new Proizvod(4, "Prsten", 6.98));
	}

	public void prikaziIzbornik() {
		System.out.println("\n Proizvod izbornik");
		System.out.println("1. Pregled proizvoda");
		System.out.println("2. Unos novog proizvoda");
		System.out.println("3. Promjena postojećeg proizvoda");
		System.out.println("4. Brisanje postojećeg proizvoda");
		System.out.println("5. Povratak na prethodni izbornik");
		ucitajStavkuIzbornika();
	}

	private void ucitajStavkuIzbornika() {
		switch (Pomocno.unosRasponBroja("Odaberi stavku dobavljača izbornika: ", "Odabir mora biti 1-5", 1, 5)) {
		case 1:
			pregledProizvoda();
			prikaziIzbornik();
			break;
		case 2:
			dodavanjeProizvoda();
			prikaziIzbornik();
			break;
		case 3:
			promjenaProizvoda();
			prikaziIzbornik();
			break;
		case 4:
			brisanjeProizvoda();
			prikaziIzbornik();
			break;
		case 5:
			break;

		}
	}

	private void promjenaProizvoda() {
		pregledProizvoda();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj proizvoda: ", "Nije dobar odabir", 1, proizvodi.size());
		Proizvod p = proizvodi.get(index - 1);
		p.setSifra(Pomocno.unosRasponBroja("Unesi šifru proizvoda (" + p.getSifra() + "):", "Pozitivan broj", 1,
				Integer.MAX_VALUE));
		p.setNaziv(Pomocno.unosString("Unesi naziv proizvoda (" + p.getNaziv() + "):", "Naziv obavezan"));
		p.setCijena(Pomocno.unosFloat("Unesi cijenu proizvoda (" + p.getCijena() + "):", "Cijena obavezna"));

	}

	private void dodavanjeProizvoda() {
		Proizvod p = new Proizvod();
		p.setSifra(Pomocno.unosRasponBroja("Unesi šifru dobavljača : ", "Pozitivan broj", 1, Integer.MAX_VALUE));
		p.setNaziv(Pomocno.unosString("Unesi naziv proizvoda", "Naziv obavezan"));
		p.setCijena(Pomocno.unosFloat("Unesi cijenu proizvoda", "Cijena obavezna"));
		Proizvod.add(p);

	}

	private void pregledProizvoda() {
		System.out.println("------------------");
		System.out.println("---- Proizvodi ----");
		System.out.println("------------------");
		int b = 1;
		for (Proizvod p : proizvodi) {
			System.out.println(b++ + ". " + p.getNaziv());
		}
		System.out.println("------------------");

	}

	private void brisanjeProizvoda() {
		pregledProizvoda();
		int index = Pomocno.unosRasponBroja("Odaberi redni broj proizvoda: ", "Nije dobar odabir", 1, proizvodi.size());
		proizvodi.remove(index - 1);
	}

}
