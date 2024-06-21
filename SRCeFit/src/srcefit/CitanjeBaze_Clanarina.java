package srcefit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CitanjeBaze_Clanarina {

    public void dohvatiClanarine(JComboBox<MapiranjeBaze_Clanarina> comboBoxClanarina) {
    	try {						
		 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			  Connection conn = DriverManager.getConnection 
					  ("jdbc:mysql://ucka.veleri.hr/dtrbovic?" +
							  "user=dtrbovic&password=11");
			  //sifra, naziv, opis
			  String sql = "SELECT * FROM RDA_proj_Clanarina;";
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(sql);
			  			  	 
			  while (rs.next()) {
				  int ClanarinaSifra = rs.getInt("Sifra");
				  String ClanarinaNaziv = rs.getString("Naziv");
				  String ClanarinaOpis = rs.getString("Opis");


				  MapiranjeBaze_Clanarina clanarina= new MapiranjeBaze_Clanarina();
				  
				  clanarina.setClanarinaSifra(ClanarinaSifra);
				  clanarina.setClanarinaNaziv(ClanarinaNaziv);
				  clanarina.setClanarinaOpis(ClanarinaOpis);

				  comboBoxClanarina.addItem(clanarina);	  
			  }		  
			  conn.close();			
			} catch(Exception ex) {
			  JOptionPane.showMessageDialog(null, ex.getMessage(),"Greška", JOptionPane.ERROR_MESSAGE);
			}	
	}
}