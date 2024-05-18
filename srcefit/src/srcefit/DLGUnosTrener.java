package srcefit;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class DLGUnosTrener extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_Time;
	private JTextField textField_Tprezime;
	private JTextField textField_Tadresa;
	private JTextField textField_Ttel;
	private JTextField textField_Temail;
	private JTextField textField_Tdatum;
	private JTextField textField_Tsport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLGUnosTrener dialog = new DLGUnosTrener();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLGUnosTrener() {
		setBounds(100, 100, 350, 322);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel Novi_trener_Ime = new JLabel("Novi trener Ime");
		Novi_trener_Ime.setBounds(10, 10, 112, 13);
		contentPanel.add(Novi_trener_Ime);
				
		JLabel Novi_trener_Prezime = new JLabel("Novi trener Prezime");
		Novi_trener_Prezime.setBounds(10, 39, 112, 13);
		contentPanel.add(Novi_trener_Prezime);
		
		JLabel Novi_trener_adresa = new JLabel("Novi trener Adresa");
		Novi_trener_adresa.setBounds(10, 68, 112, 13);
		contentPanel.add(Novi_trener_adresa);
		
		JLabel Novi_trener_tel = new JLabel("Novi trener tel/mob");
		Novi_trener_tel.setBounds(10, 97, 112, 13);
		contentPanel.add(Novi_trener_tel);
		
		JLabel Novi_trener_email = new JLabel("Novi trener email");
		Novi_trener_email.setBounds(10, 126, 112, 13);
		contentPanel.add(Novi_trener_email);
		
		JLabel Novi_trener_datum_zaposlenja = new JLabel("Novi trener datum zaposlenja");
		Novi_trener_datum_zaposlenja.setBounds(10, 155, 112, 13);
		contentPanel.add(Novi_trener_datum_zaposlenja);
		
		JLabel Novi_trener_sport = new JLabel("Novi trener sport");
		Novi_trener_sport.setBounds(10, 184, 112, 13);
		contentPanel.add(Novi_trener_sport);
		
		textField_Time = new JTextField();
		textField_Time.setBounds(132, 7, 183, 19);
		contentPanel.add(textField_Time);
		textField_Time.setColumns(10);
		
		textField_Tprezime = new JTextField();
		textField_Tprezime.setBounds(132, 36, 183, 19);
		contentPanel.add(textField_Tprezime);
		textField_Tprezime.setColumns(10);
		
		textField_Tadresa = new JTextField();
		textField_Tadresa.setBounds(132, 65, 183, 19);
		contentPanel.add(textField_Tadresa);
		textField_Tadresa.setColumns(10);
		
		textField_Ttel = new JTextField();
		textField_Ttel.setBounds(132, 94, 183, 19);
		contentPanel.add(textField_Ttel);
		textField_Ttel.setColumns(10);
		
		textField_Temail = new JTextField();
		textField_Temail.setBounds(132, 123, 183, 19);
		contentPanel.add(textField_Temail);
		textField_Temail.setColumns(10);
		
		textField_Tdatum = new JTextField();
		textField_Tdatum.setBounds(132, 152, 183, 19);
		contentPanel.add(textField_Tdatum);
		textField_Tdatum.setColumns(10);
		
		textField_Tsport = new JTextField();
		textField_Tsport.setBounds(132, 181, 183, 19);
		contentPanel.add(textField_Tsport);
		textField_Tsport.setColumns(10);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {
						String Novi_trener_Ime = textField_Time.getText();
						String Novi_trener_Prezime = textField_Tprezime.getText();
						String Novi_trener_adresa = textField_Tadresa.getText();
						String Novi_trener_tel = textField_Ttel.getText();
						String Novi_trener_email = textField_Temail.getText();
						String Novi_trener_datum_zaposlenja = textField_Tdatum.getText();
						String Novi_trener_sport = textField_Tsport.getText();
						
						
						if (!(Novi_trener_Ime.equals("") || Novi_trener_Prezime.equals("") || Novi_trener_adresa.equals("") || Novi_trener_tel.equals(""))) {

							try {						
							 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
								  Connection conn = DriverManager.getConnection ("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" + "user=zdebeljuh&password=11");
								  //id, ime, prez, adr, mob, email, datum. sport
								  String sql = "INSERT INTO UBP_proj_Trener VALUES(NULL,?,?,?,?,?,?,?);";
								  PreparedStatement stmt = conn.prepareStatement(sql);
								  stmt.setString(1, Novi_trener_Ime);
								  stmt.setString(2, Novi_trener_Prezime);
								  stmt.setString(3, Novi_trener_adresa);
								  stmt.setString(4, Novi_trener_tel);
								  stmt.setString(5, Novi_trener_email);
								  stmt.setString(6, Novi_trener_datum_zaposlenja);
								  stmt.setString(7, Novi_trener_sport);
								  
					  			  stmt.execute();
												
								  conn.close();
											
								  textField_Time.setText("");			/*prazni polja nakon unosa*/
								  textField_Tprezime.setText("");
								  textField_Tadresa.setText("");
								  textField_Ttel.setText("");
								  textField_Temail.setText("");
								  textField_Tdatum.setText("");
								  textField_Tsport.setText("");

							} 
							catch(Exception ex) {
								/*
								JOptionPane.showMessageDialog(null, "nisu uneseni svi obavezni podaci","Greška",JOptionPane.WARNING_MESSAGE);
								*/
								return;
							}
							System.out.println(Novi_trener_Ime + " " + Novi_trener_Prezime + " " + Novi_trener_adresa + " " + Novi_trener_tel + " " + Novi_trener_email + " " + Novi_trener_datum_zaposlenja + " " + Novi_trener_sport);
							
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
