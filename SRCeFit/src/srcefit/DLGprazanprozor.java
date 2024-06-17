package srcefit;

//import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DLGprazanprozor extends JDialog {

	private JFrame frame;
	private final JPanel contentPanel = new JPanel();
	/*private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {*/
				try {
					DLGprazanprozor dialog = new DLGprazanprozor();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		;

	/**
	 * Create the dialog.
	 */
	public DLGprazanprozor() {
		setBounds(100, 100, 450, 300);
		setBackground(new Color(255, 255, 255));
		
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
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Prikaz SRC-a");
		  mntmNewMenuItem_4.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                DLGPrikazSRC dlg = new DLGPrikazSRC();
	                dlg.setVisible(true);
	            }
	        });
		mnNewMenu_6.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Mijenjaj postojeci SRC");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLGPromjenaSRC dlg = new DLGPromjenaSRC();
                dlg.setVisible(true);
            }
        });
		mnNewMenu_6.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Obrisi SRC");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	             DLGBrisanjeSRC dlg = new DLGBrisanjeSRC();
	                dlg.setVisible(true);}});
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
		
		JMenu mnNewMenu_8 = new JMenu("Teren");
		mnNewMenu_1.add(mnNewMenu_8);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Dodaj teren");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLGDodavanjeTerena dlg = new DLGDodavanjeTerena();
				dlg.setVisible(true);}});
		mnNewMenu_8.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("Prikaz terena");
		mntmNewMenuItem_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLGPrikazTerena dlg = new DLGPrikazTerena();
				dlg.setVisible(true);}});
		mnNewMenu_8.add(mntmNewMenuItem_2_1);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Mijenjaj teren");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLGPromjenaTerena dlg = new DLGPromjenaTerena();
				dlg.setVisible(true);}});
		mnNewMenu_8.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Obrisi teren");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLGBrisanjeTerena dlg = new DLGBrisanjeTerena();
				dlg.setVisible(true);}});
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
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLGIzmjenaTermina dlg = new DLGIzmjenaTermina();
				dlg.setVisible(true);}});
		
		JMenuItem mntmNewMenuItem_3_1 = new JMenuItem("Prikaz termina");
		mntmNewMenuItem_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLGPrikazTermina dlg = new DLGPrikazTermina();
				dlg.setVisible(true);}});
		mnNewMenu_9.add(mntmNewMenuItem_3_1);
		mnNewMenu_9.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Obrisi termin");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLGBrisanjeTermina dlg = new DLGBrisanjeTermina();
				dlg.setVisible(true);}});
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
		
		JMenu mnKorisnik = new JMenu("Korisnici");
		mnNewMenu_2.add(mnKorisnik);
		
		JMenuItem mntmUnosKorisnika = new JMenuItem("Unesi novog korisnika");
		mntmUnosKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLG_Unos_Korisnik dlg = new DLG_Unos_Korisnik();
				dlg.setVisible(true);}});
		mnKorisnik.add(mntmUnosKorisnika);
		
		JMenuItem mntmPrikazKorisnik = new JMenuItem("Pikaži korisnike");
		mntmPrikazKorisnik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLG_Prikaz_Korisnik dlg = new DLG_Prikaz_Korisnik();
				dlg.setVisible(true);}});
		mnKorisnik.add(mntmPrikazKorisnik);
		
		JMenuItem mntmIzmjenaKorisnik = new JMenuItem("Izmijeni korisnika");
		mntmIzmjenaKorisnik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLG_Izmjena_Korisnik dlg = new DLG_Izmjena_Korisnik();
				dlg.setVisible(true);}});
		mnKorisnik.add(mntmIzmjenaKorisnik);
		
		JMenuItem mntmBrisanjeKorisnik = new JMenuItem("Obriši korisnika");
		mntmBrisanjeKorisnik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLG_Brisanje_Korisnik dlg = new DLG_Brisanje_Korisnik();
				dlg.setVisible(true);}});
		mnKorisnik.add(mntmBrisanjeKorisnik);
		
		JMenu mnAGR_KorisnikNaAktivnostiUTerminu = new JMenu("Zauzeće aktivnosti i termina");
		mnNewMenu_2.add(mnAGR_KorisnikNaAktivnostiUTerminu);
		
		JMenuItem mntmUnosAGR_KorisnikNaAktivnostiUTerminu = new JMenuItem("Unesi novo zauzeće");
		mntmUnosAGR_KorisnikNaAktivnostiUTerminu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLG_Unos_AGR_KorisnikNaAktivnostiUTerminu dlg = new DLG_Unos_AGR_KorisnikNaAktivnostiUTerminu();
				dlg.setVisible(true);}});
		mnAGR_KorisnikNaAktivnostiUTerminu.add(mntmUnosAGR_KorisnikNaAktivnostiUTerminu);
		
		JMenuItem mntmPrikazAGR_KorisnikNaAktivnostiUTerminu = new JMenuItem("Pikaži zauzeća ");
		mntmPrikazAGR_KorisnikNaAktivnostiUTerminu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLG_Prikaz_AGR_KorisnikNaAktivnostiUTerminu dlg = new DLG_Prikaz_AGR_KorisnikNaAktivnostiUTerminu();
				dlg.setVisible(true);}});
		mnAGR_KorisnikNaAktivnostiUTerminu.add(mntmPrikazAGR_KorisnikNaAktivnostiUTerminu);
		
		JMenuItem mntmIzmjenaAGR_KorisnikNaAktivnostiUTerminu = new JMenuItem("Izmijeni zauzeće");
		mntmIzmjenaAGR_KorisnikNaAktivnostiUTerminu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLG_Izmjena_AGR_KorisnikNaAktivnostiUTerminu dlg = new DLG_Izmjena_AGR_KorisnikNaAktivnostiUTerminu();
				dlg.setVisible(true);}});
		mnAGR_KorisnikNaAktivnostiUTerminu.add(mntmIzmjenaAGR_KorisnikNaAktivnostiUTerminu);
		
		JMenuItem mntmBrisanjeAGR_KorisnikNaAktivnostiUTerminu = new JMenuItem("Obriši zauzeće");
		mntmBrisanjeAGR_KorisnikNaAktivnostiUTerminu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLG_Brisanje_AGR_KorisnikNaAktivnostiUTerminu dlg = new DLG_Brisanje_AGR_KorisnikNaAktivnostiUTerminu();
				dlg.setVisible(true);}});
		mnAGR_KorisnikNaAktivnostiUTerminu.add(mntmBrisanjeAGR_KorisnikNaAktivnostiUTerminu);
		
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
	}
}
