package srcefit;

public class MapiranjeBaze_Teren {
	int teren_sifra;
	String teren_naziv;
	String teren_namjena;
	int teren_max_kapacitet;
	
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
		return teren_sifra + ", " + teren_naziv + ", " + teren_namjena + " " + teren_max_kapacitet;
	}
}

