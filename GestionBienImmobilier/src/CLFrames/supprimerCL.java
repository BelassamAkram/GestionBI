package CLFrames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class supprimerCL {

	private JFrame frame;
	private JTextField getNomS;
	private JTextField getPrenomS;
	
	private Connection connection;
	private Statement statement ;

	/**
	 * Launch the application.
	 */
	public static void supprimerCL() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supprimerCL window = new supprimerCL();
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
	public supprimerCL() {
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
		frame.setBounds(100, 100, 680, 433);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEntrezLeNom_1 = new JLabel("ENTREZ LE NOM DU CLIENT A SUPRIMME");
		lblEntrezLeNom_1.setForeground(new Color(47, 79, 79));
		lblEntrezLeNom_1.setBackground(new Color(47, 79, 79));
		lblEntrezLeNom_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrezLeNom_1.setFont(new Font("Montserrat", Font.BOLD, 17));
		lblEntrezLeNom_1.setBounds(148, 49, 368, 22);
		frame.getContentPane().add(lblEntrezLeNom_1);
		
		JLabel lblNomS = new JLabel("Nom :");
		lblNomS.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomS.setFont(new Font("Montserrat", Font.BOLD, 17));
		lblNomS.setBounds(152, 125, 52, 22);
		frame.getContentPane().add(lblNomS);
		
		JLabel lblPrenomS = new JLabel("Prenom :");
		lblPrenomS.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrenomS.setFont(new Font("Montserrat", Font.BOLD, 17));
		lblPrenomS.setBounds(124, 210, 80, 22);
		frame.getContentPane().add(lblPrenomS);
		
		getNomS = new JTextField();
		getNomS.setFont(new Font("Montserrat Medium", Font.PLAIN, 13));
		getNomS.setColumns(10);
		getNomS.setBounds(226, 120, 293, 36);
		frame.getContentPane().add(getNomS);
		
		getPrenomS = new JTextField();
		getPrenomS.setFont(new Font("Montserrat Medium", Font.PLAIN, 13));
		getPrenomS.setColumns(10);
		getPrenomS.setBounds(226, 205, 293, 36);
		frame.getContentPane().add(getPrenomS);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFocusPainted(false);
		btnSupprimer.setForeground(new Color(255, 255, 255));
		btnSupprimer.setBorder(null);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Nom = getNomS.getText();
				String Prenom = getPrenomS.getText();
				String sql = "DELETE FROM Client WHERE Nom = '"+Nom+"' AND Prenom = '"+Prenom+"'" ;
				
				try {
					statement = connection.createStatement();
					statement.executeQuery(sql);
					JOptionPane.showMessageDialog(null, "le client à été supprimé ", "DELETED!",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "ERROR OCCURED ! \n make sure that the information entered is correct and no field is empty\n", "ERROR!",JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
				}
				
			
			}
		});
		btnSupprimer.setFont(new Font("Montserrat", Font.BOLD, 20));
		btnSupprimer.setBackground(new Color(220, 20, 60));
		btnSupprimer.setBounds(257, 290, 150, 51);
		frame.getContentPane().add(btnSupprimer);
	}

}
