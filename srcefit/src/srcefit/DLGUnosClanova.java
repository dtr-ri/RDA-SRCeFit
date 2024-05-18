package srcefit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.Connection;

public class DLGUnosClanova extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_ime;
	private JTextField textField_prezime;
	private JTextField textField_adresa;
	private JTextField textField_tel;
	private JTextField textField_email;
	private JTextField textField_datum;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLGUnosClanova dialog = new DLGUnosClanova();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLGUnosClanova() {

		setTitle("SRCeFit dodavanje novog člana");
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel Novi_clan_Ime = new JLabel("Novi član Ime");
			Novi_clan_Ime.setBounds(10, 10, 122, 13);
			contentPanel.add(Novi_clan_Ime);
		}
		{
			JLabel Novi_clan_Prezime = new JLabel("Novi član Prezime");
			Novi_clan_Prezime.setBounds(10, 39, 122, 13);
			contentPanel.add(Novi_clan_Prezime);
		}
		{
			JLabel Novi_clan_adresa = new JLabel("Novi član Adresa");
			Novi_clan_adresa.setBounds(10, 68, 122, 13);
			contentPanel.add(Novi_clan_adresa);
		}
		{
			JLabel Novi_clan_tel = new JLabel("Novi član tel/mob");
			Novi_clan_tel.setBounds(10, 97, 122, 13);
			contentPanel.add(Novi_clan_tel);
		}
		{
			JLabel Novi_clan_email = new JLabel("Novi član email");
			Novi_clan_email.setBounds(10, 126, 122, 13);
			contentPanel.add(Novi_clan_email);
		}
		{
			JLabel Novi_clan_datum_upisa = new JLabel("Novi član datum upisa");
			Novi_clan_datum_upisa.setBounds(10, 155, 122, 13);
			contentPanel.add(Novi_clan_datum_upisa);
		}
		{
			textField_ime = new JTextField();
			textField_ime.setBounds(142, 4, 96, 19);
			contentPanel.add(textField_ime);
			textField_ime.setColumns(10);
		}
		{
			textField_prezime = new JTextField();
			textField_prezime.setBounds(142, 33, 96, 19);
			contentPanel.add(textField_prezime);
			textField_prezime.setColumns(10);
		}
		{
			textField_adresa = new JTextField();
			textField_adresa.setBounds(142, 62, 96, 19);
			contentPanel.add(textField_adresa);
			textField_adresa.setColumns(10);
		}
		{
			textField_tel = new JTextField();
			textField_tel.setBounds(142, 91, 96, 19);
			contentPanel.add(textField_tel);
			textField_tel.setColumns(10);
		}
		{
			textField_email = new JTextField();
			textField_email.setBounds(142, 120, 96, 19);
			contentPanel.add(textField_email);
			textField_email.setColumns(10);
		}
		{
			textField_datum = new JTextField();
			textField_datum.setBounds(142, 149, 96, 19);
			contentPanel.add(textField_datum);
			textField_datum.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String Novi_clan_Ime = textField_ime.getText();
						String Novi_clan_Prezime = textField_prezime.getText();
						String Novi_clan_adresa = textField_adresa.getText();
						String Novi_clan_tel = textField_tel.getText();
						String Novi_clan_email = textField_email.getText();
						String Novi_clan_datum_upisa = textField_datum.getText();
						
						if (!(Novi_clan_Ime.equals("") || Novi_clan_Prezime.equals("") || Novi_clan_adresa.equals("") || Novi_clan_tel.equals(""))) {

							try {						
							 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
								  Connection conn = DriverManager.getConnection ("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" + "user=zdebeljuh&password=11");
								  //id, ime, prez, adr, mob, email, datum
								  String sql = "INSERT INTO UBP_proj_Korisnik VALUES(NULL,?,?,?,?,?,?);";
								  PreparedStatement stmt = conn.prepareStatement(sql);
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
							
						}
						
						
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
	}

}


