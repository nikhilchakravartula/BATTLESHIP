import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class BattleField implements ActionListener{

	private JFrame frame;
	private ArrayList<ArrayList<JButton> > buttons;
	private Location dummyLocation;
	private ArrayList <JButton> selectedButtons;
	private Game game;
	JFrame getFrame()
	{
		return frame;
	}
	public BattleField(Game game)
	{
		frame=new JFrame();
		this.game=game;
		frame.setLayout(new GridLayout(10,10));
		selectedButtons=new ArrayList<JButton>();
		dummyLocation=new Location(-1,-1,-1,-1);
		buttons=new ArrayList<ArrayList<JButton> >(Credentials.NUM_COLS);
		for(int i=0;i<Credentials.NUM_COLS;i++)
		{
			buttons.add( new ArrayList<JButton>(Credentials.NUM_ROWS));
			for(int j=0;j<Credentials.NUM_ROWS;j++)
			{
				buttons.get(i).add( new JButton());
				buttons.get(i).get(j).putClientProperty("row", i);
				buttons.get(i).get(j).putClientProperty("col", j);
				buttons.get(i).get(j).addActionListener(this);
				buttons.get(i).get(j).setBackground(Color.BLUE);
				frame.add(buttons.get(i).get(j));
				
			}
		}
		
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}
	
	private void glowEffect(Location location)
	{
		
		int maxrow=Math.max(location.x1, location.x2),maxcol=Math.max(location.y1, location.y2),
		minrow=Math.min(location.x1, location.x2),mincol=Math.min(location.y1, location.y2);
		if(minrow==maxrow)
		{
			for(int i=mincol;i<=maxcol;i++)
			{
				selectedButtons.add(buttons.get(minrow).get(i));
				buttons.get(minrow).get(i).setBackground(Color.GREEN);
			}
		}
		else 
		{
			for(int i=minrow;i<=maxrow;i++)
			{
				selectedButtons.add(buttons.get(i).get(mincol));
				buttons.get(i).get(mincol).setBackground(Color.GREEN);
			}
		}
		
	}
	
	void cleanUpGlow()
	{
		for(JButton button: selectedButtons)
		{
			button.setBackground(Color.BLUE);
			
		}
		selectedButtons.clear();
	}
	public void actionPerformed(ActionEvent e)
	{
		
		JButton invoked=( (JButton)e.getSource() );
		int row=(Integer)invoked.getClientProperty("row"),col=(Integer)invoked.getClientProperty("col");
		if(game.getState()==Credentials.STATE_GAME_START)
		{
			if(dummyLocation.x1==-1)
			{
				dummyLocation.x1=row;dummyLocation.y1=col;
				dummyLocation.x2=-1;dummyLocation.y2=-1;
			}
			else if(dummyLocation.x2==-1)
			{
				dummyLocation.x2=row;dummyLocation.y2=col;
				Ship tempShip;
				switch(game.getTypeOfShip())
				{
				case Credentials.TYPE_DESTROYER:
				{
					
					tempShip=game.getFactory().getShip(game,Credentials.AVAILABLE_SHIPS[Credentials.TYPE_DESTROYER], game.getTurn());
					if(tempShip.setLocation(game,dummyLocation, Credentials.SIZE_DESTROYER, game.getTurn())==false)
					{
						JOptionPane.showMessageDialog(null, "cant place here", "Error", JOptionPane.OK_OPTION);
						dummyLocation.x1=-1;dummyLocation.y1=-1;
						dummyLocation.x2=-1;dummyLocation.y2=-1;
						break;
					}
					glowEffect(dummyLocation);
					synchronized (game.getFactory()) {
						try
						{
							game.getFactory().notify();
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
						}
					}
					break;
				}
					
				case Credentials.TYPE_AIRCRAFT:
				{
					tempShip=game.getFactory().getShip(game,Credentials.AVAILABLE_SHIPS[Credentials.TYPE_AIRCRAFT], game.getTurn());
					if(tempShip.setLocation(game,dummyLocation, Credentials.SIZE_AIRCRAFT, game.getTurn())==false)
					{
						JOptionPane.showMessageDialog(null, "cant place here", "Error", JOptionPane.OK_OPTION);
						dummyLocation.x1=-1;dummyLocation.y1=-1;
						dummyLocation.x2=-1;dummyLocation.y2=-1;
						break;
					}
					glowEffect(dummyLocation);
					synchronized (game.getFactory()) {
						try
						{
							game.getFactory().notify();
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
						}
					}
					break;
				}
					
				case Credentials.TYPE_BATTLESHIP:
				{
					tempShip=game.getFactory().getShip(game,Credentials.AVAILABLE_SHIPS[Credentials.TYPE_BATTLESHIP], game.getTurn());
					if(tempShip.setLocation(game,dummyLocation, Credentials.SIZE_BATTLESHIP, game.getTurn())==false)
						{
						JOptionPane.showMessageDialog(null, "cant place here", "Error", JOptionPane.OK_OPTION);
						dummyLocation.x1=-1;dummyLocation.y1=-1;
						dummyLocation.x2=-1;dummyLocation.y2=-1;
						break;
						}
					glowEffect(dummyLocation);
					synchronized (game.getFactory()) {
						try
						{
							game.getFactory().notify();
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
						}
					}
					break;
				}
					
				case Credentials.TYPE_CRUISER:
				{
					tempShip=game.getFactory().getShip(game,Credentials.AVAILABLE_SHIPS[Credentials.TYPE_CRUISER], game.getTurn());
					if(tempShip.setLocation(game,dummyLocation, Credentials.SIZE_CRUISER, game.getTurn())==false)
					{
						JOptionPane.showMessageDialog(null, "cant place here", "Error", JOptionPane.OK_OPTION);
						dummyLocation.x1=-1;dummyLocation.y1=-1;
						dummyLocation.x2=-1;dummyLocation.y2=-1;
						break;
					}
					glowEffect(dummyLocation);
					synchronized (game.getFactory()) {
						try
						{
							game.getFactory().notify();
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
						}
					}
					break;
				}
					
				case Credentials.TYPE_SUBMARINE:
				{
					tempShip=game.getFactory().getShip(game,Credentials.AVAILABLE_SHIPS[Credentials.TYPE_SUBMARINE], game.getTurn());
					if(tempShip.setLocation(game,dummyLocation, Credentials.SIZE_SUBMARINE, game.getTurn())==false)
					{
						JOptionPane.showMessageDialog(null, "cant place here", "Error", JOptionPane.OK_OPTION);
						dummyLocation.x1=-1;dummyLocation.y1=-1;
						dummyLocation.x2=-1;dummyLocation.y2=-1;
						break;
					}
					glowEffect(dummyLocation);
					synchronized (game.getFactory()) {
						try
						{
							game.getFactory().notify();
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
						}
					}
					break;
				}
					
				}
				
				dummyLocation.x1=-1;dummyLocation.y1=-1;
				dummyLocation.x2=-1;dummyLocation.y2=-1;
			}
			
			
		}
		else if(game.getState()==Credentials.STATE_GAME_PLAYING)
		{
		
			
			if(Ship.contains(game,new Pair(row,col),game.getTurn()^1))
			{
				buttons.get(row).get(col).setBackground(Color.RED);
				JOptionPane.showMessageDialog(null, game.getPlayers().get(game.getTurn()^1).getName()+" is hit",null,JOptionPane.OK_OPTION);
				Ship sh=getLocationSetValue(new Pair(row,col),game.getTurn()^1);
				System.out.println("clicked at\t"+row +"\t"+col);
				System.out.println("ship life is"+sh.life);
				if( 0==(sh.life-=1))
						{
					System.out.println("player life is"+game.getPlayers().get(game.getTurn()^1).getLife());
							if(0==(game.getPlayers().get(game.getTurn()^1).decrementLife()))
							{
								game.setState(Credentials.STATE_GAME_END);
								game.setWinner(game.getPlayers().get(game.getTurn()));
							}
						}
			//	Game.players.get(Game.turn^1).locationSet.remove(new Pair(row,col));
				
			}
			else {
				buttons.get(row).get(col).setBackground(Color.YELLOW);
				JOptionPane.showMessageDialog(null, "Miss",null,JOptionPane.OK_OPTION);
			}
			
			buttons.get(row).get(col).setEnabled(false);
			
			try
			{
				synchronized (game.getFactory()) {
					game.getFactory().notify();
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			
		}
		
		
	}
	
	private Ship getLocationSetValue(Pair p,int turn)
	{
		System.out.println("Searching in turn "+turn );
		for(Pair itr: game.getPlayers().get(turn).getLocationSet().keySet())
		{
			System.out.println("row and col "+itr.row+"\t"+itr.col);
			if(itr.row==p.row && itr.col==p.col)
			{
				return game.getPlayers().get(turn).getLocationSet().get(itr);
			}
		}
		return null;
	}



}
