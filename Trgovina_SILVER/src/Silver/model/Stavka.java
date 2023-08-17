package Silver.model;



public class Stavka extends Racun {
	private String proizvod;
	private float kolicina;

	public String getProizvod() {
		return proizvod;
	}

	public void setProizvod(String proizvod) {
		this.proizvod = proizvod;
	}

	public float getKolicina() {
		return kolicina;
	}

	public void setKolicina(float f) {
		this.kolicina = f;
	}



	public Stavka(int sifra, String datumIzdavanja, String proizvod, int kolicina) {
		super(sifra, datumIzdavanja);
		this.proizvod = proizvod;
		this.kolicina = kolicina;
	}

	public Stavka() {
		super();
	}

}
