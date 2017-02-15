import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class BattleField implements ActionListener{

	JFrame frame;
	ArrayList<ArrayList<JButton> > buttons;
	Location dummyLocation;
	ArrayList <JButton> selectedButtons;
	public BattleField()
	{
		frame=new JFrame();
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
	
	public void glowEffect(Location location)
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
	
	public void cleanUpGlow()
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
		if(Game.state==Credentials.STATE_GAME_START)
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
				switch(Game.typeOfShip)
				{
				case Credentials.TYPE_DESTROYER:
				{
					
					tempShip=Game.Factory.getShip(Credentials.AVAILABLE_SHIPS[Credentials.TYPE_DESTROYER], Game.turn);
					if(tempShip.setLocation(dummyLocation, Credentials.SIZE_DESTROYER, Game.turn)==false)
					{
						JOptionPane.showMessageDialog(null, "cant place here", "Error", JOptionPane.OK_OPTION);
						dummyLocation.x1=-1;dummyLocation.y1=-1;
						dummyLocation.x2=-1;dummyLocation.y2=-1;
						break;
					}
					glowEffect(dummyLocation);
					synchronized (Game.Factory) {
						try
						{
							Game.Factory.notify();
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
					tempShip=Game.Factory.getShip(Credentials.AVAILABLE_SHIPS[Credentials.TYPE_AIRCRAFT], Game.turn);
					if(tempShip.setLocation(dummyLocation, Credentials.SIZE_AIRCRAFT, Game.turn)==false)
					{
						JOptionPane.showMessageDialog(null, "cant place here", "Error", JOptionPane.OK_OPTION);
						dummyLocation.x1=-1;dummyLocation.y1=-1;
						dummyLocation.x2=-1;dummyLocation.y2=-1;
						break;
					}
					glowEffect(dummyLocation);
					synchronized (Game.Factory) {
						try
						{
							Game.Factory.notify();
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
					tempShip=Game.Factory.getShip(Credentials.AVAILABLE_SHIPS[Credentials.TYPE_BATTLESHIP], Game.turn);
					if(tempShip.setLocation(dummyLocation, Credentials.SIZE_BATTLESHIP, Game.turn)==false)
						{
						JOptionPane.showMessageDialog(null, "cant place here", "Error", JOptionPane.OK_OPTION);
						dummyLocation.x1=-1;dummyLocation.y1=-1;
						dummyLocation.x2=-1;dummyLocation.y2=-1;
						break;
						}
					glowEffect(dummyLocation);
					synchronized (Game.Factory) {
						try
						{
							Game.Factory.notify();
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
					tempShip=Game.Factory.getShip(Credentials.AVAILABLE_SHIPS[Credentials.TYPE_CRUISER], Game.turn);
					if(tempShip.setLocation(dummyLocation, Credentials.SIZE_CRUISER, Game.turn)==false)
					{
						JOptionPane.showMessageDialog(null, "cant place here", "Error", JOptionPane.OK_OPTION);
						dummyLocation.x1=-1;dummyLocation.y1=-1;
						dummyLocation.x2=-1;dummyLocation.y2=-1;
						break;
					}
					glowEffect(dummyLocation);
					synchronized (Game.Factory) {
						try
						{
							Game.Factory.notify();
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
					tempShip=Game.Factory.getShip(Credentials.AVAILABLE_SHIPS[Credentials.TYPE_SUBMARINE], Game.turn);
					if(tempShip.setLocation(dummyLocation, Credentials.SIZE_SUBMARINE, Game.turn)==false)
					{
						JOptionPane.showMessageDialog(null, "cant place here", "Error", JOptionPane.OK_OPTION);
						dummyLocation.x1=-1;dummyLocation.y1=-1;
						dummyLocation.x2=-1;dummyLocation.y2=-1;
						break;
					}
					glowEffect(dummyLocation);
					synchronized (Game.Factory) {
						try
						{
							Game.Factory.notify();
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
		else if(Game.state==Credentials.STATE_GAME_PLAYING)
		{
			
			if(Ship.contains(new Pair(row,col),Game.turn))
			{
				JOptionPane.showMessageDialog(null, Game.players.get(Game.turn^1).name+" is hit",null,JOptionPane.OK_OPTION);
				buttons.get(row).get(col).setBackground(Color.RED);
			}
			else {
				JOptionPane.showMessageDialog(null, "Miss",null,JOptionPane.OK_OPTION);
				buttons.get(row).get(col).setBackground(Color.YELLOW);
			}
			
			buttons.get(row).get(col).setEnabled(false);
			
			
			
		}
		
		
	}

	
}
