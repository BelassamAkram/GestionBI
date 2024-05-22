import BI.*;

import CLFrames.*;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Component;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JEditorPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import CLFrames.ajouterCL;
import CLFrames.ajouterINT;
import CLFrames.ajouterPREF;
import CLFrames.modifierCL;
import CLFrames.supprimerCL;
import RDV.ajouterRDV;
import Transaction.ajouterTR;
import net.proteanit.sql.DbUtils;


import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;

public class App {

	private JFrame frmAyProperties;
	
	private Connection connection;
	private Statement statement ; 
	
	private final Action action = new SwingAction();
	private JPanel bIPage;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	
	



	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmAyProperties.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
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
			
			JOptionPane.showMessageDialog(null, "LOGIN TO DATABASE DENIED ! \n username or password incorrect \n", "ERROR!",JOptionPane.ERROR_MESSAGE);
			
		}
		
		frmAyProperties = new JFrame();
		frmAyProperties.setFont(new Font("Montserrat", Font.PLAIN, 12));
		frmAyProperties.setTitle("A&Y PROPERTIES");
		frmAyProperties.getContentPane().setBackground(new Color(150, 239, 255));
		frmAyProperties.setBackground(Color.WHITE);
		frmAyProperties.setForeground(Color.WHITE);
		frmAyProperties.setBounds(100, 100, 728, 509);
		frmAyProperties.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAyProperties.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(203, 0, 509, 470);
		frmAyProperties.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel welcomePage = new JPanel();
		welcomePage.setBackground(Color.WHITE);
		layeredPane.add(welcomePage, "name_25964551188300");
		welcomePage.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/123.png")).getImage();
		lblNewLabel.setBounds(79, 11, 350, 350);
		lblNewLabel.setIcon(new ImageIcon(img));
		welcomePage.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME TO A&Y PROPERTIES !");
		lblNewLabel_1.setForeground(new Color(47, 79, 79));
		lblNewLabel_1.setFont(new Font("Montserrat Black", Font.BOLD, 19));
		lblNewLabel_1.setBounds(78, 359, 353, 24);
		welcomePage.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("A NAME YOU CAN TRUST");
		lblNewLabel_2.setForeground(new Color(47, 79, 79));
		lblNewLabel_2.setFont(new Font("Montserrat", Font.BOLD, 13));
		lblNewLabel_2.setBounds(168, 382, 173, 17);
		welcomePage.add(lblNewLabel_2);
		
		bIPage = new JPanel();
		bIPage.setBackground(Color.WHITE);
		layeredPane.add(bIPage, "name_24031657922600");
		bIPage.setLayout(null);
		
		JButton btnAjoutBI = new JButton("Ajouter");
		btnAjoutBI.setFocusPainted(false);
		btnAjoutBI.setForeground(new Color(255, 255, 255));
		btnAjoutBI.setBackground(new Color(0, 255, 127));
		btnAjoutBI.setBorder(null);
		btnAjoutBI.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnAjoutBI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajoutFrameBI ns = new ajoutFrameBI();
				ns.ajoutFrameBI();
				
				
			}
		});
		btnAjoutBI.setBounds(323, 26, 153, 62);
		bIPage.add(btnAjoutBI);
		
		JButton btnModifierBI = new JButton("Modifier");
		btnModifierBI.setFocusPainted(false);
		btnModifierBI.setForeground(new Color(255, 255, 255));
		btnModifierBI.setBackground(new Color(0, 255, 127));
		btnModifierBI.setBorder(null);
		btnModifierBI.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnModifierBI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifierFrameBI ns = new modifierFrameBI();
				ns.modifierFrameBI();
				
			}
		});
		btnModifierBI.setBounds(178, 114, 153, 62);
		bIPage.add(btnModifierBI);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFocusPainted(false);
		btnSupprimer.setForeground(new Color(255, 255, 255));
		btnSupprimer.setBackground(new Color(220, 20, 60));
		btnSupprimer.setBorder(null);
		btnSupprimer.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supprimerFrameBI ns = new supprimerFrameBI();
				ns.supprimerFrameBI();
			}
		});
		btnSupprimer.setBounds(58, 202, 153, 62);
		bIPage.add(btnSupprimer);
		
		JButton btnAffecter = new JButton("Agent");
		btnAffecter.setFocusPainted(false);
		btnAffecter.setForeground(new Color(255, 255, 255));
		btnAffecter.setBackground(new Color(0, 255, 127));
		btnAffecter.setBorder(null);
		btnAffecter.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnAffecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affecterFrameBI ns = new affecterFrameBI();
				ns.affecterFrameBI();
			}
		});
		btnAffecter.setBounds(178, 290, 153, 62);
		bIPage.add(btnAffecter);
		
		JButton btnRecherche = new JButton("Rechercher\r\n");
		btnRecherche.setFocusPainted(false);
		btnRecherche.setForeground(new Color(255, 255, 255));
		btnRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rechercheFrameBI ns = new rechercheFrameBI();
				ns.rechercheFrameBI();
			}
		});
		btnRecherche.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnRecherche.setBorder(null);
		btnRecherche.setBackground(new Color(0, 255, 127));
		btnRecherche.setBounds(323, 378, 153, 62);
		bIPage.add(btnRecherche);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane.add(layeredPane_1, "name_6365853104000");
		layeredPane_1.setLayout(new CardLayout(0, 0));
		
		JPanel interactionPage = new JPanel();
		interactionPage.setBackground(new Color(255, 255, 255));
		interactionPage.setLayout(null);
		layeredPane_1.add(interactionPage, "name_6385011730800");
		
		JButton btnAjouterINT = new JButton("Ajouter");
		btnAjouterINT.setFocusPainted(false);
		btnAjouterINT.setForeground(new Color(255, 255, 255));
		btnAjouterINT.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnAjouterINT.setBackground(new Color(0, 255, 127));
		btnAjouterINT.setBorder(null);
		btnAjouterINT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouterINT ns = new ajouterINT();
				ns.ajouterINT();
			}
		});
		btnAjouterINT.setBounds(171, 53, 153, 62);
		interactionPage.add(btnAjouterINT);
		
		JButton btnAfficherINT = new JButton("Afficher");
		btnAfficherINT.setFocusPainted(false);
		btnAfficherINT.setForeground(new Color(255, 255, 255));
		btnAfficherINT.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnAfficherINT.setBackground(new Color(0, 255, 127));
		btnAfficherINT.setBorder(null);
		btnAfficherINT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "SELECT * FROM interaction";
				
				try {
					statement = connection.createStatement();
					statement.executeQuery(query);
					ResultSet rs = statement.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				} catch (Exception e5) {
					// TODO Auto-generated catch block
					e5.printStackTrace();
				}
			}
			
		});
		btnAfficherINT.setBounds(171, 147, 153, 62);
		interactionPage.add(btnAfficherINT);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(10, 256, 489, 204);
		interactionPage.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		table.setBackground(new Color(234, 223, 198));
		
		JPanel clientPage = new JPanel();
		clientPage.setBackground(new Color(255, 255, 255));
		layeredPane.add(clientPage, "name_5804474651200");
		clientPage.setLayout(null);
		
		JButton btnAjouterCL = new JButton("Ajouter");
		btnAjouterCL.setFocusPainted(false);
		btnAjouterCL.setForeground(new Color(255, 255, 255));
		btnAjouterCL.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnAjouterCL.setBackground(new Color(0, 255, 127));
		btnAjouterCL.setBorder(null);
		btnAjouterCL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouterCL ns = new ajouterCL();
				ns.ajouterCL();
				
			}
		});
		btnAjouterCL.setBounds(323, 26, 153, 62);
		clientPage.add(btnAjouterCL);
		
		JButton btnModifierCL = new JButton("Modifier");
		btnModifierCL.setFocusPainted(false);
		btnModifierCL.setForeground(new Color(255, 255, 255));
		btnModifierCL.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnModifierCL.setBackground(new Color(0, 255, 127));
		btnModifierCL.setBorder(null);
		btnModifierCL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifierCL ns = new modifierCL();
				ns.modifierCL();
			}
		});
		btnModifierCL.setBounds(178, 114, 153, 62);
		clientPage.add(btnModifierCL);
		
		JButton btnSupprimerCL = new JButton("Supprimer");
		btnSupprimerCL.setFocusPainted(false);
		btnSupprimerCL.setForeground(new Color(255, 255, 255));
		btnSupprimerCL.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnSupprimerCL.setBackground(new Color(220, 20, 60));
		btnSupprimerCL.setBorder(null);
		btnSupprimerCL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supprimerCL ns = new supprimerCL();
				ns.supprimerCL();
			}
		});
		btnSupprimerCL.setBounds(58, 202, 153, 62);
		clientPage.add(btnSupprimerCL);
		
		JButton btnInteractionCL = new JButton("Interaction");
		btnInteractionCL.setFocusPainted(false);
		btnInteractionCL.setForeground(new Color(255, 255, 255));
		btnInteractionCL.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnInteractionCL.setBackground(new Color(0, 255, 127));
		btnInteractionCL.setBorder(null);
		btnInteractionCL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					layeredPane.removeAll();
					layeredPane.add(interactionPage);
					layeredPane.repaint();
					layeredPane.revalidate();
			}
		});
		btnInteractionCL.setBounds(178, 290, 153, 62);
		clientPage.add(btnInteractionCL);
		
		JButton btnPreferenceCL = new JButton("Preference");
		btnPreferenceCL.setFocusPainted(false);
		btnPreferenceCL.setForeground(new Color(255, 255, 255));
		btnPreferenceCL.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnPreferenceCL.setBackground(new Color(0, 255, 127));
		btnPreferenceCL.setBorder(null);
		btnPreferenceCL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouterPREF ns = new ajouterPREF();
				ns.ajouterPREF();
			}
		});
		btnPreferenceCL.setBounds(323, 378, 153, 62);
		clientPage.add(btnPreferenceCL);
		
		
		
		JPanel transactionPage = new JPanel();
		transactionPage.setFocusTraversalKeysEnabled(false);
		transactionPage.setBackground(Color.WHITE);
		layeredPane.add(transactionPage, "name_25256915373400");
		transactionPage.setLayout(null);
		
		JButton btnAjouter = new JButton("AJOUTER");
		btnAjouter.setFocusTraversalKeysEnabled(false);
		btnAjouter.setForeground(new Color(255, 255, 255));
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouterTR ns = new ajouterTR();
				ns.ajouterTR();
			}
		});
		btnAjouter.setFont(new Font("Montserrat", Font.BOLD, 13));
		btnAjouter.setBorder(null);
		btnAjouter.setBackground(new Color(0, 255, 127));
		btnAjouter.setBounds(178, 36, 153, 62);
		transactionPage.add(btnAjouter);
		
		JScrollPane tableC = new JScrollPane();
		tableC.setViewportBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tableC.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tableC.setBackground(SystemColor.menu);
		tableC.setFont(new Font("Montserrat", Font.BOLD, 11));
		tableC.setBounds(0, 233, 509, 237);
		transactionPage.add(tableC);
		
		table_1 = new JTable();
		tableC.setViewportView(table_1);
		
		JButton btnGenerer = new JButton("GENERER \r\n");
		btnGenerer.setFocusTraversalKeysEnabled(false);
		btnGenerer.setForeground(new Color(255, 255, 255));
		btnGenerer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "SELECT NomCL AS NOM, PrenomCL AS PRENOM, Type, NumBI, DateD, DateF, Montant FROM Transaction";
				try {
					statement = connection.createStatement();
					statement.executeQuery(sql);
					ResultSet rs = statement.executeQuery(sql);
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
			}
		);
		btnGenerer.setFont(new Font("Montserrat", Font.BOLD, 13));
		btnGenerer.setBorder(null);
		btnGenerer.setBackground(new Color(0, 255, 127));
		btnGenerer.setBounds(178, 129, 153, 62);
		transactionPage.add(btnGenerer);
		
		JPanel RDVPage = new JPanel();
		RDVPage.setBackground(SystemColor.window);
		layeredPane.add(RDVPage, "name_102937558437400");
		RDVPage.setLayout(null);
		
		JButton btnAjouterBI = new JButton("AJOUTER\r\n");
		btnAjouterBI.setForeground(new Color(255, 255, 255));
		btnAjouterBI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouterRDV ns = new ajouterRDV();
				ns.ajouterRDV();
			}
		});
		btnAjouterBI.setFont(new Font("Montserrat", Font.BOLD, 13));
		btnAjouterBI.setBorder(null);
		btnAjouterBI.setBackground(new Color(0, 255, 127));
		btnAjouterBI.setBounds(178, 36, 153, 62);
		RDVPage.add(btnAjouterBI);
		
		JScrollPane tableRDV = new JScrollPane();
		tableRDV.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tableRDV.setBounds(0, 233, 509, 237);
		RDVPage.add(tableRDV);
		
		table_2 = new JTable();
		tableRDV.setViewportView(table_2);
		
		JButton btnAfficher = new JButton("AFFICHER");
		btnAfficher.setForeground(new Color(255, 255, 255));
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "SELECT * From RDV";
				try {
					statement = connection.createStatement();
					statement.executeQuery(query);
					ResultSet rs = statement.executeQuery(query);
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAfficher.setFont(new Font("Montserrat", Font.BOLD, 13));
		btnAfficher.setBorder(null);
		btnAfficher.setBackground(new Color(0, 255, 127));
		btnAfficher.setBounds(178, 129, 153, 62);
		RDVPage.add(btnAfficher);
		
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(65, 201, 226));
		panel_1.setBounds(0, 0, 193, 470);
		frmAyProperties.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		
		JButton btnBI = new JButton("BIEN IMMO");
		btnBI.setFocusPainted(false);
		btnBI.setInheritsPopupMenu(true);
		btnBI.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnBI.setBackground(Color.WHITE);
		btnBI.setFont(new Font("Montserrat Black", Font.PLAIN, 14));
		btnBI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				layeredPane.add(bIPage);
				layeredPane.repaint();
				layeredPane.revalidate();
				
				
			}
		});
		btnBI.setBounds(29, 47, 131, 58);
		panel_1.add(btnBI);
		
		JButton btnClient = new JButton("CLIENT");
		btnClient.setFocusPainted(false);
		btnClient.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnClient.setBackground(Color.WHITE);
		btnClient.setFont(new Font("Montserrat Black", Font.PLAIN, 14));
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(clientPage);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnClient.setBounds(29, 152, 131, 58);
		panel_1.add(btnClient);
		
		JButton btnTrans = new JButton("TRANSACTION");
		btnTrans.setFocusPainted(false);
		btnTrans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(transactionPage);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnTrans.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnTrans.setBackground(Color.WHITE);
		btnTrans.setFont(new Font("Montserrat Black", Font.PLAIN, 14));
		btnTrans.setBounds(29, 257, 131, 58);
		panel_1.add(btnTrans);
		
		JButton btnRDV = new JButton("RDV\r\n");
		btnRDV.setFocusPainted(false);
		btnRDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(RDVPage);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnRDV.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnRDV.setBackground(Color.WHITE);
		btnRDV.setFont(new Font("Montserrat Black", Font.PLAIN, 14));
		btnRDV.setBounds(29, 362, 131, 58);
		panel_1.add(btnRDV);
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}