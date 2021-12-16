import java.util.ArrayList;


public class TownGraphManager_GFA_Test {
	private TownGraphManagerInterface graph;
	private String[] town;
	  
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  town = new String[12];
		  
		  for (int i = 1; i < 12; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		  }
		  
		  graph.addRoad(town[1], town[2], 2, "Road_1");
	}

	public void tearDown() throws Exception {
		graph = null;
	}

	public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
	}
}