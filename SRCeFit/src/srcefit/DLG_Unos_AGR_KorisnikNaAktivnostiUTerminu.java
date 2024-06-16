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

public class DLG_Unos_AGR_KorisnikNaAktivnostiUTerminu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JComboBox comboBoxKorisnik;
	JComboBox comboBoxAktivnost;
	JComboBox comboBoxTermin;
	private JTextField textFieldZauzeceBrOsoba;
	private JTextField textFieldZauzeceDatum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLG_Unos_AGR_KorisnikNaAktivnostiUTerminu dialog = new DLG_Unos_AGR_KorisnikNaAktivnostiUTerminu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLG_Unos_AGR_KorisnikNaAktivnostiUTerminu() {
		setTitle("SRCeFIT Unos zauzeća aktivnosti i termina - KorisnikNaAktivnostiUTerminu");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblKorisnik = new JLabel("Korisnik");
		lblKorisnik.setBounds(21, 29, 115, 13);
		contentPanel.add(lblKorisnik);
		
		JLabel lblAktivnost = new JLabel("Aktivnost");
		lblAktivnost.setBounds(21, 60, 115, 13);
		contentPanel.add(lblAktivnost);
		
		JLabel lblTermin = new JLabel("Termin");
		lblTermin.setBounds(21, 91, 115, 13);
		contentPanel.add(lblTermin);
		
		JLabel lblZauzeceDatum = new JLabel("Datum zauzeća");
		lblZauzeceDatum.setBounds(21, 121, 115, 13);
		contentPanel.add(lblZauzeceDatum);
		
		JLabel lblZauzeceBrOsoba = new JLabel("Broj osoba");
		lblZauzeceBrOsoba.setBounds(21, 149, 115, 13);
		contentPanel.add(lblZauzeceBrOsoba);
		
		comboBoxKorisnik = new JComboBox();
		comboBoxKorisnik.setBounds(146, 25, 263, 21);
		contentPanel.add(comboBoxKorisnik);
		
		comboBoxAktivnost = new JComboBox();
		comboBoxAktivnost.setBounds(146, 56, 263, 21);
		contentPanel.add(comboBoxAktivnost);
		
		comboBoxTermin = new JComboBox();
		comboBoxTermin.setBounds(146, 88, 263, 21);
		contentPanel.add(comboBoxTermin);
		
		textFieldZauzeceBrOsoba = new JTextField();
		textFieldZauzeceBrOsoba.setText("1");
		textFieldZauzeceBrOsoba.setBounds(146, 145, 80, 20);
		contentPanel.add(textFieldZauzeceBrOsoba);
		textFieldZauzeceBrOsoba.setColumns(10);
		
		textFieldZauzeceDatum = new JTextField();
		textFieldZauzeceDatum.setBounds(146, 120, 140, 20);
		contentPanel.add(textFieldZauzeceDatum);
		textFieldZauzeceDatum.setColumns(10);

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
						MapiranjeBaze_Termin termin = (MapiranjeBaze_Termin) comboBoxTermin.getSelectedItem();
						int idTermin_redni_broj = termin.getTermin_redni_broj();
						String Zauzece_Br_Osoba = textFieldZauzeceBrOsoba.getText();
						String Zauzece_Datum = textFieldZauzeceDatum.getText();

						try {						
						 	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							Connection conn = DriverManager.getConnection 
									  ("jdbc:mysql://ucka.veleri.hr/dtrbovic?" + "user=dtrbovic&password=11");
							 
							String sql = "INSERT INTO RDA_proj_AGR_KorisnikNaAktivnostiUTerminu VALUES(NULL,?,?,?,?,?);";
								
							
							PreparedStatement stmt = conn.prepareStatement(sql);
							stmt.setInt(1, idKorisnik_clanski_broj);
							stmt.setInt(2, idAktivnost_sifra);
							stmt.setInt(3, idTermin_redni_broj);
							stmt.setString(4, Zauzece_Datum);
							stmt.setString(5, Zauzece_Br_Osoba);


							  
							stmt.execute();
											
							conn.close();

							textFieldZauzeceBrOsoba.setText("");			/*prazni polja nakon unosa*/
							textFieldZauzeceDatum.setText("");
											
							} catch(Exception ex) {
							  JOptionPane.showMessageDialog(null, ex.getMessage(),"Gre�ka", JOptionPane.ERROR_MESSAGE);
							}
								
						
						System.out.println(idKorisnik_clanski_broj+" "+idAktivnost_sifra+" "+idTermin_redni_broj+" "+Zauzece_Datum+" "+Zauzece_Br_Osoba);
					
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
		//dohvatiKorisnike();
		//dohvatiAktivnosti();
				
		//citanje baze izbaceno u posebnu klasu, iste dole metode samo su public ne private, i zagrada je (JComboBox comboBoxKorisnik)
		CitanjeBaze_Korisnik citanjeBaze_Korisnik = new CitanjeBaze_Korisnik();
		citanjeBaze_Korisnik.dohvatiKorisnike(comboBoxKorisnik);
		
		CitanjeBaze_Aktivnost citanjeBaze_Aktivnost = new CitanjeBaze_Aktivnost();
		citanjeBaze_Aktivnost.dohvatiAktivnosti(comboBoxAktivnost);
		
		CitanjeBaze_Termin citanjeBaze_Termin = new CitanjeBaze_Termin();
		citanjeBaze_Termin.dohvatiTermine(comboBoxTermin);
		


		

	}
}
