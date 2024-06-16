package srcefit;

public class MapiranjeBaze_Clanarina {
	int clanarina_sifra;
	string clanarina_naziv;
	string clanarina_opis;

	public int getClanarina_sifra() { return clanarina_sifra;	}
	public void setClarina_sifra(int clanarina_sifra) { this.clanarina_sifra = clanarina_sifra; }

	public String getClanarina_naziv() { return Clanarina_naziv; }
	public void setClanarina_naziv(String clanarina_naziv) { this.clanarina_naziv = clanarina_naziv; }

	public String getClanarina_opis() { return clanarina_opis; }
	public void setClanarina_opis(String clanarina_opis) { this.clanarina_opis = clanarina_opis; }
	
	@Override
	public String toString() {
		return clanarina_sifra + ", " + clanarina_naziv + ", " + clanarina_opis;
	}
}

