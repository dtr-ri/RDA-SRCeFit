package srcefit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class DlgUnosClanarina extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField textFieldSifra;
    private JTextField textFieldNaziv;

    public static void main(String[] args) {
        try {
            DlgUnosClanarina dialog = new DlgUnosClanarina();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DlgUnosClanarina() {
        setBounds(100, 100, 450, 300);
        setBackground(new Color(255, 255, 255));
        setTitle("SRCeFIT Unos članarina");
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblNewLabelSifra = new JLabel("Šifra");
        lblNewLabelSifra.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabelSifra.setBounds(29, 35, 30, 22);
        contentPanel.add(lblNewLabelSifra);

        textFieldSifra = new JTextField();
        textFieldSifra.setBounds(128, 38, 96, 19);
        contentPanel.add(textFieldSifra);
        textFieldSifra.setColumns(10);

        JLabel lblNewLabelNaziv = new JLabel("Naziv");
        lblNewLabelNaziv.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabelNaziv.setBounds(29, 78, 90, 22);
        contentPanel.add(lblNewLabelNaziv);

        textFieldNaziv = new JTextField();
        textFieldNaziv.setBounds(128, 81, 96, 19);
        contentPanel.add(textFieldNaziv);
        textFieldNaziv.setColumns(10);

        JLabel lblNewLabelOpis = new JLabel("Opis");
        lblNewLabelOpis.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabelOpis.setBounds(29, 142, 90, 22);
        contentPanel.add(lblNewLabelOpis);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(128, 142, 96, 31);
        contentPanel.add(scrollPane);

        JTextArea textAreaOpis = new JTextArea();
        scrollPane.setViewportView(textAreaOpis);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String clanarinaSifraStr = textFieldSifra.getText();
                String clanarinaNaziv = textFieldNaziv.getText();
                String clanarinaOpis = textAreaOpis.getText();

                if (clanarinaSifraStr.equals("") || clanarinaNaziv.equals("") || clanarinaOpis.equals("")) {
                    JOptionPane.showMessageDialog(null, "Nisu uneseni svi obavezni podaci", "Greška", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int clanarinaSifra = Integer.parseInt(clanarinaSifraStr);

                    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                    try (Connection conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/dtrbovic?user=dtrbovic&password=11");
                         PreparedStatement stmt = conn.prepareStatement("INSERT INTO RDA_proj_Clanarina (clanarina_sifra, clanarina_naziv, clanarina_opis) VALUES (?, ?, ?)")) {
                        stmt.setInt(1, clanarinaSifra);
                        stmt.setString(2, clanarinaNaziv);
                        stmt.setString(3, clanarinaOpis);
                        stmt.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Članarina je uspješno dodana", "Obavijest", JOptionPane.INFORMATION_MESSAGE);

                        textFieldSifra.setText("");
                        textFieldNaziv.setText("");
                        textAreaOpis.setText("");
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Šifra mora biti cijeli broj", "Greška", JOptionPane.WARNING_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Došlo je do greške prilikom dodavanja članarine: " + ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
                }
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