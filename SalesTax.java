import java.util.*;
import java.lang.*;
import java.lang.Math.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
        public static float calculateSalesPrice(float quantity,float price,String productType,boolean imported)
        {
                float salesPrice=0;
                if(productType.matches("food")||productType.matches("book")||productType.matches("medicine"))
                        salesPrice=0;
                else salesPrice = 0.1f *quantity*price;
                
                if(imported==true)
                        salesPrice += 0.05f *quantity*price;
                return salesPrice;
        }
        
        public static void main (String[] args) throws java.lang.Exception
        {
                Scanner in = new Scanner(System.in);
                float salesTotal = 0,total =0;
                
        while(in.hasNext())
        {
                String s = in.nextLine(); 
                String[] position = s.split(" ");
                float quantity = Float.parseFloat(position[0]);
                String productName = "",productType="";
                int i=1;
                boolean imported = false;
                HashMap<String,String> categoryType = new HashMap<String,String>();
                categoryType.put("chocolate","food");
                categoryType.put("book","book");
                categoryType.put("pills","medicine");
                
                while(!position[i].matches("at"))
                {
                        productName +=" "+ position[i];
                        if(categoryType.containsKey(position[i]))
                                productType= categoryType.get(position[i]);
                        if(position[i].matches("imported")) imported = true;    
                        i++;
                }
                float price = Float.parseFloat(position[++i]);
                float salesPrice = calculateSalesPrice(quantity,price,productType,imported);
                salesTotal+=salesPrice;
                total += (quantity*price)+salesPrice;
                
                if(imported==false)
                        System.out.println(quantity+" "+productName+": "+price);
                else System.out.println(quantity+" "+productName+": "+price+salesPrice);
        }
                double finalSalesTotal= (double)Math.round(salesTotal*20)/20;
                double finalTotal = (double)Math.round(total*100)/100;
        System.out.println("Sales Total: "+finalSalesTotal);
        System.out.println("Total :"+finalTotal);
        
        }
}