package srcefit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class DLGPrikazAAktivnosti extends JDialog {

	private final JPanel contentPanel = new JPanel();
    private JTable table;

    public static void main(String[] args) {
        try {
			DLGPrikazAAktivnosti dialog = new DLGPrikazAAktivnosti();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	 public DLGPrikazAAktivnosti() {
	        setTitle("SRCeFIT");
	        setBounds(100, 100, 800, 600);
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
	                dlg.setVisible(true);
	            }
	        });
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
			
			JMenuItem mntmNewMenuItem_25 = new JMenuItem("Prikaz terena");
			mntmNewMenuItem_25.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DLGPrikazTerena dlg = new DLGPrikazTerena();
					dlg.setVisible(true);}});
			mnNewMenu_8.add(mntmNewMenuItem_25);
			
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
			mnNewMenu_9.add(mntmNewMenuItem_5);
			JMenuItem mntmNewMenuItem_27 = new JMenuItem("Prikaz termina");
			mntmNewMenuItem_27.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DLGPrikazTermina dlg = new DLGPrikazTermina();
					dlg.setVisible(true);}});
			mnNewMenu_9.add(mntmNewMenuItem_27);
			
			
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
			
			JMenu mnNewMenu_11 = new JMenu("Clanovi");
			mnNewMenu_2.add(mnNewMenu_11);
			
			JMenuItem mntmNewMenuItem_17 = new JMenuItem("Dodaj novog clana");
			mntmNewMenuItem_17.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DLG_Unos_Korisnik dlg = new DLG_Unos_Korisnik();
					dlg.setVisible(true);}});
			mnNewMenu_11.add(mntmNewMenuItem_17);
			
			JMenuItem mntmNewMenuItem_26 = new JMenuItem("Prikaz clana");
			mntmNewMenuItem_26.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DLG_Prikaz_Korisnik dlg = new DLG_Prikaz_Korisnik();
					dlg.setVisible(true);}});
			mnNewMenu_11.add(mntmNewMenuItem_26);
			
			JMenuItem mntmNewMenuItem_18 = new JMenuItem("Mijenjaj clana");
			mntmNewMenuItem_18.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DLG_Izmjena_Korisnik dlg = new DLG_Izmjena_Korisnik();
					dlg.setVisible(true);}});
			mnNewMenu_11.add(mntmNewMenuItem_18);
			
			JMenuItem mntmNewMenuItem_19 = new JMenuItem("Obrisi clana");
			mntmNewMenuItem_19.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DLG_Brisanje_Korisnik dlg = new DLG_Brisanje_Korisnik();
					dlg.setVisible(true);}});
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
		
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(5, 22, 774, 501);
	        contentPanel.add(scrollPane);

	        table = new JTable();
	        table.setModel(new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "Šifra aktivnost", "Naziv", "Šifra članarine", "Šifra terene", "Naziv terena", "Namjena terena", "Maksimum kapacitet"
	            }
	        ));
	        scrollPane.setViewportView(table);
	        
	        JPanel buttonPane = new JPanel();
	        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	        getContentPane().add(buttonPane, BorderLayout.SOUTH);

	        JButton okButton = new JButton("OK");
	        okButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dispose();
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

	        selectPrikazAAktivnost();
	    }

	    private void selectPrikazAAktivnost() {
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	            Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" + "user=zdebeljuh&password=11");
	            String sql = "SELECT * FROM RDA_proj_Aktivnost";
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            while (rs.next()) {
	                model.addRow(new Object[]{
	                    rs.getString("aktivnost_sifra"),
	                    rs.getString("aktivnost_naziv"),
	                    rs.getString("clanarina_sifra"),
	                    rs.getString("teren_sifra"),
	                    rs.getString("teren_naziv"),
	                    rs.getString("teren_namjena"),
	                    rs.getString("teren_max_kapacitet")
	                });
	            }
	            conn.close();
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}

