package srcefit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CitanjeBaze_Aktivnost {

	public void dohvatiAktivnosti(JComboBox comboBoxAktivnost) {
		try {						
		 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			  Connection conn = DriverManager.getConnection 
					  ("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" +
							  "user=zdebeljuh&password=11");
			  //sifra, naziv, teren sifra, teren naziv, teren namj, kapacitet
			  String sql = "SELECT * FROM RDA_proj_Aktivnost;";
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(sql);
			  
			  while (rs.next()) {
				  int aktivnost_sifra = rs.getInt("aktivnost_sifra");
				  String aktivnost_naziv = rs.getString("aktivnost_naziv");
				  String teren_naziv = rs.getString("teren_naziv");
				  String teren_namjena = rs.getString("teren_namjena");
				  int teren_max_kapacitet = rs.getInt("teren_max_kapacitet");	  
				  
				  MapiranjeBaze_Aktivnost aktivnost = new MapiranjeBaze_Aktivnost();
				  aktivnost.setAktivnost_sifra(aktivnost_sifra);
				  aktivnost.setAktivnost_naziv(aktivnost_naziv);
				  aktivnost.setTeren_naziv(teren_naziv);
				  aktivnost.setTeren_namjena(teren_namjena);
				  aktivnost.setTeren_max_kapacitet(teren_max_kapacitet);
				  comboBoxAktivnost.addItem(aktivnost);	
				  				  
			  }		  
			  conn.close();			
			} catch(Exception ex) {
			  JOptionPane.showMessageDialog(null, ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
			}	
	}
	
	
}
