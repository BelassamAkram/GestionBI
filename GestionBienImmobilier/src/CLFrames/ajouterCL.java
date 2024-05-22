package CLFrames;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Component;

public class ajouterCL {

	private JFrame frame;
	private JTextField getNom;
	private JTextField getPrenom;
	private JTextField getType;
	private JTextField getNumTel;
	private JTextField getAdresseEmail;
	
	private Connection connection;
	private Statement statement ;

	/**
	 * Launch the application.
	 */
	public static void ajouterCL() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajouterCL window = new ajouterCL();
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
	public ajouterCL() {
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
		
		getAdresseEmail = new JTextField();
		getAdresseEmail.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		getAdresseEmail.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		getAdresseEmail.setColumns(10);
		getAdresseEmail.setBounds(261, 344, 293, 36);
		frame.getContentPane().add(getAdresseEmail);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblNom.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNom.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNom.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblNom.setBounds(129, 48, 109, 36);
		frame.getContentPane().add(lblNom);
		
		getPrenom = new JTextField();
		getPrenom.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		getPrenom.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		getPrenom.setColumns(10);
		getPrenom.setBounds(259, 122, 293, 36);
		frame.getContentPane().add(getPrenom);
		
		getNom = new JTextField();
		getNom.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		getNom.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		getNom.setBounds(259, 48, 293, 36);
		frame.getContentPane().add(getNom);
		getNom.setColumns(10);
		
		getType = new JTextField();
		getType.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		getType.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		getType.setColumns(10);
		getType.setBounds(259, 196, 293, 36);
		frame.getContentPane().add(getType);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblPrenom.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPrenom.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrenom.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblPrenom.setBounds(129, 122, 109, 36);
		frame.getContentPane().add(lblPrenom);
		
		JLabel lblAdresseEmail = new JLabel("Adresse Email :");
		lblAdresseEmail.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblAdresseEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblAdresseEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAdresseEmail.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblAdresseEmail.setBounds(98, 344, 140, 36);
		frame.getContentPane().add(lblAdresseEmail);
		
		getNumTel = new JTextField();
		getNumTel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		getNumTel.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		getNumTel.setColumns(10);
		getNumTel.setBounds(259, 270, 293, 36);
		frame.getContentPane().add(getNumTel);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblType.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblType.setHorizontalAlignment(SwingConstants.TRAILING);
		lblType.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblType.setBounds(162, 196, 76, 36);
		frame.getContentPane().add(lblType);
		
		JLabel lblNumTel = new JLabel("Num Tel :");
		lblNumTel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblNumTel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNumTel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumTel.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblNumTel.setBounds(129, 270, 109, 36);
		frame.getContentPane().add(lblNumTel);
		
		JLabel lblAjouterCL = new JLabel("Entrez les informations du client");
		lblAjouterCL.setForeground(new Color(47, 79, 79));
		lblAjouterCL.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblAjouterCL.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouterCL.setBounds(197, -7, 318, 44);
		frame.getContentPane().add(lblAjouterCL);
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setFocusPainted(false);
		btnConfirmer.setForeground(new Color(255, 255, 255));
		btnConfirmer.setBorder(null);
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomCL = getNom.getText();
				String PrenomCL = getPrenom.getText();
				String TypeCL = getType.getText();
				String NumTelCL = getNumTel.getText();
				String AdresseEmailCL = getAdresseEmail.getText();
			
				String sql = "INSERT INTO Client VALUES ('"+NomCL+"', '"+PrenomCL+"','"+TypeCL+"', '"+NumTelCL+"', '"+AdresseEmailCL+"')";
				try {
					statement = connection.createStatement();
					statement.executeQuery(sql);
					JOptionPane.showMessageDialog(null, "le client à été ajouté", "ADDED!",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "ERROR OCCURED ! \n make sure that the information entered is correct and no field is empty\n note : make sure that the client doesn't exist already", "ERROR!",JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
				}

			
			}
				
		});
		btnConfirmer.setBackground(new Color(0, 255, 127));
		btnConfirmer.setFont(new Font("Montserrat", Font.BOLD, 17));
		btnConfirmer.setBounds(281, 410, 150, 36);
		frame.getContentPane().add(btnConfirmer);
	}
}
