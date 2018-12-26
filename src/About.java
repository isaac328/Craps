/**************************************
 * Project: Gui-based Craps
 * File   : About
 * @author  Alex Isaac
 * Date   : 10/24/16
 * 
 * Description:
 * 	1.) The purpose of this code is to display the assignment and author in a window
 *  2.) No data structures
 *  3.) Strategies used here include using a several labels for the text
 *
 * Changes:
 * 
 *************************************************/
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class About {

	private JFrame frmAbout;

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
					About window = new About();
					window.frmAbout.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Method  : About
	 * Purpose : create the application
	 * @param none
	 * @returns nothing
	 */
	public About() {
		initialize();
	}

	/**
	 * Method  : initialize
	 * Purpose : Initialize the contents of the frame
	 * @param none
	 * @returns void, nothing
	 */
	private void initialize() {
		frmAbout = new JFrame();
		frmAbout.setTitle("About");
		frmAbout.setBounds(100, 100, 429, 281);
		frmAbout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAbout.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(About.class.getResource("/Images/yays.jpeg")));
		label.setBounds(113, 16, 168, 100);
		frmAbout.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("CSIS1410 Object Oriented Programming");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(32, 128, 345, 20);
		frmAbout.getContentPane().add(lblNewLabel);
		
		JLabel lblAssignment = new JLabel("Assignment: M4-A3 - GUI-based Craps");
		lblAssignment.setBounds(63, 153, 293, 20);
		frmAbout.getContentPane().add(lblAssignment);
		
		JLabel lblAuthor = new JLabel("Author: Alex Isaac");
		lblAuthor.setBounds(127, 189, 138, 20);
		frmAbout.getContentPane().add(lblAuthor);
	}
}
