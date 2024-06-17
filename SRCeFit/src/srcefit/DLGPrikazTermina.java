package srcefit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class DLGPrikazTermina extends JDialog {

    private JTable table;
    private DefaultTableModel model;

    public static void main(String[] args) {
        try {
            DLGPrikazTermina dialog = new DLGPrikazTermina();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DLGPrikazTermina() {
        setTitle("Prikaz Termina");
        setBounds(100, 100, 800, 600);
        getContentPane().setLayout(new BorderLayout());

        // Panel za gumb
        JPanel buttonPanel = new JPanel();
        JButton exitButton = new JButton("Izađi");
        buttonPanel.add(exitButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Panel za tablicu
        JPanel tablePanel = new JPanel(new BorderLayout());
        model = new DefaultTableModel();
        table = new JTable(model);

        // Postavljanje naslova tablice
        Vector<String> header = new Vector<>();
        header.add("Redni Broj");
        header.add("Datum");
        header.add("Početak Sati");
        header.add("Trajanje Sati");
        model.setColumnIdentifiers(header);

        // JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(tablePanel, BorderLayout.CENTER);

        //izlaz
        exitButton.addActionListener(e -> dispose());

        // Pozivanje metode za popunjavanje tablice
        populateTable();
    }

    private void populateTable() {
        // spoj na bazu za probu ovako
        String url = "jdbc:mysql://ucka.veleri.hr/zdebeljuh";
        String user = "zdebeljuh";
        String password = "11";
        String sql = "SELECT termin_redni_broj, termin_datum, termin_pocetak_sati, termin_trajanje_sati FROM RDA_proj_Termin";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            // Popunjavanje iz ResultSeta
            while (rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(rs.getString("termin_redni_broj"));
                row.add(rs.getString("termin_datum"));
                row.add(rs.getString("termin_pocetak_sati"));
                row.add(rs.getString("termin_trajanje_sati"));
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Greška pri dohvatu podataka: " + e.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }
}
