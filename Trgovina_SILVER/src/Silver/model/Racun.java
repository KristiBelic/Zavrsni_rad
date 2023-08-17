package Silver.model;



public class Racun extends Entitet {

	private String datumIzdavanja;
	

	public String getDatumIzdavanja() {
		return datumIzdavanja;
	}

	public void setDatumIzdavanja(String datumIzdavanja) {
		this.datumIzdavanja = datumIzdavanja;
	}

	public Racun(int sifra, String datumIzdavanja) {
		super(sifra);
		this.datumIzdavanja = datumIzdavanja;
	}

	public Racun() {
		super();
	}

	public static void add(Racun racun) {
		// TODO Auto-generated method stub
		
	}

}
