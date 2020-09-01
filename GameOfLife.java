/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	
	public static int returnNeighborCount(int [][] pattern, int i, int j)
	{
		int neighbourCount =0;
		int iMax = pattern.length;
		int jMax = pattern[0].length;
		int x=i,y=j;
		
		if(pattern[i][j]==1) neighbourCount = -1;
		for(int row=i-1;row<=i+1;row++)
		{
			for(int col=j-1;col<=j+1;col++)
			{
				if(row>=0 && col>=0 && row<iMax && col<jMax)
				{
					
					neighbourCount += pattern[row][col];
	
				}
			}
		}
		
		return neighbourCount;
	}
	
	public static int [][] nextPattern(int [][] pattern,int [][] neighbourCount)
	{
		for(int i=0;i<pattern.length;i++)
		{
			for(int j=0;j<pattern[0].length;j++)
			{
				if(neighbourCount[i][j]>3) pattern[i][j]=0;
				if(neighbourCount[i][j]==3) pattern[i][j]=1;
				if(neighbourCount[i][j]<2) pattern[i][j]=0;
			}
		}
		return pattern;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in); 
		int [][] pattern = new int [10][10];
		int [][] neighbourCount = new int [10][10];
		
        while(in.hasNext())
        {
        	String s = in.nextLine(); 
        	String[] position = s.split(",");
        	int row= Integer.parseInt(position[0]);
        	int col= Integer.parseInt(position[1]);
        	pattern[row][col] = 1;
        }
        
        for(int i=0;i<pattern.length;i++)
        {	
        	for(int j=0;j<pattern[0].length;j++)
        	{
        		neighbourCount[i][j]= returnNeighborCount(pattern,i,j);
        	}
        }
        
        newPattern = nextPattern(pattern,neighbourCount);
        
        for(int i=0;i<newPattern.length;i++)
        {
        	for(int j=0;j<newPattern[0].length;j++)
        	{
        		System.out.print(newPattern[i][j]+" ");
        	}
        	System.out.println();
        }
       
	}
}