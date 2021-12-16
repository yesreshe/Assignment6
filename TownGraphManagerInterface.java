import java.util.*;

public interface TownGraphManagerInterface {
	
	
	public boolean addRoad(String town1, String town2, int weight, String roadName);
	
	
	public String getRoad(String town1, String town2);
	
	
	public boolean addTown(String v);
	
	
	public Town getTown(String name);
	
	
	public boolean containsTown(String v);
	
	
	public boolean containsRoadConnection(String town1, String town2);
	
	
	public ArrayList<String> allRoads();
	
	
	public boolean deleteRoadConnection(String town1, String town2, String road);
	
	
	public boolean deleteTown(String v);

	
	public ArrayList<String> allTowns();
	
	
	public ArrayList<String> getPath(String town1, String town2);
	
}
