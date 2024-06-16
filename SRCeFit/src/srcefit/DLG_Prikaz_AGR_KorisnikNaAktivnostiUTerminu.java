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

public class DLG_Prikaz_AGR_KorisnikNaAktivnostiUTerminu extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tablePrikazKorisnikNaAktivnostiUTerminu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLG_Prikaz_AGR_KorisnikNaAktivnostiUTerminu dialog = new DLG_Prikaz_AGR_KorisnikNaAktivnostiUTerminu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLG_Prikaz_AGR_KorisnikNaAktivnostiUTerminu() {
		setTitle("SRCeFIT Pregled zauzeća aktivnosti i termina");
		setBounds(100, 100, 701, 435);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 23, 641, 317);
		contentPanel.add(scrollPane);
		{
			tablePrikazKorisnikNaAktivnostiUTerminu = new JTable();
			tablePrikazKorisnikNaAktivnostiUTerminu.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"zauzece_sifra", "korisnik_clanski_broj", "aktivnost_sifra", "termin_redni_broj", "zauzece_datum", "zauzece_br_osoba"}
			));
			scrollPane.setViewportView(tablePrikazKorisnikNaAktivnostiUTerminu);
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
			Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/dtrbovic?" + "user=dtrbovic&password=11");
			String sql = "SELECT * FROM RDA_proj_AGR_KorisnikNaAktivnostiUTerminu";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			DefaultTableModel model = (DefaultTableModel) tablePrikazKorisnikNaAktivnostiUTerminu.getModel();
			model.setRowCount(0); // brisanje postojećih podataka
			
			while (rs.next()) {
				String zauzece_sifra = rs.getString("zauzece_sifra");
				String korisnik_clanski_broj = rs.getString("korisnik_clanski_broj");
				String aktivnost_sifra = rs.getString("aktivnost_sifra");
				String termin_redni_broj = rs.getString("termin_redni_broj");
				String zauzece_datum = rs.getString("zauzece_datum");
				String zauzece_br_osoba = rs.getString("zauzece_br_osoba");

				model.addRow(new Object[] {zauzece_sifra, korisnik_clanski_broj, aktivnost_sifra, termin_redni_broj, zauzece_datum, zauzece_br_osoba});
			}
			
			conn.close();
			
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
		}
	}
}
