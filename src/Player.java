
public class Player {
	public String name;
	private int age;
	public int life;
	public Player(String name,int age,int life)
	{
		this.name=name;
		this.life=life;
		this.age=age;
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
	
}
