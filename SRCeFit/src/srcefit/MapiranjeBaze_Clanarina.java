package srcefit;

public class MapiranjeBaze_Clanarina {
	private int clanarinaSifra;
	private String clanarinaNaziv;
	private String clanarinaOpis;

	public int getClanarinaSifra() { return clanarinaSifra;	}
	public void setClanarinaSifra(int clanarinaSifra) { this.clanarinaSifra = clanarinaSifra; }
	
	public String getClanarinaNaziv() { return clanarinaNaziv;	}
	public void setClanarinaNaziv(String clanarinaNaziv) { this.clanarinaNaziv = clanarinaNaziv; }
	
	public String getClanarinaOpis() { return clanarinaOpis;	}
	public void setClanarinaOpis(String clanarinaOpis) { this.clanarinaOpis = clanarinaOpis; }


	@Override
	public String toString() {
		return "Šifra: " + clanarinaSifra + ", Naziv " + clanarinaNaziv + " Opis " + clanarinaOpis;
}
}

