package BI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.Color;

public class supprimerFrameBI {

	private JFrame frame;
	private JTextField getSearch;
	
	private Connection connection;
	private Statement statement ; 

	/**
	 * Launch the application.
	 */
	public static void supprimerFrameBI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supprimerFrameBI window = new supprimerFrameBI();
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
	public supprimerFrameBI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","BELASSAM","AKRAM");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 728, 509);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblgetNomBI = new JLabel("Donnez le nom de votre Bien Immobilier : ");
		lblgetNomBI.setForeground(new Color(47, 79, 79));
		lblgetNomBI.setFont(new Font("Montserrat", Font.BOLD, 18));
		lblgetNomBI.setBounds(162, 126, 393, 38);
		frame.getContentPane().add(lblgetNomBI);
		
		getSearch = new JTextField();
		getSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		getSearch.setBounds(237, 208, 244, 38);
		frame.getContentPane().add(getSearch);
		getSearch.setColumns(10);
		
		JButton btnRechercheBI = new JButton("SUPPRIMER\r\n");
		btnRechercheBI.setForeground(new Color(255, 255, 255));
		btnRechercheBI.setFont(new Font("Montserrat Black", Font.BOLD, 14));
		btnRechercheBI.setBorderPainted(false);
		btnRechercheBI.setBackground(new Color(220, 20, 60));
		btnRechercheBI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchBI = getSearch.getText();
				String sql = "DELETE FROM BienImmobilier BI WHERE BI.Num = '"+searchBI+"'";
				
				try {
					statement = connection.createStatement();
					statement.executeQuery(sql);
					JOptionPane.showMessageDialog(null, "le bien immobilier à été supprimé ", "DELETED!",JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "BI DOESN'T EXISTS !", "ERROR!",JOptionPane.ERROR_MESSAGE);
					
				}
				
				
				
				
			
			}
		});
		btnRechercheBI.setBounds(293, 290, 132, 49);
		frame.getContentPane().add(btnRechercheBI);
	}
}
