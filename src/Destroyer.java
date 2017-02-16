
public class Destroyer extends Ship {

	public Destroyer(Game game,int owner)
	{
		this.life=Credentials.LIFE_DESTROYER;
		this.owner=game.getPlayers().get(owner);
		
	}

	 int getLife() {
		// TODO Auto-generated method stub
		return this.life;
	}
	
	 Location getLocation() {
		// TODO Auto-generated method stub
		return this.location;
	}

	 Player getOwner() {
		// TODO Auto-generated method stub
		return this.owner;
	}
}
