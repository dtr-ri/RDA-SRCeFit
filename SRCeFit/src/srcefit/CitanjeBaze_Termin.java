package srcefit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CitanjeBaze_Termin {

    public void dohvatiTermine(JComboBox comboBoxTermin) {
    	try {						
		 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			  Connection conn = DriverManager.getConnection 
					  ("jdbc:mysql://ucka.veleri.hr/dtrbovic?" +
							  "user=dtrbovic&password=11");
			  //rbr, pocetak, trajanje
			  String sql = "SELECT * FROM RDA_proj_Termin;";
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(sql);
			  			  	 
			  while (rs.next()) {
				  int termin_redni_broj = rs.getInt("termin_redni_broj");
				  int termin_pocetak_sati = rs.getInt("termin_pocetak_sati");
				  int termin_trajanje_sati = rs.getInt("termin_trajanje_sati");


				  MapiranjeBaze_Termin termin = new MapiranjeBaze_Termin();
				  
				  termin.setTermin_redni_broj(termin_redni_broj);
				  termin.setTermin_pocetak_sati(termin_pocetak_sati);
				  termin.setTermin_trajanje_sati(termin_trajanje_sati);

				  comboBoxTermin.addItem(termin);	  
			  }		  
			  conn.close();			
			} catch(Exception ex) {
			  JOptionPane.showMessageDialog(null, ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
			}	
	}
}