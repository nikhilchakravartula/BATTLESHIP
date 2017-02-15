
public abstract class Ship {
	Location location;
	Player owner;
	int life;
	abstract Location getLocation();
	abstract int getLife();
	abstract Player getOwner();
	
	public boolean contains(Object o,int turn)
	{
		Pair param=(Pair)o;
		for(Pair p:Game.players.get(turn).locationSet)
		{
			if(p.row==param.row && p.col==param.col)
			{
				return true;
			}
		}
		return false;
	}
	public boolean intersect(Location location,int turn)
	{
		if(location.x1==location.x2)
		{
			if(location.y1<location.y2)
			{
				for(int i=location.y1;i<=location.y2;i++)
				{
					if(contains(new Pair(location.x1,i),turn))
					{
						//System.out.println("here2");
						return true;
					}
				}
			}
			else 
			{
				for(int i=location.y2;i<=location.y1;i++)
				{
					if(contains(new Pair(location.x1,i),turn))
					{
						return true;
					}
				}
			}
		}
		else if(location.y1==location.y2)
		{
			if(location.x1<location.x2)
			{
				for(int i=location.x1;i<=location.x2;i++)
				{
				if(contains(new Pair(i,location.y1),turn))
					{
						return true;
					}
				}
			}
			else 
			{
				for(int i=location.x2;i<=location.x1;i++)
				{
					if(contains(new Pair(i,location.y1),turn))
					{
						return true;
					}
				}
			}
			
		}
		return false;
	}
	
	public boolean setLocation(Location location,int size,int turn)
	{
		if(intersect(location,turn)==true)
			return false;
		
		if(location.x1==location.x2)
		{
			if(Math.abs(location.y1-location.y2)+1!=size)
				return false;
			
			if(location.y1<location.y2)
			{
				for(int i=location.y1;i<=location.y2;i++)
				{
					Game.players.get(turn).locationSet.add(new Pair(location.x1,i));
					
				}
				return true;
			}
			else 
			{
			
				
				for(int i=location.y2;i<=location.y1;i++)
				{
					Game.players.get(turn).locationSet.add(new Pair(location.x1,i));
					
				}
				return true;
			}
		}
		else if(location.y1==location.y2)
		{
			if(Math.abs(location.x1-location.x2)+1!=size)
				return false;
			
			if(location.x1<location.x2)
			{
				for(int i=location.x1;i<=location.x2;i++)
				{
					Game.players.get(turn).locationSet.add(new Pair(i,location.y1));
					
				}
				return true;
			}
			else 
			{
				for(int i=location.x2;i<=location.x1;i++)
				{
					Game.players.get(turn).locationSet.add(new Pair(i,location.y1));
					
					
				}
				return true;
			}
			
		}
		
		return false;
	
	}	
	
	
	
}
