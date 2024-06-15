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

public class DLG_Izmjena_Aktivnost extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JComboBox comboBoxTeren;
	JComboBox comboBoxAktivnost;
	private JTextField textField_aktivnost_naziv;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLG_Izmjena_Aktivnost dialog = new DLG_Izmjena_Aktivnost();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLG_Izmjena_Aktivnost() {

		setBounds(100, 100, 450, 300);
		setBackground(new Color(255, 255, 255));
		
		setTitle("SRCeFIT Unos nove aktivnosti");
		setBounds(100, 100, 611, 398);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
				{
			JLabel Izmjena_aktivnost_naslov = new JLabel("Koju aktivnost želite mijenjati?");
			Izmjena_aktivnost_naslov.setBounds(10, 10, 413, 22);
			contentPanel.add(Izmjena_aktivnost_naslov);
		}
		{
			JLabel Izmjena_aktivnost_izmjena = new JLabel("Unesite nove podatke");
			Izmjena_aktivnost_izmjena.setBounds(10, 88, 413, 22);
			contentPanel.add(Izmjena_aktivnost_izmjena);
		}
		{
			JLabel Nova_aktivnost_naziv = new JLabel("Nova aktivnost naziv");
			Nova_aktivnost_naziv.setBounds(10, 120, 122, 22);
			contentPanel.add(Nova_aktivnost_naziv);
		}
		{
			JLabel Nova_aktivnost_teren = new JLabel("Nova kativnost koristi teren");
			Nova_aktivnost_teren.setBounds(10, 153, 158, 13);
			contentPanel.add(Nova_aktivnost_teren);
		}
		{
			textField_aktivnost_naziv = new JTextField();
			textField_aktivnost_naziv.setBounds(178, 120, 136, 19);
			contentPanel.add(textField_aktivnost_naziv);
			textField_aktivnost_naziv.setColumns(10);
		}
		{
			comboBoxTeren = new JComboBox();
			comboBoxTeren.setBounds(178, 149, 252, 21);
			contentPanel.add(comboBoxTeren);
		}
		{
			comboBoxAktivnost = new JComboBox();
			comboBoxAktivnost.setBounds(10, 36, 413, 21);
			contentPanel.add(comboBoxAktivnost);
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
						MapiranjeBaze_Aktivnost aktivnost = (MapiranjeBaze_Aktivnost) comboBoxAktivnost.getSelectedItem();
						int idAktivnost_sifra = aktivnost.getAktivnost_sifra();
						
						String Nova_aktivnost_naziv = textField_aktivnost_naziv.getText();
						
						MapiranjeBaze_Teren teren = (MapiranjeBaze_Teren) comboBoxTeren.getSelectedItem();
						int idTeren_sifra = teren.getTeren_sifra();
						

				
						if (!(Nova_aktivnost_naziv.equals(""))) {

							try {						
							 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							 	 Connection conn = DriverManager.getConnection ("jdbc:mysql://ucka.veleri.hr/dtrbovic?" + "user=dtrbovic&password=11");
								  //id, naziv, teren_sifra
								  String sql = "UPDATE RDA_proj_Aktivnost SET aktivnost_naziv=?, teren_sifra=? WHERE aktivnost_sifra=?;";
				
								  PreparedStatement stmt = conn.prepareStatement(sql);
								  stmt.setString(1, Nova_aktivnost_naziv);
								  stmt.setInt(2, idTeren_sifra);
								  stmt.setInt(3, idAktivnost_sifra);


					  			  stmt.execute();
												
								  conn.close();
											
								  textField_aktivnost_naziv.setText("");			/*prazni polja nakon unosa*/


							} 
							catch(Exception ex) {
								/*

								JOptionPane.showMessageDialog(null, "nisu uneseni svi obavezni podaci","Greška",JOptionPane.WARNING_MESSAGE);
								*/
								return;
							}
							System.out.println(idAktivnost_sifra + " " + Nova_aktivnost_naziv + " " + idTeren_sifra);
							
							
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
		CitanjeBaze_Teren citanjeBaze_Teren = new CitanjeBaze_Teren();
		citanjeBaze_Teren.dohvatiTerene(comboBoxTeren);
		
		CitanjeBaze_Aktivnost citanjeBaze_Aktivnost = new CitanjeBaze_Aktivnost();
		citanjeBaze_Aktivnost.dohvatiAktivnosti(comboBoxAktivnost);
		
		
	}
}


