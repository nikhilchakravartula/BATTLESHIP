
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
	
	public Ship getShip(String type,int owner)
	{
		if(type.equalsIgnoreCase("DESTROYER"))
		{
			return new Destroyer(owner);
		}
		else if(type.equalsIgnoreCase("SUBMARINE"))
		{
			return new Cruiser(owner);
		}
		else if(type.equalsIgnoreCase("CRUISER"))
		{
			return new Submarine(owner);
		}else if(type.equalsIgnoreCase("BATTLESHIP"))
		{
			return new Carrier(owner);
		}
		else if(type.equalsIgnoreCase("AIRCRAFT"))
		{
			return new BattleShip(owner);
		}
		
		return null;
	}
}
