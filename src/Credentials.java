import java.util.HashSet;
import java.util.ArrayList;


public class Credentials {
	public static final int NUM_SHIPS=5;
	public static final int NUM_PLAYERS=2;

	public static final int LIFE_DESTROYER=2;
	public static final int LIFE_AIRCRAFT=5;
	public static final int LIFE_CRUISER=3;
	public static final int LIFE_BATTLESHIP=4;
	public static final int LIFE_SUBMARINE=3;

	public static final int SIZE_SUBMARINE=3;
	public static final int SIZE_DESTROYER=2;
	public static final int SIZE_AIRCRAFT=5;
	public static final int SIZE_CRUISER=3;
	public static final int SIZE_BATTLESHIP=4;
	
	public static final int NUM_ROWS=10;
	public static final int NUM_COLS=10;
	public static final String AVAILABLE_SHIPS[]={"DESTROYER","SUBMARINE","CRUISER","BATTLESHIP","AIRCRAFT"};
	public static final int TYPE_DESTROYER=0,TYPE_SUBMARINE=1,TYPE_CRUISER=2,TYPE_BATTLESHIP=3,TYPE_AIRCRAFT=4;
	//public static ArrayList<HashSet<Location> > locationSet;
	public static final int STATE_GAME_START =1,STATE_GAME_PLAYING=2,STATE_GAME_END=3;
	

	
}
