package BI;
import java.awt.EventQueue;

import java.sql.*;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;

public class ajoutFrameBI{

	private JFrame frame;
	private JTextField getNom;
	private JTextField getType;
	private JTextField getSurface;
	private JTextField getLocalisation;
	private JTextField getDescription;
	private Connection connection;
	private Statement statement ;
	private JTextField getPrix;

	


	/**
	 * Launch the application.
	 */
	public static void ajoutFrameBI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajoutFrameBI window = new ajoutFrameBI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public ajoutFrameBI(){
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
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
		
		JLabel lblNewLabel = new JLabel("ENTREZ LES INFORMATIONS DE BI ");
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblNewLabel.setBounds(207, 11, 298, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNum = new JLabel("Num :");
		lblNum.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblNum.setBounds(165, 88, 46, 14);
		frame.getContentPane().add(lblNum);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblType.setBounds(165, 139, 46, 14);
		frame.getContentPane().add(lblType);
		
		JLabel lblTaille = new JLabel("Surface :");
		lblTaille.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblTaille.setBounds(141, 190, 70, 14);
		frame.getContentPane().add(lblTaille);
		
		JLabel lblLocalisation = new JLabel("Localisation :");
		lblLocalisation.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblLocalisation.setBounds(107, 241, 104, 14);
		frame.getContentPane().add(lblLocalisation);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblDescription.setBounds(111, 343, 100, 14);
		frame.getContentPane().add(lblDescription);
		
		getNom = new JTextField();
		getNom.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getNom.setBounds(225, 77, 326, 34);
		frame.getContentPane().add(getNom);
		getNom.setColumns(10);
		
		getType = new JTextField();
		getType.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getType.setColumns(10);
		getType.setBounds(225, 129, 326, 34);
		frame.getContentPane().add(getType);
		
		getSurface = new JTextField();
		getSurface.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getSurface.setColumns(10);
		getSurface.setBounds(225, 181, 326, 34);
		frame.getContentPane().add(getSurface);
		
		getLocalisation = new JTextField();
		getLocalisation.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getLocalisation.setColumns(10);
		getLocalisation.setBounds(225, 233, 326, 34);
		frame.getContentPane().add(getLocalisation);
		
		getDescription = new JTextField();
		getDescription.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getDescription.setColumns(10);
		getDescription.setBounds(225, 337, 326, 34);
		frame.getContentPane().add(getDescription);
		
		
		

		
		
		
		
		
		
		JButton btnAjouterBI = new JButton("AJOUTER\r\n");
		btnAjouterBI.setForeground(new Color(255, 255, 255));
		btnAjouterBI.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnAjouterBI.setBorder(null);
		btnAjouterBI.setBackground(new Color(0, 255, 127));
		btnAjouterBI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String NomBI = getNom.getText();
				String TypeBI = getType.getText();
				String SurfaceBI = getSurface.getText();
				String PrixBI = getPrix.getText();
				String LocalisationBI = getLocalisation.getText();
				String DescBI = getDescription.getText();
			
				String sql = "INSERT INTO BienImmobilier VALUES ('"+NomBI+"', '"+TypeBI+"', '"+SurfaceBI+"', '"+LocalisationBI+"','"+PrixBI+"','"+DescBI+"')";
				try {
					statement = connection.createStatement();
					statement.executeQuery(sql);
					JOptionPane.showMessageDialog(null, "le bien immobilier à été ajouté", "ADDED!",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "ERROR OCCURED ! \n make sure that the information entered is correct and no field is empty\n", "ERROR!",JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
				}
				

			
			}
		});
		btnAjouterBI.setBounds(295, 403, 122, 41);
		frame.getContentPane().add(btnAjouterBI);
		
		JLabel lblPrix = new JLabel("Prix :");
		lblPrix.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblPrix.setBounds(165, 292, 46, 14);
		frame.getContentPane().add(lblPrix);
		
		getPrix = new JTextField();
		getPrix.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getPrix.setColumns(10);
		getPrix.setBounds(225, 285, 326, 34);
		frame.getContentPane().add(getPrix);
	}
}
