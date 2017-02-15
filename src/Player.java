import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class Player {
	public String name;
	private int age;
	public int life;
	public BattleField field;
	 HashMap<Pair,Ship> locationSet;
	public Player(String name,int age,int life)
	{
		this.name=name;
		this.life=life;
		this.age=age;
		field=new BattleField();
		locationSet=new HashMap<Pair,Ship>();
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
