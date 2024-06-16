package srcefit;

public class MapiranjeBaze_AGR_KorisnikNaAktivnostiUTerminu {
	int zauzece_sifra;
	int korisnik_clanski_broj;
	int aktivnost_sifra;
	int termin_redni_broj;
	String zauzece_datum;
	int zauzece_br_osoba;

	
	public int getZauzece_sifra() { return zauzece_sifra;	}
	public void setZauzece_sifra(int zauzece_sifra) { this.zauzece_sifra = zauzece_sifra; }
	
	public int getKorisnik_clanski_broj() { return korisnik_clanski_broj;	}
	public void setKorisnik_clanski_broj(int korisnik_clanski_broj) { this.korisnik_clanski_broj = korisnik_clanski_broj; }
	
	public int getAktivnost_sifra() { return aktivnost_sifra;	}
	public void setAktivnost_sifra(int aktivnost_sifra) { this.aktivnost_sifra = aktivnost_sifra; }
	
	public int getTermin_redni_broj() { return termin_redni_broj;	}
	public void setTermin_redni_broj(int termin_redni_broj) { this.termin_redni_broj = termin_redni_broj; }

	public String getZauzece_datum() { return zauzece_datum; }
	public void setZauzece_datum(String zauzece_datum) { this.zauzece_datum = zauzece_datum; }

	public int getZauzece_br_osoba() { return zauzece_br_osoba;	}
	public void setZauzece_br_osoba(int zauzece_br_osoba) { this.zauzece_br_osoba = zauzece_br_osoba; }

	@Override
	public String toString() {
		return zauzece_sifra + ", " + korisnik_clanski_broj + ", " + aktivnost_sifra + ", " + termin_redni_broj + ", " + zauzece_datum + ", " + zauzece_br_osoba;
	}
}
