package srcefit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.Connection;

public class DLG_Unos_Korisnik extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_ime;
	private JTextField textField_prezime;
	private JTextField textField_adresa;
	private JTextField textField_tel;
	private JTextField textField_email;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLG_Unos_Korisnik dialog = new DLG_Unos_Korisnik();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLG_Unos_Korisnik() {

		setBounds(100, 100, 450, 300);
		setBackground(new Color(255, 255, 255));
		
		setTitle("SRCeFIT Unos novog korisnika");
		setBounds(100, 100, 611, 398);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel Novi_korisnik_Ime = new JLabel("Novi korisnik Ime");
			Novi_korisnik_Ime.setBounds(10, 33, 122, 22);
			contentPanel.add(Novi_korisnik_Ime);
		}
		{
			JLabel Novi_korisnik_Prezime = new JLabel("Novi korisnik Prezime");
			Novi_korisnik_Prezime.setBounds(10, 66, 122, 13);
			contentPanel.add(Novi_korisnik_Prezime);
		}
		{
			JLabel Novi_korisnik_adresa = new JLabel("Novi korisnik Adresa");
			Novi_korisnik_adresa.setBounds(10, 100, 122, 13);
			contentPanel.add(Novi_korisnik_adresa);
		}
		{
			JLabel Novi_korisnik_tel = new JLabel("Novi korisnik tel/mob");
			Novi_korisnik_tel.setBounds(10, 134, 122, 13);
			contentPanel.add(Novi_korisnik_tel);
		}
		{
			JLabel Novi_korisnik_email = new JLabel("Novi korisnik email");
			Novi_korisnik_email.setBounds(10, 158, 122, 22);
			contentPanel.add(Novi_korisnik_email);
		}

		{
			textField_ime = new JTextField();
			textField_ime.setBounds(178, 33, 136, 19);
			contentPanel.add(textField_ime);
			textField_ime.setColumns(10);
		}
		{
			textField_prezime = new JTextField();
			textField_prezime.setBounds(178, 62, 136, 19);
			contentPanel.add(textField_prezime);
			textField_prezime.setColumns(10);
		}
		{
			textField_adresa = new JTextField();
			textField_adresa.setBounds(178, 96, 136, 19);
			contentPanel.add(textField_adresa);
			textField_adresa.setColumns(10);
		}
		{
			textField_tel = new JTextField();
			textField_tel.setBounds(178, 130, 136, 19);
			contentPanel.add(textField_tel);
			textField_tel.setColumns(10);
		}
		{
			textField_email = new JTextField();
			textField_email.setBounds(178, 159, 136, 19);
			contentPanel.add(textField_email);
			textField_email.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {
						String Novi_korisnik_Ime = textField_ime.getText();
						String Novi_korisnik_Prezime = textField_prezime.getText();
						String Novi_korisnik_adresa = textField_adresa.getText();
						String Novi_korisnik_tel = textField_tel.getText();
						String Novi_korisnik_email = textField_email.getText();

						
						if (!(Novi_korisnik_Ime.equals("") || Novi_korisnik_Prezime.equals("") || Novi_korisnik_adresa.equals("") || Novi_korisnik_tel.equals(""))) {

							try {						
							 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							 	 Connection conn = DriverManager.getConnection ("jdbc:mysql://ucka.veleri.hr/dtrbovic?" + "user=dtrbovic&password=11");
								  //id, ime, prez, adr, mob, email
								  String sql = "INSERT INTO RDA_proj_Korisnik VALUES(NULL,?,?,?,?,?);";
				
								  PreparedStatement stmt = conn.prepareStatement(sql);
								  stmt.setString(1, Novi_korisnik_Ime);
								  stmt.setString(2, Novi_korisnik_Prezime);
								  stmt.setString(3, Novi_korisnik_adresa);
								  stmt.setString(4, Novi_korisnik_tel);
								  stmt.setString(5, Novi_korisnik_email);

					  			  stmt.execute();
												
								  conn.close();
											
								  textField_ime.setText("");			/*prazni polja nakon unosa*/
								  textField_prezime.setText("");
								  textField_adresa.setText("");
								  textField_tel.setText("");
								  textField_email.setText("");


							} 
							catch(Exception ex) {
								/*

								JOptionPane.showMessageDialog(null, "nisu uneseni svi obavezni podaci","Greška",JOptionPane.WARNING_MESSAGE);
								*/
								return;
							}
							System.out.println(Novi_korisnik_Ime + " " + Novi_korisnik_Prezime + " " + Novi_korisnik_adresa + " " + Novi_korisnik_tel + " " + Novi_korisnik_email);
							
							
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


