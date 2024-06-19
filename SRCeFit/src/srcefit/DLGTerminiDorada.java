package srcefit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DLGTerminiDorada extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JTextArea textAreaPregled;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLGTerminiDorada dialog = new DLGTerminiDorada();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLGTerminiDorada() {
		setTitle("SRCeFIT Pregled termina po određenom početku i trajanju sati");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
		
		{
			textAreaPregled = new JTextArea();
			scrollPane.setViewportView(textAreaPregled);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose(); // zatvara dijalog
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        dispose(); // zatvara dijalog
				    }
				});
				buttonPane.add(cancelButton);
			}
		}
		selectTermini();
	}
	private void selectTermini() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/dtrbovic?" +
				                                   "user=dtrbovic&password=11");
			String sql = "SELECT * FROM RDA_proj_Termin WHERE termin_pocetak_sati=18 AND termin_trajanje_sati=2";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		  String tekst = "";
		  while (rs.next()) {
			  tekst += "Redni broj: "+rs.getString("termin_redni_broj")+"\t";				
			  tekst += "Početak sati: "+rs.getString("termin_pocetak_sati")+"\t";
			  tekst += "Trajanje sati: "+rs.getString("termin_trajanje_sati")+"\n";

		  }	
		  textAreaPregled.setText(tekst);
		  conn.close();
		
	} catch(Exception ex) {
		JOptionPane.showMessageDialog(null, ex.getMessage(),"Greška",
	 JOptionPane.ERROR_MESSAGE);
		}
	}
}
