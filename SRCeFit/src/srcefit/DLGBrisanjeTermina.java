package srcefit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DLGBrisanjeTermina extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JComboBox<String> comboBoxtermin_redni_broj;
    private JTextField textFieldtermin_datum;
    private JTextField textFieldtermin_pocetak_sati;
    private JTextField textFieldtermin_trajanje_sati;

    public static void main(String[] args) {
        try {
            DLGBrisanjeTermina dialog = new DLGBrisanjeTermina();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DLGBrisanjeTermina() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Korisnik\\Downloads\\srcefit3.png"));
        setTitle("Brisanje Termina");
        setBounds(100, 100, 553, 373);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(240, 255, 240));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lbltermin_redni_broj = new JLabel("Redni Broj");
        lbltermin_redni_broj.setBounds(26, 34, 84, 21);
        contentPanel.add(lbltermin_redni_broj);

        comboBoxtermin_redni_broj = new JComboBox<>();
        comboBoxtermin_redni_broj.setBounds(96, 36, 96, 21);
        comboBoxtermin_redni_broj.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedRedniBroj = (String) comboBoxtermin_redni_broj.getSelectedItem();
                if (selectedRedniBroj != null) {
                    // Pozivamo metodu za popunjavanje polja na osnovu odabranog rednog broja
                    populateFields(selectedRedniBroj);
                }
            }
        });
        contentPanel.add(comboBoxtermin_redni_broj);

        JLabel lbltermin_datum = new JLabel("Datum");
        lbltermin_datum.setBounds(26, 88, 45, 13);
        contentPanel.add(lbltermin_datum);

        textFieldtermin_datum = new JTextField();
        textFieldtermin_datum.setBounds(96, 85, 90, 19);
        contentPanel.add(textFieldtermin_datum);
        textFieldtermin_datum.setColumns(10);

        JLabel lbltermin_pocetak_sati = new JLabel("Početak sati");
        lbltermin_pocetak_sati.setBounds(26, 134, 71, 13);
        contentPanel.add(lbltermin_pocetak_sati);

        textFieldtermin_pocetak_sati = new JTextField();
        textFieldtermin_pocetak_sati.setBounds(96, 131, 90, 19);
        contentPanel.add(textFieldtermin_pocetak_sati);
        textFieldtermin_pocetak_sati.setColumns(10);

        JLabel lbltermin_trajanje_sati = new JLabel("Trajanje sati");
        lbltermin_trajanje_sati.setBounds(26, 189, 71, 13);
        contentPanel.add(lbltermin_trajanje_sati);

        textFieldtermin_trajanje_sati = new JTextField();
        textFieldtermin_trajanje_sati.setBounds(96, 186, 90, 19);
        contentPanel.add(textFieldtermin_trajanje_sati);
        textFieldtermin_trajanje_sati.setColumns(10);

        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(new Color(240, 255, 240));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton deleteButton = new JButton("Obrisi");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String termin_redni_broj = (String) comboBoxtermin_redni_broj.getSelectedItem();
                if (termin_redni_broj == null) {
                    JOptionPane.showMessageDialog(null, "Nije odabran termin za brisanje", "Greška", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(null, "Jeste li sigurni da želite obrisati odabrani termin?",
                        "Potvrda brisanja", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    deleteTermin(termin_redni_broj);
                }
            }
        });
        deleteButton.setActionCommand("Obrisi");
        buttonPane.add(deleteButton);
        getRootPane().setDefaultButton(deleteButton);

        JButton cancelButton = new JButton("Odustani");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cancelButton.setActionCommand("Odustani");
        buttonPane.add(cancelButton);

        populateComboBox();
    }

    private void populateComboBox() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" + "user=zdebeljuh&password=11");

            String sql = "SELECT termin_redni_broj FROM RDA_proj_Termin";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            ArrayList<String> termin_redni_brojevi = new ArrayList<>();
            
             // Dodavanje elementa "Odaberi" u ComboBox
            termin_redni_brojevi.add("Odaberi");
            
            //dodavanje brojeva iz baze
            while (rs.next()) {
                termin_redni_brojevi.add(rs.getString("termin_redni_broj"));
            }

            conn.close();

            comboBoxtermin_redni_broj.setModel(new DefaultComboBoxModel<>(termin_redni_brojevi.toArray(new String[0])));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);  }  
            }

    private void populateFields(String termin_redni_broj) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" + "user=zdebeljuh&password=11");

            String sql = "SELECT termin_datum, termin_pocetak_sati, termin_trajanje_sati FROM RDA_proj_Termin WHERE termin_redni_broj=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, termin_redni_broj);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                textFieldtermin_datum.setText(rs.getString("termin_datum"));
                textFieldtermin_pocetak_sati.setText(rs.getString("termin_pocetak_sati"));
                textFieldtermin_trajanje_sati.setText(rs.getString("termin_trajanje_sati"));
            } else {
                // Ako ne postoji termin s odabranim rednim brojem, očisti polja ili obavijesti korisnika
                textFieldtermin_datum.setText("");
                textFieldtermin_pocetak_sati.setText("");
                textFieldtermin_trajanje_sati.setText("");
                JOptionPane.showMessageDialog(null, "Nije pronađen termin s odabranim rednim brojem", "Greška", JOptionPane.ERROR_MESSAGE);
            }

            conn.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteTermin(String termin_redni_broj) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" + "user=zdebeljuh&password=11");

            String sql = "DELETE FROM RDA_proj_Termin WHERE termin_redni_broj=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, termin_redni_broj);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Termin uspješno obrisan", "Informacija", JOptionPane.INFORMATION_MESSAGE);
                populateComboBox(); // Ažuriraj ComboBox nakon brisanja
                // Nakon brisanja, očisti polja
                textFieldtermin_datum.setText("");
                textFieldtermin_pocetak_sati.setText("");
                textFieldtermin_trajanje_sati.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Nije moguće obrisati termin", "Greška", JOptionPane.ERROR_MESSAGE);
            }

            conn.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }
}
