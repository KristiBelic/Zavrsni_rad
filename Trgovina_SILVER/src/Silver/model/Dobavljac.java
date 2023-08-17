package Silver.model;

public class Dobavljac extends Entitet {
	private String naziv;
	private String adresa;
	private String oib;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getOib() {
		return oib;
	}

	public void setOib(String oib) {
		this.oib = oib;
	}


	public Dobavljac() {
		super();
	}

	public static void add(Dobavljac dobavljac) {
		// TODO Auto-generated method stub
		
	}

	public Dobavljac(int sifra, String naziv, String adresa, String oib) {
		super(sifra);
		this.naziv = naziv;
		this.adresa = adresa;
		this.oib = oib;
	}


	}


		
	


