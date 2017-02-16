import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class Player {
	private String name;
	private int age;
	private int life;
	private BattleField field;
	 private HashMap<Pair,Ship> locationSet;
	 
	 
	public Player(Game game,String name,int age,int life)
	{
		this.name=name;
		this.life=life;
		this.age=age;
		locationSet=new HashMap<Pair,Ship>();
		field=new BattleField(game);
		field.getFrame().setTitle("\n"+this.name+": Fire Missiles on this enemy BattleField\n");
		
	}
	
	int decrementLife()
	{
		this.life-=1;
		return this.life;
	}
	BattleField getField()
	{
		return field;
	}
	
	HashMap<Pair,Ship> getLocationSet()
	{
		return locationSet;
	}
	String getName()
	{
		return this.name;
	}
	int getLife()
	{
		return this.life;
	}
	int getAge()
	{
		return this.age;
	}
	public boolean isDead()
	{
		return (this.life==0);
	}
	void printLocationSet()
	{
		for(Pair p:locationSet.keySet())
		{
			System.out.println(p.row +"\t"+p.col);
		}
	}
	
	
	
}
