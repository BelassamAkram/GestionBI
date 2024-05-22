package BI;
import java.awt.EventQueue;
import java.sql.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class modifierFrameBI {

	private JFrame frame;
	private JTextField getNum;
	private Connection connection;
	private Statement statement ; 
	private JTable table;
	private JButton btnModifierBI;
	private JTextField getType1;
	private JLabel lblType;
	private JLabel lblTaille;
	private JTextField getSurface1;
	private JLabel lblLocalisation;
	private JTextField getLocalisation1;
	private JLabel lblPrix;
	private JTextField getPrix1;
	private JLabel lblDescription;
	private JTextField getDesc1;
	private JLabel lblLesPreferenceDu;

	

	/**
	 * Launch the application.
	 */
	public static void modifierFrameBI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifierFrameBI window = new modifierFrameBI();
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
	public modifierFrameBI() {
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
		frame.setBounds(100, 100, 728, 649);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblgetNomBI = new JLabel("POUR AFFICHER LA LISTE DES BIEN IMMO TAPPEZ SUR :");
		lblgetNomBI.setForeground(new Color(47, 79, 79));
		lblgetNomBI.setHorizontalAlignment(SwingConstants.CENTER);
		lblgetNomBI.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblgetNomBI.setBounds(33, 35, 441, 19);
		frame.getContentPane().add(lblgetNomBI);
		
		getNum = new JTextField();
		getNum.setFont(new Font("Montserrat Medium", Font.PLAIN, 13));
		getNum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		getNum.setBounds(239, 218, 244, 38);
		frame.getContentPane().add(getNum);
		getNum.setColumns(10);
		

		table = new JTable();
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setBounds(0, 86, 712, 86);
		frame.getContentPane().add(table);
		
		btnModifierBI = new JButton("Rechercher");
		btnModifierBI.setFocusPainted(false);
		btnModifierBI.setForeground(new Color(255, 255, 255));
		btnModifierBI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NumBI = getNum.getText();
				String sql = "SELECT * FROM BienImmobilier WHERE Num = '"+NumBI+"'";
				try {
					statement = connection.createStatement();
					statement.executeQuery(sql);
					ResultSet rs = statement.executeQuery(sql);
					
			           while(rs.next()) {
						
						 	String TypeBI = rs.getString("TypeBI");
					        String Surface1 = rs.getString("Surface");
					        String Local = rs.getString("Localisation");
					        String Prix = rs.getString("Prix");
					        String Desc = rs.getString("Description");
					        
					        getType1.setText(TypeBI);
					        getSurface1.setText(Surface1);
					        getLocalisation1.setText(Local);
					        getPrix1.setText(Prix);
					        getDesc1.setText(Desc);
					      
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
		btnModifierBI.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnModifierBI.setBorder(null);
		btnModifierBI.setBackground(new Color(0, 255, 127));
		btnModifierBI.setBounds(556, 215, 122, 41);
		frame.getContentPane().add(btnModifierBI);
		
		getType1 = new JTextField();
		getType1.setFont(new Font("Montserrat Medium", Font.PLAIN, 13));
		getType1.setColumns(10);
		getType1.setBounds(147, 345, 326, 34);
		frame.getContentPane().add(getType1);
		
		lblType = new JLabel("Type :");
		lblType.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblType.setBounds(80, 354, 46, 14);
		frame.getContentPane().add(lblType);
		
		lblTaille = new JLabel("Surface :");
		lblTaille.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblTaille.setBounds(63, 405, 70, 14);
		frame.getContentPane().add(lblTaille);
		
		getSurface1 = new JTextField();
		getSurface1.setFont(new Font("Montserrat Medium", Font.PLAIN, 13));
		getSurface1.setColumns(10);
		getSurface1.setBounds(147, 396, 326, 34);
		frame.getContentPane().add(getSurface1);
		
		lblLocalisation = new JLabel("Localisation :");
		lblLocalisation.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblLocalisation.setBounds(33, 456, 104, 14);
		frame.getContentPane().add(lblLocalisation);
		
		getLocalisation1 = new JTextField();
		getLocalisation1.setFont(new Font("Montserrat Medium", Font.PLAIN, 13));
		getLocalisation1.setColumns(10);
		getLocalisation1.setBounds(147, 447, 326, 34);
		frame.getContentPane().add(getLocalisation1);
		
		lblPrix = new JLabel("Prix :");
		lblPrix.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblPrix.setBounds(80, 507, 46, 14);
		frame.getContentPane().add(lblPrix);
		
		getPrix1 = new JTextField();
		getPrix1.setFont(new Font("Montserrat Medium", Font.PLAIN, 13));
		getPrix1.setColumns(10);
		getPrix1.setBounds(147, 498, 326, 34);
		frame.getContentPane().add(getPrix1);
		
		lblDescription = new JLabel("Description :");
		lblDescription.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblDescription.setBounds(33, 561, 100, 14);
		frame.getContentPane().add(lblDescription);
		
		getDesc1 = new JTextField();
		getDesc1.setFont(new Font("Montserrat Medium", Font.PLAIN, 13));
		getDesc1.setColumns(10);
		getDesc1.setBounds(147, 552, 326, 34);
		frame.getContentPane().add(getDesc1);
		
		JButton btnActualiser = new JButton("Afficher");
		btnActualiser.setFocusPainted(false);
		btnActualiser.setForeground(new Color(255, 255, 255));
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "SELECT * FROM BienImmobilier";
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
		btnActualiser.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnActualiser.setBorder(null);
		btnActualiser.setBackground(new Color(0, 255, 127));
		btnActualiser.setBounds(493, 24, 122, 41);
		frame.getContentPane().add(btnActualiser);
		
		JLabel lblNumDuBien = new JLabel("Num du bien a modifier : ");
		lblNumDuBien.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblNumDuBien.setBounds(20, 230, 196, 19);
		frame.getContentPane().add(lblNumDuBien);
		
		JButton btnModifierBI_1 = new JButton("Modifier");
		btnModifierBI_1.setFocusPainted(false);
		btnModifierBI_1.setForeground(new Color(255, 255, 255));
		btnModifierBI_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String NumBI = getNum.getText();
				String TypeBI = getType1.getText();
				String Surface1 = getSurface1.getText();
				String Prix = getPrix1.getText();
				String Local = getLocalisation1.getText();
				String Desc = getDesc1.getText();
			
				String sql2 = "UPDATE BienImmobilier SET TypeBI = '"+TypeBI+"', Surface = '"+Surface1+"', Localisation = '"+Local+"', Prix = '"+Prix+"', Description = '"+Desc+"' WHERE Num = '"+NumBI+"'";
				
				try {
					statement = connection.createStatement();
					statement.executeUpdate(sql2);
					JOptionPane.showMessageDialog(null, "le bien immobilier à été modifié", "UPDATED!",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "ERROR OCCURED ! \n make sure that the information entered is correct and no field is empty\n", "ERROR!",JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
				}
				
				
			}
		});
		btnModifierBI_1.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnModifierBI_1.setBorder(null);
		btnModifierBI_1.setBackground(new Color(0, 255, 127));
		btnModifierBI_1.setBounds(538, 443, 122, 41);
		frame.getContentPane().add(btnModifierBI_1);
		
		lblLesPreferenceDu = new JLabel("LES PREFERENCE DU BI :");
		lblLesPreferenceDu.setHorizontalAlignment(SwingConstants.CENTER);
		lblLesPreferenceDu.setForeground(new Color(47, 79, 79));
		lblLesPreferenceDu.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblLesPreferenceDu.setBounds(135, 295, 441, 19);
		frame.getContentPane().add(lblLesPreferenceDu);
}
}
