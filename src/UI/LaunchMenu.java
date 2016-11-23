/**
 * 
 */
package UI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
		Color Wine = Color.decode("#722f37");
		Color Gold = Color.decode("#FFD700");

		
		final JFrame frame = new JFrame("Yahtzee!");
		frame.setSize(500,610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		// Menu seen by user
		JPanel menu = new JPanel( new GridLayout(0,1,10,10));
		menu.setBorder(new EmptyBorder(50,75,50,75));
		menu.setBackground(Color.BLACK);
		
		Insets margin = new Insets(20, 150, 20, 150);
		
		BufferedImage img = null;
		
		
		JLabel Logo = new JLabel(); 
		try {
		    img = ImageIO.read(new File("/home/aar/Documents/Dev/Eclipse/YahtzeeUserInterface/src/UI/yahtzee1final.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(null,"No");
		}
		
		Image dimg = img.getScaledInstance(300, 100,
		        Image.SCALE_SMOOTH);
		
		ImageIcon imageIcon = new ImageIcon(dimg);
		
		Logo.setIcon(imageIcon);
		Logo.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(Logo); 
		
		// Buttons
		Font ButtonNumber = new Font("Arial", Font.BOLD, 15); 
		JButton newGame = new JButton("New Game");
		newGame.setBackground(Wine); 
		newGame.setFont(ButtonNumber);
		newGame.setForeground(Color.WHITE); 
		newGame.setBorder(BorderFactory.createLineBorder(Gold, 2));
		newGame.setMargin( margin );
		newGame.setFocusPainted(false); 
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
		continueGame.setBorder(BorderFactory.createLineBorder(Gold, 2));
		continueGame.setBackground(Wine); 
		continueGame.setForeground(Color.WHITE);
		continueGame.setMargin( margin );
		menu.add( continueGame );
		
		/*  Game*/
		JButton gameInstructions = new JButton("How to Play");
		gameInstructions.setBorder(BorderFactory.createLineBorder(Gold, 2));
		gameInstructions.setBackground(Wine); 
		gameInstructions.setForeground(Color.WHITE);
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
		quitGame.setBorder(BorderFactory.createLineBorder(Gold, 2));
		quitGame.setBackground(Wine); 
		quitGame.setForeground(Color.WHITE);
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
