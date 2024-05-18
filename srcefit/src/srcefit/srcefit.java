package srcefit;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class srcefit {

	private JFrame frame;
	private JTextField textFieldk_ime;
	private JTextField textFieldlozz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					srcefit window = new srcefit();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public srcefit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBackground(new Color(102, 205, 170));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(284, 177, 69, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Korisnicko ime:");
		lblNewLabel.setBounds(44, 104, 114, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lozinka:");
		lblNewLabel_1.setBounds(44, 129, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldk_ime = new JTextField();
		textFieldk_ime.setBounds(122, 101, 231, 20);
		frame.getContentPane().add(textFieldk_ime);
		textFieldk_ime.setColumns(10);
		
		textFieldlozz = new JTextField();
		textFieldlozz.setBounds(88, 126, 265, 20);
		frame.getContentPane().add(textFieldlozz);
		textFieldlozz.setColumns(10);
		
		JButton btnNewButton_1_1 = new JButton("OK");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String k_ime=textFieldk_ime.getText();
				String lozz=textFieldlozz.getText();
				
				if (k_ime.equals("") || lozz.equals("")) {
					JOptionPane.showMessageDialog(null, "Pogrešno korisnièko ime ili lozinka", "Greška", JOptionPane.WARNING_MESSAGE);
					return;};
				System.out.println(k_ime+" "+lozz);}
		});
		btnNewButton_1_1.setBackground(new Color(102, 205, 170));
		btnNewButton_1_1.setBounds(205, 177, 69, 23);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("SRCeFIT Prijava");
		lblNewLabel_2.setBounds(142, 47, 135, 14);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
