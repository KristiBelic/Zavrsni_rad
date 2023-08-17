package Silver;

import java.util.Scanner;

public class Izbornik {

	private ObradaDjelatnica obradaDjelatnica;
	private ObradaRacun obradaRacun;
	private ObradaProizvod obradaProizvod;
	private ObradaStavka obradaStavka;
	private ObradaDobavljac obradaDobavljac;

	public ObradaDjelatnica getObradaDjelatnica() {
		return obradaDjelatnica;
	}

	public ObradaRacun getObradaRacun() {
		return obradaRacun;
	}

	public ObradaProizvod getObradaProizvod() {
		return obradaProizvod;
	}

	public ObradaStavka getObradaStavka() {
		return obradaStavka;
	}

	private void pozdravnaPoruka() {
		
		System.out.println("*************************************");
		System.out.println("*** Edunova Console OOP APP v 1.0 ***");
		System.out.println("*************************************");
	}
	
	public Izbornik() {
		obradaDjelatnica = new ObradaDjelatnica();
		obradaRacun = new ObradaRacun();
		obradaProizvod = new ObradaProizvod();
		obradaStavka = new ObradaStavka();
		Pomocno.ulaz = new Scanner(System.in);
		pozdravnaPoruka();
		prikaziIzbornik();
		Pomocno.ulaz.close();
}

	private void prikaziIzbornik() {
		System.out.println("Glavni izbornik");
		System.out.println("1. Djelatnica");
		System.out.println("2. Račun");
		System.out.println("3. Proizvodi");
		System.out.println("4. Stavka");
		System.out.println("5. Dobavljači");
		System.out.println("6. Izlaz iz programa");
		ucitajStavkuIzbornika();
		

	}

	private void ucitajStavkuIzbornika() {
		switch(Pomocno.unosRasponBroja("Odaberi stavku izbornika: ",
				"Obavezno 1-5",1,5)) {
		case 1:
			obradaDjelatnica.prikaziIzbornik();
			prikaziIzbornik();
			break;
		case 2:
			obradaRacun.prikaziIzbornik();
			prikaziIzbornik();
			break;
		case 3:
			obradaProizvod.prikaziIzbornik();
			prikaziIzbornik();
			break;
		case 4:
			obradaStavka.prikaziIzbornik();
			prikaziIzbornik();
			break;
		case 5:
			obradaDobavljac.prikaziIzbornik();
		case 6:
			System.out.println("Doviđenja");
			break;
		
	}
	}


	}
