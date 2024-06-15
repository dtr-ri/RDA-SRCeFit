package srcefit;

public class MapiranjeBaze_Aktivnost {
	int aktivnost_sifra;
	String aktivnost_naziv;
	int teren_sifra;

	public int getAktivnost_sifra() { return aktivnost_sifra;	}
	public void setAktivnost_sifra(int aktivnost_sifra) { this.aktivnost_sifra = aktivnost_sifra; }

	public String getAktivnost_naziv() { return aktivnost_naziv; }
	public void setAktivnost_naziv(String aktivnost_naziv) { this.aktivnost_naziv = aktivnost_naziv; }
	
	public int getTeren_sifra() { return teren_sifra;	}
	public void setTeren_sifra(int teren_sifra) { this.teren_sifra = teren_sifra; }

	@Override
	public String toString() {
		return aktivnost_sifra + ", " + aktivnost_naziv + ", " + teren_sifra;
	}
}
