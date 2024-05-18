package srcefit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

public class DLGUnosAktivnost extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldSifraNoviSport;
	private JTextField textFieldNoviSport;
	private JTextField textFieldSifraClanarina;
	private JTextField textFieldNazivTerena;
	private JTextField textFieldSifraTeren;
	private JTextField textFieldNajveciBrojKorisnika;
	private JComboBox comboBoxTerenNamjena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLGUnosAktivnost dialog = new DLGUnosAktivnost();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLGUnosAktivnost() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Korisnik\\Downloads\\srcefit3.png"));
		setTitle("SRCeFIT");
		setBounds(100, 100, 553, 373);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("�ifra novog sporta");
		lblNewLabel_4.setBounds(10, 33, 112, 14);
		contentPanel.add(lblNewLabel_4);
		
		textFieldSifraNoviSport = new JTextField();
		textFieldSifraNoviSport.setBounds(119, 30, 211, 20);
		contentPanel.add(textFieldSifraNoviSport);
		textFieldSifraNoviSport.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Novi sport");
		lblNewLabel.setBounds(10, 61, 64, 14);
		contentPanel.add(lblNewLabel);
		
		textFieldNoviSport = new JTextField();
		textFieldNoviSport.setBounds(119, 58, 211, 20);
		contentPanel.add(textFieldNoviSport);
		textFieldNoviSport.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Sifra clanarine");
		lblNewLabel_6.setBounds(10, 92, 64, 14);
		contentPanel.add(lblNewLabel_6);
		
		textFieldSifraClanarina = new JTextField();
		textFieldSifraClanarina.setBounds(84, 89, 211, 20);
		contentPanel.add(textFieldSifraClanarina);
		textFieldSifraClanarina.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("�ifra terena");
		lblNewLabel_5.setBounds(10, 120, 79, 14);
		contentPanel.add(lblNewLabel_5);
		
		textFieldSifraTeren = new JTextField();
		textFieldSifraTeren.setBounds(84, 117, 211, 20);
		contentPanel.add(textFieldSifraTeren);
		textFieldSifraTeren.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Naziv terena");
		lblNewLabel_1.setBounds(10, 157, 79, 14);
		contentPanel.add(lblNewLabel_1);
		
		textFieldNazivTerena = new JTextField();
		textFieldNazivTerena.setBounds(119, 154, 211, 20);
		contentPanel.add(textFieldNazivTerena);
		textFieldNazivTerena.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Namjena terena");
		lblNewLabel_2.setBounds(10, 198, 98, 14);
		contentPanel.add(lblNewLabel_2);
		
		JComboBox comboBoxTerenNamjena = new JComboBox();
		comboBoxTerenNamjena.setModel(new DefaultComboBoxModel(new String[] {"odabrati namjenu", "malinogomet", "odbojka", "ko�arka", "tenis"}));
		comboBoxTerenNamjena.setBounds(119, 190, 176, 22);
		contentPanel.add(comboBoxTerenNamjena);
		
		JLabel lblNewLabel_3 = new JLabel("Najveci broj korisnika");
		lblNewLabel_3.setBounds(10, 234, 137, 14);
		contentPanel.add(lblNewLabel_3);
		
		textFieldNajveciBrojKorisnika = new JTextField();
		textFieldNajveciBrojKorisnika.setBounds(144, 231, 86, 20);
		contentPanel.add(textFieldNajveciBrojKorisnika);
		textFieldNajveciBrojKorisnika.setColumns(10);
		
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
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Dodaj novu slanarinu");
		mnNewMenu_10.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Mijenjaj \slanarinu");
		mnNewMenu_10.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Obrisi slanarinu");
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
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(240, 255, 240));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String sifrasport=textFieldSifraNoviSport.getText();
						String sport=textFieldNoviSport.getText();
						String clanarina=textFieldSifraClanarina.getText();
						String sifrateren=textFieldSifraTeren.getText();
						String teren=textFieldNazivTerena.getText();
						String namjena= (String) comboBoxTerenNamjena.getSelectedItem();
						String brojkorisnika=textFieldNajveciBrojKorisnika.getText();
						
						if (sifrasport.equals("") || sport.equals("") || sifrateren.equals("") || teren.equals("") || brojkorisnika.equals("") || clanarina.equals("")) {
							JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena", "Gre�ka", JOptionPane.WARNING_MESSAGE);
							return;};
							try {						
							 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
								  Connection conn = DriverManager.getConnection 
										  ("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" + "user=zdebeljuh&password=11");
								 
								  String sql = "INSERT INTO UBP_proj_Aktivnost VALUES(?,?,?,?,?,?,?);";
								  PreparedStatement stmt = conn.prepareStatement(sql);
								  stmt.setString(1,sifrasport);
								  stmt.setString(2, sport);
								  stmt.setString(3, clanarina);
								  stmt.setString(4, sifrateren);
								  stmt.setString(5, teren);
								  stmt.setString(6, namjena);
								  stmt.setString(7, brojkorisnika);
								  
					  			  stmt.execute();
												
								  conn.close();
											
								  textFieldSifraNoviSport.setText("");
								  textFieldNoviSport.setText("");
								  textFieldSifraTeren.setText("");
								  textFieldNazivTerena.setText("");
								  comboBoxTerenNamjena.setSelectedIndex(-1);
								  textFieldNajveciBrojKorisnika.setText("");
								  textFieldSifraClanarina.setText("");
												
								} catch(Exception ex) {
								  JOptionPane.showMessageDialog(null, 
					   ex.getMessage(),"Gre�ka", JOptionPane.ERROR_MESSAGE);
								}

						System.out.println(sport+" "+clanarina+" "+teren+" "+namjena+" "+brojkorisnika+" ");}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					dispose();}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
