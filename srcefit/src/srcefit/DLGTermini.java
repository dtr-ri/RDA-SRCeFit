package srcefit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DLGTermini extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldRedniBroj;
	private JTextField textFieldDatum;
	private JComboBox comboBoxPočetakSati;
	private JComboBox comboBoxTrajanjeSati;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLGTermini dialog = new DLGTermini();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLGTermini() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Korisnik\\Downloads\\srcefit3.png"));
		setTitle("SRCeFIT Termini");
		setBounds(100, 100, 553, 373);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblRedniBroj = new JLabel("Redni Broj");
		lblRedniBroj.setBounds(26, 34, 84, 21);
		contentPanel.add(lblRedniBroj);
		
		textFieldRedniBroj = new JTextField();
		textFieldRedniBroj.setBounds(96, 36, 96, 19);
		contentPanel.add(textFieldRedniBroj);
		textFieldRedniBroj.setColumns(10);
		
		JLabel lblDatum = new JLabel("Datum");
		lblDatum.setBounds(26, 88, 45, 13);
		contentPanel.add(lblDatum);
		
		textFieldDatum = new JTextField();
		textFieldDatum.setBounds(96, 85, 96, 19);
		contentPanel.add(textFieldDatum);
		textFieldDatum.setColumns(10);
		
		JLabel lblPočetakSati = new JLabel("Početak sati");
		lblPočetakSati.setBounds(26, 134, 71, 13);
		contentPanel.add(lblPočetakSati);
		
		JComboBox comboBoxPočetakSati = new JComboBox();
		comboBoxPočetakSati.setModel(new DefaultComboBoxModel(new String[] {"18", "19", "20", "21"}));
		comboBoxPočetakSati.setBounds(96, 131, 96, 21);
		contentPanel.add(comboBoxPočetakSati);
		
		JLabel lblTrajanjeSati = new JLabel("Trajanje sati");
		lblTrajanjeSati.setBounds(26, 189, 71, 13);
		contentPanel.add(lblTrajanjeSati);
		
		comboBoxTrajanjeSati = new JComboBox();
		comboBoxTrajanjeSati.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBoxTrajanjeSati.setBounds(96, 186, 96, 21);
		contentPanel.add(comboBoxTrajanjeSati);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 537, 22);
		contentPanel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Kontrola");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Odjava");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("SRCeFIT");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_6 = new JMenu("SRC");
		mnNewMenu_1.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Dodaj novi SRC");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLGDodavanjeSRC dlg = new DLGDodavanjeSRC();
				dlg.setVisible(true);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Mijenjaj postojeci SRC");
		mnNewMenu_6.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Obrisi SRC");
		mnNewMenu_6.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_7 = new JMenu("Aktivnost/sport");
		mnNewMenu_1.add(mnNewMenu_7);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Dodaj novu aktivnost/sport");
		mnNewMenu_7.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Mijenjaj aktivnost/sport");
		mnNewMenu_7.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Obrisi aktivnost/sport");
		mnNewMenu_7.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_8 = new JMenu("Trener");
		mnNewMenu_1.add(mnNewMenu_8);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Dodaj trenera");
		mnNewMenu_8.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Mijenjaj trenera");
		mnNewMenu_8.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Obrisi trenera");
		mnNewMenu_8.add(mntmNewMenuItem_12);
		
		JMenu mnNewMenu_9 = new JMenu("Termin");
		mnNewMenu_1.add(mnNewMenu_9);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Dodaj termin");
		mnNewMenu_9.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Mijenjaj termin");
		mnNewMenu_9.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Obrisi termin");
		mnNewMenu_9.add(mntmNewMenuItem_13);
		
		JMenu mnNewMenu_2 = new JMenu("Clanovi");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_10 = new JMenu("Clanarine");
		mnNewMenu_2.add(mnNewMenu_10);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Dodaj novu clanarinu");
		mnNewMenu_10.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Mijenjaj clanarinu");
		mnNewMenu_10.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Obrisi clanarinu");
		mnNewMenu_10.add(mntmNewMenuItem_16);
		
		JMenu mnNewMenu_11 = new JMenu("Clanovi");
		mnNewMenu_2.add(mnNewMenu_11);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Dodaj novog clana");
		mnNewMenu_11.add(mntmNewMenuItem_17);
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Mijenjaj clana");
		mnNewMenu_11.add(mntmNewMenuItem_18);
		
		JMenuItem mntmNewMenuItem_19 = new JMenuItem("Obrisi clana");
		mnNewMenu_11.add(mntmNewMenuItem_19);
		
		JMenu mnNewMenu_12 = new JMenu("Posebne pogodnosti");
		mnNewMenu_2.add(mnNewMenu_12);
		
		JMenuItem mntmNewMenuItem_20 = new JMenuItem("Dodaj posebnu pogodnost");
		mnNewMenu_12.add(mntmNewMenuItem_20);
		
		JMenuItem mntmNewMenuItem_21 = new JMenuItem("Mijenjaj posebnu pogodnost");
		mnNewMenu_12.add(mntmNewMenuItem_21);
		
		JMenuItem mntmNewMenuItem_22 = new JMenuItem("Dodijeli posebnu pogodnost canu");
		mnNewMenu_12.add(mntmNewMenuItem_22);
		
		JMenuItem mntmNewMenuItem_23 = new JMenuItem("Obrisi posebnu pogodnost");
		mnNewMenu_12.add(mntmNewMenuItem_23);
		
		JMenu mnNewMenu_3 = new JMenu("Recenzije");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_24 = new JMenuItem("Procitaj recenzije");
		mnNewMenu_3.add(mntmNewMenuItem_24);
		
		JMenu mnNewMenu_5 = new JMenu("Izvjestaji");
		menuBar.add(mnNewMenu_5);
		
		JMenu mnNewMenu_4 = new JMenu("Racunovodstvo");
		menuBar.add(mnNewMenu_4);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(240, 255, 240));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String redniBroj = textFieldRedniBroj.getText();
				String datum = textFieldDatum.getText();
				String početakSati = (String) comboBoxPočetakSati.getSelectedItem();
				String trajanjeSati = (String) comboBoxTrajanjeSati.getSelectedItem();
				
				if (redniBroj.equals("") || datum.equals("") || početakSati.equals("") || trajanjeSati.equals("")) {
					JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena", "Greška", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				try {						
					Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" + "user=zdebeljuh&password=11");
					
					String sql = "INSERT INTO UBP_proj_Termin VALUES(?,?,?,?);";
					PreparedStatement stmt = conn.prepareStatement(sql);
					stmt.setString(1, redniBroj);
					stmt.setString(2, datum);
					stmt.setString(3, početakSati);
					stmt.setString(4, trajanjeSati);
					
					stmt.execute();
					conn.close();
					
					textFieldRedniBroj.setText("");
					textFieldDatum.setText("");
					comboBoxPočetakSati.setSelectedIndex(-1);
					comboBoxTrajanjeSati.setSelectedIndex(-1);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
				}

				System.out.println(redniBroj + " " + datum + " " + početakSati + " " + trajanjeSati);
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
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

		