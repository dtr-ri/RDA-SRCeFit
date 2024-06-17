package srcefit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DLGPromjenaTerena extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JComboBox<String> comboBoxTerenSifre;
    private JTextField textFieldTerenNaziv;
    private JTextField textFieldTerenNamjena;
    private JTextField textFieldTerenKapacitet;
    private String[][] tereni;

    public static void main(String[] args) {
        try {
            DLGPromjenaTerena dialog = new DLGPromjenaTerena();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DLGPromjenaTerena() {
        setTitle("SRCeFIT");
        setBounds(100, 100, 663, 479);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(240, 255, 240));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Naziv terena");
        lblNewLabel.setBounds(10, 65, 105, 14);
        contentPanel.add(lblNewLabel);

        comboBoxTerenSifre = new JComboBox<>();
        comboBoxTerenSifre.setBounds(213, 18, 211, 20);
        contentPanel.add(comboBoxTerenSifre);

        JLabel lblNewLabel_4 = new JLabel("Šifra terena");
        lblNewLabel_4.setBounds(10, 21, 193, 14);
        contentPanel.add(lblNewLabel_4);

        textFieldTerenNaziv = new JTextField();
        textFieldTerenNaziv.setBounds(213, 62, 211, 20);
        contentPanel.add(textFieldTerenNaziv);
        textFieldTerenNaziv.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Namjena terena");
        lblNewLabel_1.setBounds(10, 108, 193, 14);
        contentPanel.add(lblNewLabel_1);

        textFieldTerenNamjena = new JTextField();
        textFieldTerenNamjena.setBounds(213, 105, 211, 20);
        contentPanel.add(textFieldTerenNamjena);
        textFieldTerenNamjena.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Najveći kapacitet");
        lblNewLabel_2.setBounds(10, 149, 193, 14);
        contentPanel.add(lblNewLabel_2);
        
        textFieldTerenKapacitet = new JTextField();
        textFieldTerenKapacitet.setBounds(213, 145, 211, 22);
        contentPanel.add(textFieldTerenKapacitet);
        textFieldTerenKapacitet.setColumns(10);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(SystemColor.menu);
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("Kontrola");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("Odjava");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        mnNewMenu.add(mntmNewMenuItem);

        JMenu mnNewMenu_1 = new JMenu("SRCeFIT");
        menuBar.add(mnNewMenu_1);

        JMenu mnNewMenu_6 = new JMenu("SRC");
        mnNewMenu_1.add(mnNewMenu_6);

        JMenuItem mntmNewMenuItem_6 = new JMenuItem("Dodaj novi SRC");
        mnNewMenu_6.add(mntmNewMenuItem_6);
        
        JMenuItem mntmNewMenuItem_4 = new JMenuItem("Prikaz SRC");
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
   /*     mntmNewMenuItem_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLGBrisanjeSRC dlg = new DLGBrisanjeSRC();
                dlg.setVisible(true);
            }
        }); */
        mnNewMenu_6.add(mntmNewMenuItem_8);

        JMenu mnNewMenu_7 = new JMenu("Aktivnost/sport");
        mnNewMenu_1.add(mnNewMenu_7);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Dodaj novu aktivnost/sport");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLGUnosAktivnost dlg = new DLGUnosAktivnost();
                dlg.setVisible(true);
            }
        });
        mnNewMenu_7.add(mntmNewMenuItem_1);

        JMenuItem mntmNewMenuItem_9 = new JMenuItem("Mijenjaj aktivnost/sport");
        mntmNewMenuItem_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLG_Izmjena_Aktivnost dlg = new DLG_Izmjena_Aktivnost();
                dlg.setVisible(true);
            }
        });
        mnNewMenu_7.add(mntmNewMenuItem_9);

        JMenuItem mntmNewMenuItem_10 = new JMenuItem("Obrisi aktivnost/sport");
        mntmNewMenuItem_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLG_Brisanje_Aktivnost dlg = new DLG_Brisanje_Aktivnost();
                dlg.setVisible(true);
            }
        });
        mnNewMenu_7.add(mntmNewMenuItem_10);

        JMenu mnNewMenu_8 = new JMenu("Teren");
        mnNewMenu_1.add(mnNewMenu_8);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Dodaj teren");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLGDodavanjeTerena dlg = new DLGDodavanjeTerena();
                dlg.setVisible(true);
            }
        });
        mnNewMenu_8.add(mntmNewMenuItem_2);
        
        JMenuItem mntmNewMenuItem_5 = new JMenuItem("Pregledaj terene");
        mntmNewMenuItem_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLGPrikazTerena dlg = new DLGPrikazTerena();
                dlg.setVisible(true);
            }
        });
        mnNewMenu_8.add(mntmNewMenuItem_5);

        JMenuItem mntmNewMenuItem_11 = new JMenuItem("Mijenjaj teren");
 /*       mntmNewMenuItem_11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLGPromjenaTerena dlg = new DLGPromjenaTerena();
                dlg.setVisible(true);
            }
        });*/
        mnNewMenu_8.add(mntmNewMenuItem_11);

        JMenuItem mntmNewMenuItem_12 = new JMenuItem("Obrisi teren");
        mntmNewMenuItem_12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLGBrisanjeTerena dlg = new DLGBrisanjeTerena();
                dlg.setVisible(true);
            }
        });
        mnNewMenu_8.add(mntmNewMenuItem_12);

        JMenu mnNewMenu_9 = new JMenu("Termin");
        mnNewMenu_1.add(mnNewMenu_9);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("Dodaj termin");
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLGTermini dlg = new DLGTermini();
                dlg.setVisible(true);
            }
        });
        mnNewMenu_9.add(mntmNewMenuItem_3);

        JMenuItem mntmNewMenuItem_13 = new JMenuItem("Obrisi termin");
        mntmNewMenuItem_13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLG_Brisanje_Termin dlg = new DLG_Brisanje_Termin();
                dlg.setVisible(true);
            }
        });
        mnNewMenu_9.add(mntmNewMenuItem_13);

        JMenu mnNewMenu_2 = new JMenu("Korisnici");
        menuBar.add(mnNewMenu_2);

        JMenu mnNewMenu_10 = new JMenu("Clanarine");
        mnNewMenu_2.add(mnNewMenu_10);

        JMenuItem mntmNewMenuItem_14 = new JMenuItem("Dodaj novu clanarinu");
    /*    mntmNewMenuItem_14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLGUnosClanarine dlg = new DLGUnosClanarine();
                dlg.setVisible(true);
            }
        });*/
        mnNewMenu_10.add(mntmNewMenuItem_14);

        JMenuItem mntmNewMenuItem_15 = new JMenuItem("Mijenjaj clanarinu");
   /*     mntmNewMenuItem_15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLGIzmjenaClanarine dlg = new DLGIzmjenaClanarine();
                dlg.setVisible(true);
            }
        });*/
        mnNewMenu_10.add(mntmNewMenuItem_15);

        JMenuItem mntmNewMenuItem_16 = new JMenuItem("Obrisi clanarinu");
    /*    mntmNewMenuItem_16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLGBrisanjeClanarine dlg = new DLGBrisanjeClanarine();
                dlg.setVisible(true);
            }
        });*/
        mnNewMenu_10.add(mntmNewMenuItem_16);

        JMenu mnNewMenu_11 = new JMenu("Clanovi");
        mnNewMenu_2.add(mnNewMenu_11);

        JMenuItem mntmNewMenuItem_17 = new JMenuItem("Dodaj novog clana");
        mntmNewMenuItem_17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLG_Unos_Korisnik dlg = new DLG_Unos_Korisnik();
                dlg.setVisible(true);
            }
        });
        mnNewMenu_11.add(mntmNewMenuItem_17);

        JMenuItem mntmNewMenuItem_18 = new JMenuItem("Mijenjaj clana");
        mntmNewMenuItem_18.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLG_Izmjena_Korisnik dlg = new DLG_Izmjena_Korisnik();
                dlg.setVisible(true);
            }
        });
        mnNewMenu_11.add(mntmNewMenuItem_18);

        JMenuItem mntmNewMenuItem_19 = new JMenuItem("Obrisi clana");
        mntmNewMenuItem_19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLG_Brisanje_Korisnik dlg = new DLG_Brisanje_Korisnik();
                dlg.setVisible(true);
            }
        });
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
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton deleteButton = new JButton("Izmijeni");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmation = JOptionPane.showConfirmDialog(null, "Želite li ažurirati ovaj teren?", "Da", JOptionPane.OK_CANCEL_OPTION);
                if (confirmation == JOptionPane.OK_OPTION) {
                    updateSelectedTeren();
                }
            }
        });
        deleteButton.setActionCommand("Delete");
        buttonPane.add(deleteButton);
        getRootPane().setDefaultButton(deleteButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);

        populateComboBoxTerenSifra();

        comboBoxTerenSifre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateFields();
            }
        });
    }

    private void populateComboBoxTerenSifra() {
        tereni = fetchTereniFromDatabase();
        String[] TereniSifre = new String[tereni.length];
        for (int i = 0; i < tereni.length; i++) {
            TereniSifre[i] = tereni[i][0];
        }
        comboBoxTerenSifre.setModel(new DefaultComboBoxModel<>(TereniSifre));
    }

    private String[][] fetchTereniFromDatabase() {
        String[][] tereni = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" + "user=zdebeljuh&password=11");

            String countSql = "SELECT COUNT(*) AS total FROM RDA_proj_Teren";
            PreparedStatement countStmt = conn.prepareStatement(countSql);
            ResultSet countRs = countStmt.executeQuery();
            int totalTereni = 0;
            if (countRs.next()) {
                totalTereni = countRs.getInt("total");
            }

            tereni = new String[totalTereni][2];

            String sql = "SELECT teren_sifra, teren_naziv FROM RDA_proj_Teren";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            int index = 0;
            while (rs.next()) {
                tereni[index][0] = rs.getString("teren_sifra");
                tereni[index][1] = rs.getString("teren_naziv");
                index++;
            }

            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
        return tereni;
    }

    private void updateFields() {
        int selectedIndex = comboBoxTerenSifre.getSelectedIndex();
        if (selectedIndex < 0) return;

        String selectedSifra = tereni[selectedIndex][0];
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" + "user=zdebeljuh&password=11");

            String sql = "SELECT teren_naziv, teren_namjena, teren_max_kapacitet FROM RDA_proj_Teren WHERE teren_sifra = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, selectedSifra);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                textFieldTerenNaziv.setText(rs.getString("teren_naziv"));
                textFieldTerenNamjena.setText(rs.getString("teren_namjena"));
                textFieldTerenKapacitet.setText(rs.getString("teren_max_kapacitet"));
            }

            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateSelectedTeren() {
        int selectedIndex = comboBoxTerenSifre.getSelectedIndex();
        if (selectedIndex < 0) return;

        String selectedSifra = tereni[selectedIndex][0];
        String naziv = textFieldTerenNaziv.getText();
        String namjena = textFieldTerenNamjena.getText();
        String kapacitet = textFieldTerenKapacitet.getText();

        if (naziv.equals("") || namjena.equals("") || kapacitet.equals("")) {
            JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena", "Greska", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" + "user=zdebeljuh&password=11");

            String sql = "UPDATE RDA_proj_Teren SET teren_naziv = ?, teren_namjena = ?, teren_max_kapacitet = ? WHERE teren_sifra = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, naziv);
            stmt.setString(2, namjena);
            stmt.setString(3, kapacitet);
            stmt.setString(4, selectedSifra);

            stmt.execute();
            conn.close();

            JOptionPane.showMessageDialog(null, "Uspješno ste izmijenili podatke o terenu!", "Informacija", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        textFieldTerenNaziv.setText("");
        textFieldTerenNamjena.setText("");
        textFieldTerenKapacitet.setText("");
    }
}
