package srcefit;

public class MapiranjeBaze_Termin {
	int termin_redni_broj;
	int termin_pocetak_sati;
	int termin_trajanje_sati;

	public int getTermin_redni_broj() { return termin_redni_broj;	}
	public void setTermin_redni_broj(int termin_redni_broj) { this.termin_redni_broj = termin_redni_broj; }
	
	public int getTermin_pocetak_sati() { return termin_pocetak_sati;	}
	public void setTermin_pocetak_sati(int termin_pocetak_sati) { this.termin_pocetak_sati = termin_pocetak_sati; }
	
	public int getTermin_trajanje_sati() { return termin_trajanje_sati;	}
	public void setTermin_trajanje_sati(int termin_trajanje_sati) { this.termin_trajanje_sati = termin_trajanje_sati; }


	@Override
	public String toString() {
		return "termin redni br: " + termin_redni_broj + ", početak u " + termin_pocetak_sati + " sati, traje " + termin_trajanje_sati + " sati";
//		return termin_redni_broj + ", " + termin_pocetak_sati + " " + termin_trajanje_sati;
	}
}

