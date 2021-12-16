public class GraphDemo
{
   public static void main(String[] args)
   {
       Graph graph = new Graph();
       Town[] towns = { new Town("A"), new Town("B"), new Town("C"), new Town("D"), new Town("E"), new Town("F") };

       graph.addEdge(towns[0], towns[1], 10, "AB");
       graph.addEdge(towns[0], towns[2], 15, "AC");
       graph.addEdge(towns[1], towns[3], 12, "BD");
       graph.addEdge(towns[1], towns[5], 15, "BF");
       graph.addEdge(towns[2], towns[4], 10, "CE");
       graph.addEdge(towns[3], towns[4], 2, "DE");
       graph.addEdge(towns[3], towns[5], 1, "DF");
       graph.addEdge(towns[5], towns[4], 5, "FE");

       for (int i = 0; i < towns.length; i++)
       {
           for (int j = i+1; j < towns.length; j++)
           {
               System.out.println(towns[i].getNameOfTown() + " to " + towns[j].getNameOfTown() + ": ");
               System.out.println(graph.shortestPath(towns[i], towns[j]) + "\n");
           }
       }
   }
} 

