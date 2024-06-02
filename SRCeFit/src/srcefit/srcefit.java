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
import javax.swing.JPasswordField;

public class srcefit {

	private JFrame frame;
	private JTextField textFieldk_ime;
	private JPasswordField passwordField;

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
		frame.setBounds(100, 100, 480, 316);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBackground(new Color(102, 205, 170));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(304, 218, 118, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Korisnicko ime:");
		lblNewLabel.setBounds(47, 112, 176, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lozinka:");
		lblNewLabel_1.setBounds(47, 163, 90, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFieldk_ime = new JTextField();
		textFieldk_ime.setBounds(191, 108, 231, 23);
		frame.getContentPane().add(textFieldk_ime);
		textFieldk_ime.setColumns(10);
		
		JButton btnNewButton_1_1 = new JButton("OK");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String k_ime=textFieldk_ime.getText();
				String lozz=new String(passwordField.getPassword());
				
				if (k_ime.equals("") || lozz.equals("")) {
					JOptionPane.showMessageDialog(null, "Pogresno korisnicko ime ili lozinka", "Greska", JOptionPane.WARNING_MESSAGE);
					return;};
				System.out.println(k_ime+" "+lozz);
				
				DLGprazanprozor dlg = new DLGprazanprozor();
					dlg.setVisible(true);}});
				
				
		btnNewButton_1_1.setBackground(new Color(102, 205, 170));
		btnNewButton_1_1.setBounds(176, 218, 118, 23);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("SRCeFIT Prijava");
		lblNewLabel_2.setBounds(142, 47, 135, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(147, 159, 275, 23);
		frame.getContentPane().add(passwordField);
	}
}
