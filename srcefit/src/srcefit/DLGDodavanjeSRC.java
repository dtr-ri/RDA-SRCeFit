package srcefit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DLGDodavanjeSRC extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNoviSRC;
	private JTextField textFieldAdresa;
	private JTextField textFieldOpisSRC;
	private JComboBox comboBoxAktivnosti;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLGDodavanjeSRC dialog = new DLGDodavanjeSRC();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLGDodavanjeSRC() {
		
		/*
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Korisnik\\Downloads\\srcefit3.png"));
		*/
		
		setTitle("SRCeFIT");
		setBounds(100, 100, 611, 398);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 240));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Naziv novog Sportsko-rekreacijskog centra");
		lblNewLabel.setBounds(10, 46, 289, 14);
		contentPanel.add(lblNewLabel);
		
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
		lblNewLabel_2.setBounds(10, 116, 253, 14);
		contentPanel.add(lblNewLabel_2);
		
		JComboBox<?> comboBoxAktivnosti = new JComboBox();
		comboBoxAktivnosti.setModel(new DefaultComboBoxModel(new String[] {"odabrati aktivnost/sport", "mali nogomet", "kosarka", "squash", "odbojka", "tenis"}));
		comboBoxAktivnosti.setBounds(273, 112, 176, 22);
		contentPanel.add(comboBoxAktivnosti);
		
		JLabel lblNewLabel_3 = new JLabel("Kratak tektualni opis novog SRC-a");
		lblNewLabel_3.setBounds(10, 152, 207, 14);
		contentPanel.add(lblNewLabel_3);
		
		textFieldOpisSRC = new JTextField();
		textFieldOpisSRC.setBounds(227, 147, 272, 62);
		contentPanel.add(textFieldOpisSRC);
		textFieldOpisSRC.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 595, 22);
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
		mnNewMenu_6.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Mijenjaj postojesi SRC");
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
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String centar=textFieldNoviSRC.getText();
						String lokacija=textFieldAdresa.getText();
						String sport=(String) comboBoxAktivnosti.getSelectedItem();
						String opis=textFieldOpisSRC.getText();
						
						if (centar.equals("") || lokacija.equals("") || opis.equals("")) {
							JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena", "Greška", JOptionPane.WARNING_MESSAGE);
							return;};
						System.out.println(centar+" "+lokacija+" "+sport+" "+opis+" ");
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
					dispose();}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
