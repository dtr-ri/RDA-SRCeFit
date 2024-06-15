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

public class DLG_Unos_Termin extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_termin_pocetak;
	private JTextField textField_termin_trajanje;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLG_Unos_Termin dialog = new DLG_Unos_Termin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLG_Unos_Termin() {

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
			Novi_termin_pocetak.setBounds(10, 33, 122, 22);
			contentPanel.add(Novi_termin_pocetak);
		}
		{
			JLabel Novi_termin_trajanje = new JLabel("Novi termin trajanje (sati)");
			Novi_termin_trajanje.setBounds(10, 66, 122, 13);
			contentPanel.add(Novi_termin_trajanje);
		}

		{
			textField_termin_pocetak = new JTextField();
			textField_termin_pocetak.setBounds(178, 33, 136, 19);
			contentPanel.add(textField_termin_pocetak);
			textField_termin_pocetak.setColumns(10);
		}
		{
			textField_termin_trajanje = new JTextField();
			textField_termin_trajanje.setBounds(178, 62, 136, 19);
			contentPanel.add(textField_termin_trajanje);
			textField_termin_trajanje.setColumns(10);
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
						String Novi_termin_pocetak = textField_termin_pocetak.getText();
						String Novi_termin_trajanje = textField_termin_trajanje.getText();


						
						if (!(Novi_termin_pocetak.equals("") || Novi_termin_trajanje.equals(""))) {

							try {						
							 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							 	 Connection conn = DriverManager.getConnection ("jdbc:mysql://ucka.veleri.hr/dtrbovic?" + "user=dtrbovic&password=11");
								  //id, pocetak, trajanje
								  String sql = "INSERT INTO RDA_proj_Termin VALUES(NULL,?,?);";
				
								  PreparedStatement stmt = conn.prepareStatement(sql);
								  stmt.setString(1, Novi_termin_pocetak);
								  stmt.setString(2, Novi_termin_trajanje);


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
							System.out.println(Novi_termin_pocetak + " " + Novi_termin_trajanje);
							
							
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


