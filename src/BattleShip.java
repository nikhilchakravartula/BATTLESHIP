
public class BattleShip extends Ship {

	public BattleShip(int owner)
	{
		this.life=Credentials.LIFE_BATTLESHIP;
		this.owner=Game.players.get(owner);
		
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
