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

public class DLG_Brisanje_Termin extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JComboBox comboBoxTermin;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLG_Brisanje_Termin dialog = new DLG_Brisanje_Termin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLG_Brisanje_Termin() {

		setBounds(100, 100, 450, 300);
		setBackground(new Color(255, 255, 255));
		
		setTitle("SRCeFIT Brisanje postojećeg termina");
		setBounds(100, 100, 611, 398);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel Brisanje_termin_naslov = new JLabel("Koji termin želite obrisati?");
			Brisanje_termin_naslov.setBounds(10, 10, 413, 22);
			contentPanel.add(Brisanje_termin_naslov);
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

							try {						
							 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							 	 Connection conn = DriverManager.getConnection ("jdbc:mysql://ucka.veleri.hr/dtrbovic?" + "user=dtrbovic&password=11");
								  //id, pocetak, trajanje
								  String sql = "DELETE FROM RDA_proj_Termin WHERE termin_redni_broj=?;";
								  
								  PreparedStatement stmt = conn.prepareStatement(sql);
								  stmt.setInt(1, idTermin_redni_broj);

					  			  stmt.execute();
												
								  conn.close();
											
							} 
							catch(Exception ex) {
								/*

								JOptionPane.showMessageDialog(null, "nisu uneseni svi obavezni podaci","Greška",JOptionPane.WARNING_MESSAGE);
								*/
								return;
							}
							System.out.println(idTermin_redni_broj);
					
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


