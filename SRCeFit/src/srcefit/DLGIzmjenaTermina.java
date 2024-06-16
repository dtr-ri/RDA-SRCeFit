package srcefit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DLGIzmjenaTermina extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textFieldtermin_datum;
    private JComboBox<String> comboBoxtermin_redni_broj;
    private JComboBox<String> comboBoxtermin_pocetak_sati;
    private JComboBox<String> comboBoxtermin_trajanje_sati;

    public static void main(String[] args) {
        try {
            DLGIzmjenaTermina dialog = new DLGIzmjenaTermina();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DLGIzmjenaTermina() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Korisnik\\Downloads\\srcefit3.png"));
        setTitle("Izmjena Termina");
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
        comboBoxtermin_redni_broj.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedtermin_redni_broj = (String) comboBoxtermin_redni_broj.getSelectedItem();
                    populateFields(selectedtermin_redni_broj);
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

        comboBoxtermin_pocetak_sati = new JComboBox<>();
        comboBoxtermin_pocetak_sati.setModel(new DefaultComboBoxModel<>(new String[]{"18", "19", "20", "21"}));
        comboBoxtermin_pocetak_sati.setBounds(96, 131, 96, 21);
        contentPanel.add(comboBoxtermin_pocetak_sati);

        JLabel lbltermin_trajanje_sati = new JLabel("Trajanje sati");
        lbltermin_trajanje_sati.setBounds(26, 189, 71, 13);
        contentPanel.add(lbltermin_trajanje_sati);

        comboBoxtermin_trajanje_sati = new JComboBox<>();
        comboBoxtermin_trajanje_sati.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4"}));
        comboBoxtermin_trajanje_sati.setBounds(96, 186, 96, 21);
        contentPanel.add(comboBoxtermin_trajanje_sati);

        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(new Color(240, 255, 240));
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton saveButton = new JButton("Spremi");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String termin_redni_broj = (String) comboBoxtermin_redni_broj.getSelectedItem();
                String datum = textFieldtermin_datum.getText();
                //JComboBox<String> comboBoxtermin_pocetak_sati = null;
				String početakSati = (String) comboBoxtermin_pocetak_sati.getSelectedItem();
                String trajanjeSati = (String) comboBoxtermin_trajanje_sati.getSelectedItem();

                if (termin_redni_broj == null || datum.equals("") || početakSati.equals("") || trajanjeSati.equals("")) {
                    JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena", "Greška", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                    Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/zdebeljuh?" + "user=zdebeljuh&password=11");

                    String sql = "UPDATE RDA_proj_Termin SET termin_datum=?, termin_pocetak_sati=?, termin_trajanje_sati=? WHERE termin_redni_broj=?;";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, datum);
                    stmt.setString(2, početakSati);
                    stmt.setString(3, trajanjeSati);
                    stmt.setString(4, termin_redni_broj);

                    stmt.executeUpdate();
                    conn.close();

                    textFieldtermin_datum.setText("");
                    comboBoxtermin_pocetak_sati.setSelectedIndex(-1);
                    comboBoxtermin_trajanje_sati.setSelectedIndex(-1);

                    JOptionPane.showMessageDialog(null, "Termin uspješno izmijenjen", "Informacija", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        saveButton.setActionCommand("Spremi");
        buttonPane.add(saveButton);
        getRootPane().setDefaultButton(saveButton);

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
            while (rs.next()) {
                termin_redni_brojevi.add(rs.getString("termin_redni_broj"));
            }

            conn.close();

            comboBoxtermin_redni_broj.setModel(new DefaultComboBoxModel<>(termin_redni_brojevi.toArray(new String[0])));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
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
                //JComboBox<String> comboBoxtermin_pocetak_sati = null; - brisati
				comboBoxtermin_pocetak_sati.setSelectedItem(rs.getString("Početak sati"));
                comboBoxtermin_trajanje_sati.setSelectedItem(rs.getString("TrajanjeSati"));
            }

            conn.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }
}
