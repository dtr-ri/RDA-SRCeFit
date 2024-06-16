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

public class DLG_Brisanje_AGR_KorisnikNaAktivnostiUTerminu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JComboBox comboBoxZauzece;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLG_Brisanje_AGR_KorisnikNaAktivnostiUTerminu dialog = new DLG_Brisanje_AGR_KorisnikNaAktivnostiUTerminu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLG_Brisanje_AGR_KorisnikNaAktivnostiUTerminu() {
		setBounds(100, 100, 450, 300);
		setBackground(new Color(255, 255, 255));
		
		setTitle("SRCeFIT Brisanje postojećeg zauzeća aktivnosti i termina - KorisnikNaAktivnostiUTerminu");
		setBounds(100, 100, 611, 398);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(240, 255, 240));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		comboBoxZauzece = new JComboBox();
		comboBoxZauzece.setBounds(20, 36, 420, 21);
		contentPanel.add(comboBoxZauzece);
		
		JLabel Izmjena_zauzece_naslov = new JLabel("Koje zauzeća aktivnosti i termina želite obrisati?");
		Izmjena_zauzece_naslov.setBounds(20, 10, 413, 22);
		contentPanel.add(Izmjena_zauzece_naslov);

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
						
						try {						
						 	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							Connection conn = DriverManager.getConnection ("jdbc:mysql://ucka.veleri.hr/dtrbovic?" + "user=dtrbovic&password=11");

						    String sql = "DELETE FROM RDA_proj_AGR_KorisnikNaAktivnostiUTerminu WHERE zauzece_sifra=?;";
					  			
							PreparedStatement stmt = conn.prepareStatement(sql);
							stmt.setInt(1, idZauzece_sifra);
  
							stmt.execute();
											
							conn.close();

											
							} catch(Exception ex) {
							  JOptionPane.showMessageDialog(null, ex.getMessage(),"Gre�ka", JOptionPane.ERROR_MESSAGE);
							}
								
						
						System.out.println(idZauzece_sifra);
					
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

		CitanjeBaze_AGR_KorisnikNaAktivnostiUTerminu citanjeBaze_AGR_KorisnikNaAktivnostiUTerminu = new CitanjeBaze_AGR_KorisnikNaAktivnostiUTerminu();
		citanjeBaze_AGR_KorisnikNaAktivnostiUTerminu.dohvatiZauzeca(comboBoxZauzece);



	}
}
