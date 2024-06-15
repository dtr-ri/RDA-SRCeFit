package srcefit;

public class MapiranjeBaze_Korisnik {
	int korisnik_clanski_broj;
	String korisnik_ime;
	String korisnik_prezime;
	String korisnik_adresa;
	String korisnik_mob;
	String korisnik_email;
	
	public int getKorisnik_clanski_broj() { return korisnik_clanski_broj;	}
	public void setKorisnik_clanski_broj(int korisnik_clanski_broj) { this.korisnik_clanski_broj = korisnik_clanski_broj; }

	public String getKorisnik_ime() { return korisnik_ime; }
	public void setKorisnik_ime(String korisnik_ime) { this.korisnik_ime = korisnik_ime; }

	public String getKorisnik_prezime() { return korisnik_prezime; }
	public void setKorisnik_prezime(String korisnik_prezime) { this.korisnik_prezime = korisnik_prezime; }

	public String getKorisnik_adresa() { return korisnik_adresa; }
	public void setKorisnik_adresa(String korisnik_adresa) { this.korisnik_adresa = korisnik_adresa; }

	public String getKorisnik_mob() { return korisnik_mob; }
	public void setKorisnik_mob(String korisnik_mob) { this.korisnik_mob = korisnik_mob; }

	public String getKorisnik_email() { return korisnik_email; }
	public void setKorisnik_email(String korisnik_email) { this.korisnik_email = korisnik_email; }

	@Override
	public String toString() {
		return korisnik_clanski_broj + ", " + korisnik_ime + ", " + korisnik_prezime;
	}
}
