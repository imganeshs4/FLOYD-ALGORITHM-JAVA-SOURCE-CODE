import java.util.*;
import java.io.*;
import java.lang.*;

public class Floyd
{
  public static int cost[][];
  public static int n;

  public static int min(int a,int b)
  {
    return (a<b)?a:b;
  }


  public static void floyd(int cost[][],int n)
  {
    int i,j,k;
    int d[][]=new int[10][10];

    for(i=0;i<n;i++)
    {
     for(j=0;j<n;j++)
      {
        d[i][j]=cost[i][j];
      }
    }
    
    for(k=0;k<n;k++)
    {
     for(i=0;i<n;i++)
      {
        for(j=0;j<n;j++)
         {
           d[i][j]=min(d[i][j],d[i][k]+d[k][j]);
         }
      }
    }
    
    for(i=0;i<n;i++)
    {
     for(j=0;j<n;j++)
      {
        System.out.println("The minimum distance from "+i+"to "+j+" : "+d[i][j]);
      }
    }
    
    System.out.println("The Resultant Floyds Matrix : ");
    for(i=0;i<n;i++)
    {
     System.out.println();  
     for(j=0;j<n;j++)
      {
        System.out.print(d[i][j]+"\t");
      }
    }
  }

  public static void main(String args[])
  {
    int i,j,n;
    cost=new int[10][10];
    
    Scanner in=new Scanner(System.in);

    System.out.println("Enter the Size of the Adjacency Matrix : ");
    n=in.nextInt();
    
    System.out.println("Enter the elements of the Adjacency Matrix : ");
    for(i=0;i < n;i++)
    {
     for(j=0;j < n;j++)
     {
      cost[i][j]=in.nextInt();
     }
    }
    
    floyd(cost,n);
  }
}
