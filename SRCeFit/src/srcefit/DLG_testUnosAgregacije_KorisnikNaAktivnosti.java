package srcefit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class DLG_testUnosAgregacije_KorisnikNaAktivnosti extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLG_testUnosAgregacije_KorisnikNaAktivnosti dialog = new DLG_testUnosAgregacije_KorisnikNaAktivnosti();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLG_testUnosAgregacije_KorisnikNaAktivnosti() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("odabir korisnika");
		lblNewLabel.setBounds(10, 11, 107, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblOdabirAktivnosti = new JLabel("odabir aktivnosti");
		lblOdabirAktivnosti.setBounds(10, 46, 107, 14);
		contentPanel.add(lblOdabirAktivnosti);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 86, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(127, 7, 200, 22);
		contentPanel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(127, 42, 200, 22);
		contentPanel.add(comboBox_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
		/*dalje zapoceto na vjezbama, try catch iz unosa clanova*/
		
		
		
		
		
		try {						
		 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		 	 Connection conn = DriverManager.getConnection ("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" + "user=zdebeljuh&password=11");
			  //id, ime, prez, adr, mob, email, datum
			  String sql = "SELECT * FROM RDA_proj_Korisnik;";

			  Statement stmt = conn.createStatement();
			  stmt.setString(1, Novi_clan_Ime);
			  stmt.setString(2, Novi_clan_Prezime);
			  stmt.setString(3, Novi_clan_adresa);
			  stmt.setString(4, Novi_clan_tel);
			  stmt.setString(5, Novi_clan_email);
			  stmt.setString(6, Novi_clan_datum_upisa);
			  stmt.execute();
							
			  conn.close();
						
			  textField_ime.setText("");			/*prazni polja nakon unosa*/
			  textField_prezime.setText("");
			  textField_adresa.setText("");
			  textField_tel.setText("");
			  textField_email.setText("");
			  textField_datum.setText("");

		} 
		catch(Exception ex) {
			/*

			JOptionPane.showMessageDialog(null, "nisu uneseni svi obavezni podaci","Greška",JOptionPane.WARNING_MESSAGE);
			*/
			return;
		}
		System.out.println(Novi_clan_Ime + " " + Novi_clan_Prezime + " " + Novi_clan_adresa + " " + Novi_clan_tel + " " + Novi_clan_email + " " + Novi_clan_datum_upisa);
		
		
		
		
	}
}
