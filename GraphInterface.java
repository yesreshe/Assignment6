import java.io.File;
import java.util.*;



public interface GraphInterface<V, E>
{
  
    public E getEdge(V sourceVertex, V destinationVertex);


     */
    public E addEdge(V sourceVertex, V destinationVertex, int weight, String description);

   
    public boolean addVertex(V v);

    
    public boolean containsEdge(V sourceVertex, V destinationVertex);

    
    public boolean containsVertex(V v);

    
    public Set<E> edgeSet();

    
    public Set<E> edgesOf(V vertex);


    
    public E removeEdge(V sourceVertex, V destinationVertex, int weight, String description);


   
    public boolean removeVertex(V v);

   
    public Set<V> vertexSet();
    
    
   
    public ArrayList<String> shortestPath(V sourceVertex, V destinationVertex);
    
    
    public void dijkstraShortestPath(V sourceVertex);
}

