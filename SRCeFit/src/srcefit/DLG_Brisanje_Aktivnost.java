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

public class DLG_Brisanje_Aktivnost extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JComboBox comboBoxAktivnost;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLG_Brisanje_Aktivnost dialog = new DLG_Brisanje_Aktivnost();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLG_Brisanje_Aktivnost() {

		setBounds(100, 100, 450, 300);
		setBackground(new Color(255, 255, 255));
		
		setTitle("SRCeFIT Brisanje postojeće aktivnosti");
		setBounds(100, 100, 611, 398);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
				{
			JLabel Brisanje_aktivnost_naslov = new JLabel("Koju aktivnost želite obrisati?");
			Brisanje_aktivnost_naslov.setBounds(10, 10, 413, 22);
			contentPanel.add(Brisanje_aktivnost_naslov);
		}
		{
			comboBoxAktivnost = new JComboBox();
			comboBoxAktivnost.setBounds(10, 36, 420, 21);
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

							try {						
							 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							 	 Connection conn = DriverManager.getConnection ("jdbc:mysql://ucka.veleri.hr/dtrbovic?" + "user=dtrbovic&password=11");
								  //id, naziv, teren_sifra
								  String sql = "DELETE FROM RDA_proj_Aktivnost WHERE aktivnost_sifra=?;";
								  
								  PreparedStatement stmt = conn.prepareStatement(sql);

								  stmt.setInt(1, idAktivnost_sifra);


					  			  stmt.execute();
												
								  conn.close();


							} 
							catch(Exception ex) {
								/*

								JOptionPane.showMessageDialog(null, "nisu uneseni svi obavezni podaci","Greška",JOptionPane.WARNING_MESSAGE);
								*/
								return;
							}
							System.out.println(idAktivnost_sifra);
				
						
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

		CitanjeBaze_Aktivnost citanjeBaze_Aktivnost = new CitanjeBaze_Aktivnost();
		citanjeBaze_Aktivnost.dohvatiAktivnosti(comboBoxAktivnost);
		
		
	}
}


