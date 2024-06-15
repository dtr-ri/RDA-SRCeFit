package srcefit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CitanjeBaze_Teren {

    public void dohvatiTerene(JComboBox comboBoxTeren) {
    	try {						
		 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			  Connection conn = DriverManager.getConnection 
					  ("jdbc:mysql://ucka.veleri.hr/dtrbovic?" +
							  "user=dtrbovic&password=11");
			  //šifra, naziv, nemjena, max kap
			  String sql = "SELECT * FROM RDA_proj_Teren;";
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(sql);
			  			  	 
			  while (rs.next()) {
				  int teren_sifra = rs.getInt("teren_sifra");
				  String teren_naziv = rs.getString("teren_naziv");
				  String teren_namjena = rs.getString("teren_namjena");
				  int teren_max_kapacitet = rs.getInt("teren_max_kapacitet");
				  MapiranjeBaze_Teren teren = new MapiranjeBaze_Teren();
				  
				  teren.setTeren_sifra(teren_sifra);
				  teren.setTeren_naziv(teren_naziv);
				  teren.setTeren_namjena(teren_namjena);
				  teren.setTeren_max_kapacitet(teren_max_kapacitet);
				  comboBoxTeren.addItem(teren);	  
			  }		  
			  conn.close();			
			} catch(Exception ex) {
			  JOptionPane.showMessageDialog(null, ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
			}	
	}
}