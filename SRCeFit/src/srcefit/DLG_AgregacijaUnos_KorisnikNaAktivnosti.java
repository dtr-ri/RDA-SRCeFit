package srcefit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class DLG_AgregacijaUnos_KorisnikNaAktivnosti extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JComboBox comboBoxKorisnik;
	JComboBox comboBoxAktivnost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLG_AgregacijaUnos_KorisnikNaAktivnosti dialog = new DLG_AgregacijaUnos_KorisnikNaAktivnosti();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLG_AgregacijaUnos_KorisnikNaAktivnosti() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblKorisnik = new JLabel("Korisnik");
		lblKorisnik.setBounds(21, 29, 115, 13);
		contentPanel.add(lblKorisnik);
		
		comboBoxKorisnik = new JComboBox();
		comboBoxKorisnik.setBounds(146, 25, 263, 21);
		contentPanel.add(comboBoxKorisnik);
		
		JLabel lblAktivnost = new JLabel("Aktivnost");
		lblAktivnost.setBounds(21, 60, 115, 13);
		contentPanel.add(lblAktivnost);
		
		comboBoxAktivnost = new JComboBox();
		comboBoxAktivnost.setBounds(146, 56, 263, 21);
		contentPanel.add(comboBoxAktivnost);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MapiranjeBaze_Korisnik korisnik = (MapiranjeBaze_Korisnik) comboBoxKorisnik.getSelectedItem();
						int idKorisnik_clanski_broj = korisnik.getKorisnik_clanski_broj();
						MapiranjeBaze_Aktivnost aktivnost = (MapiranjeBaze_Aktivnost) comboBoxAktivnost.getSelectedItem();
						int idAktivnost_sifra = aktivnost.getAktivnost_sifra();
						
						try {						
						 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							  Connection conn = DriverManager.getConnection 
									  ("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" + "user=zdebeljuh&password=11");
							 
							  String sql = "INSERT INTO RDA_proj_KorisnikNaAktivnosti VALUES(?,?);";
								
							  PreparedStatement stmt = conn.prepareStatement(sql);
							  stmt.setInt(1, idKorisnik_clanski_broj);
							  stmt.setInt(2, idAktivnost_sifra);
							  stmt.execute();
											
							  conn.close();

											
							} catch(Exception ex) {
							  JOptionPane.showMessageDialog(null, ex.getMessage(),"Gre�ka", JOptionPane.ERROR_MESSAGE);
							}
								
						
						System.out.println(idKorisnik_clanski_broj+" "+idAktivnost_sifra);
					
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		dohvatiKorisnike();
		dohvatiAktivnosti();
	}
	

	private void dohvatiKorisnike() {
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
	
	
	private void dohvatiAktivnosti() {
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
