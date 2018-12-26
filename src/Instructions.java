/**************************************
 * Project: Gui-based Craps
 * File   : Instructions
 * @author  Alex Isaac
 * Date   : 10/24/16
 * 
 * Description:
 * 	1.) The purpose of this code is to display the instructions to the user
 *  2.) No data structures
 *  3.) Strategies used here include using a text area to display the instructions
 *
 * Changes:
 * 
 *************************************************/
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class Instructions {

	private JFrame frmInstructions;

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
					Instructions window = new Instructions();
					window.frmInstructions.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Method  : Instructions
	 * Purpose : create the application
	 * @param none
	 * @returns nothing
	 */
	public Instructions() {
		initialize();
	}

	/**
	 * Method  : initialize
	 * Purpose : Initialize the contents of the frame
	 * @param none
	 * @returns void, nothing
	 */
	private void initialize() {
		frmInstructions = new JFrame();
		frmInstructions.setTitle("Instructions");
		frmInstructions.getContentPane().setBackground(Color.WHITE);
		frmInstructions.setBounds(100, 100, 502, 310);
		frmInstructions.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInstructions.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Instructions.class.getResource("/Images/dice.jpg")));
		lblNewLabel.setBounds(26, 31, 160, 144);
		frmInstructions.getContentPane().add(lblNewLabel);
		
		JTextArea txtrText = new JTextArea();
		txtrText.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtrText.setEditable(false);
		txtrText.setText("Set up\r\n - Select File | New Shooter\r\n - Enter players name\r\n\r\nPlay\r\n - Click the come-out Roll Button\r\n\t- Win if you roll 7 or 11\r\n\t- Lose if you roll 2, 3, or 12\r\n\t- Otherwise, set point value and continue\r\n - Point Roll\r\n\t- Win if you roll your point value\r\n\t- Lose if you roll 7\r\n\t- Otherwise, continue until you win or lose");
		txtrText.setBounds(188, 16, 278, 219);
		frmInstructions.getContentPane().add(txtrText);
	}
}
