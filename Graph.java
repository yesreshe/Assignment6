import java.util.*;
import java.util.Map.Entry;
public class Graph implements GraphInterface<Town, Road>
{
   private Set<Town> towns;
   private Set<Road> roads;

   public Graph()
   {
       towns = new HashSet<Town>();
       roads = new HashSet<Road>();
   }

   
   public Road getEdge(Town sv, Town dv)
   {
       for (Road road : roads)
       {
           if (((road.getEndPoint1().compareTo(sv) == 0) && (road.getEndPoint2().compareTo(dv) == 0))
                   || ((road.getEndPoint2().compareTo(sv) == 0)
                           && (road.getEndPoint1().compareTo(dv) == 0)))
           {
               return road;
           }
       }
      
       return null;
   }

 
   public Road addEdge(Town sv, Town dv, int dist, String name)
   {
       Road road = new Road(sv, dv, dist, name);
       roads.add(road);
       sv.addAdjacentTown(dv, dist);
       dv.addAdjacentTown(sv, dist);

       return road;
   }

   
   public boolean addVertex(Town v)
   {
       return towns.add(v);
   }

   
   public boolean containsEdge(Town sv, Town dv)
   {
       for (Road road : roads)
       {
           if (road.contains(sv) && road.contains(dv))
               return true;

       }
       return false;
   }

   
   public boolean containsVertex(Town v)
   {
       for (Town town : towns)
       {
           if (town.getNameOfTown().compareToIgnoreCase(v.getNameOfTown()) == 0)
               return true;
       }

       return false;
   }

   
   public Set<Road> edgeSet()
   {
       return roads;
   }

   
   public Set<Road> edgesOf(Town v)
   {
       Set<Road> res = new HashSet<Road>();
       for (Road road : this.roads)
       {
           if (road.contains(v))
               res.add(road);
       }
       return res;
   }

  
   public Road removeEdge(Town sv, Town dv, int dist, String name)
   {
       Road road = new Road(sv, dv, dist, name);
       roads.remove(road);
       return road;
   }

   public boolean removeVertex(Town v)
   {
       return towns.remove(v);
   }

   public Set<Town> vertexSet()
   {
       return towns;
   }

   
   public ArrayList<String> shortestPath(Town sv, Town dv)
   {
       dijkstraShortestPath(sv);

       ArrayList<String> sp = new ArrayList<String>();
       LinkedList<Town> listOfTowns = dv.getShortestPath();

       for (int i = 0; i < listOfTowns.size(); i++)
       {
           sp.add(listOfTowns.get(i).toString());
       }
       sp.add(dv.toString());

       return sp;
   }

   // dijkstraShortestPath method implementation
   @Override
   public void dijkstraShortestPath(Town sv)
   {
       sv.setDistance(0);
       Set<Town> setOfTowns1 = new HashSet<>();
       Set<Town> setOfTowns2 = new HashSet<>();
       setOfTowns2.add(sv);

       while (setOfTowns2.size() != 0)
       {
           Town currentTown = getLowestDistanceTown(setOfTowns2);
           setOfTowns2.remove(currentTown);

           for (Entry<Town, Integer> entry : currentTown.getAdjacentTowns().entrySet())
           {
               Town adjTown = entry.getKey();
               Integer edgedistance = entry.getValue();

               if (!setOfTowns1.contains(adjTown))
               {
                   findMinDistance(adjTown, edgedistance, currentTown);
                   setOfTowns2.add(adjTown);
               }
           }
           setOfTowns1.add(currentTown);
       }
   }

   // getLowestDistanceTown method implementation
   private static Town getLowestDistanceTown(Set<Town> setOfTowns)
   {
       Town lowDistanceTown = null;
       int lowDistance = Integer.MAX_VALUE;
       for (Town town : setOfTowns)
       {
           int townDistance = town.getDistance();
           if (townDistance < lowDistance)
           {
               lowDistance = townDistance;
               lowDistanceTown = town;
           }
       }
       return lowDistanceTown;
   }

   // findMinDistance method implementation
   private static void findMinDistance(Town evaluationTown, Integer edgeWeigh, Town sourceTown)
   {
       Integer sourceTownDistance = sourceTown.getDistance();
       if (sourceTownDistance + edgeWeigh < evaluationTown.getDistance())
       {
           evaluationTown.setDistance(sourceTownDistance + edgeWeigh);
           LinkedList<Town> sp = new LinkedList<>(sourceTown.getShortestPath());
           sp.add(sourceTown);
           evaluationTown.setShortestPath(sp);
       }
   }



