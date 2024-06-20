package srcefit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgUnosIzvjestajaOKorisnicima extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldGodina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgUnosIzvjestajaOKorisnicima dialog = new DlgUnosIzvjestajaOKorisnicima();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgUnosIzvjestajaOKorisnicima() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblGodina = new JLabel("Godina");
			lblGodina.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblGodina.setBounds(30, 38, 47, 20);
			contentPanel.add(lblGodina);
		}
		
		textFieldGodina = new JTextField();
		textFieldGodina.setBounds(161, 40, 96, 19);
		contentPanel.add(textFieldGodina);
		textFieldGodina.setColumns(10);
		
		JLabel lblPodaci = new JLabel("Podaci o plaćanju");
		lblPodaci.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPodaci.setBounds(30, 94, 125, 20);
		contentPanel.add(lblPodaci);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Redovito plaćanje", "Odstupanja u plaćanja", "Nagrade", "Sankcije"}));
		comboBox.setBounds(161, 95, 96, 21);
		contentPanel.add(comboBox);
		
		JLabel lblDodatneNapomene = new JLabel("Dodatne napomene");
		lblDodatneNapomene.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDodatneNapomene.setBounds(30, 166, 125, 28);
		contentPanel.add(lblDodatneNapomene);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(161, 168, 107, 28);
		contentPanel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
