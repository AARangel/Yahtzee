/**
 * 
 */
package UI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 * @author jamesBryant
 *
 */
public class LaunchMenu {
	
	public static Boolean Main = false; 
	
	public Boolean getMain() {
		return Main;
	}

	public void setMain(Boolean main) {
		 Main = main;
	}

	public static void startLaunchMenu()
	{
		final JFrame frame = new JFrame("Yahtzee!");
		frame.setSize(900,550);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		
		// Menu seen by user
		JPanel menu = new JPanel( new GridLayout(0,1,10,10));
		menu.setBorder(new EmptyBorder(100,250,100,250));
		
		JButton[] buttons = {};
		Insets margin = new Insets(20, 150, 20, 150);
		
		// Buttons
		JButton newGame = new JButton("New Game");
		newGame.setMargin( margin );
		newGame.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				System.out.println("\nStarting new game");
				Main = true; //MainPage Master = new MainPage();
				frame.dispose(); 
			}
		});
		menu.add(newGame);
		
		JButton continueGame = new JButton("Continue");
		continueGame.setMargin( margin );
		menu.add( continueGame );
		
		/*  Game*/
		JButton gameInstructions = new JButton("How to Play");
		gameInstructions.setMargin( margin );
		gameInstructions.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				System.out.println("Launching Instructions");
				String url = "http://www.hasbro.com/common/instruct/Yahtzee.pdf";
				try{
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				}
				catch( IOException ex )
				{
					System.out.println( ex.getMessage() );
				}
				
			}
		});
		menu.add( gameInstructions);
		
		
		/* Quit Game*/
		JButton quitGame = new JButton("Quit");
		quitGame.setMargin( margin );
		quitGame.addActionListener( new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{
				System.out.println("Exiting Game");
				System.exit(0);
			}
		});
		
		menu.add( quitGame );
		
		frame.add( menu );
		frame.setVisible(true);
		
	}

}
