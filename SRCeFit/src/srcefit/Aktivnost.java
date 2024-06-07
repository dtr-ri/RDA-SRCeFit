package srcefit;

public class Aktivnost {
	int aktivnost_sifra;
	String aktivnost_naziv;
	int clanarina_sifra;	
	int teren_sifra;
	String teren_naziv;	
	String teren_namjena;
	int teren_max_kapacitet;	

	public int getAktivnost_sifra() { return aktivnost_sifra;	}
	public void setAktivnost_sifra(int aktivnost_sifra) { this.aktivnost_sifra = aktivnost_sifra; }

	public String getAktivnost_naziv() { return aktivnost_naziv; }
	public void setAktivnost_naziv(String aktivnost_naziv) { this.aktivnost_naziv = aktivnost_naziv; }
	
	public int getClanarina_sifra() { return clanarina_sifra;	}
	public void setClanarina_sifra(int clanarina_sifra) { this.clanarina_sifra = clanarina_sifra; }

	public int getTeren_sifra() { return teren_sifra;	}
	public void setTeren_sifra(int teren_sifra) { this.teren_sifra = teren_sifra; }

	public String getTeren_naziv() { return teren_naziv; }
	public void setTeren_naziv(String teren_naziv) { this.teren_naziv = teren_naziv; }

	public String getTeren_namjena() { return teren_namjena; }
	public void setTeren_namjena(String teren_namjena) { this.teren_namjena = teren_namjena; }

	public int getTeren_max_kapacitet() { return teren_max_kapacitet;	}
	public void setTeren_max_kapacitet(int teren_max_kapacitet) { this.teren_max_kapacitet = teren_max_kapacitet; }
	
	@Override
	public String toString() {
		return aktivnost_sifra + ", " + aktivnost_naziv + ", " + teren_naziv + ", " + teren_namjena + teren_max_kapacitet;
	}
}
