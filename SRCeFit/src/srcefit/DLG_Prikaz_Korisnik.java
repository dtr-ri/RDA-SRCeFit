package srcefit;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class DLG_Prikaz_Korisnik extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tablePrikazKorisnik;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLG_Prikaz_Korisnik dialog = new DLG_Prikaz_Korisnik();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLG_Prikaz_Korisnik() {
		setTitle("SRCeFIT Pregled korisnika");
		setBounds(100, 100, 701, 435);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(241, 255, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 23, 641, 317);
		contentPanel.add(scrollPane);
		{
			tablePrikazKorisnik = new JTable();
			tablePrikazKorisnik.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"korisnik_clanski_broj", "korisnik_ime", "korisnik_prezime", "korisnik_adresa", "korisnik_mob", "korisnik_email"}
			));
			scrollPane.setViewportView(tablePrikazKorisnik);
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
		selectKorisnik();
		
	}

	private void selectKorisnik() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/dtrbovic?" + "user=dtrbovic&password=11");
			String sql = "SELECT * FROM RDA_proj_Korisnik";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			DefaultTableModel model = (DefaultTableModel) tablePrikazKorisnik.getModel();
			model.setRowCount(0); // brisanje postojećih podataka
			
			while (rs.next()) {
				String korisnik_clanski_broj = rs.getString("korisnik_clanski_broj");
				String korisnik_ime = rs.getString("korisnik_ime");
				String korisnik_prezime = rs.getString("korisnik_prezime");
				String korisnik_adresa = rs.getString("korisnik_adresa");
				String korisnik_mob = rs.getString("korisnik_mob");
				String korisnik_email = rs.getString("korisnik_email");

				model.addRow(new Object[] {korisnik_clanski_broj, korisnik_ime, korisnik_prezime, korisnik_adresa, korisnik_mob, korisnik_email});
			}
			
			conn.close();
			
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
		}
	}
}
