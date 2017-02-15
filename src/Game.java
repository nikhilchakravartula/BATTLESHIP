import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

	static ArrayList<Player> players;
	static int turn;
	static int state;
	static int typeOfShip;
	static ShapeFactory Factory;
	
	public Game()
	{
		players=new ArrayList<Player>(Credentials.NUM_PLAYERS);
		Factory=ShapeFactory.getFactory();
		turn=0;
		state=Credentials.STATE_GAME_START;
		for(int i=0;i<Credentials.NUM_PLAYERS;i++)
		{
			
			ArrayList<String> choices=new ArrayList<String> (Arrays.asList(Credentials.AVAILABLE_SHIPS));
			JTextArea nameText=new JTextArea(),ageText=new JTextArea();
			
			do
			{
				JOptionPane.showConfirmDialog(null,
                        nameText,
                        "Enter your name Player "+i,
                        JOptionPane.OK_CANCEL_OPTION);
				
			}while(nameText.getText()!=null && nameText.getText().length()==0);
			
		
			 players.add(new Player(nameText.getText(),100,Credentials.NUM_SHIPS));

			 while(choices.size()!=0){
			 String input = (String) JOptionPane.showInputDialog(null, "Place your Ships \n\nChoose your Ship "+nameText.getText(),
				        nameText.getText(), JOptionPane.QUESTION_MESSAGE, null, choices.toArray(),  choices.get(0));
			
			 
			 Game.typeOfShip=Arrays.asList(Credentials.AVAILABLE_SHIPS).indexOf(input);
			 synchronized (Factory) {
				 try{
				Factory.wait();
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
				 }
			}
			 choices.remove(input);
			 }
			players.get(turn).field.cleanUpGlow();
			turn=turn^1;
			
		}
		
		JOptionPane.showMessageDialog(null, "Brace for impact!!");
		state=Credentials.STATE_GAME_PLAYING;
		
	}
	void startPlay()
	{
		turn=0;
		while(state!=Credentials.STATE_GAME_END)
		{
			
			
			
			
			
			turn^=1;
		}
	}
	public static void main(String args[])
	{
		Game game=new Game();
		System.out.println("Player1");
		players.get(0).printLocationSet();
		System.out.println("Player2");
		players.get(1).printLocationSet();
		game.startPlay();
	}
}
