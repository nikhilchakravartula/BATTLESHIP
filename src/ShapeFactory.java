
public class ShapeFactory {

	static ShapeFactory  Factory;
	private ShapeFactory()
	{
		
	}
	
	public static ShapeFactory getFactory()
	{
		if(Factory==null)
		{
			return (Factory=new ShapeFactory());
		}
		else return Factory;
	}
	
	public Ship getShip(Game game,String type,int owner)
	{
		if(type.equalsIgnoreCase("DESTROYER"))
		{
			return new Destroyer(game,owner);
		}
		else if(type.equalsIgnoreCase("SUBMARINE"))
		{
			return new Submarine(game,owner);
		}
		else if(type.equalsIgnoreCase("CRUISER"))
		{
			return new Cruiser(game,owner);
		}else if(type.equalsIgnoreCase("BATTLESHIP"))
		{
			return new BattleShip(game,owner);
		}
		else if(type.equalsIgnoreCase("AIRCRAFT"))
		{
			return new Carrier(game,owner);
		}
		
		return null;
	}
}
