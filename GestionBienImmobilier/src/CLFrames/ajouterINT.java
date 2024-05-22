package CLFrames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ajouterINT {

	private JFrame frame;
	private JTextField getNomINT;
	private JTextField getPrenomINT;
	private JTextField getDescriptionINT;
	private JTextField getDateINT;
	
	private Connection connection;
	private Statement statement ;


	/**
	 * Launch the application.
	 */
	public static void ajouterINT() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajouterINT window = new ajouterINT();
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
	public ajouterINT() {
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
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 728, 509);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEntrezLesInformations = new JLabel("Entrez les informations de l'interaction");
		lblEntrezLesInformations.setForeground(new Color(47, 79, 79));
		lblEntrezLesInformations.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrezLesInformations.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblEntrezLesInformations.setBounds(191, 11, 329, 20);
		frame.getContentPane().add(lblEntrezLesInformations);
		
		JLabel lblNomINT = new JLabel("Nom Client :");
		lblNomINT.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomINT.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblNomINT.setBounds(131, 94, 97, 19);
		frame.getContentPane().add(lblNomINT);
		
		JLabel lblPrenomINT = new JLabel("Prenom Client :");
		lblPrenomINT.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenomINT.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblPrenomINT.setBounds(107, 149, 121, 19);
		frame.getContentPane().add(lblPrenomINT);
		
		JLabel lblDescriptionINT = new JLabel("Description :");
		lblDescriptionINT.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescriptionINT.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblDescriptionINT.setBounds(129, 255, 99, 19);
		frame.getContentPane().add(lblDescriptionINT);
		
		getNomINT = new JTextField();
		getNomINT.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		getNomINT.setColumns(10);
		getNomINT.setBounds(257, 82, 293, 36);
		frame.getContentPane().add(getNomINT);
		
		getPrenomINT = new JTextField();
		getPrenomINT.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		getPrenomINT.setColumns(10);
		getPrenomINT.setBounds(257, 137, 293, 36);
		frame.getContentPane().add(getPrenomINT);
		
		getDescriptionINT = new JTextField();
		getDescriptionINT.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		getDescriptionINT.setColumns(10);
		getDescriptionINT.setBounds(257, 252, 379, 81);
		frame.getContentPane().add(getDescriptionINT);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFocusPainted(false);
		btnAjouter.setForeground(new Color(255, 255, 255));
		btnAjouter.setBorder(null);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				String Nom = getNomINT.getText();
				String Prenom = getPrenomINT.getText();
				String Date = getDateINT.getText();
				String Description = getDescriptionINT.getText();
			
				String sql = "INSERT INTO Interaction VALUES ('"+Nom+"', '"+Prenom+"',to_date('"+Date+"','dd-mm-yyyy'), '"+Description+"')";
				try {
					statement = connection.createStatement();
					statement.executeQuery(sql);
					JOptionPane.showMessageDialog(null, "l'interaction à été ajouté", "ADDED!",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "ERROR OCCURED ! \n make sure that the information entered is correct and no field is empty\n note : make sure that the client exists ", "ERROR!",JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
				}
				
			}
		});
		btnAjouter.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnAjouter.setBackground(new Color(0, 255, 127));
		btnAjouter.setBounds(281, 367, 150, 49);
		frame.getContentPane().add(btnAjouter);
		
		JLabel lblDateINT = new JLabel("Date :");
		lblDateINT.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateINT.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblDateINT.setBounds(183, 197, 45, 19);
		frame.getContentPane().add(lblDateINT);
		
		getDateINT = new JTextField();
		getDateINT.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		getDateINT.setColumns(10);
		getDateINT.setBounds(257, 193, 293, 36);
		frame.getContentPane().add(getDateINT);
	}

}
