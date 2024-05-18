package srcefit;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class DlgAgrKorisnikNaAktivnosti extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAgrKorisnikNaAktivnosti dialog = new DlgAgrKorisnikNaAktivnosti();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAgrKorisnikNaAktivnosti() {
		setBounds(100, 100, 446, 215);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JComboBox comboBox_korisnik_clanski_broj = new JComboBox();
		comboBox_korisnik_clanski_broj.setBounds(177, 11, 225, 22);
		contentPanel.add(comboBox_korisnik_clanski_broj);
		
		JComboBox comboBox_aktivnost_sifra = new JComboBox();
		comboBox_aktivnost_sifra.setBounds(177, 44, 225, 22);
		contentPanel.add(comboBox_aktivnost_sifra);
		
		JLabel korisnik_clanski_broj = new JLabel("korisnik_clanski_broj");
		korisnik_clanski_broj.setBounds(10, 15, 145, 14);
		contentPanel.add(korisnik_clanski_broj);
		
		JLabel aktivnost_sifra = new JLabel("aktivnost_sifra -2zaprobu");
		aktivnost_sifra.setBounds(10, 48, 145, 14);
		contentPanel.add(aktivnost_sifra);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
