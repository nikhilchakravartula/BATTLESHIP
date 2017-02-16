import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

	private ArrayList<Player> players;
	private int turn;
	private int state;
	private int typeOfShip;
	private ShapeFactory Factory;
	private Player winner;
	
	ArrayList<Player> getPlayers()
	{
		return players;
	}
	void setState(final int state)
	{
		this.state=state;
	}
	void setWinner(Player winner)
	{
		this.winner=winner;
	}
	int getTurn()
	{
		return turn;
	}
	
	int getState()
	{
		return state;
	}
	int getTypeOfShip()
	{
		return typeOfShip;
	}
	void setTypeOfShip(int type)
	{
		this.typeOfShip=type;
	}
	ShapeFactory getFactory()
	{
		return Factory;
	}
	Player getWinner()
	{
		return winner;
	}
	
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
			
		
			 players.add(new Player(this,nameText.getText(),100,Credentials.NUM_SHIPS));

			 while(choices.size()!=0){
			 String input = (String) JOptionPane.showInputDialog(null, "Place your Ships \n\nChoose your Ship "+nameText.getText(),
				        nameText.getText(), JOptionPane.QUESTION_MESSAGE, null, choices.toArray(),  choices.get(0));
			
			 setTypeOfShip(Arrays.asList(Credentials.AVAILABLE_SHIPS).indexOf(input));
			// System.out.println("choice chosen "+input+"\tand type "+Game.typeOfShip);
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
			players.get(turn).getField().cleanUpGlow();
			turn=turn^1;
			
		}
		
		JOptionPane.showMessageDialog(null, "Brace for impact!!");
		state=Credentials.STATE_GAME_PLAYING;
		
	}
	void startPlay()
	{
		players.get(1).getField().getFrame().setVisible(false);
		turn=0;
		while(state!=Credentials.STATE_GAME_END)
		{
			try
			{
				synchronized (Factory) {
					Factory.wait();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			players.get(turn).getField().getFrame().setVisible(false);
			players.get(turn^1).getField().getFrame().setVisible(true);
			turn=turn^1;
		}
		players.get(turn).getField().getFrame().setVisible(true);
		players.get(turn^1).getField().getFrame().setVisible(true);
		
	}
	public static void main(String args[])
	{
		Game game=new Game();
		System.out.println("Player1");
		game.players.get(0).printLocationSet();
		System.out.println("Player2");
		game.players.get(1).printLocationSet();
		game.startPlay();
		JOptionPane.showMessageDialog(null, "WINNER IS "+game.getWinner().getName());
	}
}
