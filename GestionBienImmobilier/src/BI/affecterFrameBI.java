package BI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.*;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class affecterFrameBI {

	private JFrame frame;
	private JTextField getNomAG;
	private JTextField getPrenomAG;
	private JTextField getPhoneAG;
	private JTextField getEmailAG;
	private JTextField getPrenomAgent;
	private JTextField getNomAgent;
	private JTextField getNumBI;
	private Connection connection;
	private Statement statement ; 
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void affecterFrameBI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					affecterFrameBI window = new affecterFrameBI();
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
	public affecterFrameBI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","BELASSAM","AKRAM");
					
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, "ERROR OCCURED ! \n username or password incorrect \n", "ERROR!",JOptionPane.ERROR_MESSAGE);
			
}

		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 728, 509);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
	
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.WHITE);
		layeredPane.setBounds(0, 0, 488, 470);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel ajouterPanel = new JPanel();
		ajouterPanel.setBackground(Color.WHITE);
		layeredPane.add(ajouterPanel, "name_92973704198800");
		ajouterPanel.setLayout(null);
		
		getNomAG = new JTextField();
		getNomAG.setAlignmentY(0.3f);
		getNomAG.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getNomAG.setColumns(10);
		getNomAG.setBounds(179, 85, 254, 34);
		ajouterPanel.add(getNomAG);
		
		getPrenomAG = new JTextField();
		getPrenomAG.setAlignmentY(0.3f);
		getPrenomAG.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getPrenomAG.setColumns(10);
		getPrenomAG.setBounds(179, 157, 254, 34);
		ajouterPanel.add(getPrenomAG);
		
		getPhoneAG = new JTextField();
		getPhoneAG.setAlignmentY(0.3f);
		getPhoneAG.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getPhoneAG.setColumns(10);
		getPhoneAG.setBounds(179, 229, 254, 34);
		ajouterPanel.add(getPhoneAG);
		
		getEmailAG = new JTextField();
		getEmailAG.setAlignmentY(0.3f);
		getEmailAG.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getEmailAG.setColumns(10);
		getEmailAG.setBounds(179, 306, 254, 34);
		ajouterPanel.add(getEmailAG);
		
		
		
		
		JLabel lblNewLabel = new JLabel("ENTREZ LES INFORMATIONS DE L'AGENT");
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblNewLabel.setBounds(70, 0, 348, 34);
		ajouterPanel.add(lblNewLabel);
		
		JButton btnAjouterBI = new JButton("AJOUTER\r\n");
		btnAjouterBI.setFocusPainted(false);
		btnAjouterBI.setForeground(Color.WHITE);
		btnAjouterBI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomAG = getNomAG.getText();
				String PrenomAG = getPrenomAG.getText();
				String PhoneAG = getPhoneAG.getText();
				String EmailAG = getEmailAG.getText();
				
				String sql = "INSERT INTO AGENT VALUES ('"+NomAG+"','"+PrenomAG+"', '"+PhoneAG+"', '"+EmailAG+"')";
				try {
					statement = connection.createStatement();
					statement.executeQuery(sql);
					JOptionPane.showMessageDialog(null, "agent à été ajouté", "ADDED!",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "ERROR OCCURED ! \n make sure that the information entered is correct and no field is empty\n note : make sure that the agent doesn't exist already ", "ERROR!",JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
				}
				
			
				
			}
		});
		btnAjouterBI.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnAjouterBI.setBorder(null);
		btnAjouterBI.setBackground(new Color(0, 255, 127));
		btnAjouterBI.setBounds(183, 392, 122, 41);
		ajouterPanel.add(btnAjouterBI);
		
		JLabel lblAdresseEmail = new JLabel("Adresse Email :");
		lblAdresseEmail.setAlignmentY(0.3f);
		lblAdresseEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAdresseEmail.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblAdresseEmail.setBounds(32, 312, 118, 19);
		ajouterPanel.add(lblAdresseEmail);
		
		JLabel lblNumTel = new JLabel("Num Tel :");
		lblNumTel.setAlignmentY(0.3f);
		lblNumTel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumTel.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblNumTel.setBounds(77, 235, 73, 19);
		ajouterPanel.add(lblNumTel);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setAlignmentY(0.3f);
		lblPrenom.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrenom.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblPrenom.setBounds(77, 163, 70, 19);
		ajouterPanel.add(lblPrenom);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setAlignmentY(0.3f);
		lblNom.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNom.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblNom.setBounds(104, 91, 46, 19);
		ajouterPanel.add(lblNom);
		
		JPanel affecterPanel = new JPanel();
		affecterPanel.setBackground(SystemColor.window);
		layeredPane.add(affecterPanel, "name_92973721583300");
		affecterPanel.setLayout(null);
		
		JButton btnAffecterBI = new JButton("AFFECTER\r\n");
		btnAffecterBI.setFocusPainted(false);
		btnAffecterBI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(affecterPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		
		JLabel lblNomAgent = new JLabel("Nom Agent :");
		lblNomAgent.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNomAgent.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblNomAgent.setBounds(60, 63, 109, 36);
		affecterPanel.add(lblNomAgent);
		
		JLabel lblPrenomAgent = new JLabel("Prenom Agent :");
		lblPrenomAgent.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPrenomAgent.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblPrenomAgent.setBounds(41, 164, 128, 36);
		affecterPanel.add(lblPrenomAgent);
		
		getPrenomAgent = new JTextField();
		getPrenomAgent.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getPrenomAgent.setColumns(10);
		getPrenomAgent.setBounds(179, 167, 254, 34);
		affecterPanel.add(getPrenomAgent);
		
		getNomAgent = new JTextField();
		getNomAgent.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getNomAgent.setColumns(10);
		getNomAgent.setBounds(179, 67, 254, 34);
		affecterPanel.add(getNomAgent);
		
		JLabel lblNumDeBi = new JLabel("Num de BI :");
		lblNumDeBi.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumDeBi.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblNumDeBi.setBounds(60, 265, 109, 36);
		affecterPanel.add(lblNumDeBi);
		
		getNumBI = new JTextField();
		getNumBI.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
		getNumBI.setColumns(10);
		getNumBI.setBounds(179, 267, 254, 34);
		affecterPanel.add(getNumBI);
		
		JButton btnAffecter = new JButton("AFFECTER");
		btnAffecter.setFocusPainted(false);
		btnAffecter.setForeground(new Color(255, 255, 255));
		btnAffecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomAG = getNomAgent.getText();
				String PrenomAG = getPrenomAgent.getText();
				String NumBI = getNumBI.getText();
				
				String sql = "INSERT INTO AFFECTATION VALUES ('"+NomAG+"','"+PrenomAG+"', '"+NumBI+"')";
				try {
					statement = connection.createStatement();
					statement.executeQuery(sql);
					JOptionPane.showMessageDialog(null, "BI à été affecté à l'agent", "AFFECTED!",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "ERROR OCCURED ! \n make sure that the information entered is correct or exists\n", "ERROR!",JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
				}
				

			
				
			}
		});
		btnAffecter.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnAffecter.setBorder(null);
		btnAffecter.setBackground(new Color(0, 255, 127));
		btnAffecter.setBounds(179, 363, 122, 41);
		affecterPanel.add(btnAffecter);
		
		JPanel affichagePanel = new JPanel();
		affichagePanel.setBackground(SystemColor.window);
		layeredPane.add(affichagePanel, "name_95743718791600");
		affichagePanel.setLayout(null);
		
		JScrollPane tableAff = new JScrollPane();
		tableAff.setBounds(41, 123, 405, 223);
		affichagePanel.add(tableAff);
		
		table = new JTable();
		tableAff.setViewportView(table);
		btnAffecterBI.setForeground(Color.BLACK);
		btnAffecterBI.setFont(new Font("Montserrat", Font.BOLD, 14));
		btnAffecterBI.setBorderPainted(false);
		btnAffecterBI.setBackground(Color.CYAN);
		btnAffecterBI.setBounds(511, 209, 179, 49);
		frame.getContentPane().add(btnAffecterBI);
		
		
		JButton btnAjouteragent = new JButton("AJOUTER AGENT");
		btnAjouteragent.setFocusPainted(false);
		btnAjouteragent.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(ajouterPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnAjouteragent.setForeground(Color.BLACK);
		btnAjouteragent.setFont(new Font("Montserrat", Font.BOLD, 14));
		btnAjouteragent.setBorderPainted(false);
		btnAjouteragent.setBackground(Color.CYAN);
		btnAjouteragent.setBounds(511, 80, 179, 49);
		frame.getContentPane().add(btnAjouteragent);
		
		JButton btnAffichage = new JButton("AFFICHAGE");
		btnAffichage.setFocusPainted(false);
		btnAffichage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(affichagePanel);
				layeredPane.repaint();
				layeredPane.revalidate();
				String query = "SELECT * From Affectation";
				try {
					statement = connection.createStatement();
					statement.executeQuery(query);
					ResultSet rs = statement.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
				
			}
		);
		btnAffichage.setForeground(Color.BLACK);
		btnAffichage.setFont(new Font("Montserrat", Font.BOLD, 14));
		btnAffichage.setBorderPainted(false);
		btnAffichage.setBackground(Color.CYAN);
		btnAffichage.setBounds(511, 338, 179, 49);
		frame.getContentPane().add(btnAffichage);
	}
}
