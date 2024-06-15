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
					  ("jdbc:mysql://ucka.veleri.hr/dtrbovic?" +
							  "user=dtrbovic&password=11");
			  //sifra, naziv, teren sifra, teren naziv, teren namj, kapacitet
			  String sql = "SELECT * FROM RDA_proj_Aktivnost;";
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(sql);
			  
			  while (rs.next()) {
				  int aktivnost_sifra = rs.getInt("aktivnost_sifra");
				  String aktivnost_naziv = rs.getString("aktivnost_naziv");
				  int teren_sifra = rs.getInt("teren_sifra");	  
				  
				  MapiranjeBaze_Aktivnost aktivnost = new MapiranjeBaze_Aktivnost();
				  aktivnost.setAktivnost_sifra(aktivnost_sifra);
				  aktivnost.setAktivnost_naziv(aktivnost_naziv);
				  aktivnost.setTeren_sifra(teren_sifra);
				  comboBoxAktivnost.addItem(aktivnost);	
				  				  
			  }		  
			  conn.close();			
			} catch(Exception ex) {
			  JOptionPane.showMessageDialog(null, ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
			}	
	}
	
	
}
