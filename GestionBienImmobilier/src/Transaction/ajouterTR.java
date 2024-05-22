package Transaction;

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

public class ajouterTR {

	private JFrame frame;
	private Connection connection;
	private Statement statement ; 
	private JTextField getTransID;
	private JTextField getNomCL;
	private JTextField getPrenomCL;
	private JTextField getMontant;
	private JTextField getNumBI;
	private JTextField getDateD;
	private JLabel lblDateDeDebut;
	private JTextField getDateF;
	private JLabel lblDateDeFin;
	private JLabel lblMontant;
	private JButton btnAjouterBI;
	private JLabel lblType;
	private JTextField getType;

	/**
	 * Launch the application.
	 */
	public static void ajouterTR() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajouterTR window = new ajouterTR();
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
	public ajouterTR() {
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
		frame.setBounds(100, 100, 728, 593);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTREZ LES INFORMATIONS DU TRANSACTION  :");
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblNewLabel.setBounds(148, 6, 415, 20);
		frame.getContentPane().add(lblNewLabel);
		
		btnAjouterBI = new JButton("AJOUTER\r\n");
		btnAjouterBI.setFocusPainted(false);
		btnAjouterBI.setForeground(new Color(255, 255, 255));
		btnAjouterBI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String TransID = getTransID.getText();
				String NomCL = getNomCL.getText();
				String PrenomCL = getPrenomCL.getText();
				String NumBI = getNumBI.getText();
				String Type = getType.getText();
				String DateD = getDateD.getText();
				String DateF = getDateF.getText();
				String Montant = getMontant.getText();
				
				
				
				String sql = "INSERT INTO Transaction VALUES ('"+TransID+"', '"+NomCL+"', '"+PrenomCL+"', '"+Type+"', '"+NumBI+"', to_date('"+DateD+"','dd-mm-yyyy'), to_date('"+DateF+"', 'dd-mm-yyyy'),    '"+Montant+"')";
				try {
					statement = connection.createStatement();
					statement.executeQuery(sql);
					JOptionPane.showMessageDialog(null, "transaction à été ajouté", "ADDED!",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERROR OCCURED ! \n make sure that the information entered is correct and no field is empty \n note : make sure that the client and BI exists ", "ERROR!",JOptionPane.ERROR_MESSAGE);
				}
				
			
			}
		});
		btnAjouterBI.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnAjouterBI.setBorder(null);
		btnAjouterBI.setBackground(new Color(0, 255, 127));
		btnAjouterBI.setBounds(295, 502, 122, 41);
		frame.getContentPane().add(btnAjouterBI);
		
		JLabel lblNomCL = new JLabel("Nom Client :");
		lblNomCL.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNomCL.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblNomCL.setBounds(101, 118, 130, 14);
		frame.getContentPane().add(lblNomCL);
		
		JLabel lblTransID = new JLabel("Trans ID :");
		lblTransID.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTransID.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblTransID.setBounds(47, 61, 184, 14);
		frame.getContentPane().add(lblTransID);
		
		lblMontant = new JLabel("Montant :");
		lblMontant.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMontant.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblMontant.setBounds(101, 403, 130, 14);
		frame.getContentPane().add(lblMontant);
		
		lblDateDeDebut = new JLabel("Date de debut :");
		lblDateDeDebut.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDateDeDebut.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblDateDeDebut.setBounds(101, 289, 130, 14);
		frame.getContentPane().add(lblDateDeDebut);
		
		lblDateDeFin = new JLabel("Date de fin :");
		lblDateDeFin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDateDeFin.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblDateDeFin.setBounds(101, 346, 130, 14);
		frame.getContentPane().add(lblDateDeFin);
		
		JLabel lblPrenomCL = new JLabel("Prenom Cient :");
		lblPrenomCL.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrenomCL.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblPrenomCL.setBounds(77, 175, 154, 14);
		frame.getContentPane().add(lblPrenomCL);
		
		JLabel lblNumBI = new JLabel("Num BI :");
		lblNumBI.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumBI.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblNumBI.setBounds(47, 232, 184, 14);
		frame.getContentPane().add(lblNumBI);
		
		getTransID = new JTextField();
		getTransID.setFont(new Font("Montserrat", Font.PLAIN, 12));
		getTransID.setColumns(10);
		getTransID.setBounds(245, 52, 326, 34);
		frame.getContentPane().add(getTransID);
		
		getDateF = new JTextField();
		getDateF.setFont(new Font("Montserrat", Font.PLAIN, 12));
		getDateF.setColumns(10);
		getDateF.setBounds(245, 337, 326, 34);
		frame.getContentPane().add(getDateF);
		
		getNumBI = new JTextField();
		getNumBI.setFont(new Font("Montserrat", Font.PLAIN, 12));
		getNumBI.setColumns(10);
		getNumBI.setBounds(245, 223, 326, 34);
		frame.getContentPane().add(getNumBI);
		
		getPrenomCL = new JTextField();
		getPrenomCL.setFont(new Font("Montserrat", Font.PLAIN, 12));
		getPrenomCL.setColumns(10);
		getPrenomCL.setBounds(245, 166, 326, 34);
		frame.getContentPane().add(getPrenomCL);
		
		getMontant = new JTextField();
		getMontant.setFont(new Font("Montserrat", Font.PLAIN, 12));
		getMontant.setColumns(10);
		getMontant.setBounds(245, 394, 326, 34);
		frame.getContentPane().add(getMontant);
		
		getDateD = new JTextField();
		getDateD.setFont(new Font("Montserrat", Font.PLAIN, 12));
		getDateD.setColumns(10);
		getDateD.setBounds(245, 280, 326, 34);
		frame.getContentPane().add(getDateD);
		
		getNomCL = new JTextField();
		getNomCL.setFont(new Font("Montserrat", Font.PLAIN, 12));
		getNomCL.setColumns(10);
		getNomCL.setBounds(245, 109, 326, 34);
		frame.getContentPane().add(getNomCL);
		
		lblType = new JLabel("Type :");
		lblType.setHorizontalAlignment(SwingConstants.TRAILING);
		lblType.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblType.setBounds(101, 457, 130, 14);
		frame.getContentPane().add(lblType);
		
		getType = new JTextField();
		getType.setFont(new Font("Montserrat", Font.PLAIN, 12));
		getType.setColumns(10);
		getType.setBounds(245, 449, 326, 34);
		frame.getContentPane().add(getType);
	}
}
