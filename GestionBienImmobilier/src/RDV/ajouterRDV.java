package RDV;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ajouterRDV {

	private JFrame frame;
	private JTextField getNomCL;
	private JTextField getPrenomCL;
	private JTextField getDate;
	private JTextField getDesc;
	private Connection connection;
	private Statement statement ; 

	/**
	 * Launch the application.
	 */
	public static void ajouterRDV() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajouterRDV window = new ajouterRDV();
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
	public ajouterRDV() {
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
		
		JLabel lblNewLabel = new JLabel("Entrez les informations du RDV");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblNewLabel.setBounds(233, 11, 298, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNum = new JLabel("Nom de client :");
		lblNum.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblNum.setBounds(88, 87, 118, 19);
		frame.getContentPane().add(lblNum);
		
		getNomCL = new JTextField();
		getNomCL.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getNomCL.setColumns(10);
		getNomCL.setBounds(215, 79, 326, 34);
		frame.getContentPane().add(getNomCL);
		
		JLabel lblType = new JLabel("Prenom de client :");
		lblType.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblType.setBounds(64, 150, 142, 19);
		frame.getContentPane().add(lblType);
		
		getPrenomCL = new JTextField();
		getPrenomCL.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getPrenomCL.setColumns(10);
		getPrenomCL.setBounds(215, 142, 326, 34);
		frame.getContentPane().add(getPrenomCL);
		
		JLabel lblTaille = new JLabel("Date :");
		lblTaille.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblTaille.setBounds(161, 217, 45, 19);
		frame.getContentPane().add(lblTaille);
		
		getDate = new JTextField();
		getDate.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getDate.setColumns(10);
		getDate.setBounds(215, 209, 326, 34);
		frame.getContentPane().add(getDate);
		
		JButton btnAjouterBI = new JButton("AJOUTER\r\n");
		btnAjouterBI.setFocusPainted(false);
		btnAjouterBI.setForeground(new Color(255, 255, 255));
		btnAjouterBI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomCL = getNomCL.getText();
				String PrenomCL = getPrenomCL.getText();
				String Date = getDate.getText();
				String Desc = getDesc.getText();
				
				String query = "INSERT INTO RDV VALUES ('"+NomCL+"', '"+PrenomCL+"', to_date('"+Date+"', 'dd-mm-yyyy'), '"+Desc+"')";
				try {
					statement = connection.createStatement();
					statement.executeQuery(query);
					JOptionPane.showMessageDialog(null, "RDV à été ajouté", "ADDED!",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "ERROR OCCURED ! \n make sure that the information entered is correct and no field is empty \n note : make sure that the client exists ", "ERROR!",JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
				}
				
				
				
			}
		});
		btnAjouterBI.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnAjouterBI.setBorder(null);
		btnAjouterBI.setBackground(new Color(0, 255, 127));
		btnAjouterBI.setBounds(295, 405, 122, 41);
		frame.getContentPane().add(btnAjouterBI);
		
		JLabel lblDesc = new JLabel("Description :");
		lblDesc.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblDesc.setBounds(107, 317, 99, 19);
		frame.getContentPane().add(lblDesc);
		
		getDesc = new JTextField();
		getDesc.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getDesc.setColumns(10);
		getDesc.setBounds(215, 279, 326, 94);
		frame.getContentPane().add(getDesc);
		
		
		
		
	}

}
