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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ajouterPREF {

	private JFrame frame;
	private JTextField getNomPREF;
	private JTextField getPrenomPREF;
	private JTextField getTypePREF;
	private JTextField getSurfacePREF;
	private JTextField getLocalisationPREF;
	private JTextField getPrixPREF;
	
	private Connection connection;
	private Statement statement ;

	/**
	 * Launch the application.
	 */
	public static void ajouterPREF() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajouterPREF window = new ajouterPREF();
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
	public ajouterPREF() {
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
		frame.setBackground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 728, 509);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEntrezLeNom = new JLabel("Entrez le nom du client ");
		lblEntrezLeNom.setForeground(new Color(47, 79, 79));
		lblEntrezLeNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrezLeNom.setFont(new Font("Montserrat", Font.BOLD, 18));
		lblEntrezLeNom.setBounds(38, 11, 380, 44);
		frame.getContentPane().add(lblEntrezLeNom);
		
		JLabel lblNomPREF = new JLabel("Nom :");
		lblNomPREF.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomPREF.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblNomPREF.setBounds(96, 77, 46, 19);
		frame.getContentPane().add(lblNomPREF);
		
		JLabel lblPrenomPREF = new JLabel("Prenom :");
		lblPrenomPREF.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenomPREF.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblPrenomPREF.setBounds(75, 141, 70, 19);
		frame.getContentPane().add(lblPrenomPREF);
		
		JLabel lblTypePREF = new JLabel("Type :");
		lblTypePREF.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypePREF.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblTypePREF.setBounds(97, 259, 45, 19);
		frame.getContentPane().add(lblTypePREF);
		
		JLabel lblSurfacePREF = new JLabel("Surface :");
		lblSurfacePREF.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurfacePREF.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblSurfacePREF.setBounds(75, 306, 67, 19);
		frame.getContentPane().add(lblSurfacePREF);
		
		JLabel lblLocalisationPREF = new JLabel("Localisation :");
		lblLocalisationPREF.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocalisationPREF.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblLocalisationPREF.setBounds(38, 400, 104, 19);
		frame.getContentPane().add(lblLocalisationPREF);
		
		JLabel lblEntrezSesPreferences = new JLabel("Entrez ses preferences");
		lblEntrezSesPreferences.setForeground(new Color(47, 79, 79));
		lblEntrezSesPreferences.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrezSesPreferences.setFont(new Font("Montserrat", Font.BOLD, 18));
		lblEntrezSesPreferences.setBounds(38, 193, 380, 44);
		frame.getContentPane().add(lblEntrezSesPreferences);
		
		getNomPREF = new JTextField();
		getNomPREF.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		getNomPREF.setColumns(10);
		getNomPREF.setBounds(169, 68, 293, 36);
		frame.getContentPane().add(getNomPREF);
		
		getPrenomPREF = new JTextField();
		getPrenomPREF.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		getPrenomPREF.setCaretColor(new Color(255, 255, 255));
		getPrenomPREF.setColumns(10);
		getPrenomPREF.setBounds(169, 130, 293, 36);
		frame.getContentPane().add(getPrenomPREF);
		
		getTypePREF = new JTextField();
		getTypePREF.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		getTypePREF.setColumns(10);
		getTypePREF.setBounds(165, 248, 293, 36);
		frame.getContentPane().add(getTypePREF);
		
		getSurfacePREF = new JTextField();
		getSurfacePREF.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		getSurfacePREF.setColumns(10);
		getSurfacePREF.setBounds(165, 295, 293, 36);
		frame.getContentPane().add(getSurfacePREF);
		
		getLocalisationPREF = new JTextField();
		getLocalisationPREF.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		getLocalisationPREF.setColumns(10);
		getLocalisationPREF.setBounds(165, 389, 293, 36);
		frame.getContentPane().add(getLocalisationPREF);
		
		JLabel lblPrixMaxPREF = new JLabel("Prix Max : ");
		lblPrixMaxPREF.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrixMaxPREF.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblPrixMaxPREF.setBounds(63, 353, 79, 19);
		frame.getContentPane().add(lblPrixMaxPREF);
		
		getPrixPREF = new JTextField();
		getPrixPREF.setFont(new Font("Montserrat Medium", Font.PLAIN, 12));
		getPrixPREF.setColumns(10);
		getPrixPREF.setBounds(165, 342, 293, 36);
		frame.getContentPane().add(getPrixPREF);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFocusPainted(false);
		btnAjouter.setBounds(516, 206, 150, 58);
		frame.getContentPane().add(btnAjouter);
		btnAjouter.setBorder(null);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Nom = getNomPREF.getText();
				String Prenom = getPrenomPREF.getText();
				String Type = getTypePREF.getText();
				String Surface = getSurfacePREF.getText();
				String PrixMax = getPrixPREF.getText();
				String Localisation = getLocalisationPREF.getText();
			
				String sql = "INSERT INTO Preference VALUES ('"+Nom+"', '"+Prenom+"','"+Type+"', '"+Surface+"', '"+PrixMax+"','"+Localisation+"')";
				try {
					statement = connection.createStatement();
					statement.executeQuery(sql);
					JOptionPane.showMessageDialog(null, "les preferences du client ont été ajoutés", "ADDED!",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "ERROR OCCURED ! \n make sure that the information entered is correct and no field is empty\n note : make sure that the client exists", "ERROR!",JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
				}

			
			}
			
		});
		btnAjouter.setForeground(new Color(255, 255, 255));
		btnAjouter.setFont(new Font("Montserrat", Font.BOLD, 17));
		btnAjouter.setBackground(new Color(0, 255, 127));
	}
}
