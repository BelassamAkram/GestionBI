package BI;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.Window.Type;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;

public class rechercheFrameBI {

	private JFrame frame;
	private JTextField getSurfaceMin;
	private JTextField getSurfaceMax;
	private JTextField getPrixMin;
	private JTextField getLocalisation;
	private JTextField getPrixMax;
	private JTextField getType;
	
	private Connection connection;
	private Statement statement ; 
	private JTable table;
	
	

	/**
	 * Launch the application.
	 */
	public static void rechercheFrameBI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rechercheFrameBI window = new rechercheFrameBI();
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
	public rechercheFrameBI() {
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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 728, 650);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEntrezLesCritres = new JLabel("Entrez les critères du BI");
		lblEntrezLesCritres.setForeground(new Color(47, 79, 79));
		lblEntrezLesCritres.setBackground(Color.CYAN);
		lblEntrezLesCritres.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrezLesCritres.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblEntrezLesCritres.setBounds(230, 0, 251, 34);
		frame.getContentPane().add(lblEntrezLesCritres);
		
		JButton btnRecherche2 = new JButton("RECHERCHE\r\n");
		btnRecherche2.setForeground(new Color(255, 255, 255));
		btnRecherche2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String SMin = getSurfaceMin.getText();
				String SMax = getSurfaceMax.getText();
				String Type = getType.getText();
				String PMin = getPrixMin.getText();
				String PMax = getPrixMax.getText();
				String Local = getLocalisation.getText();
				
				String query = "SELECT * FROM BienImmobilier WHERE (CAST(Surface AS INT) between CAST('"+SMin+"' AS INT ) AND CAST('"+SMax+"' AS INT)) AND (CAST(Prix AS INT) between (CAST('"+PMin+"' AS INT )) AND CAST('"+PMax+"'AS INT)) AND typeBI = '"+Type+"' AND Localisation = '"+Local+"' ";
				try {
					statement = connection.createStatement();
					statement.executeQuery(query);
					ResultSet rs = statement.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "ERROR OCCURED ! \n make sure that the information entered is correct and no field is empty\n", "ERROR!",JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
				}
			}
			
		});
		btnRecherche2.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnRecherche2.setBorder(null);
		btnRecherche2.setBackground(new Color(0, 255, 127));
		btnRecherche2.setBounds(295, 351, 122, 41);
		frame.getContentPane().add(btnRecherche2);
		
		JLabel lblSurfaceMin = new JLabel("Surface Min :\r\n");
		lblSurfaceMin.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblSurfaceMin.setBounds(136, 55, 104, 14);
		frame.getContentPane().add(lblSurfaceMin);
		
		getSurfaceMin = new JTextField();
		getSurfaceMin.setColumns(10);
		getSurfaceMin.setBounds(253, 45, 326, 34);
		frame.getContentPane().add(getSurfaceMin);
		
		JLabel lblSurfaceMax = new JLabel("Surface Max :\r\n");
		lblSurfaceMax.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblSurfaceMax.setBounds(136, 104, 104, 14);
		frame.getContentPane().add(lblSurfaceMax);
		
		getSurfaceMax = new JTextField();
		getSurfaceMax.setColumns(10);
		getSurfaceMax.setBounds(253, 94, 326, 34);
		frame.getContentPane().add(getSurfaceMax);
		
		JLabel lblPrixMin = new JLabel("Prix Min :");
		lblPrixMin.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblPrixMin.setBounds(168, 202, 72, 14);
		frame.getContentPane().add(lblPrixMin);
		
		getPrixMin = new JTextField();
		getPrixMin.setColumns(10);
		getPrixMin.setBounds(253, 192, 326, 34);
		frame.getContentPane().add(getPrixMin);
		
		JLabel lblLocalisation = new JLabel("Localisation :");
		lblLocalisation.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblLocalisation.setBounds(136, 300, 104, 14);
		frame.getContentPane().add(lblLocalisation);
		
		getLocalisation = new JTextField();
		getLocalisation.setColumns(10);
		getLocalisation.setBounds(253, 290, 326, 34);
		frame.getContentPane().add(getLocalisation);
		
		JLabel lblPrixMax = new JLabel("Prix Max :");
		lblPrixMax.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblPrixMax.setBounds(165, 251, 75, 14);
		frame.getContentPane().add(lblPrixMax);
		
		getPrixMax = new JTextField();
		getPrixMax.setColumns(10);
		getPrixMax.setBounds(253, 241, 326, 34);
		frame.getContentPane().add(getPrixMax);
		
		getType = new JTextField();
		getType.setColumns(10);
		getType.setBounds(253, 143, 326, 34);
		frame.getContentPane().add(getType);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblType.setBounds(189, 153, 51, 14);
		frame.getContentPane().add(lblType);
		
		JScrollPane tableBI = new JScrollPane();
		tableBI.setViewportBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tableBI.setFont(new Font("Montserrat", Font.BOLD, 12));
		tableBI.setBounds(13, 419, 689, 172);
		frame.getContentPane().add(tableBI);
		
		table = new JTable();
		tableBI.setViewportView(table);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	}
}
