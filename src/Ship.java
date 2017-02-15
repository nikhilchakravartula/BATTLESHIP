
public abstract class Ship {
	Location location;
	Player owner;
	int life;
	abstract Location getLocation();
	abstract int getLife();
	abstract Player getOwner();
	public boolean intersect(Location location)
	{
		if(location.x1==location.x2)
		{
			if(location.y1<location.y2)
			{
				for(int i=location.y1;i<=location.y2;i++)
				{
					if(Credentials.locationSet.contains(new Location(location.x1,i,location.x2,location.y2)))
					{
						return false;
					}
				}
			}
			else 
			{
				for(int i=location.y2;i<=location.y1;i++)
				{
					if(Credentials.locationSet.contains(new Location(location.x1,i,location.x2,location.y1)))
					{
						return false;
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
					if(Credentials.locationSet.contains(new Location(i,location.y1,location.x2,location.y2)))
					{
						return false;
					}
				}
			}
			else 
			{
				for(int i=location.x2;i<=location.x1;i++)
				{
					if(Credentials.locationSet.contains(new Location(i,location.y1,location.x1,location.y2)))
					{
						return false;
					}
				}
			}
			
		}
		return true;
	}
	
	public boolean setLocation(Location location,int size)
	{
		if(intersect(location)==true)
			return false;
		
		if(location.x1==location.x2)
		{
			if(location.y1<location.y2)
			{
				for(int i=location.y1;i<=location.y2;i++)
				{
					if(Credentials.locationSet.add(new Location(location.x1,i,location.x2,location.y2)))
					{
						return true;
					}
				}
			}
			else 
			{
				for(int i=location.y2;i<=location.y1;i++)
				{
					if(Credentials.locationSet.add(new Location(location.x1,i,location.x2,location.y1)))
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
					if(Credentials.locationSet.add(new Location(i,location.y1,location.x2,location.y2)))
					{
						return true;
					}
				}
			}
			else 
			{
				for(int i=location.x2;i<=location.x1;i++)
				{
					if(Credentials.locationSet.add(new Location(i,location.y1,location.x1,location.y2)))
					{
						return true;
					}
				}
			}
			
		}
		
		return false;
	
	}	
	
	
	
}
