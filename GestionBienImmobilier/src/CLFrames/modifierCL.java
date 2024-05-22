package CLFrames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.sql.*;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JPanel;

public class modifierCL {

	private JFrame frame;
	private JTable table;
	private Connection connection;
	private Statement statement ; 
	private JButton btnRecherche;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JTextField getPrenomCL;
	private JTextField getNomCL;
	private JLabel lblType;
	private JTextField getTypeCL;
	private JLabel lblNtelephone;
	private JTextField getPhoneCL;
	private JLabel lblEmail;
	private JTextField getEmailCL;
	private JButton btnModifierBI;
	private JLabel lblListeDesClients;


	/**
	 * Launch the application.
	 */
	public static void modifierCL() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifierCL window = new modifierCL();
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
	public modifierCL() {
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
		frame.setBounds(100, 100, 750, 557);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnActualiser = new JButton("Afficher");
		btnActualiser.setFocusPainted(false);
		btnActualiser.setForeground(new Color(255, 255, 255));
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "SELECT * FROM Client";
				try {
					statement = connection.createStatement();
					statement.executeQuery(sql);
					ResultSet rs = statement.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 84, 734, 143);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		btnActualiser.setFont(new Font("Montserrat", Font.BOLD, 14));
		btnActualiser.setBorder(null);
		btnActualiser.setBackground(new Color(0, 255, 127));
		btnActualiser.setBounds(482, 20, 122, 41);
		frame.getContentPane().add(btnActualiser);
		
		btnRecherche = new JButton("Rechercher");
		btnRecherche.setFocusPainted(false);
		btnRecherche.setForeground(new Color(255, 255, 255));
		btnRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String NomCL = getNomCL.getText();
				String PrenomCL = getPrenomCL.getText();
				String sql = "SELECT * FROM Client WHERE Nom = '"+NomCL+"' AND Prenom = '"+PrenomCL+"'";
				try {
					statement = connection.createStatement();
					statement.executeQuery(sql);
					ResultSet rs = statement.executeQuery(sql);
					
			           while(rs.next()) {
						
						 	String NomCL1 = rs.getString("Nom");
					        String PrenomCL1 = rs.getString("Prenom");
					        String Type1 = rs.getString("Type");
					        String Phone1 = rs.getString("NumTel");
					        String Email1 = rs.getString("AdresseEmail");
					        
					      
					        
					        getTypeCL.setText(Type1);
					        getPhoneCL.setText(Phone1);
					        getEmailCL.setText(Email1);
					       
					}
					
					rs.close();			     
	

					}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			}
		);
				
				;
		btnRecherche.setFont(new Font("Montserrat", Font.BOLD, 14));
		btnRecherche.setBorder(null);
		btnRecherche.setBackground(new Color(0, 255, 127));
		btnRecherche.setBounds(68, 439, 122, 41);
		frame.getContentPane().add(btnRecherche);
		
		lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblNom.setBounds(34, 296, 46, 14);
		frame.getContentPane().add(lblNom);
		
		lblPrenom = new JLabel("Prenom :");
		lblPrenom.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblPrenom.setBounds(10, 361, 70, 14);
		frame.getContentPane().add(lblPrenom);
		
		getPrenomCL = new JTextField();
		getPrenomCL.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getPrenomCL.setColumns(10);
		getPrenomCL.setBounds(101, 354, 150, 34);
		frame.getContentPane().add(getPrenomCL);
		
		getNomCL = new JTextField();
		getNomCL.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getNomCL.setColumns(10);
		getNomCL.setBounds(101, 287, 150, 34);
		frame.getContentPane().add(getNomCL);
		
		lblType = new JLabel("Type :");
		lblType.setHorizontalAlignment(SwingConstants.TRAILING);
		lblType.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblType.setBounds(320, 268, 104, 14);
		frame.getContentPane().add(lblType);
		
		lblNtelephone = new JLabel("N-Telephone :");
		lblNtelephone.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNtelephone.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblNtelephone.setBounds(309, 329, 115, 14);
		frame.getContentPane().add(lblNtelephone);
		
		lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblEmail.setBounds(324, 386, 100, 14);
		frame.getContentPane().add(lblEmail);
		
		btnModifierBI = new JButton("Modifier");
		btnModifierBI.setFocusPainted(false);
		btnModifierBI.setForeground(new Color(255, 255, 255));
		btnModifierBI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String NomCL = getNomCL.getText();
				String PrenomCL = getPrenomCL.getText();
				String TypeCL = getTypeCL.getText();
				String PhoneCL = getPhoneCL.getText();
				String EmailCL= getEmailCL.getText();
				
			
				String sql2 = "UPDATE Client SET  Type = '"+TypeCL+"', NumTel= '"+PhoneCL+"', AdresseEmail = '"+EmailCL+"' WHERE (Nom = '"+NomCL+"' AND Prenom = '"+PrenomCL+"')";
				
				try {
					statement = connection.createStatement();
					statement.executeUpdate(sql2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "le client à été modifié", "UPDATED!",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnModifierBI.setFont(new Font("Montserrat", Font.BOLD, 14));
		btnModifierBI.setBorder(null);
		btnModifierBI.setBackground(new Color(0, 255, 127));
		btnModifierBI.setBounds(468, 439, 122, 41);
		frame.getContentPane().add(btnModifierBI);
		
		lblListeDesClients = new JLabel("POUR AFFICHER LA LISTE DES CLIENTS TAPPEZ SUR :");
		lblListeDesClients.setForeground(new Color(47, 79, 79));
		lblListeDesClients.setHorizontalAlignment(SwingConstants.CENTER);
		lblListeDesClients.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblListeDesClients.setBounds(68, 32, 391, 18);
		frame.getContentPane().add(lblListeDesClients);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(289, 222, 10, 307);
		frame.getContentPane().add(panel);
		
		getPhoneCL = new JTextField();
		getPhoneCL.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getPhoneCL.setColumns(10);
		getPhoneCL.setBounds(442, 320, 270, 34);
		frame.getContentPane().add(getPhoneCL);
		
		getTypeCL = new JTextField();
		getTypeCL.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getTypeCL.setColumns(10);
		getTypeCL.setBounds(442, 259, 271, 34);
		frame.getContentPane().add(getTypeCL);
		
		getEmailCL = new JTextField();
		getEmailCL.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getEmailCL.setColumns(10);
		getEmailCL.setBounds(442, 378, 270, 34);
		frame.getContentPane().add(getEmailCL);
	}
}
