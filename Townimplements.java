import java.util.*;
public class Townimplements implements Comparable<Townimplements>
{
   private String nameOfTown;
   private Map<Townimplements, Integer> adjacentTowns;
  
   private LinkedList<Townimplements> shortestPath;
   private Integer distance;

   public Townimplements()
   {
       super();
       this.adjacentTowns = new HashMap<Townimplements, Integer>();
       this.shortestPath = new LinkedList<Townimplements>();
       this.distance = Integer.MAX_VALUE;
   }

   public Townimplements(String nameOfTown)
   {
       this.nameOfTown = nameOfTown;
       this.adjacentTowns = new HashMap<Townimplements, Integer>();
       this.shortestPath = new LinkedList<Townimplements>();
       this.distance = Integer.MAX_VALUE;
   }

   public Townimplements(String nameOfTown, Map<Townimplements, Integer> adjacentTowns)
   {
       this.nameOfTown = nameOfTown;
       this.adjacentTowns = adjacentTowns;
       this.shortestPath = new LinkedList<Townimplements>();
       this.distance = Integer.MAX_VALUE;
   }

   public String getNameOfTown()
   {
       return nameOfTown;
   }

   public Map<Townimplements, Integer> getAdjacentTowns()
   {
       return adjacentTowns;
   }
  
   public void setName(String nameOfTown)
   {
       this.nameOfTown = nameOfTown;
   }

   public void setAdjTowns(Map<Townimplements, Integer> AdjTowns)
   {
       this.adjacentTowns = AdjTowns;
   }

   public String toString()
   {
       return "Town{" + "Name=" + nameOfTown + ", AdjTowns=" + adjacentTowns.values() + "}";
   }

   
   public int compareTo(Townimplements other)
   {
       if (nameOfTown.compareToIgnoreCase(other.nameOfTown) < 0)
           return -1;
       else if (nameOfTown.compareToIgnoreCase(other.nameOfTown) > 0)
           return 1;
       else
           return 0;
   }

   public void addAdjacentTown(Townimplements destinationTown, int distance)
   {
       this.adjacentTowns.put(destinationTown, distance);
   }

   public LinkedList<Townimplements> getShortestPath()
   {
       return shortestPath;
   }

   public void setDistance(int distance)
   {
       this.distance = distance;
   }

   public int getDistance()
   {
       return distance;
   }

   public void setShortestPath(LinkedList<Townimplements> shortestPath)
   {
       this.shortestPath = shortestPath;
   }
} 