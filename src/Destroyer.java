
public class Destroyer extends Ship {

	public Destroyer(Player owner)
	{
		this.life=Credentials.LIFE_DESTROYER;
		this.owner=owner;
		
	}

	public int getLife() {
		// TODO Auto-generated method stub
		return this.life;
	}
	
	public Location getLocation() {
		// TODO Auto-generated method stub
		return this.location;
	}

	public Player getOwner() {
		// TODO Auto-generated method stub
		return this.owner;
	}
}
