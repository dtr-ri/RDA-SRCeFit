package srcefit;

public class MapiranjeBaze_AGR_ValjanostClanarine {
	int valjanost_clanarine_sifra;
	int clanarina_sifra;
	int korisnik_clanski_broj;
	int valjanost_clanarine_datum_uplate;
	int valjanost_clanarine_datum_isteka;

	
	public int getValjanost_clanarine_sifra() { return valjanost_clanarine_sifra;	}
	public void setValjanost_clanarine_sifra(int valjanost_clanarine_sifra) { this.valjanost_clanarine_sifra = valjanost_clanarine_sifra; }
	
	public int getClanarina_sifra() { return clanarina_sifra;	}
	public void setClanarina_sifra (int clanarina_sifra) { this.clanarina_sifra = clanarina_sifra; }
	
	public int getKorisnik_clanski_broj() { return korisnik_clanski_broj;	}
	public void setKorisnik_clanski_broj (int korisnik_clanski_broj) { this.korisnik_clanski_broj = korisnik_clanski_broj; }
	
	public int getValjanost_clanarine_datum_uplate() { return valjanost_clanarine_datum_uplate;	}
	public void setValjanost_clanarine_datum_uplate (int valjanost_clanarine_datum_uplate) { this.valjanost_clanarine_datum_uplate = valjanost_clanarine_datum_uplate; }

	public int getValjanost_clanarine_datum_isteka() { return valjanost_clanarine_datum_isteka;	}
	public void setValjanost_clanarine_datum_isteka (int valjanost_clanarine_datum_isteka) { this.valjanost_clanarine_datum_isteka = valjanost_clanarine_datum_isteka; }

	@Override
	public String toString() {
		return valjanost_clanarine_sifra + ", " + clanarina_sifra + ", " + korisnik_clanski_broj + ", " + valjanost_clanarine_datum_uplate + ", " + valjanost_clanarine_datum_isteka;
	}
}


