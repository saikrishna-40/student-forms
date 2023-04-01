package RegistrationFrom;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class access {

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					access window = new access();
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
	public access() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 834, 675);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Sno   :");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel.setBounds(143, 96, 95, 38);
		frame.getContentPane().add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setBounds(276, 96, 112, 41);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(269, 307, 119, 38);
		frame.getContentPane().add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(269, 379, 119, 38);
		frame.getContentPane().add(t3);
		JButton btnNewButton = new JButton("Click");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1=t1.getText();
				int s=Integer.parseInt(s1);
				
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rf1","root","mrec");
					String q="select name1,marks from regform where sno=?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setInt(1, s);
					ResultSet rs=ps.executeQuery();
					rs.next();
					t2.setText(rs.getString(1));
					t3.setText(""+rs.getFloat(2));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBounds(407, 213, 112, 38);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Name  :");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(127, 304, 84, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Marks :");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(127, 387, 84, 30);
		frame.getContentPane().add(lblNewLabel_1_1);
	
		
		JLabel lblNewLabel_2 = new JLabel("Access form");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 35));
		lblNewLabel_2.setBounds(253, 24, 266, 38);
		frame.getContentPane().add(lblNewLabel_2);
	}

}
