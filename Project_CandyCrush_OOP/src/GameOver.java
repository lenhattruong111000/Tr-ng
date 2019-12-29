import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.UIManager;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.TextArea;
import javax.swing.JTextPane;

public class GameOver {
	JFrame frame;

	/**
	 * Launch the application.
	
	/**
	 * Create the application.
	 */

	public GameOver() {initialize(0,null );} //change form number into "scoreValue" 

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(int str, String str1) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(105, 105, 105));
		frame.setBounds(100, 100, 350, 138);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		
		JLabel lblGameOver = new JLabel("GAME OVER");
		lblGameOver.setBounds(45, 6, 299, 51);
		lblGameOver.setForeground(new Color(255, 204, 102));
		lblGameOver.setFont(new Font("Helvetica", Font.BOLD, 45));
		frame.getContentPane().add(lblGameOver);
		
//		scoreValue.setText(str);
//		scoreValue.setText(Integer.toString(str));
		JLabel lblScores = new JLabel("SCORE:  " + str);
//		scoreValue.setText(Integer.toString(str));
		lblScores.setBounds(67, 69, 117, 16);
		lblScores.setForeground(new Color(255, 255, 0));
		frame.getContentPane().add(lblScores);
		
		
		Button button = new Button("PLAY AGAIN");
		button.setBounds(190, 63, 117, 29);
		button.setFont(new Font("Helvetica", Font.BOLD, 14));
		button.setForeground(SystemColor.menuText);
		button.setBackground(new Color(105, 105, 105));
		frame.getContentPane().add(button);
		//play again
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						Main.playButton(MainMenu.click);
					}
					
				});
				frame.dispose();
			}
			
		});
		
	}
}
