
public abstract class Ship {
	Location location;
	Player owner;
	int life;
	abstract Location getLocation();
	abstract int getLife();
	
	abstract Player getOwner();
	
	 static boolean contains(Game game,Object o,int turn)
	{
		Pair param=(Pair)o;
		System.out.println("game :"+game+"\n getPlayers ");//+game.getPlayers()+"\n locationset"+game.getPlayers().get(turn).getLocationSet());
		for(Pair p:game.getPlayers().get(turn).getLocationSet().keySet())
		{
			if(p.row==param.row && p.col==param.col)
			{
				return true;
			}
		}
		return false;
	}
	 boolean intersect(Game game,Location location,int turn)
	{
		if(location.x1==location.x2)
		{
			if(location.y1<location.y2)
			{
				for(int i=location.y1;i<=location.y2;i++)
				{
					if(contains(game,new Pair(location.x1,i),turn))
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
					if(contains(game,new Pair(location.x1,i),turn))
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
				if(contains(game,new Pair(i,location.y1),turn))
					{
						return true;
					}
				}
			}
			else 
			{
				for(int i=location.x2;i<=location.x1;i++)
				{
					if(contains(game,new Pair(i,location.y1),turn))
					{
						return true;
					}
				}
			}
			
		}
		return false;
	}
	
	 boolean setLocation(Game game,Location location,int size,int turn)
	{
		if(intersect(game,location,turn)==true)
			return false;
		
		if(location.x1==location.x2)
		{
			if(Math.abs(location.y1-location.y2)+1!=size)
				return false;
			
			if(location.y1<location.y2)
			{
				for(int i=location.y1;i<=location.y2;i++)
				{
					game.getPlayers().get(turn).getLocationSet().put(new Pair(location.x1,i),this);
					
				}
				return true;
			}
			else 
			{
			
				
				for(int i=location.y2;i<=location.y1;i++)
				{
					game.getPlayers().get(turn).getLocationSet().put(new Pair(location.x1,i),this);
					
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
					game.getPlayers().get(turn).getLocationSet().put(new Pair(i,location.y1),this);
					
				}
				return true;
			}
			else 
			{
				for(int i=location.x2;i<=location.x1;i++)
				{
					game.getPlayers().get(turn).getLocationSet().put(new Pair(i,location.y1),this);
					
					
				}
				return true;
			}
			
		}
		
		return false;
	
	}	
	
	
	
}
