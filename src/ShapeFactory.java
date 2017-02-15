
public class ShapeFactory {

	public Ship getShip(String type,Player owner)
	{
		if(type.equalsIgnoreCase("Destroyer"))
		{
			return new Destroyer(owner);
		}
		else if(type.equalsIgnoreCase("Cruiser"))
		{
			return new Cruiser(owner);
		}
		else if(type.equalsIgnoreCase("Submarine"))
		{
			return new Submarine(owner);
		}else if(type.equalsIgnoreCase("Carrier"))
		{
			return new Carrier(owner);
		}
		else if(type.equalsIgnoreCase("BattleShip"))
		{
			return new BattleShip(owner);
		}
		
		return null;
	}
}
