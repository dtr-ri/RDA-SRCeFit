package srcefit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DLG_Prikaz_Termin extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tablePrikazTermin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLG_Prikaz_Termin dialog = new DLG_Prikaz_Termin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLG_Prikaz_Termin() {
		setTitle("SRCeFIT Pregled termina");
		setBounds(100, 100, 701, 435);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 23, 641, 317);
		contentPanel.add(scrollPane);
		{
			tablePrikazTermin = new JTable();
			tablePrikazTermin.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"termin_redni_broj", "termin_pocetak_sati", "termin_trajanje_sati"}
			));
			scrollPane.setViewportView(tablePrikazTermin);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Zatvori");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("Zatvori");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			/*
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
			*/
		}
		selectTermin();
		
	}

	private void selectTermin() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/dtrbovic?" +
				                                   "user=dtrbovic&password=11");
			String sql = "SELECT * FROM RDA_proj_Termin";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			DefaultTableModel model = (DefaultTableModel) tablePrikazTermin.getModel();
			model.setRowCount(0); // brisanje postojećih podataka
			
			while (rs.next()) {
				String termin_redni_broj = rs.getString("termin_redni_broj");
				String termin_pocetak_sati = rs.getString("termin_pocetak_sati");
				String termin_trajanje_sati = rs.getString("termin_trajanje_sati");


				model.addRow(new Object[] {termin_redni_broj, termin_pocetak_sati, termin_trajanje_sati});
			}
			
			conn.close();
			
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
		}
	}
}
