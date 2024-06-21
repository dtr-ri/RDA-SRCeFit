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
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DlgTerminiDoradaDrugiNacin extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tableTerminDrugiNacin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgTerminiDoradaDrugiNacin dialog = new DlgTerminiDoradaDrugiNacin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgTerminiDoradaDrugiNacin() {
		setTitle("SRCeFIT Pregled termina na drugi način");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(26, 10, 400, 220);
			contentPanel.add(scrollPane);
			
			tableTerminDrugiNacin = new JTable();
			tableTerminDrugiNacin.setModel(new DefaultTableModel(
					new Object[][] {},
					new String[] {"termin_redni_broj", "termin_pocetak_sati", "termin_trajanje_sati"}
				));
			scrollPane.setViewportView(tableTerminDrugiNacin);
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
		selectTerminDrugiNacin();
		
	}

	private void selectTerminDrugiNacin() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/dtrbovic?" +
				                                   "user=dtrbovic&password=11");
			String sql = "SELECT * FROM RDA_proj_Termin WHERE termin_pocetak_sati=18 AND termin_trajanje_sati=2";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			DefaultTableModel model = (DefaultTableModel) tableTerminDrugiNacin.getModel();
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
