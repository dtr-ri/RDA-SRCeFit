package srcefit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CitanjeBaze_Korisnik {

    public void dohvatiKorisnike(JComboBox comboBoxKorisnik) {
    	try {						
		 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			  Connection conn = DriverManager.getConnection 
					  ("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" +
							  "user=zdebeljuh&password=11");
			  //clanski br, ime, prez, adr, mob, email, dat upisa
			  String sql = "SELECT * FROM RDA_proj_Korisnik;";
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(sql);
			  			  	 
			  while (rs.next()) {
				  int korisnik_clanski_broj = rs.getInt("korisnik_clanski_broj");
				  String korisnik_ime = rs.getString("korisnik_ime");
				  String korisnik_prezime = rs.getString("korisnik_prezime");
				  String korisnik_datum_upisa = rs.getString("korisnik_datum_upisa");
				  MapiranjeBaze_Korisnik korisnik = new MapiranjeBaze_Korisnik();
				  
				  korisnik.setKorisnik_clanski_broj(korisnik_clanski_broj);
				  korisnik.setKorisnik_ime(korisnik_ime);
				  korisnik.setKorisnik_prezime(korisnik_prezime);
				  korisnik.setKorisnik_datum_upisa(korisnik_datum_upisa);
				  comboBoxKorisnik.addItem(korisnik);	  
			  }		  
			  conn.close();			
			} catch(Exception ex) {
			  JOptionPane.showMessageDialog(null, ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
			}	
	}
}