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
import javax.swing.JComboBox;

public class DLG_Brisanje_Korisnik extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JComboBox comboBoxKorisnik;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLG_Brisanje_Korisnik dialog = new DLG_Brisanje_Korisnik();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLG_Brisanje_Korisnik() {

		setBounds(100, 100, 450, 300);
		setBackground(new Color(255, 255, 255));
		
		setTitle("SRCeFIT Brisanje postojećeg korisnika");
		setBounds(100, 100, 611, 398);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel Brisanje_korisnik_naslov = new JLabel("Kojeg korisnika želite obrisati?");
			Brisanje_korisnik_naslov.setBounds(10, 10, 413, 22);
			contentPanel.add(Brisanje_korisnik_naslov);
		}
		{
			comboBoxKorisnik = new JComboBox();
			comboBoxKorisnik.setBounds(10, 36, 420, 21);
			contentPanel.add(comboBoxKorisnik);
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
						
						MapiranjeBaze_Korisnik korisnik = (MapiranjeBaze_Korisnik) comboBoxKorisnik.getSelectedItem();
						int idKorisnik_clanski_broj = korisnik.getKorisnik_clanski_broj();
						

							try {						
							 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							 	 Connection conn = DriverManager.getConnection ("jdbc:mysql://ucka.veleri.hr/dtrbovic?" + "user=dtrbovic&password=11");
								  //id, ime, prez, adr, mob, email
								  String sql = "DELETE FROM RDA_proj_Korisnik WHERE korisnik_clanski_broj=?;";
								  								  							  
								  PreparedStatement stmt = conn.prepareStatement(sql);
								  stmt.setInt(1, idKorisnik_clanski_broj);

					  			  stmt.execute();
												
								  conn.close();
											


							} 
							catch(Exception ex) {
								/*

								JOptionPane.showMessageDialog(null, "nisu uneseni svi obavezni podaci","Greška",JOptionPane.WARNING_MESSAGE);
								*/
								return;
							}
							System.out.println(idKorisnik_clanski_broj);
							
							
						
						
						
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
		CitanjeBaze_Korisnik citanjeBaze_Korisnik = new CitanjeBaze_Korisnik();
		citanjeBaze_Korisnik.dohvatiKorisnike(comboBoxKorisnik);
		
	}

}


