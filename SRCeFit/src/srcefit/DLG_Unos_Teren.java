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

public class DLG_Unos_Teren extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_teren_naziv;
	private JTextField textField_teren_namjena;
	private JTextField textField_teren_max_kapacitet;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLG_Unos_Teren dialog = new DLG_Unos_Teren();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLG_Unos_Teren() {

		setBounds(100, 100, 450, 300);
		setBackground(new Color(255, 255, 255));
		
		setTitle("SRCeFIT Unos novog terena");
		setBounds(100, 100, 611, 398);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel Novi_teren_naziv = new JLabel("Novi teren naziv");
			Novi_teren_naziv.setBounds(10, 33, 122, 22);
			contentPanel.add(Novi_teren_naziv);
		}
		{
			JLabel Novi_teren_namjena = new JLabel("Novi teren namjena");
			Novi_teren_namjena.setBounds(10, 66, 122, 13);
			contentPanel.add(Novi_teren_namjena);
		}
		{
			JLabel Novi_teren_max_kapacitet = new JLabel("Novi teren max kapacitet");
			Novi_teren_max_kapacitet.setBounds(10, 94, 122, 13);
			contentPanel.add(Novi_teren_max_kapacitet);
		}
		{
			textField_teren_naziv = new JTextField();
			textField_teren_naziv.setBounds(178, 33, 136, 19);
			contentPanel.add(textField_teren_naziv);
			textField_teren_naziv.setColumns(10);
		}
		{
			textField_teren_namjena = new JTextField();
			textField_teren_namjena.setBounds(178, 62, 136, 19);
			contentPanel.add(textField_teren_namjena);
			textField_teren_namjena.setColumns(10);
		}
		{
			textField_teren_max_kapacitet = new JTextField();
			textField_teren_max_kapacitet.setColumns(10);
			textField_teren_max_kapacitet.setBounds(178, 91, 136, 19);
			contentPanel.add(textField_teren_max_kapacitet);
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
						String Novi_teren_naziv = textField_teren_naziv.getText();
						String Novi_teren_namjena = textField_teren_namjena.getText();
						String Novi_teren_max_kapacitet = textField_teren_max_kapacitet.getText();


						
						if (!(Novi_teren_naziv.equals("") || Novi_teren_namjena.equals("") || Novi_teren_max_kapacitet.equals(""))) {

							try {						
							 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							 	 Connection conn = DriverManager.getConnection ("jdbc:mysql://ucka.veleri.hr/dtrbovic?" + "user=dtrbovic&password=11");
								  //id, naziv, namjena, max_kapacitet
								  String sql = "INSERT INTO RDA_proj_Teren VALUES(NULL,?,?,?);";
				
								  PreparedStatement stmt = conn.prepareStatement(sql);
								  stmt.setString(1, Novi_teren_naziv);
								  stmt.setString(2, Novi_teren_namjena);
								  stmt.setString(3, Novi_teren_max_kapacitet);


					  			  stmt.execute();
												
								  conn.close();
											
								  textField_teren_naziv.setText("");			/*prazni polja nakon unosa*/
								  textField_teren_namjena.setText("");
								  textField_teren_max_kapacitet.setText("");



							} 
							catch(Exception ex) {
								/*

								JOptionPane.showMessageDialog(null, "nisu uneseni svi obavezni podaci","Greška",JOptionPane.WARNING_MESSAGE);
								*/
								return;
							}
							System.out.println(Novi_teren_naziv + " " + Novi_teren_namjena + " " + Novi_teren_max_kapacitet);
							
							
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


