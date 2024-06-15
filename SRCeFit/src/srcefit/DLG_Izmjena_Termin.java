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

public class DLG_Izmjena_Termin extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_termin_pocetak;
	private JTextField textField_termin_trajanje;
	JComboBox comboBoxTermin;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLG_Izmjena_Termin dialog = new DLG_Izmjena_Termin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLG_Izmjena_Termin() {

		setBounds(100, 100, 450, 300);
		setBackground(new Color(255, 255, 255));
		
		setTitle("SRCeFIT Unos novog termina");
		setBounds(100, 100, 611, 398);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel Novi_termin_pocetak = new JLabel("Novi termin početak (sati)");
			Novi_termin_pocetak.setBounds(10, 120, 122, 22);
			contentPanel.add(Novi_termin_pocetak);
		}
		{
			JLabel Novi_termin_trajanje = new JLabel("Novi termin trajanje (sati)");
			Novi_termin_trajanje.setBounds(10, 153, 122, 13);
			contentPanel.add(Novi_termin_trajanje);
		}

		{
			textField_termin_pocetak = new JTextField();
			textField_termin_pocetak.setBounds(178, 120, 136, 19);
			contentPanel.add(textField_termin_pocetak);
			textField_termin_pocetak.setColumns(10);
		}
		{
			textField_termin_trajanje = new JTextField();
			textField_termin_trajanje.setBounds(178, 149, 136, 19);
			contentPanel.add(textField_termin_trajanje);
			textField_termin_trajanje.setColumns(10);
		}
		{
			JLabel Izmjena_termin_naslov = new JLabel("Koji termin želite mijenjati?");
			Izmjena_termin_naslov.setBounds(10, 10, 413, 22);
			contentPanel.add(Izmjena_termin_naslov);
		}
		{
			JLabel Izmjena_termin_izmjena = new JLabel("Unesite nove podatke:");
			Izmjena_termin_izmjena.setBounds(10, 88, 279, 22);
			contentPanel.add(Izmjena_termin_izmjena);
		}
		{
			comboBoxTermin = new JComboBox();
			comboBoxTermin.setBounds(10, 37, 420, 21);
			contentPanel.add(comboBoxTermin);
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
						MapiranjeBaze_Termin termin = (MapiranjeBaze_Termin) comboBoxTermin.getSelectedItem();
						int idTermin_redni_broj = termin.getTermin_redni_broj();
						
						String Novi_termin_pocetak = textField_termin_pocetak.getText();
						String Novi_termin_trajanje = textField_termin_trajanje.getText();


						
						if (!(Novi_termin_pocetak.equals("") || Novi_termin_trajanje.equals(""))) {

							try {						
							 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							 	 Connection conn = DriverManager.getConnection ("jdbc:mysql://ucka.veleri.hr/dtrbovic?" + "user=dtrbovic&password=11");
								  //id, pocetak, trajanje
								  String sql = "UPDATE RDA_proj_Termin SET termin_pocetak_sati=?, termin_trajanje_sati=? WHERE termin_redni_broj=?;";
				
								  PreparedStatement stmt = conn.prepareStatement(sql);
								  stmt.setString(1, Novi_termin_pocetak);
								  stmt.setString(2, Novi_termin_trajanje);
								  stmt.setInt(3, idTermin_redni_broj);

					  			  stmt.execute();
												
								  conn.close();
											
								  textField_termin_pocetak.setText("");			/*prazni polja nakon unosa*/
								  textField_termin_trajanje.setText("");



							} 
							catch(Exception ex) {
								/*

								JOptionPane.showMessageDialog(null, "nisu uneseni svi obavezni podaci","Greška",JOptionPane.WARNING_MESSAGE);
								*/
								return;
							}
							System.out.println(idTermin_redni_broj + " " + Novi_termin_pocetak + " " + Novi_termin_trajanje);
							
							
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
		CitanjeBaze_Termin citanjeBaze_Termin = new CitanjeBaze_Termin();
		citanjeBaze_Termin.dohvatiTermine(comboBoxTermin);
		
	}

}


