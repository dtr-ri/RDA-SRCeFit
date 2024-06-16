package srcefit;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class DLG_Izmjena_AGR_KorisnikNaAktivnostiUTerminu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JComboBox comboBoxKorisnik;
	JComboBox comboBoxAktivnost;
	JComboBox comboBoxTermin;
	JComboBox comboBoxZauzece;
	private JTextField textFieldZauzeceBrOsoba;
	private JTextField textFieldZauzeceDatum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLG_Izmjena_AGR_KorisnikNaAktivnostiUTerminu dialog = new DLG_Izmjena_AGR_KorisnikNaAktivnostiUTerminu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLG_Izmjena_AGR_KorisnikNaAktivnostiUTerminu() {
		setBounds(100, 100, 450, 300);
		setBackground(new Color(255, 255, 255));
		
		setTitle("SRCeFIT Izmjena postojećeg zauzeća aktivnosti i termina - KorisnikNaAktivnostiUTerminu");
		setBounds(100, 100, 611, 398);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(240, 255, 240));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel Izmjena_korisnik_izmjena = new JLabel("Unesite nove podatke:");
		Izmjena_korisnik_izmjena.setBounds(20, 88, 413, 22);
		contentPanel.add(Izmjena_korisnik_izmjena);
		
		comboBoxZauzece = new JComboBox();
		comboBoxZauzece.setBounds(20, 36, 420, 21);
		contentPanel.add(comboBoxZauzece);
		
		JLabel Izmjena_zauzece_naslov = new JLabel("Koje zauzeća aktivnosti i termina želite mijenjati?");
		Izmjena_zauzece_naslov.setBounds(20, 10, 413, 22);
		contentPanel.add(Izmjena_zauzece_naslov);
				
		JLabel lblKorisnik = new JLabel("Korisnik");
		lblKorisnik.setBounds(20, 124, 115, 13);
		contentPanel.add(lblKorisnik);
		
		JLabel lblAktivnost = new JLabel("Aktivnost");
		lblAktivnost.setBounds(20, 155, 115, 13);
		contentPanel.add(lblAktivnost);
		
		JLabel lblTermin = new JLabel("Termin");
		lblTermin.setBounds(20, 186, 115, 13);
		contentPanel.add(lblTermin);
		
		JLabel lblZauzeceDatum = new JLabel("Datum zauzeća");
		lblZauzeceDatum.setBounds(20, 216, 115, 13);
		contentPanel.add(lblZauzeceDatum);
		
		JLabel lblZauzeceBrOsoba = new JLabel("Broj osoba");
		lblZauzeceBrOsoba.setBounds(20, 244, 115, 13);
		contentPanel.add(lblZauzeceBrOsoba);
		
		comboBoxKorisnik = new JComboBox();
		comboBoxKorisnik.setBounds(145, 120, 263, 21);
		contentPanel.add(comboBoxKorisnik);
		
		comboBoxAktivnost = new JComboBox();
		comboBoxAktivnost.setBounds(145, 151, 263, 21);
		contentPanel.add(comboBoxAktivnost);
		
		comboBoxTermin = new JComboBox();
		comboBoxTermin.setBounds(145, 183, 263, 21);
		contentPanel.add(comboBoxTermin);
		
		textFieldZauzeceBrOsoba = new JTextField();
		textFieldZauzeceBrOsoba.setText("1");
		textFieldZauzeceBrOsoba.setBounds(145, 244, 80, 20);
		contentPanel.add(textFieldZauzeceBrOsoba);
		textFieldZauzeceBrOsoba.setColumns(10);
		
		textFieldZauzeceDatum = new JTextField();
		textFieldZauzeceDatum.setBounds(145, 215, 140, 20);
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
						
						MapiranjeBaze_AGR_KorisnikNaAktivnostiUTerminu zauzece = (MapiranjeBaze_AGR_KorisnikNaAktivnostiUTerminu) comboBoxZauzece.getSelectedItem();
						int idZauzece_sifra = zauzece.getZauzece_sifra();
						
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
							Connection conn = DriverManager.getConnection ("jdbc:mysql://ucka.veleri.hr/dtrbovic?" + "user=dtrbovic&password=11");

							String sql = "UPDATE RDA_proj_AGR_KorisnikNaAktivnostiUTerminu SET korisnik_clanski_broj=?, aktivnost_sifra=?, termin_redni_broj=?, zauzece_datum=?, zauzece_br_osoba=? WHERE zauzece_sifra=?;";
							
							PreparedStatement stmt = conn.prepareStatement(sql);
							stmt.setInt(1, idKorisnik_clanski_broj);
							stmt.setInt(2, idAktivnost_sifra);
							stmt.setInt(3, idTermin_redni_broj);
							stmt.setString(4, Zauzece_Datum);
							stmt.setString(5, Zauzece_Br_Osoba);
							stmt.setInt(6, idZauzece_sifra);

							  
							stmt.execute();
											
							conn.close();

							textFieldZauzeceBrOsoba.setText("");			/*prazni polja nakon unosa*/
							textFieldZauzeceDatum.setText("");
											
							} catch(Exception ex) {
							  JOptionPane.showMessageDialog(null, ex.getMessage(),"Gre�ka", JOptionPane.ERROR_MESSAGE);
							}
								
						
						System.out.println(idZauzece_sifra+" "+idKorisnik_clanski_broj+" "+idAktivnost_sifra+" "+idTermin_redni_broj+" "+Zauzece_Datum+" "+Zauzece_Br_Osoba);
					
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
		
		CitanjeBaze_AGR_KorisnikNaAktivnostiUTerminu citanjeBaze_AGR_KorisnikNaAktivnostiUTerminu = new CitanjeBaze_AGR_KorisnikNaAktivnostiUTerminu();
		citanjeBaze_AGR_KorisnikNaAktivnostiUTerminu.dohvatiZauzeca(comboBoxZauzece);



	}
}
