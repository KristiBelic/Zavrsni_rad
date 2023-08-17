package Silver.model;

public class Proizvod extends Entitet {


	private String naziv;
	private float cijena;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public float getCijena() {
		return cijena;
	}

	public void setCijena(float cijena) {
		this.cijena = cijena;
	}


	public Proizvod(int sifra, String naziv, double d) {
		super(sifra);
		this.naziv = naziv;
		this.cijena = (float) d;
	}

	public Proizvod() {
		super();
	}

	public static void add(Proizvod proizvod) {
		// TODO Auto-generated method stub
		
	}

}
