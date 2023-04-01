package RegistrationFrom;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class rf1 {

	private JFrame frame;
	private JTextField s1;
	private JTextField n1;
	private JTextField e1;
	private JTextField m1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rf1 window = new rf1();
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
	public rf1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("null")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 785, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 34));
		lblNewLabel.setBounds(180, 38, 359, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sno");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 21));
		lblNewLabel_1.setBounds(98, 144, 72, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 21));
		lblNewLabel_1_1.setBounds(98, 217, 72, 30);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 21));
		lblNewLabel_1_2.setBounds(98, 300, 72, 30);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Marks");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 21));
		lblNewLabel_1_3.setBounds(98, 371, 72, 30);
		frame.getContentPane().add(lblNewLabel_1_3);
		
//		Container btnNewButton = new JButton("Submit"); ;
//		btnNewButton.setFont(new Font("Arial", Font.BOLD, 22));
//		btnNewButton.setBounds(318, 455, 121, 23);
//		frame.getContentPane().add(btnNewButton);
//		
		s1 = new JTextField();
		s1.setBounds(263, 147, 131, 30);
		frame.getContentPane().add(s1);
		s1.setColumns(10);
		
		n1 = new JTextField();
		n1.setColumns(10);
		n1.setBounds(263, 225, 131, 30);
		frame.getContentPane().add(n1);
		
		e1 = new JTextField();
		e1.setColumns(10);
		e1.setBounds(263, 308, 131, 30);
		frame.getContentPane().add(e1);
		
		m1 = new JTextField();
		m1.setColumns(10);
		m1.setBounds(263, 379, 131, 30);
		frame.getContentPane().add(m1);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=s1.getText();
				int sno=Integer.parseInt(s);
				String name=n1.getText();
				String email=e1.getText();
				String m=m1.getText();
				float marks=Float.parseFloat(m);
				 
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rf1","root","mrec");
					String q="Insert into regform values('"+sno+"','"+name+"','"+email+"','"+marks+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton_1, "DONE!");
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(194, 470, 99, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}		
}
