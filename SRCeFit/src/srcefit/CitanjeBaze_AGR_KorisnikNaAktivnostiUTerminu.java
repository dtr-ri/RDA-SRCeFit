package srcefit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CitanjeBaze_AGR_KorisnikNaAktivnostiUTerminu {

    public void dohvatiZauzeca(JComboBox comboBoxZauzece) {
    	try {						
		 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			  Connection conn = DriverManager.getConnection 
					  ("jdbc:mysql://ucka.veleri.hr/dtrbovic?" +
							  "user=dtrbovic&password=11");
			  //
			  String sql = "SELECT * FROM RDA_proj_AGR_KorisnikNaAktivnostiUTerminu;";
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(sql);
			  			  	 
			  while (rs.next()) {
				  int zauzece_sifra = rs.getInt("zauzece_sifra");
				  int korisnik_clanski_broj = rs.getInt("korisnik_clanski_broj");
				  int aktivnost_sifra = rs.getInt("aktivnost_sifra");
				  int termin_redni_broj = rs.getInt("termin_redni_broj");
				  String zauzece_datum = rs.getString("zauzece_datum");
				  int zauzece_br_osoba = rs.getInt("zauzece_br_osoba");
				  MapiranjeBaze_AGR_KorisnikNaAktivnostiUTerminu zauzece = new MapiranjeBaze_AGR_KorisnikNaAktivnostiUTerminu();
				  
				  zauzece.setZauzece_sifra(zauzece_sifra);
				  zauzece.setKorisnik_clanski_broj(korisnik_clanski_broj);
				  zauzece.setAktivnost_sifra(aktivnost_sifra);
				  zauzece.setTermin_redni_broj(termin_redni_broj);
				  zauzece.setZauzece_datum(zauzece_datum);
				  zauzece.setZauzece_br_osoba(zauzece_br_osoba);
				  comboBoxZauzece.addItem(zauzece);	  
			  }		  
			  conn.close();			
			} catch(Exception ex) {
			  JOptionPane.showMessageDialog(null, ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
			}	
	}
}