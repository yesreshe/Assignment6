public class Roadimplements implements Comparable<Roadimplements>
{
   private Town endPoint1;
   private Town endPoint2;
   private int distance;
   private String nameOfRoad;
  
   public Roadimplements(Town endPoint1, Town endPoint2, int distance, String nameOfRoad)
   {
       this.endPoint1 = endPoint1;
       this.endPoint2 = endPoint2;
       this.distance = distance;
       this.nameOfRoad = nameOfRoad;      
   }

   public Town getEndPoint1()
   {
       return endPoint1;
   }

   public Town getEndPoint2()
   {
       return endPoint2;
   }
  
   public int getDistance()
   {
       return distance;
   }
  
   public String getNameOfRoad()
   {
       return nameOfRoad;
   }
  
   public void setEndPoint1(Town endPoint1)
   {
       this.endPoint1 = endPoint1;
   }

   public void setEndPoint2(Town endPoint2)
   {
       this.endPoint2 = endPoint2;
   }  

   public void setDistance(int distance)
   {
       this.distance = distance;
   }
  
   public void setName(String nameOfRoad)
   {
       this.nameOfRoad = nameOfRoad;
   }

   
   public String toString()
   {
       return "Road{" + "endPoint1=" + endPoint1.getNameOfTown() + ", endPoint2=" + endPoint2.getNameOfTown() + ", Name=" + nameOfRoad + ", Distance=" + distance + '}';
   }
  
   
   public int compareTo(Roadimplements other)
   {
       if (this.distance < (other.distance))
           return -1;
       else if (this.distance > (other.distance))
           return 1;
       else
           return 0;
   }

   public boolean contains(Town sourceVertex)
   {
       return (endPoint1.compareTo(sourceVertex) == 0 || endPoint2.compareTo(sourceVertex) == 0);
   }
} 

