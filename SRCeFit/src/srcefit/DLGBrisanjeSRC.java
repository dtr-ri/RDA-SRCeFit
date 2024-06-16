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

public class DLGBrisanjeSRC extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JComboBox<String> comboBoxCentarSifra;
    private JTextField textFieldNoviSRC;
    private JTextField textFieldAdresa;
    private JTextField textFieldTel;
    private JTextField textFieldEmail;
    private JTextField textFieldDatumUnosa;
    private JTextField textFieldOpisSRC;
    private JComboBox<String> comboBoxAktivnosti;
    private String[][] centri;

    public static void main(String[] args) {
        try {
            DLGBrisanjeSRC dialog = new DLGBrisanjeSRC();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DLGBrisanjeSRC() {
        setTitle("SRCeFIT");
        setBounds(100, 100, 663, 479);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(240, 255, 240));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Šifra SRC-a ");
        lblNewLabel.setBounds(10, 11, 105, 14);
        contentPanel.add(lblNewLabel);

        comboBoxCentarSifra = new JComboBox<>();
        comboBoxCentarSifra.setBounds(88, 7, 211, 20);
        contentPanel.add(comboBoxCentarSifra);

        JLabel lblNewLabel_4 = new JLabel("Naziv novog Sportsko-rekreacijskog centra");
        lblNewLabel_4.setBounds(10, 46, 289, 14);
        contentPanel.add(lblNewLabel_4);

        textFieldNoviSRC = new JTextField();
        textFieldNoviSRC.setBounds(320, 43, 211, 20);
        contentPanel.add(textFieldNoviSRC);
        textFieldNoviSRC.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Adresa");
        lblNewLabel_1.setBounds(10, 82, 68, 14);
        contentPanel.add(lblNewLabel_1);

        textFieldAdresa = new JTextField();
        textFieldAdresa.setBounds(88, 79, 211, 20);
        contentPanel.add(textFieldAdresa);
        textFieldAdresa.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Aktivnosti/sportovi u ponudi novog SRC-a");
        lblNewLabel_2.setBounds(10, 191, 253, 14);
        contentPanel.add(lblNewLabel_2);

        comboBoxAktivnosti = new JComboBox<>();
        comboBoxAktivnosti.setBounds(248, 187, 176, 22);
        contentPanel.add(comboBoxAktivnosti);

        JLabel lblNewLabel_3 = new JLabel("Kratak tektualni opis novog SRC-a");
        lblNewLabel_3.setBounds(10, 240, 207, 14);
        contentPanel.add(lblNewLabel_3);

        JLabel lblNewLabel_tel = new JLabel("Telefon");
        lblNewLabel_tel.setBounds(10, 110, 46, 14);
        contentPanel.add(lblNewLabel_tel);

        textFieldTel = new JTextField();
        textFieldTel.setBounds(88, 110, 211, 20);
        contentPanel.add(textFieldTel);
        textFieldTel.setColumns(10);

        JLabel lblNewLabel_email = new JLabel("Email");
        lblNewLabel_email.setBounds(10, 148, 46, 14);
        contentPanel.add(lblNewLabel_email);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(88, 145, 211, 20);
        contentPanel.add(textFieldEmail);
        textFieldEmail.setColumns(10);

        JLabel lblNewLabel_datumUnosa = new JLabel("Datum unosa");
        lblNewLabel_datumUnosa.setBounds(10, 301, 76, 14);
        contentPanel.add(lblNewLabel_datumUnosa);

        textFieldDatumUnosa = new JTextField();
        textFieldDatumUnosa.setBounds(88, 298, 151, 20);
        contentPanel.add(textFieldDatumUnosa);
        textFieldDatumUnosa.setColumns(10);

        textFieldOpisSRC = new JTextField();
        textFieldOpisSRC.setBounds(10, 265, 521, 20);
        contentPanel.add(textFieldOpisSRC);
        textFieldOpisSRC.setColumns(10);

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
        mntmNewMenuItem_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLGDodavanjeSRC dlg = new DLGDodavanjeSRC();
                dlg.setVisible(true);
            }
        });
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
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLGTermini dlg = new DLGTermini();
                dlg.setVisible(true);
            }
        });
        mnNewMenu_9.add(mntmNewMenuItem_3);

        JMenuItem mntmNewMenuItem_5 = new JMenuItem("Mijenjaj termin");
        mntmNewMenuItem_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DLGIzmjenaTermina dlg = new DLGIzmjenaTermina();
                dlg.setVisible(true);
            }
        });
        mnNewMenu_9.add(mntmNewMenuItem_5);

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

        JMenuItem mntmNewMenuItem_22 = new JMenuItem("Dodijeli posebnu pogodnost clanu");
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

        JButton deleteButton = new JButton("Obrisati");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmation = JOptionPane.showConfirmDialog(null, "Želite li obrisati odabrani SRC?", "Potvrda brisanja", JOptionPane.OK_CANCEL_OPTION);
                if (confirmation == JOptionPane.OK_OPTION) {
                    deleteSelectedCentar();
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

        populateComboBoxCentarSifra();
        populateComboBoxAktivnosti();

        comboBoxCentarSifra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateFields();
            }
        });
    }

    private void populateComboBoxCentarSifra() {
        centri = fetchCentriFromDatabase();
        String[] centarNazivi = new String[centri.length];
        for (int i = 0; i < centri.length; i++) {
            centarNazivi[i] = centri[i][1];
        }
        comboBoxCentarSifra.setModel(new DefaultComboBoxModel<>(centarNazivi));
    }

    private String[][] fetchCentriFromDatabase() {
        String[][] centri = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" + "user=zdebeljuh&password=11");

            String countSql = "SELECT COUNT(*) AS total FROM RDA_proj_SRCentar";
            PreparedStatement countStmt = conn.prepareStatement(countSql);
            ResultSet countRs = countStmt.executeQuery();
            int totalCentri = 0;
            if (countRs.next()) {
                totalCentri = countRs.getInt("total");
            }

            centri = new String[totalCentri][2];

            String sql = "SELECT centar_sifra, centar_naziv FROM RDA_proj_SRCentar";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            int index = 0;
            while (rs.next()) {
                centri[index][0] = rs.getString("centar_sifra");
                centri[index][1] = rs.getString("centar_naziv");
                index++;
            }

            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
        return centri;
    }

    private void updateFields() {
        int selectedIndex = comboBoxCentarSifra.getSelectedIndex();
        if (selectedIndex < 0) return;

        String selectedSifra = centri[selectedIndex][0];
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" + "user=zdebeljuh&password=11");

            String sql = "SELECT centar_naziv, centar_adresa, centar_tel, centar_email, aktivnost_sifra, centar_opis, centar_datum_unosa FROM RDA_proj_SRCentar WHERE centar_sifra = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, selectedSifra);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                textFieldNoviSRC.setText(rs.getString("centar_naziv"));
                textFieldAdresa.setText(rs.getString("centar_adresa"));
                textFieldTel.setText(rs.getString("centar_tel"));
                textFieldEmail.setText(rs.getString("centar_email"));
                textFieldOpisSRC.setText(rs.getString("centar_opis"));
                textFieldDatumUnosa.setText(rs.getString("centar_datum_unosa"));
                int aktivnostIndex = getAktivnostIndex(rs.getString("aktivnost_sifra"));
                comboBoxAktivnosti.setSelectedIndex(aktivnostIndex);
            }

            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int getAktivnostIndex(String aktivnostSifra) {
        String[][] aktivnosti = fetchActivitiesFromDatabase();
        for (int i = 0; i < aktivnosti.length; i++) {
            if (aktivnosti[i][0].equals(aktivnostSifra)) {
                return i;
            }
        }
        return -1;
    }

    private void populateComboBoxAktivnosti() {
        String[][] aktivnosti = fetchActivitiesFromDatabase();
        String[] aktivnostiNaziv = new String[aktivnosti.length];
        for (int i = 0; i < aktivnosti.length; i++) {
            aktivnostiNaziv[i] = aktivnosti[i][1];
        }
        comboBoxAktivnosti.setModel(new DefaultComboBoxModel<>(aktivnostiNaziv));
    }

    private String[][] fetchActivitiesFromDatabase() {
        String[][] aktivnosti = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" + "user=zdebeljuh&password=11");

            String countSql = "SELECT COUNT(*) AS total FROM RDA_proj_Aktivnost";
            PreparedStatement countStmt = conn.prepareStatement(countSql);
            ResultSet countRs = countStmt.executeQuery();
            int totalAktivnosti = 0;
            if (countRs.next()) {
                totalAktivnosti = countRs.getInt("total");
            }

            aktivnosti = new String[totalAktivnosti][2];

            String sql = "SELECT aktivnost_sifra, aktivnost_naziv FROM RDA_proj_Aktivnost";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            int index = 0;
            while (rs.next()) {
                aktivnosti[index][0] = rs.getString("aktivnost_sifra");
                aktivnosti[index][1] = rs.getString("aktivnost_naziv");
                index++;
            }

            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
        return aktivnosti;
    }

    private void deleteSelectedCentar() {
        int selectedIndex = comboBoxCentarSifra.getSelectedIndex();
        if (selectedIndex < 0) return;

        String selectedSifra = centri[selectedIndex][0];
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" + "user=zdebeljuh&password=11");

            String sql = "DELETE FROM RDA_proj_SRCentar WHERE centar_sifra = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, selectedSifra);
            stmt.executeUpdate();

            conn.close();

            JOptionPane.showMessageDialog(null, "SRC je uspješno obrisan!", "Informacija", JOptionPane.INFORMATION_MESSAGE);
            populateComboBoxCentarSifra();
            clearFields();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        textFieldNoviSRC.setText("");
        textFieldAdresa.setText("");
        textFieldTel.setText("");
        textFieldEmail.setText("");
        textFieldOpisSRC.setText("");
        textFieldDatumUnosa.setText("");
        comboBoxAktivnosti.setSelectedIndex(-1);
    }
}
