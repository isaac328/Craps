/**************************************
 * Project: Gui-based Craps
 * File   : CrapsGUI
 * @author  Alex Isaac
 * Date   : 10/24/16
 * 
 * Description:
 * 	1.) The purpose of this code is to create a graphical user interface that a user can use to play a game of craps
 *  2.) Data structures include if-structures and nested if-statements.
 *  3.) The largest algorithm here is in the play button. Depending on the text of the play button (only slight differences in execution), the 
 *  	program rolls two dice and displays a message if its a winning or losing combination. If neither, the sum is the new point value,
 *  	the user rolls again, and the game goes on until win or lose. Stats are tracked along the way.
 *
 * Changes:
 * 
 *************************************************/
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrapsGUI {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtDie1;
	private JTextField txtDie2;
	private JTextField txtPointValue;
	private String name;
	private JLabel lblMessage;
	private JLabel lblPointValue;
	private JButton btnPlay;
	private JButton btnPlayAgain;
	private int pointValue;
	Die d1 = new Die();
	Die d2 = new Die();
	int totalGames = 0;
	int totalWins = 0;
	int totalRolls = 0;

	/**
	 * Method  : main
	 * Purpose : Launch the application
	 * @param String[] args
	 * @returns void, nothing
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrapsGUI window = new CrapsGUI();
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
	public CrapsGUI() {
		initialize();
	}

	/**
	 * Method  : initialize
	 * Purpose : Initialize the contents of the frame
	 * @param String[] args
	 * @returns void, nothing
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 703, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewShooter = new JMenuItem("New Shooter");
		mntmNewShooter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String testName = JOptionPane.showInputDialog("What is your name?");
				if (testName != null) // if the user doesn't press the cancel button
				{
					name = testName;
					txtName.setText(name);
					btnPlay.setEnabled(true);
					totalWins = 0;
					totalGames = 0;
					totalRolls = 0;
					lblMessage.setText("Lets Play");
				}
			}
		});
		mnFile.add(mntmNewShooter);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnGameStats = new JMenu("Game Stats");
		menuBar.add(mnGameStats);
		
		JMenuItem mntmTotalGames = new JMenuItem("Total Games");
		mntmTotalGames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane.showMessageDialog(null, "Total Games: " + totalGames);
			}
		});
		mnGameStats.add(mntmTotalGames);
		
		JMenuItem mntmTotalWins = new JMenuItem("Total Wins");
		mntmTotalWins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Total Wins: " + totalWins);
			}
		});
		mnGameStats.add(mntmTotalWins);
		
		JMenuItem mntmAvgRollsgame = new JMenuItem("Avg Rolls/Game");
		mntmAvgRollsgame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, String.format("Average Rolls Per Game: %d", totalRolls/totalGames));
			}
		});
		mnGameStats.add(mntmAvgRollsgame);
		
		JMenuItem mntmSummary = new JMenuItem("Summary");
		mntmSummary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane.showMessageDialog(null, String.format("Total Games: %d\nTotal Wins: %d\nAvg Rolls/Game: %d",
						totalGames, totalWins, (totalRolls/totalGames)));
			}
		});
		mnGameStats.add(mntmSummary);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmInstructions = new JMenuItem("Instructions");
		mntmInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Instructions.main(null);
			}
		});
		mnHelp.add(mntmInstructions);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				About.main(null);
			}
		});
		mnHelp.add(mntmAbout);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDicepic = new JLabel("");
		lblDicepic.setIcon(new ImageIcon(CrapsGUI.class.getResource("/Images/dice.jpg")));
		lblDicepic.setBounds(38, 40, 150, 155);
		frame.getContentPane().add(lblDicepic);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 37));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setEditable(false);
		txtName.setBounds(338, 63, 233, 73);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtDie1 = new JTextField();
		txtDie1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDie1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		txtDie1.setEditable(false);
		txtDie1.setBounds(38, 225, 47, 45);
		frame.getContentPane().add(txtDie1);
		txtDie1.setColumns(10);
		
		txtDie2 = new JTextField();
		txtDie2.setHorizontalAlignment(SwingConstants.CENTER);
		txtDie2.setFont(new Font("Tahoma", Font.PLAIN, 36));
		txtDie2.setEditable(false);
		txtDie2.setBounds(100, 225, 47, 45);
		frame.getContentPane().add(txtDie2);
		txtDie2.setColumns(10);
		
		JLabel lblDie = new JLabel("Die 1");
		lblDie.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDie.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDie.setBounds(37, 199, 69, 20);
		frame.getContentPane().add(lblDie);
		
		JLabel lblDie_1 = new JLabel("Die 2");
		lblDie_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDie_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDie_1.setBounds(99, 198, 69, 20);
		frame.getContentPane().add(lblDie_1);
		
		btnPlay = new JButton("Come-out Roll");
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				// if the button label is Come-out Roll
				if (btnPlay.getText().equals("Come-out Roll"))
				{
					// roll dice
					d1.roll();
					d2.roll();
					totalRolls++;
					
					// assign dice numbers to variables
					int num1 = d1.getValue();
					int num2 = d2.getValue();
					
					// put dice numbers in text boxes
					txtDie1.setText(Integer.toString(num1));
					txtDie2.setText(Integer.toString(num2));
					
					//initially set the point value box and label invisible
					txtPointValue.setVisible(false);
					lblPointValue.setVisible(false);
					
					// if roll equals 2, 3, or 12.....Lose and reset
					if (num1 + num2 == 2 || num1 + num2 == 3 || num1 + num2 == 12)
					{
						lblMessage.setText(name + " is a Loser!");
						totalGames++;
						btnPlay.setEnabled(false);
						btnPlayAgain.setEnabled(true);
						btnPlayAgain.setVisible(true);
					}
					// if roll equals 7 or 11...Win and reset
					else if (num1 + num2 == 7 || num1 + num2 == 11)
					{
						lblMessage.setText(name + " is a Winner!");
						totalGames++;
						totalWins++;
						btnPlay.setEnabled(false);
						btnPlayAgain.setEnabled(true);
						btnPlayAgain.setVisible(true);
					}
					//If neither win nor lose on first roll.....assign point value to text box and move on
					else 
					{
						btnPlay.setText("Point Roll");
						lblMessage.setText("Game in Progress...");
						pointValue = num1 + num2;
						txtPointValue.setVisible(true);
						lblPointValue.setVisible(true);
						txtPointValue.setText(Integer.toString(pointValue));
						
					}
				}
				// if button label equals point roll
				else if (btnPlay.getText().equals("Point Roll"))
				{
					// roll dice again
					d1.roll();
					d2.roll();
					totalRolls++;
					
					//re-assign numbers
					int num1 = d1.getValue();
					int num2 = d2.getValue();
					
					//put new numbers in text box
					txtDie1.setText(Integer.toString(num1));
					txtDie2.setText(Integer.toString(num2));
					
					// if dice numbers equal point value......Win and reset
					if (num1 + num2 == pointValue)
					{
						lblMessage.setText(name + " is a Winner!");
						totalGames++;
						totalWins++;
						btnPlay.setEnabled(false);
						btnPlayAgain.setEnabled(true);
						btnPlayAgain.setVisible(true);
					}
					
					// if dice numbers equal 7......Lose and reset
					else if (num1 + num2 == 7)
					{
						lblMessage.setText(name + " is a Loser!");
						totalGames++;
						btnPlay.setEnabled(false);
						btnPlayAgain.setEnabled(true);
						btnPlayAgain.setVisible(true);
					}
				}
			}
		});
		btnPlay.setEnabled(false);
		btnPlay.setBounds(351, 169, 211, 45);
		frame.getContentPane().add(btnPlay);
		
		lblMessage = new JLabel("Enter New Shooter");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMessage.setBounds(303, 265, 309, 61);
		frame.getContentPane().add(lblMessage);
		
		txtPointValue = new JTextField();
		txtPointValue.setHorizontalAlignment(SwingConstants.CENTER);
		txtPointValue.setFont(new Font("Tahoma", Font.PLAIN, 36));
		txtPointValue.setVisible(false);
		txtPointValue.setEditable(false);
		txtPointValue.setColumns(10);
		txtPointValue.setBounds(71, 299, 47, 45);
		frame.getContentPane().add(txtPointValue);
		
		lblPointValue = new JLabel("Point Value");
		lblPointValue.setVisible(false);
		lblPointValue.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPointValue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPointValue.setBounds(59, 273, 69, 20);
		frame.getContentPane().add(lblPointValue);
		
		btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.setVisible(false);
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				//reset everything
				btnPlay.setText("Come-out Roll");
				btnPlay.setEnabled(true);
				btnPlayAgain.setEnabled(false);
				btnPlayAgain.setVisible(false);
				txtDie1.setText("");
				txtDie2.setText("");
				txtPointValue.setText("");
				lblMessage.setText("Start Rolling");
			}
		});
		btnPlayAgain.setEnabled(false);
		btnPlayAgain.setBounds(402, 225, 115, 29);
		frame.getContentPane().add(btnPlayAgain);
	}
}
