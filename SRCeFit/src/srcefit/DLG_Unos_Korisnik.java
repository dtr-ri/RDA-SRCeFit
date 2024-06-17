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

public class DLG_Unos_Korisnik extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_ime;
	private JTextField textField_prezime;
	private JTextField textField_adresa;
	private JTextField textField_tel;
	private JTextField textField_email;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLG_Unos_Korisnik dialog = new DLG_Unos_Korisnik();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLG_Unos_Korisnik() {

		setBounds(100, 100, 450, 300);
		setBackground(new Color(255, 255, 255));
		
		setTitle("SRCeFIT Unos novog korisnika");
		setBounds(100, 100, 611, 398);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel Novi_korisnik_Ime = new JLabel("Novi korisnik Ime");
			Novi_korisnik_Ime.setBounds(10, 33, 122, 22);
			contentPanel.add(Novi_korisnik_Ime);
		}
		{
			JLabel Novi_korisnik_Prezime = new JLabel("Novi korisnik Prezime");
			Novi_korisnik_Prezime.setBounds(10, 66, 122, 13);
			contentPanel.add(Novi_korisnik_Prezime);
		}
		{
			JLabel Novi_korisnik_adresa = new JLabel("Novi korisnik Adresa");
			Novi_korisnik_adresa.setBounds(10, 100, 122, 13);
			contentPanel.add(Novi_korisnik_adresa);
		}
		{
			JLabel Novi_korisnik_tel = new JLabel("Novi korisnik tel/mob");
			Novi_korisnik_tel.setBounds(10, 134, 122, 13);
			contentPanel.add(Novi_korisnik_tel);
		}
		{
			JLabel Novi_korisnik_email = new JLabel("Novi korisnik email");
			Novi_korisnik_email.setBounds(10, 158, 122, 22);
			contentPanel.add(Novi_korisnik_email);
		}

		{
			textField_ime = new JTextField();
			textField_ime.setBounds(178, 33, 136, 19);
			contentPanel.add(textField_ime);
			textField_ime.setColumns(10);
		}
		{
			textField_prezime = new JTextField();
			textField_prezime.setBounds(178, 62, 136, 19);
			contentPanel.add(textField_prezime);
			textField_prezime.setColumns(10);
		}
		{
			textField_adresa = new JTextField();
			textField_adresa.setBounds(178, 96, 136, 19);
			contentPanel.add(textField_adresa);
			textField_adresa.setColumns(10);
		}
		{
			textField_tel = new JTextField();
			textField_tel.setBounds(178, 130, 136, 19);
			contentPanel.add(textField_tel);
			textField_tel.setColumns(10);
		}
		{
			textField_email = new JTextField();
			textField_email.setBounds(178, 159, 136, 19);
			contentPanel.add(textField_email);
			textField_email.setColumns(10);
		}
		setTitle("SRCeFIT");
		setBounds(100, 100, 611, 398);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.menu);
		menuBar.setBounds(0, 0, 595, 22);
		contentPanel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Kontrola");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Odjava");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();}});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("SRCeFIT");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_6 = new JMenu("SRC");
		mnNewMenu_1.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Dodaj novi SRC");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLGDodavanjeSRC dlg = new DLGDodavanjeSRC();
				dlg.setVisible(true);}});
		mnNewMenu_6.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Mijenjaj postojeci SRC");
		mnNewMenu_6.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Obrisi SRC");
		mnNewMenu_6.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_7 = new JMenu("Aktivnost/sport");
		mnNewMenu_1.add(mnNewMenu_7);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Dodaj novu aktivnost/sport");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLGUnosAktivnost dlg = new DLGUnosAktivnost();
				dlg.setVisible(true);}});
		mnNewMenu_7.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Mijenjaj aktivnost/sport");
		mnNewMenu_7.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Obrisi aktivnost/sport");
		mnNewMenu_7.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_8 = new JMenu("Trener");
		mnNewMenu_1.add(mnNewMenu_8);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Dodaj trenera");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLGUnosTrener dlg = new DLGUnosTrener();
				dlg.setVisible(true);}});
		mnNewMenu_8.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Mijenjaj trenera");
		mnNewMenu_8.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Obrisi trenera");
		mnNewMenu_8.add(mntmNewMenuItem_12);
		
		JMenu mnNewMenu_9 = new JMenu("Termin");
				mnNewMenu_1.add(mnNewMenu_9);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Dodaj termin");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLGTermini dlg = new DLGTermini();
				dlg.setVisible(true);}});
		mnNewMenu_9.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Mijenjaj termin");
		mnNewMenu_9.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Obrisi termin");
		mnNewMenu_9.add(mntmNewMenuItem_13);
		
		JMenu mnNewMenu_2 = new JMenu("Korisnici");
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
		mntmNewMenuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLG_Unos_Korisnik dlg = new DLG_Unos_Korisnik();
				dlg.setVisible(true);}});
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
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {
						String Novi_korisnik_Ime = textField_ime.getText();
						String Novi_korisnik_Prezime = textField_prezime.getText();
						String Novi_korisnik_adresa = textField_adresa.getText();
						String Novi_korisnik_tel = textField_tel.getText();
						String Novi_korisnik_email = textField_email.getText();

						
						if (!(Novi_korisnik_Ime.equals("") || Novi_korisnik_Prezime.equals("") || Novi_korisnik_adresa.equals("") || Novi_korisnik_tel.equals(""))) {

							try {						
							 	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
							 	 Connection conn = DriverManager.getConnection ("jdbc:mysql://ucka.veleri.hr/dtrbovic?" + "user=dtrbovic&password=11");
								  //id, ime, prez, adr, mob, email
								  String sql = "INSERT INTO RDA_proj_Korisnik VALUES(NULL,?,?,?,?,?);";
				
								  PreparedStatement stmt = conn.prepareStatement(sql);
								  stmt.setString(1, Novi_korisnik_Ime);
								  stmt.setString(2, Novi_korisnik_Prezime);
								  stmt.setString(3, Novi_korisnik_adresa);
								  stmt.setString(4, Novi_korisnik_tel);
								  stmt.setString(5, Novi_korisnik_email);

					  			  stmt.execute();
												
								  conn.close();
											
								  textField_ime.setText("");			/*prazni polja nakon unosa*/
								  textField_prezime.setText("");
								  textField_adresa.setText("");
								  textField_tel.setText("");
								  textField_email.setText("");


							} 
							catch(Exception ex) {
								/*

								JOptionPane.showMessageDialog(null, "nisu uneseni svi obavezni podaci","Greška",JOptionPane.WARNING_MESSAGE);
								*/
								return;
							}
							System.out.println(Novi_korisnik_Ime + " " + Novi_korisnik_Prezime + " " + Novi_korisnik_adresa + " " + Novi_korisnik_tel + " " + Novi_korisnik_email);
							
							
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


