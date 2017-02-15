
public class BattleShip extends Ship {

	public BattleShip(Player owner,Location location)
	{
		this.life=Credentials.LIFE_BATTLESHIP;
		this.location=location;
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
